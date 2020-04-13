package edu.yulinu.teacher.dao;

import edu.yulinu.common.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 16:20
 **/
public interface TeaDao extends JpaRepository<Teacher,Integer>{
}
