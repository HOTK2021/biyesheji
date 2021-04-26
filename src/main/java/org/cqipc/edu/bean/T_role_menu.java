package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_role_menu {
	private BigInteger role_id;
	private BigInteger menu_id;
	public BigInteger getRole_id() {
		return role_id;
	}
	public void setRole_id(BigInteger role_id) {
		this.role_id = role_id;
	}
	public BigInteger getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(BigInteger menu_id) {
		this.menu_id = menu_id;
	}
	public T_role_menu() {
	}
	public T_role_menu(BigInteger role_id, BigInteger menu_id) {
		this.role_id = role_id;
		this.menu_id = menu_id;
	}
	@Override
	public String toString() {
		return "T_role_menu [role_id=" + role_id + ", menu_id=" + menu_id + "]";
	}
	
}
