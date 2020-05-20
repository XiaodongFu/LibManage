package edu.yulinu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 14:46
 **/
@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="apply_record")
public class ApplyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applyId;
    private String stuId;
    private String stuNo;
    private String teaId;
    private String teaName;
    private String stuName;
    private Integer record;
    private LocalDate applyTime;
    private String courseName;
    private Integer courseId;
    private String isApprove;//批准


}
