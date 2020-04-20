package edu.yulinu.student.dao;

import edu.yulinu.common.domain.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-19 07:59
 **/
public interface TeacherDao extends PagingAndSortingRepository<Teacher,Integer> {
    Teacher findByTeaName(String userName);
}
