package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_hadescurrency {
	private BigInteger id;
	private BigInteger userId;
	private double total;
	private String time;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public T_mingjie_hadescurrency(BigInteger id, BigInteger userId, double total, String time) {
		this.id = id;
		this.userId = userId;
		this.total = total;
		this.time = time;
	}
	public T_mingjie_hadescurrency(BigInteger userId, double total, String time) {
		this.userId = userId;
		this.total = total;
		this.time = time;
	}
	public T_mingjie_hadescurrency() {
	}
	@Override
	public String toString() {
		return "T_mingjie_hadescurrency [id=" + id + ", userId=" + userId + ", total=" + total + ", time=" + time + "]";
	}
}
