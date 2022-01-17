package com.lambert.fun.result;

public enum ResultEnum {

    UNKNOWN_EXCEPTION(-1, "未知错误."),
    RESULT(0, "success"),
    PARAM_USER_NULL(10001, "用户标识为空，请退出重新登录！"),
    PARAM_ERROR(10002, "参数不符合规范."),
    TEACHER_SUBJECT_NOT_RULE(10003, "教师科目超出规定数量，请重新安排教师"),
    TEACHER_CLASS_NOT_RULE(10004, "教师班级超出规定数量，请重新安排教师"),
    TEACHER_IS_CONTACT(10005, "教师还与班级或科目有关联，请核实后，再进行相关删除操作"),
    TEACHER_SUBJECT_IS_CONTACT(10006, "班级对应的教师及其所教科目不为空，不允许删除"),
    TEACHER_SECTION_IS_CONTACT(10007, "教师所教课程数超过10门，请安排其他教师"),
    SAVE_ERROR(10008, "%s"),


    USER_NOT_LOGIN(20001, "用户未登录."),
    USER_LOGIN_EXCEPTION(20002, "登录失败."),
    USER_NOT_PERMISSION(20003, "没有相应权限."),
    USER_IS_LOCKED(20004, "用户已锁定."),
    USER_PASSWORD_ERROR(20005, "密码错误."),
    USER_NOT_FOUND(20006, "用户不存在."),
    USER_EXPIRED(20007, "用户凭证过期."),
    USER_ERROR(20008, "令牌错误."),
    USER_IS_UNAVAILABLE(20009, "用户不可用"),
    USER_IS_EXISTENCE(20010, "用户已存在"),
    NO_DATA(30000, "数据不存在"),
    HAS_ROLE_JOIN(30001, "存在角色关联"),
    HAS_RESOURCE_JOIN(30002, "存在用户关联"),

    FOLDER_IS_NOT_CREATE(40001, "文件夹创建失败");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
