package org.cqipc.edu.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.*;
import org.cqipc.edu.dao.*;
import org.cqipc.edu.service.T_userService;
import org.cqipc.edu.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("t_userService")
public class T_userServiceImpl implements T_userService {
	@Autowired(required = false)
	T_userDao tu;
	@Autowired(required = false)
	T_user_configDao tc;
	@Autowired(required = false)
	T_user_roleDao to;
	@Autowired(required = false)
	T_roleDao rd;
	@Autowired(required = false)
	T_role_menuDao trm;
	@Autowired(required = false)
	T_menuDao tm;
	@Autowired(required = false)
	T_deptDao dd;
	@Autowired(required = false)
	T_mingjie_lifeanddieDao mjd;
	@Autowired(required = false)
	T_plifeDao tpd;

	@Override
	//用户登录的方法
	public Object[] Login(String username, String password) {

			//根据用户名和密码查询用户对象
			T_user user=tu.userLogin(username, MD5.getMd5(password));
			System.out.println();
			System.out.println("1");

			if(user!=null) {
				if(user.getStatus()==1){
					try {
						//根据用户ID查询用户配置信息对象
						T_user_config userConfig = tc.findUserConfigByUid(user.getUser_id());
						//根据用户ID查询用户权限ref对象
						System.out.println("-----------userid------------");
						System.out.println(user.getUser_id());
						T_user_role userRole = to.findRoleByUid(user.getUser_id());
						System.out.println("-----------userRole------------");
						System.out.println(userRole);
						//根据用户的权限ID查询权限对象
						T_role role = rd.findRoleByRid(userRole.getRole_id());
						System.out.println("------------role-----------");
						System.out.println(role);
						//根据权限id查询权限下所有对应的权限ID
						List<BigInteger> ids = trm.findRoleMenuByRid(role.getRole_id());
						System.out.println("------------ids-----------");
						System.out.println(ids);
						//根据所有的权限ID查询所有的权限对象
						List<T_menu> list = tm.findMenuByMid(ids);
						System.out.println("------------list-----------");
						System.out.println(list);
						return new Object[]{user, userConfig};
					}catch (Exception e){
						return new Object[] {"error1"};
					}
				}else{
					return  new Object[] {"not"};
				}
			}else {
				return new Object[] {"error"};
			}
	}

	@Override
	public int adduser(T_user t_user) {
		return tu.adduser(t_user);
	}

	@Override
	public List<T_dept> selectDeptAll() {
		return dd.selectDeptAll();
	}

	@Override
	public List<T_user> selectUserAll(int user_id, String username,int pageCount,int pageSize) {
		int p=(pageCount-1)*pageSize;
		return tu.selectUserAll( user_id,  username,p,pageSize);
	}

	@Override
	public int selectUserCount(int user_id, String username) {
		return tu.selectUserCount( user_id,  username);
	}

	@Override
	public int addLifeAndDie(T_mingjie_lifeanddie t_mingjie_lifeanddie) {
		return mjd.addLifeAndDie(t_mingjie_lifeanddie);
	}

	@Override
	public List<T_user> selectUserDie() {
		return tu.selectUserDie();
	}

	@Override
	public int addPlife(T_plife t_plife) {
		return tpd.addPlife(t_plife);
	}

	@Override
	public int selectPife(int user_c_id) {
		return tpd.selectPife(user_c_id);
	}

	@Override
	public List<T_user> selectUserDieAll(int user_id, String username, int pageCount, int pageSize) {
		int p=(pageCount-1)*pageSize;
		return tu.selectUserDieAll(user_id,username,p,pageSize);
	}

	@Override
	public int selectUserDieCount(int user_id, String username) {
		return tu.selectUserDieCount(user_id,username);
	}

	@Override
	public List<T_user_ov> selectLifeAndDie(int user_id, String username,int pageCount,int pageSize) {
		int p=(pageCount-1)*pageSize;
		return mjd.selectLifeAndDie(user_id,username,p,pageSize);
	}

	@Override
	public int selectLifeAndDieCount(int user_id, String username) {
		return mjd.selectLifeAndDieCount(user_id,username);
	}

	@Override
	public List<T_user_ov> userdie() {
		return tu.userdie();
	}

	@Override
	public int userdieCount() {
		return tu.userdieCount();
	}

	@Override
	public int removeUser(List<BigInteger> list) {
		return tu.removeUser(list);
	}

	@Override
	public int addToUser_c(List<T_user> list) {
		return tu.addToUser_c(list);
	}

	@Override
	public List<T_user> selectUserConfirmed(List<BigInteger> list) {
		return tu.selectUserConfirmed(list);
	}

	@Override
	public int addIntoTrial(List<T_mingjie_trial> list) {
		return tu.addIntoTrial(list);
	}

	//待审判
	@Override
	public List<T_user_ov> selectApprove() {
		return tu.selectApprove();
	}

	@Override
	public int selectApproveCount() {
		return tu.selectApproveCount();
	}

	//入狱
	@Override
	public int addJail(T_mingjie_eighteen t_mingjie_eighteen) {
		return tu.addJail(t_mingjie_eighteen);
	}
	@Override
	public int inJail(T_mingjie_eighteen_log t_mingjie_eighteen_log) {
		return tu.inJail(t_mingjie_eighteen_log);
	}
	@Override
	public List<T_mingjie_eighteen> selectJail(){
		return tu.selectJail();
	}


}
