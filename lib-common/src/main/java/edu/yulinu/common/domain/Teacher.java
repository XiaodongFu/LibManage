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
 * @date: 2020-04-12 12:38
 **/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teaId;
    private String teaGender;
    private String teaName;
    private String teaPhone;
    private String teaPermission;
    private LocalDate teaCreateDate;
}
