package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_user_role {
	private BigInteger user_id;
	private BigInteger role_id;
	public BigInteger getUser_id() {
		return user_id;
	}
	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}
	public BigInteger getRole_id() {
		return role_id;
	}
	public void setRole_id(BigInteger role_id) {
		this.role_id = role_id;
	}
	public T_user_role(BigInteger user_id, BigInteger role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}
	public T_user_role() {
	}
	@Override
	public String toString() {
		return "T_user_role [user_id=" + user_id + ", role_id=" + role_id + "]";
	}
}
