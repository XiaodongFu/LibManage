package edu.yulinu.common;

import edu.yulinu.common.utils.ResponseEnum;
import edu.yulinu.common.utils.ResponseWarp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-06 14:27
 **/
@ControllerAdvice
public class BaseController<V> {

    static ResponseEnum success = ResponseEnum.getByCode("1000");
    static ResponseEnum fail = ResponseEnum.getByCode("1001");

//    成功返回
    public static ResponseWarp success(Object value){
        return new ResponseWarp(success.isSuccess(), value, success.getCode(), success.getMessage());
    }

//    已知异常处理以及返回
    public static ResponseWarp fail(String code){
        ResponseEnum fail = ResponseEnum.getByCode(code);
        return new ResponseWarp(fail.isSuccess(),null,fail.getCode(),fail.getMessage());
    }
    public static ResponseWarp fail(String code,String valueErro){
        ResponseEnum fail = ResponseEnum.getByCode(code);
        return new ResponseWarp(fail.isSuccess(),valueErro,fail.getCode(),fail.getMessage());
    }

//    统一异常处理
    @ExceptionHandler
    public ResponseWarp exceptionHandler (Exception e){
        return new ResponseWarp(fail.isSuccess(), null, fail.getCode(), e.getMessage());
    }

}
