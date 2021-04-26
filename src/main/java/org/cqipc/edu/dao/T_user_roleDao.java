package org.cqipc.edu.dao;

import java.math.BigInteger;

import org.cqipc.edu.bean.T_user_role;

public interface T_user_roleDao {
	public T_user_role findRoleByUid(BigInteger userID);
}
