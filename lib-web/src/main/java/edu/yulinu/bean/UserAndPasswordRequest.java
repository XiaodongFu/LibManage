package edu.yulinu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-19 07:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAndPasswordRequest {
    private String username;
    private String password;
}
