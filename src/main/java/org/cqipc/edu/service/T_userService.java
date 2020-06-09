package org.cqipc.edu.service;


import org.cqipc.edu.bean.T_dept;
import org.cqipc.edu.bean.T_user;

import java.util.List;


public interface T_userService {
	public Object[] Login(String username,String password);
	public int adduser(T_user t_user);
	public List<T_dept> selectDeptAll();

}
