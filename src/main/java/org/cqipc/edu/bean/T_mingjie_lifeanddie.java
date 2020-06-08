package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_lifeanddie {
	private BigInteger id;
	private BigInteger userId;
	private String createTime;
	private int age;
	private int totalAge;
	private int overAge;
	private int statu;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTotalAge() {
		return totalAge;
	}
	public void setTotalAge(int totalAge) {
		this.totalAge = totalAge;
	}
	public int getOverAge() {
		return overAge;
	}
	public void setOverAge(int overAge) {
		this.overAge = overAge;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public T_mingjie_lifeanddie(BigInteger id, BigInteger userId, String createTime, int age, int totalAge, int overAge, int statu) {
		this.id = id;
		this.userId = userId;
		this.createTime = createTime;
		this.age = age;
		this.totalAge = totalAge;
		this.overAge = overAge;
		this.statu = statu;
	}
	public T_mingjie_lifeanddie(BigInteger userId, String createTime, int age, int totalAge, int overAge, int statu) {
		this.userId = userId;
		this.createTime = createTime;
		this.age = age;
		this.totalAge = totalAge;
		this.overAge = overAge;
		this.statu = statu;
	}
	public T_mingjie_lifeanddie() {
	}
	@Override
	public String toString() {
		return "T_mingjie_lifeanddie [id=" + id + ", userId=" + userId + ", createTime=" + createTime + ", age=" + age
				+ ", totalAge=" + totalAge + ", overAge=" + overAge + ", statu=" + statu + "]";
	}
}
