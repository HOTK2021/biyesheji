package org.cqipc.edu.service;


import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.*;

import java.math.BigInteger;
import java.util.List;


public interface T_userService {
	public Object[] Login(String username,String password);
	public int adduser(T_user t_user);
	public List<T_dept> selectDeptAll();
	public List<T_user> selectUserAll( int user_id,String username,int pageCount,int pageSize);
	public int selectUserCount( int user_id,String username);
	public int addLifeAndDie(T_mingjie_lifeanddie t_mingjie_lifeanddie);
	public List<T_user> selectUserDie();
	public int addPlife(T_plife t_plife);
	public int selectPife(int user_c_id);
	public List<T_user> selectUserDieAll( int user_id,String username, int pageCount, int pageSize);
	public int selectUserDieCount(int user_id, String username);
	public List<T_user_ov> selectLifeAndDie(int user_id,
											String username,
											int pageCount,
											int pageSize);
	public  int selectLifeAndDieCount(int user_id,String username);


	//待确认功能
	public List<T_user_ov> userdie();
	public int userdieCount();
	public int removeUser(List<BigInteger> list);
	public int addToUser_c(List<T_user> list);
	public List<T_user>  selectUserConfirmed(List<BigInteger> list);
	public int addIntoTrial(List<T_mingjie_trial> list);


	//待审判
	public List<T_user_ov> selectApprove();
	public  int selectApproveCount();

	//入狱
	public int addJail(T_mingjie_eighteen t_mingjie_eighteen);
	public int inJail(T_mingjie_eighteen_log t_mingjie_eighteen_log);
	public List<T_mingjie_eighteen> selectJail();

}
