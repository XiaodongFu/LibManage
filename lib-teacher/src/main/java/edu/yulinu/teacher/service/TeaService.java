package edu.yulinu.teacher.service;

import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.common.domain.Teacher;
import edu.yulinu.teacher.dao.TeaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Teacher addTeacher(Teacher s){
        return teaDao.save(s);
    }
}
