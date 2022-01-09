#! /bin/bash

# 开启该注解将自动执行生成实体类
# python3 gentity.py -sa

echo "注意：！！！请将该脚本置于项目跟目录"
echo -e "这是一个初始化 Spring Boot 项目脚本，可以生成目录及目录下固定的java文件：\\n /controller/dao/dto/entity/service/serviceImpl/主类/\n"

mkdir -pv ./src/{main/java/com/lambert/fun/{config,controller,dao,dto,entity,service/serviceImpl,config,exception,result,utils},resource}

allEntity=`ls ./src/main/java/com/lambert/fun/entity |grep .java`
if [ ! $allEntity ]
then
	echo -e "entity 为空无法自动生成以上java类，自动跳出循环\n"
	# shellcheck disable=SC2105
	break
fi
for file in $allEntity
do
name=`echo "$file" | awk '{print $1}' FS="Entity."`

serviceName=`echo "$file" | awk '{print $1"Service"}' FS="Entity."`
serviceNameClass=`echo "$file" | awk '{print $1"Service."$2}' FS="Entity."`
echo -e "package com.lambert.fun.service;\n\npublic interface $serviceName {\n\n}\n"> ./src/main/java/com/lambert/fun/service/$serviceNameClass

serviceImplName=`echo "$file" | awk '{print $1"ServiceImpl"}' FS="Entity."`
serviceImplNameClass=`echo "$file" | awk '{print $1"ServiceImpl."$2}' FS="Entity."`
echo -e "package com.lambert.fun.service.serviceImpl; \n\nimport com.lambert.fun.service.$serviceName; \n\npublic class $serviceImplName implements $serviceName {\n\n}\n">./src/main/java/com/lambert/fun/service/serviceImpl/$serviceImplNameClass

controllerName=`echo "$file" | awk '{print $1"Controller"}' FS="Entity."`
controllerNameClass=`echo "$file" | awk '{print $1"Controller."$2}' FS="Entity."`
echo -e "package com.lambert.fun.controller;\n\nimport io.swagger.annotations.Api;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RestController;\n\n@RestController\n@RequestMapping(\"\")\n@Api(tags = \"\")\npublic class $controllerName {\n\n}\n"> ./src/main/java/com/lambert/fun/controller/$controllerNameClass

daoName=`echo "$file" | awk '{print $1"DAO"}' FS="Entity."`
daoEntityName=`echo "$file" | awk '{print $1}' FS="."`
daoNameClass=`echo "$file" | awk '{print $1"DAO."$2}' FS="Entity."`
echo -e "package com.lambert.fun.dao;\n\nimport com.lambert.fun.entity.$daoEntityName;\nimport org.springframework.data.jpa.repository.JpaRepository;\n\npublic interface $daoName extends JpaRepository<$daoEntityName,Integer> {\n\n}\n"> ./src/main/java/com/lambert/fun/dao/$daoNameClass

dtoName=`echo "$file" | awk '{print $1"ReqDTO"}' FS="Entity."`
dtoNameClass=`echo "$file" | awk '{print $1"ReqDTO."$2}' FS="Entity."`
echo -e "package com.lambert.fun.dto;\n\nimport io.swagger.annotations.ApiModel;\n\n@ApiModel(\"\")\npublic class $dtoName {\n\n}\n"> ./src/main/java/com/lambert/fun/dto/$dtoNameClass

done

echo "执行完成"
