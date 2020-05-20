package edu.yulinu.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-05-05 19:25
 **/
@Data
public class ScoringRequest {
    @NotNull
    private Integer applyId;
    @NotNull
    private Integer score;

}
