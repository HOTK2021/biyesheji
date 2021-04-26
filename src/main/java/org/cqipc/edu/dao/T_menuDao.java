package org.cqipc.edu.dao;

import java.math.BigInteger;
import java.util.List;

import org.cqipc.edu.bean.T_menu;

public interface T_menuDao {
	public List<T_menu> findMenuByMid(List<BigInteger> list);
}
