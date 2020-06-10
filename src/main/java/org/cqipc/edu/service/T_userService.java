package org.cqipc.edu.service;


import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_dept;
import org.cqipc.edu.bean.T_mingjie_lifeanddie;
import org.cqipc.edu.bean.T_user;

import java.util.List;


public interface T_userService {
	public Object[] Login(String username,String password);
	public int adduser(T_user t_user);
	public List<T_dept> selectDeptAll();
	public List<T_user> selectUserAll(int pageCount,int pageSize);
	public int selectUserCount();
	public int addLifeAndDie(T_mingjie_lifeanddie t_mingjie_lifeanddie);
	public List<T_user> selectUserDie();


}
