package edu.yulinu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
    private Integer id;
    private String name;
    private String stuNo;
    private String phone;
}
