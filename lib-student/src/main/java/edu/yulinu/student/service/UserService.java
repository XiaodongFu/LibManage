package edu.yulinu.student.service;

import edu.yulinu.common.domain.Student;
import edu.yulinu.common.domain.Teacher;
import edu.yulinu.common.domain.UserBean;
import edu.yulinu.student.dao.StuDao;
import edu.yulinu.student.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-20 06:54
 **/
@Service
public class UserService {
    @Autowired
    private StuDao stuDao;
    @Autowired
    private TeacherDao teaDao;


    public UserBean findByName(String userName) {
        Student byStuName = stuDao.findByStuName(userName);
        System.out.println(byStuName);
        if(byStuName!=null){
            return new UserBean(byStuName.getPassword(),byStuName.getStuName());
        }else {
            Teacher byTeaName = teaDao.findByTeaName(userName);
            return new UserBean(byTeaName.getTeaName(),byTeaName.getPassword());
        }
    }
}
