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
 * @date: 2020-04-12 13:06
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="course_resource")
public class ClassResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseId;
    private String courseName;
    private String teaName;
    private String teaPhone;
    private Integer studentLimit;//学习上限人数
    private LocalDate createTime;
    private LocalDate overDueTime;
    private Integer learnerAmount;//学习次数
    private Integer avgRecord;
    private Integer miniScore;
    private Integer highestScore;
    private String status;//是否关闭  可学习状态
}
