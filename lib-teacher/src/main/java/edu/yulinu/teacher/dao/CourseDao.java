package edu.yulinu.teacher.dao;

import edu.yulinu.common.domain.CourseResource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 21:55
 **/
public interface CourseDao extends JpaRepository<CourseResource,Integer> {
}
