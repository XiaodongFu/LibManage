package edu.yulinu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-20 07:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private String password;
    private String userName;
}
