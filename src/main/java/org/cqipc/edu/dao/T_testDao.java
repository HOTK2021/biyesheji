package org.cqipc.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_test;

public interface T_testDao {
	public List<T_test> selectTestAll(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	public int queryCount(String keyWord);
	int insertTest(T_test t_test);
}
