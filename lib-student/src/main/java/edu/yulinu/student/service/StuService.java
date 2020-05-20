package edu.yulinu.student.service;

import edu.yulinu.common.domain.Student;
import edu.yulinu.student.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        return (List<Student>) stuDao.findAll();
    }

    @Transactional
    public Student addStudent(Student s){
        s.setStuCreateDate(LocalDate.now());
        s.setStuPermission("guest");
        return stuDao.save(s);
    }
}
