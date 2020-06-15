package org.cqipc.edu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.cqipc.edu.bean.T_test;
import org.cqipc.edu.dao.T_testDao;
import org.cqipc.edu.service.T_testService;
import org.mybatis.spring.SqlSessionHolder;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("t_testService")
public class T_testServiceImpl implements T_testService{
	@Autowired(required = false)
	T_testDao td;
	private SqlSessionHolder SqlsessionUtil;


	@Override
	public List<T_test> selectTestAll(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return td.selectTestAll(page, limit, keyWord);
	}

	@Override
	public int queryCount(String keyWord) {
		return td.queryCount(keyWord);
	}

	@Override
	public int insertTest(T_test t_test) {
//		SqlSession sqlSession = null;
//		try {
//			sqlSession = SqlsessionUtil.getSqlSession();
//			int key =  sqlSession.insert("test.insertAndgetkey",t_test);
//			// commit
//			sqlSession.commit();
//			return key;
//		} catch (Exception e) {
//			sqlSession.rollback();
//			e.printStackTrace();
//		}
//		return 0;
		return td.insertTest(t_test);
	}


}
