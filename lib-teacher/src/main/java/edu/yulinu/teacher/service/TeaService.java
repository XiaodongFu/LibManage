package edu.yulinu.teacher.service;

import edu.yulinu.apply.dao.ApplyDao;
import edu.yulinu.common.domain.ApplyRecord;
import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.common.domain.Teacher;
import edu.yulinu.common.domain.UserBean;
import edu.yulinu.course.dao.CourseDao;
import edu.yulinu.teacher.dao.TeaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 16:18
 **/
@Service
public class TeaService {

    @Autowired
    private TeaDao teaDao;
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private CourseDao courseDao;

    @Transactional
    public Teacher addTeacher(Teacher t){
        t.setTeaCreateDate(LocalDate.now());
        t.setTeaPermission("admin");
        return teaDao.save(t);
    }

//    打成绩
    @Transactional
    public String scoring(Integer applyId, Integer score, UserBean user) {

        Optional<ApplyRecord> applyRecord = applyDao.findById(applyId);
//        验证教师是否与发布课程教师一致
        Boolean aBoolean = authTeacher(user,applyRecord);
        if(aBoolean){
            applyRecord.get().setRecord(score);
            applyDao.save(applyRecord.get());
            CourseResource courseResource = updateCourseScore(applyRecord.get(), score);
            if(null==courseResource){
                return "课程不存在";
            }
            courseDao.save(courseResource);
           return "更新成功";
        }

        return "该课程并非此用户发布";
    }

//    更新课程的成绩
    private CourseResource updateCourseScore(ApplyRecord applyRecord,Integer score) {
        Optional<CourseResource> byId = courseDao.findById(applyRecord.getCourseId());
        if(byId.isPresent()){
            CourseResource course = byId.get();
            course.setLearnerAmount(course.getLearnerAmount()+1);
            if(score>course.getHighestScore()){
                course.setHighestScore(score);
            }
            if(score<course.getMiniScore()){
                course.setMiniScore(score);
            }
            BigDecimal bigDecimal = new BigDecimal(course.getAvgRecord())
                    .multiply(new BigDecimal(course.getLearnerAmount()))
                    .add(new BigDecimal(score))
                    .divide(new BigDecimal(course.getLearnerAmount()+1));
            course.setAvgRecord(bigDecimal.doubleValue());
            return byId.get();
        }
        return null;
    }

//        验证教师是否与发布课程教师一致
    private Boolean authTeacher(UserBean user, Optional<ApplyRecord> applyRecord){
        Integer teaId = teaDao.findByTeaName(user.getUserName()).getTeaId();
        if(applyRecord.isPresent()){
            if(applyRecord.get().getTeaId().equals(teaId)) return true;
        }
        return false;
    }


}
