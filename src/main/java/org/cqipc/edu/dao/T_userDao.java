package org.cqipc.edu.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.*;

import java.math.BigInteger;
import java.util.List;

public interface T_userDao {
	public T_user userLogin(@Param("username")String username,@Param("password")String password);
	public int adduser(T_user t_user);
	public List<T_user> selectUserAll(@Param("user_id") int user_id,
									  @Param("username") String username,
									  @Param("pageCount")int pageCount,
									  @Param("pageSize")int pageSize);
	public int selectUserCount(@Param("user_id") int user_id,
							   @Param("username") String username);
	public List<T_user> selectUserDie();
	public List<T_user> selectUserDieAll(@Param("user_id") int user_id,
										 @Param("username") String username,
										 @Param("pageCount")int pageCount,
										 @Param("pageSize")int pageSize);
	public int selectUserDieCount(
			@Param("user_id") int user_id,
			@Param("username") String username
	);


	//待确认功能
	public List<T_user_ov> userdie();
	public int userdieCount();
	public int removeUser(List<BigInteger> list);
	public int addToUser_c(List<T_user> list);
	public List<T_user>  selectUserConfirmed(List<BigInteger> list);
	public int addIntoTrial(List<T_mingjie_trial> list);


	//待审判
	public List<T_user_ov> selectApprove( @Param("pageCount")int pageCount,
										  @Param("pageSize")int pageSize);
	public  int selectApproveCount();

	//入狱
	public int addJail(T_mingjie_eighteen t_mingjie_eighteen);
	public int inJail(T_mingjie_eighteen_log t_mingjie_eighteen_log);
	public List<T_mingjie_eighteen> selectJail();

}
