package edu.yulinu.apply.dao;

import edu.yulinu.common.domain.ApplyRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-21 19:09
 **/
public interface ApplyDao extends PagingAndSortingRepository<ApplyRecord,Integer> {
}
