package org.cqipc.edu.service;

import java.util.List;

import org.cqipc.edu.bean.T_test;

public interface T_testService {
	public List<T_test> selectTestAll(int page, int limit, String keyWord);
	public int queryCount(String keyWord);
	int insertTest(T_test t_test);

}
