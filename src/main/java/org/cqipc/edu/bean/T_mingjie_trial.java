package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_trial {
	private BigInteger id;
	private BigInteger userId;
	private BigInteger trialUserId;
	private String trialTime;
	private String info;
	private int type;
	private int types;
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
	public BigInteger getTrialUserId() {
		return trialUserId;
	}
	public void setTrialUserId(BigInteger trialUserId) {
		this.trialUserId = trialUserId;
	}
	public String getTrialTime() {
		return trialTime;
	}
	public void setTrialTime(String trialTime) {
		this.trialTime = trialTime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
	}
	public T_mingjie_trial(BigInteger id, BigInteger userId, BigInteger trialUserId, String trialTime, String info, int type, int types) {
		this.id = id;
		this.userId = userId;
		this.trialUserId = trialUserId;
		this.trialTime = trialTime;
		this.info = info;
		this.type = type;
		this.types = types;
	}
	public T_mingjie_trial(BigInteger userId, BigInteger trialUserId, String trialTime, String info, int type, int types) {
		this.userId = userId;
		this.trialUserId = trialUserId;
		this.trialTime = trialTime;
		this.info = info;
		this.type = type;
		this.types = types;
	}
	public T_mingjie_trial() {
	}
	@Override
	public String toString() {
		return "T_mingjie_trial [id=" + id + ", userId=" + userId + ", trialUserId=" + trialUserId + ", trialTime="
				+ trialTime + ", info=" + info + ", type=" + type + ", types=" + types + "]";
	}
}
