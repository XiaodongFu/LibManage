package edu.yulinu.student.dao;

import edu.yulinu.common.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-03-29 12:27
 **/
public interface StuDao extends PagingAndSortingRepository<Student,Integer> {
    Student findByStuName(String userName);

    @Override
    <S extends Student> S save(S s);
}
