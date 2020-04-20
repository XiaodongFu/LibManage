package edu.yulinu.student;

import edu.yulinu.bean.UserAndPasswordRequest;
import edu.yulinu.common.BaseController;
import edu.yulinu.common.domain.Student;
import edu.yulinu.common.utils.ResponseWarp;
import edu.yulinu.course.service.CourseService;
import edu.yulinu.student.service.StuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    @Autowired
    CourseService courseService;

    @PostMapping("/course/list")
    public ResponseWarp listCourse(@RequestParam("page")Integer page, @RequestParam("size")Integer size){
        return success(courseService.findAll(page, size));
    }

    @PostMapping("/course/apply")
    public String applyCourse(@RequestBody Integer courseId){
        UserAndPasswordRequest user = (UserAndPasswordRequest) SecurityUtils.getSubject().getPrincipal();
        return "string";
    }

    @PostMapping("/add")
    public ResponseWarp add(@RequestBody Student s){
        s.setStuCreateDate(LocalDate.now());
        return success(stuService.addStudent(s));
    }
}
