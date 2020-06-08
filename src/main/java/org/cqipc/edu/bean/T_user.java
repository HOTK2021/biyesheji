package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_user {
	private BigInteger user_id;
	private String username;
	private String password;
	private BigInteger dept_id;
	private String email;
	private String mobile;
	private int status;
	private String create_time;
	private String modify_time;
	private String last_login_time;
	private String ssex;
	private String description;
	private String avatar;
	private int age;
	public BigInteger getUser_id() {
		return user_id;
	}
	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigInteger getDept_id() {
		return dept_id;
	}
	public void setDept_id(BigInteger dept_id) {
		this.dept_id = dept_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public T_user(BigInteger user_id, String username, String password, BigInteger dept_id, String email, String mobile, int status,
			String create_time, String modify_time, String last_login_time, String ssex, String description,
			String avatar, int age) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.dept_id = dept_id;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.create_time = create_time;
		this.modify_time = modify_time;
		this.last_login_time = last_login_time;
		this.ssex = ssex;
		this.description = description;
		this.avatar = avatar;
		this.age = age;
	}
	public T_user(String username, String password, BigInteger dept_id, String email, String mobile, int status,
			String create_time, String modify_time, String last_login_time, String ssex, String description,
			String avatar, int age) {
		this.username = username;
		this.password = password;
		this.dept_id = dept_id;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.create_time = create_time;
		this.modify_time = modify_time;
		this.last_login_time = last_login_time;
		this.ssex = ssex;
		this.description = description;
		this.avatar = avatar;
		this.age = age;
	}
	public T_user() {
	}
	@Override
	public String toString() {
		return "T_user [user_id=" + user_id + ", username=" + username + ", password=" + password + ", dept_id="
				+ dept_id + ", email=" + email + ", mobile=" + mobile + ", status=" + status + ", create_time="
				+ create_time + ", modify_time=" + modify_time + ", last_login_time=" + last_login_time + ", ssex="
				+ ssex + ", description=" + description + ", avatar=" + avatar + ", age=" + age + "]";
	}
}
