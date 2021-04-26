package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_soul {
	private BigInteger id;
	private BigInteger userId;
	private BigInteger executorId;
	private String executorInfo;
	private String executorTime;
	private int executorStatus;
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
	public BigInteger getExecutorId() {
		return executorId;
	}
	public void setExecutorId(BigInteger executorId) {
		this.executorId = executorId;
	}
	public String getExecutorInfo() {
		return executorInfo;
	}
	public void setExecutorInfo(String executorInfo) {
		this.executorInfo = executorInfo;
	}
	public String getExecutorTime() {
		return executorTime;
	}
	public void setExecutorTime(String executorTime) {
		this.executorTime = executorTime;
	}
	public int getExecutorStatus() {
		return executorStatus;
	}
	public void setExecutorStatus(int executorStatus) {
		this.executorStatus = executorStatus;
	}
	public T_mingjie_soul(BigInteger id, BigInteger userId, BigInteger executorId, String executorInfo, String executorTime,
			int executorStatus) {
		this.id = id;
		this.userId = userId;
		this.executorId = executorId;
		this.executorInfo = executorInfo;
		this.executorTime = executorTime;
		this.executorStatus = executorStatus;
	}
	public T_mingjie_soul(BigInteger userId, BigInteger executorId, String executorInfo, String executorTime, int executorStatus) {
		this.userId = userId;
		this.executorId = executorId;
		this.executorInfo = executorInfo;
		this.executorTime = executorTime;
		this.executorStatus = executorStatus;
	}
	public T_mingjie_soul() {
	}
	@Override
	public String toString() {
		return "T_mingjie_soul [id=" + id + ", userId=" + userId + ", executorId=" + executorId + ", executorInfo="
				+ executorInfo + ", executorTime=" + executorTime + ", executorStatus=" + executorStatus + "]";
	}
}
