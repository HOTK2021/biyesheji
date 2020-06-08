package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_dept {
	private BigInteger dept_id;
	private BigInteger parent_id;
	private String dept_name;
	private double order_num;
	private String create_time;
	private String modify_time;
	public BigInteger getDept_id() {
		return dept_id;
	}
	public void setDept_id(BigInteger dept_id) {
		this.dept_id = dept_id;
	}
	public BigInteger getParent_id() {
		return parent_id;
	}
	public void setParent_id(BigInteger parent_id) {
		this.parent_id = parent_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
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
	public T_dept(BigInteger dept_id, BigInteger parent_id, String dept_name, double order_num, String create_time,
			String modify_time) {
		this.dept_id = dept_id;
		this.parent_id = parent_id;
		this.dept_name = dept_name;
		this.order_num = order_num;
		this.create_time = create_time;
		this.modify_time = modify_time;
	}
	public T_dept(BigInteger parent_id, String dept_name, double order_num, String create_time, String modify_time) {
		this.parent_id = parent_id;
		this.dept_name = dept_name;
		this.order_num = order_num;
		this.create_time = create_time;
		this.modify_time = modify_time;
	}
	public T_dept() {
	}
	@Override
	public String toString() {
		return "T_dept [dept_id=" + dept_id + ", parent_id=" + parent_id + ", dept_name=" + dept_name + ", order_num="
				+ order_num + ", create_time=" + create_time + ", modify_time=" + modify_time + "]";
	}
}
