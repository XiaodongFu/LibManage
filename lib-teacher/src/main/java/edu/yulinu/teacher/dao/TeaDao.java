package edu.yulinu.teacher.dao;

import edu.yulinu.common.domain.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 16:20
 **/
public interface TeaDao extends PagingAndSortingRepository<Teacher,Integer> {
    @Override
    <S extends Teacher> S save(S s);

    Teacher findByTeaName(String userName);
}
