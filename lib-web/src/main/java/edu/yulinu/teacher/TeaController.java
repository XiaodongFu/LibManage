package edu.yulinu.teacher;

import edu.yulinu.bean.CourseStatusRequest;
import edu.yulinu.common.BaseController;
import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.common.domain.Student;
import edu.yulinu.common.domain.Teacher;
import edu.yulinu.common.utils.ResponseWarp;
import edu.yulinu.course.service.CourseService;
import edu.yulinu.teacher.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 15:46
 **/
@RestController
@RequestMapping("/teacher")
public class TeaController extends BaseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeaService teaService;

    @PostMapping("/course/create")
    public ResponseWarp createCourse(@RequestBody CourseResource courseResource){
        courseResource.setCourseName("数据挖掘");
        courseResource.setCreateTime(LocalDate.now());
        courseResource.setOverDueTime(LocalDate.parse("2020-10-12"));
        courseResource.setStatus("closed");
        courseResource.setTeaName("李肇星");
        courseResource.setTeaPhone("15891561121");
        courseResource.setStudentLimit(100);
        courseResource.setLearnerAmount(0);
        courseResource.setAvgRecord(80);
        courseResource.setMiniScore(60);
        courseResource.setHighestScore(100);
        return success(courseService.createCourse(courseResource));
    }

    @PostMapping("/course/list")
    public ResponseWarp listCourse(@RequestParam("page")Integer page,@RequestParam("size")Integer size){
        return success(courseService.findAll(page, size));
    }

    @PostMapping("/course/release")
    public ResponseWarp courseRelease(@RequestBody CourseStatusRequest req){
        return success(courseService.setStatus(req.getStatus(),req.getCourseId()));
    }

    @PostMapping("/add")
    public ResponseWarp add(@RequestBody Teacher t){
        return success(teaService.addTeacher(t));
    }
}
