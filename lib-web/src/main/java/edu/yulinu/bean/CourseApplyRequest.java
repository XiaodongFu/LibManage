package edu.yulinu.common;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-15 22:58
 **/
@Data
public class CourseApplyRequest {
    @NotNull
    private String courseId;

    private String stuId;
    private String teaId;

}
