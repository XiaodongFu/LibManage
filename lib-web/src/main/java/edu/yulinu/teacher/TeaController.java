package edu.yulinu.teacher;

import edu.yulinu.bean.CourseStatusRequest;
import edu.yulinu.bean.ScoringRequest;
import edu.yulinu.common.BaseController;
import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.common.domain.Teacher;
import edu.yulinu.common.domain.UserBean;
import edu.yulinu.common.utils.ResponseWarp;
import edu.yulinu.course.service.CourseService;
import edu.yulinu.teacher.service.TeaService;
import org.apache.shiro.SecurityUtils;
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
        UserBean principal = (UserBean) SecurityUtils.getSubject().getPrincipal();
        courseResource.setTeaName(principal.getUserName());

        courseResource.setTeaPhone(teaService.findById(principal.getId()).getTeaPhone());
//        TODO      当前用户为教师时获取教师信息   当用户不为教师时返回错误

        courseResource.setTeaId(principal.getId().toString());
        courseResource.setStudentLimit(100);
        courseResource.setLearnerAmount(0);
        courseResource.setAvgRecord(80.0);
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
//  重复用户名认证
    @PostMapping("/add")
    public ResponseWarp add(@RequestBody Teacher t){
        Teacher teacher = teaService.findByName(t.getTeaName());
        if (null==teacher){fail("1006");};
        return success(teaService.addTeacher(t));
    }


    @PostMapping("/scoring")
    public ResponseWarp scoring(@RequestBody ScoringRequest s){
        //TODO 重复用户名  电话
        UserBean user = (UserBean) SecurityUtils.getSubject().getPrincipal();
        return success(teaService.scoring(s.getApplyId(),s.getScore(),user));
    }
}
