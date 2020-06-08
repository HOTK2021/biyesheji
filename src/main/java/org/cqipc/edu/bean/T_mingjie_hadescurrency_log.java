package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_hadescurrency_log {
	private BigInteger id;
	private BigInteger userId;
	private String info;
	private String createTime;
	private int status;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T_mingjie_hadescurrency_log(BigInteger id, BigInteger userId, String info, String createTime, int status) {
		this.id = id;
		this.userId = userId;
		this.info = info;
		this.createTime = createTime;
		this.status = status;
	}
	public T_mingjie_hadescurrency_log(BigInteger userId, String info, String createTime, int status) {
		this.userId = userId;
		this.info = info;
		this.createTime = createTime;
		this.status = status;
	}
	public T_mingjie_hadescurrency_log() {
	}
	@Override
	public String toString() {
		return "T_mingjie_hadescurrency_log [id=" + id + ", userId=" + userId + ", info=" + info + ", createTime="
				+ createTime + ", status=" + status + "]";
	}
}
