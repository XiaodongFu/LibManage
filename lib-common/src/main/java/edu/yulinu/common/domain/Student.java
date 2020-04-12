package edu.yulinu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-03-29 12:54
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;//标示学生唯一id
    private String stuGender;//性别
    private String stuName;
    private String stuNo;//学号
    private String stuPhone;//手机号
    private String stuPermission;//权限级别
    private LocalDate stuCreateDate;//注册时间
}
