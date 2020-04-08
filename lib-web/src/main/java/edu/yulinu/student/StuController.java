package edu.yulinu.student;

import edu.yulinu.common.BaseController;
import edu.yulinu.common.utils.ResponseWarp;
import edu.yulinu.student.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-03-29 12:27
 **/
@RestController
@RequestMapping("/student")
public class StuController extends BaseController {

    @Autowired
    StuService stuService;

    @GetMapping("/list")
    public ResponseWarp findAll(){
       return success(stuService.findAll());
    }

    @GetMapping("/a")
    public String findAl(){
        return "string";
    }
}
