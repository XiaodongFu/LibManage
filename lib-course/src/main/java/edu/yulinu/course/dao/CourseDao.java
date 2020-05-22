package edu.yulinu.course.dao;

import edu.yulinu.common.domain.CourseResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 21:55
 **/
public interface CourseDao extends PagingAndSortingRepository<CourseResource,Integer> {
    Page<CourseResource> findByStatus(String status, Pageable pageable);

    @Modifying
    @Query("update CourseResource c set c.status=?1 where c.courseId=?2")
    Integer setStatus(String status, Integer courseId);

    Page<CourseResource> findByTeaId(String teaId,Pageable pageable);
}
