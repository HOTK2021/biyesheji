package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_menu {
	private BigInteger menu_id;
	private BigInteger parent_id;
	private String menu_name;
	private String path;
	private String component;
	private String prems;
	private String icon;
	private String type;
	private double order_num;
	private String create_time;
	private String modify_time;
	public BigInteger getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(BigInteger menu_id) {
		this.menu_id = menu_id;
	}
	public BigInteger getParent_id() {
		return parent_id;
	}
	public void setParent_id(BigInteger parent_id) {
		this.parent_id = parent_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getPrems() {
		return prems;
	}
	public void setPrems(String prems) {
		this.prems = prems;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getOrder_num() {
		return order_num;
	}
	public void setOrder_num(double order_num) {
		this.order_num = order_num;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public T_menu(BigInteger menu_id, BigInteger parent_id, String menu_name, String path, String component, String prems,
			String icon, String type, double order_num, String create_time, String modify_time) {
		this.menu_id = menu_id;
		this.parent_id = parent_id;
		this.menu_name = menu_name;
		this.path = path;
		this.component = component;
		this.prems = prems;
		this.icon = icon;
		this.type = type;
		this.order_num = order_num;
		this.create_time = create_time;
		this.modify_time = modify_time;
	}
	public T_menu(BigInteger parent_id, String menu_name, String path, String component, String prems, String icon,
			String type, double order_num, String create_time, String modify_time) {
		this.parent_id = parent_id;
		this.menu_name = menu_name;
		this.path = path;
		this.component = component;
		this.prems = prems;
		this.icon = icon;
		this.type = type;
		this.order_num = order_num;
		this.create_time = create_time;
		this.modify_time = modify_time;
	}
	public T_menu() {
	}
	@Override
	public String toString() {
		return "T_menu [menu_id=" + menu_id + ", parent_id=" + parent_id + ", menu_name=" + menu_name + ", path=" + path
				+ ", component=" + component + ", prems=" + prems + ", icon=" + icon + ", type=" + type + ", order_num="
				+ order_num + ", create_time=" + create_time + ", modify_time=" + modify_time + "]";
	}
}
