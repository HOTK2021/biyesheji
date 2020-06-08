package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_role {
	private BigInteger role_id;
	private String role_name;
	private String remark;
	private String create_tiem;
	private String modify_time;
	public BigInteger getRole_id() {
		return role_id;
	}
	public void setRole_id(BigInteger role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreate_tiem() {
		return create_tiem;
	}
	public void setCreate_tiem(String create_tiem) {
		this.create_tiem = create_tiem;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public T_role(BigInteger role_id, String role_name, String remark, String create_tiem, String modify_time) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.remark = remark;
		this.create_tiem = create_tiem;
		this.modify_time = modify_time;
	}
	public T_role(String role_name, String remark, String create_tiem, String modify_time) {
		this.role_name = role_name;
		this.remark = remark;
		this.create_tiem = create_tiem;
		this.modify_time = modify_time;
	}
	public T_role() {
	}
	@Override
	public String toString() {
		return "T_role [role_id=" + role_id + ", role_name=" + role_name + ", remark=" + remark + ", create_tiem="
				+ create_tiem + ", modify_time=" + modify_time + "]";
	}
}
