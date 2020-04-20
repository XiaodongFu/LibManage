package edu.yulinu.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-15 13:41
 **/
@Data
public class CourseStatusRequest {
    @NotNull
    private String status;
    @NotNull
    private Integer courseId;
}
