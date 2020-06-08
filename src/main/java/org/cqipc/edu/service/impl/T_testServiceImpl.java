package org.cqipc.edu.service.impl;

import java.util.List;

import org.cqipc.edu.bean.T_test;
import org.cqipc.edu.dao.T_testDao;
import org.cqipc.edu.service.T_testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("t_testService")
public class T_testServiceImpl implements T_testService{
	@Autowired
	T_testDao td;

	@Override
	public List<T_test> selectTestAll(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return td.selectTestAll(page, limit, keyWord);
	}

	@Override
	public int queryCount(String keyWord) {
		return td.queryCount(keyWord);
	}
	
	
	
}
