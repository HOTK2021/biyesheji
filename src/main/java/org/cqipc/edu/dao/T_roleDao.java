package org.cqipc.edu.dao;

import java.math.BigInteger;

import org.cqipc.edu.bean.T_role;

public interface T_roleDao {
	public T_role findRoleByRid(BigInteger roleId);
}
