package org.cqipc.edu.dao;

import java.math.BigInteger;
import java.util.List;

public interface T_role_menuDao {
	public List<BigInteger> findRoleMenuByRid(BigInteger roleId);
}
