package org.cqipc.edu.dao;

import java.math.BigInteger;

import org.cqipc.edu.bean.T_user_config;

public interface T_user_configDao {
	public T_user_config findUserConfigByUid(BigInteger userId);
}
