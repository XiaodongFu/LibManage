package edu.yulinu.student.service;

import edu.yulinu.common.domain.Student;
import edu.yulinu.student.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-03-29 12:27
 **/
@Service
public class StuService {

    @Autowired
    StuDao stuDao;

    public List<Student> findAll(){
        int i=1/0;
        return stuDao.findAll();
    }
}
