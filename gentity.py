# -*- coding: UTF-8 -*-
import sys, pymysql, os, shutil, json

SWAGGER = False
JPA = False
COL = False

TABLE = None
APPLICATION_PATH = None

# 获取配置文件路径
if getattr(sys, 'frozen', False):
    APPLICATION_PATH = os.path.dirname(sys.executable)
elif __file__:
    APPLICATION_PATH = os.path.dirname(__file__)
CONFIG_FILE = os.path.join(APPLICATION_PATH, "gentity_cfg.json")

DEFAULT_CONFIG = {
    "MYSQL_HOST": "127.0.0.1",
    "MYSQL_PORT": "3306",
    "MYSQL_USER": "root",
    "MYSQL_PASSWORD": "123456",
    "TYPE_DIC": {
        "int": "Integer", 
        "double": "Double", 
        "datetime": "Timestamp",
        "float": "Float",
        "varchar": "String",
        "bigint": "Long",
        "text": "String",
        "date": "Date",
        "char": "String",
        "timestamp": "Timestamp",
        "decimal": "Double"
    }
}

CONFIG = None

MYSQL_PORT = ""
MYSQL_USER = ""
MYSQL_PASSWORD = ""
MYSQL_DB = ""
ALIAS = ""

TYPE_DIC = {}

# 不存在配置创建默认配置
if(not os.path.exists(CONFIG_FILE)):
    with open(CONFIG_FILE, "w") as f:
        json.dump(DEFAULT_CONFIG, f, indent=2)

# 加载配置
with open(CONFIG_FILE, encoding='utf-8') as f:
    CONFIG = json.load(f)
    MYSQL_HOST = CONFIG["MYSQL_HOST"]
    MYSQL_PORT = CONFIG["MYSQL_PORT"]
    MYSQL_USER = CONFIG["MYSQL_USER"]
    MYSQL_PASSWORD = CONFIG["MYSQL_PASSWORD"]
    TYPE_DIC = CONFIG["TYPE_DIC"]

# 生成class
def generate_class():
    if(os.path.exists("./classes")):
        shutil.rmtree("./classes")
    os.mkdir("./classes")
    for table in get_table():
        className = get_class_name(table[0])
        with open("./classes/%s.java" % (className), 'w', encoding='utf-8') as f:
            generate(table[0], className, f)

# 生成列名
def generate_col():
    for table in get_table():
        result = "[%s]: " % table[0]
        for col in get_col(table[0]):
            result = result + ALIAS + col[0] + ", "
        print(result[0:-2])

# 生成
def generate(tableName, className, f):

    print("生成--%s.java" % (className))

    f.write("import java.io.Serializable;\n")
    f.write("\n")

    if(JPA):
        f.write("@Entity( name = \"%s\")\n" % (tableName))
    if(SWAGGER):
        f.write("@ApiModel(value = \"\")\n")

    f.write("public class %s implements Serializable {\n" % (className))

    # 数据库字段
    cols = get_col(tableName)
    for col in cols:
        f.write("\n")

        note = col[1].replace("\r\n", ";")
        if(col[0] != "id"):
            if(not SWAGGER):
                f.write("\t//%s\n" % (note))
            if(JPA):
                f.write("\t@Column(name = \"%s\", columnDefinition = \"%s COMMENT '%s'\")\n" % (col[0], col[3], note))

            if(SWAGGER):
                f.write("\t@ApiModelProperty(value = \"%s\")\n" % (note))            
        else:
            if(JPA):
                f.write("\t@Id\n")
                f.write("\t@GeneratedValue(strategy = GenerationType.IDENTITY)\n")
        f.write("\tprivate %s %s;\n" % (TYPE_DIC[col[2]], get_prop_name(col[0])))

    f.write("\n")
    
    # getter and setter
    for col in cols:
        f.write("\tpublic %s get%s() {return %s;}\n" % (TYPE_DIC[col[2]], get_prop_name(col[0], True), get_prop_name(col[0])))
        f.write("\n")     
        f.write("\tpublic void set%s (%s %s) {this.%s = %s;}\n" % (get_prop_name(col[0], True), TYPE_DIC[col[2]], get_prop_name(col[0]), get_prop_name(col[0]), get_prop_name(col[0])))
        f.write("\n")
        
    f.write("}")


# 获取java文件名
def get_class_name(table):
    l = []
    for i in range(0, len(table)):
        if(i == 0):
            l.append(table[0].upper())
            continue
        if(table[i-1] == "_"):
            l.append(table[i].upper())
        elif(table[i] != "_"):
            l.append(table[i])
    l.append("Entity")
    return "".join(l)    

# 获取属性名
def get_prop_name(prop, inMethod = False):
    l = []
    for i in range(0, len(prop)):
        if(i == 0):
            if(inMethod):
                l.append(prop[0].upper())
            else:
                l.append(prop[0].lower())
            continue
        if(prop[i-1] == "_"):
            l.append(prop[i].upper())
        elif(prop[i] != "_"):
            l.append(prop[i])
    return "".join(l)   

# 获取表
def get_table():
    conn = pymysql.connect(host=MYSQL_HOST, user=MYSQL_USER, password=MYSQL_PASSWORD, database=MYSQL_DB, port=int(MYSQL_PORT), charset='utf8')
    cur = conn.cursor()
    sql = "SELECT DISTINCT TABLE_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = %s "
    if(TABLE != None):
        sql += "AND TABLE_NAME LIKE %s"
        cur.execute(sql, (MYSQL_DB, "%%" + TABLE + "%%"))
    else:
        cur.execute(sql, (MYSQL_DB))
    result = cur.fetchall()
    cur.close()
    conn.close()
    return result

# 获取列
def get_col(table):
    conn = pymysql.connect(host=MYSQL_HOST, user=MYSQL_USER, password=MYSQL_PASSWORD, database=MYSQL_DB, port=int(MYSQL_PORT), charset='utf8')
    cur = conn.cursor()
    sql = "SELECT COLUMN_NAME, COLUMN_COMMENT, DATA_TYPE, COLUMN_TYPE, CHARACTER_MAXIMUM_LENGTH from information_schema.COLUMNS where TABLE_NAME = %s AND TABLE_SCHEMA = %s"
    cur.execute(sql, (table, MYSQL_DB))
    result = cur.fetchall()
    cur.close()
    conn.close()
    return result

def get_cmd(sign):
    for i in range(len(sys.argv)):
        if(sys.argv[i].startswith(sign)):
            return sys.argv[i + 1]
    return None
    
# 帮助
def help():
    print("command help")
    print("----: gentity database|path (-|s|a)|(-c) [-t table] [-as alias-name] [-i ip] [-o port] [-u username] [-p password] ")
    print("----: {generate entity mode}: -s:SWAGGER-UI -a:JPA -:none")
    print("----: [example]: gentity example_database -sa")
    print("----: {generate col name mode}: -c:col name")
    print("----: [example]: gentity example_database -c -t example_table -as alias")
    print("----: {get config path mode}")
    print("----: [example]: gentity path")

def where():
    print("应用目录:" + APPLICATION_PATH)
    print("配置文件:" + CONFIG_FILE)

if __name__ == "__main__":    
    # 指令解析
    if(len(sys.argv) < 3):
        if(len(sys.argv) > 1 and sys.argv[1] == "path"): 
            where()
        else:
            help()
    else:
        MYSQL_DB = sys.argv[1]
        cmd = sys.argv[2]
        if(cmd.startswith("-")):
            for c in cmd:
                if(c == "s"):
                    SWAGGER = True
                    print("启用Swagger注解")
                if(c == "a"):
                    JPA = True 
                    print("启用JPA注解")
                if(c == "c"):
                    COL = True 
                    print("启用列名生成")
            
            table = get_cmd("-t")
            ip = get_cmd("-i")
            u = get_cmd("-u")
            p = get_cmd("-p")
            o = get_cmd("-o")
            alias = get_cmd("-as")

            if(table):
                TABLE = table
            if(ip):
                MYSQL_HOST = ip  
            if(o):
                MYSQL_PORT = o  
            if(u):
                MYSQL_USER = u
            if(p):
                MYSQL_PASSWORD = p
            if(alias):
                 ALIAS = alias + "."

            # 开始
            if COL :
                generate_col()  
            else:
                generate_class()  
