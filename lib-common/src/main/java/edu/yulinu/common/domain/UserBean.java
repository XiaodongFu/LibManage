package edu.yulinu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-20 07:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBean {
    private Integer id;
    private String password;
    private String userName;
    private String permission;
}
