package org.cqipc.edu.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_user;

public interface T_userDao {
	public T_user userLogin(@Param("username")String username,@Param("password")String password);
}
