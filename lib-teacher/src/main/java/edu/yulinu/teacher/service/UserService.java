package edu.yulinu.teacher.service;

import edu.yulinu.common.domain.Student;
import edu.yulinu.common.domain.Teacher;
import edu.yulinu.common.domain.UserBean;
import edu.yulinu.student.dao.StuDao;
import edu.yulinu.teacher.dao.TeaDao;
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
    private TeaDao teaDao;


    public UserBean findByName(String userName) {
        Student byStuName = stuDao.findByStuName(userName);
        Teacher byTeaName = teaDao.findByTeaName(userName);
        if(byStuName!=null){
            return new UserBean(byStuName.getStuId(),byStuName.getPassword(),byStuName.getStuName(),byStuName.getStuPermission());
        }else if(byTeaName!=null){
            return new UserBean(byTeaName.getTeaId(),byTeaName.getPassword(),byTeaName.getTeaName(),byTeaName.getTeaPermission());
        }else{
            return null;
        }
    }
}
