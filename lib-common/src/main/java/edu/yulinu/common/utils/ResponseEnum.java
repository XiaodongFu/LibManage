package edu.yulinu.common.utils;

import java.util.Objects;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-07 20:09
 **/
public enum ResponseEnum {

    SUCCESS_RESPONSE(true,"response success","1000"),
    SERVER_ERROR(false,"unknow exception","1001"),
    USERNAME_ERROR(false,"your username is incorrect","1002"),
    PASSWORD_ERROR(false,"your password is incorrect","1003"),
    UN_AUTHENTICATION(false,"you are not login","1004"),//未登录
    UN_AUTHORIZED(false,"you are Unauthorized,please get touch with admin","1005")//未授权
//    每个异常后面需要"，"   最后一个是"；"
    ;

    private String message;
    private String code;
    private Boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseEnum(Boolean isSuccess,String message,String code){
        this.code=code;
        this.isSuccess=isSuccess;
        this.message=message;
    }

    public static ResponseEnum getByCode(String code) {
        if(Objects.isNull(code)) {
            return SERVER_ERROR;
        }
        for (ResponseEnum response : values()) {
            if(response.getCode().equals(code)) {
                return response;
            }
        }
        return SERVER_ERROR;
    }


}
