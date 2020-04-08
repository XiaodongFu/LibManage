package edu.yulinu.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-06 00:18
 **/
@Data
@AllArgsConstructor
public class ResponseWarp<V> {
    private Boolean isSuccess;
    private V responseData;
    private String code;
    private String message;
}
