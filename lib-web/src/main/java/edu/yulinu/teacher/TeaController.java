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
        courseResource.setCreateTime(LocalDate.now());
        courseResource.setStatus("open");
        UserBean principal = (UserBean) SecurityUtils.getSubject().getPrincipal();
        if(null==principal){ principal=UserBean.builder().id(Integer.parseInt(courseResource.getTeaId())).build();}
        Teacher byId = teaService.findById(principal.getId());
        if(null==byId){return fail("1005");};
        courseResource.setTeaName(byId.getTeaName());
        courseResource.setTeaPhone(byId.getTeaPhone());

        courseResource.setLearnerAmount(0);
        courseResource.setAvgRecord(0.0);
        courseResource.setMiniScore(1000);
        courseResource.setHighestScore(0);
        return success(courseService.createCourse(courseResource));
    }

    @PostMapping("/course/list")
    public ResponseWarp listCourse(@RequestParam("page")Integer page,@RequestParam("size")Integer size,@RequestParam("teaId")Integer teaId){
        UserBean principal = (UserBean) SecurityUtils.getSubject().getPrincipal();
          if(null==principal){principal=UserBean.builder().id(teaId).build();}
        return success(courseService.findByTeaId(page, size,principal.getId().toString()));
    }

    @PostMapping("/course/release")
    public ResponseWarp courseRelease(@RequestBody CourseStatusRequest req){
        return success(courseService.setStatus(req.getStatus(),req.getCourseId()));
    }
//  重复用户名认证
    @PostMapping("/add")
    public ResponseWarp add(@RequestBody Teacher t){
        Teacher teacher = teaService.findByName(t.getTeaName());
        if (null!=teacher){fail("1006");};
        return success(teaService.addTeacher(t));
    }


    @PostMapping("/scoring")
    public ResponseWarp scoring(@RequestBody ScoringRequest s){
        //TODO 重复用户名  电话
        UserBean user = (UserBean) SecurityUtils.getSubject().getPrincipal();
        return success(teaService.scoring(s.getApplyId(),s.getScore(),user));
    }
}
