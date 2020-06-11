package org.cqipc.edu.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_user;

import java.math.BigInteger;
import java.util.List;

public interface T_userDao {
	public T_user userLogin(@Param("username")String username,@Param("password")String password);
	public int adduser(T_user t_user);
	public List<T_user> selectUserAll(@Param("pageCount")int pageCount,@Param("pageSize")int pageSize);
	public int selectUserCount();
	public List<T_user> selectUserDie();
	public List<T_user> selectUserDieAll(@Param("user_id") int user_id,
										 @Param("username") String username,
										 @Param("pageCount")int pageCount,
										 @Param("pageSize")int pageSize);
	public int selectUserDieCount(
			@Param("user_id") int user_id,
			@Param("username") String username
	);
}
