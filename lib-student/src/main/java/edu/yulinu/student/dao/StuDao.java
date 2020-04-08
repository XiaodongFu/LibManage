package edu.yulinu.student.dao;

import edu.yulinu.common.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-03-29 12:27
 **/
public interface StuDao extends JpaRepository <Student,String>{

}
