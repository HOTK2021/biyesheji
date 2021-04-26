package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_eighteen_log {
	private BigInteger id;
	private BigInteger userId;
	private BigInteger eighteenId;
	private String inOrOutTime;
	private int status;
	private String info;
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
	public BigInteger getEighteenId() {
		return eighteenId;
	}
	public void setEighteenId(BigInteger eighteenId) {
		this.eighteenId = eighteenId;
	}
	public String getInOrOutTime() {
		return inOrOutTime;
	}
	public void setInOrOutTime(String inOrOutTime) {
		this.inOrOutTime = inOrOutTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public T_mingjie_eighteen_log(BigInteger id, BigInteger userId, BigInteger eighteenId, String inOrOutTime, int status, String info) {
		this.id = id;
		this.userId = userId;
		this.eighteenId = eighteenId;
		this.inOrOutTime = inOrOutTime;
		this.status = status;
		this.info = info;
	}
	public T_mingjie_eighteen_log(BigInteger userId, BigInteger eighteenId, String inOrOutTime, int status, String info) {
		this.userId = userId;
		this.eighteenId = eighteenId;
		this.inOrOutTime = inOrOutTime;
		this.status = status;
		this.info = info;
	}
	public T_mingjie_eighteen_log() {
	}
	@Override
	public String toString() {
		return "T_mingjie_eighteen_log [id=" + id + ", userId=" + userId + ", eighteenId=" + eighteenId
				+ ", inOrOutTime=" + inOrOutTime + ", status=" + status + ", info=" + info + "]";
	}
}
