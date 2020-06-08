package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_area {
	private BigInteger id;
	private int code;
	private String name;
	private String info;
	private String createTime;
	private int fatherId;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getFatherId() {
		return fatherId;
	}
	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}
	public T_area(BigInteger id, int code, String name, String info, String createTime, int fatherId) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.info = info;
		this.createTime = createTime;
		this.fatherId = fatherId;
	}
	public T_area(int code, String name, String info, String createTime, int fatherId) {
		this.code = code;
		this.name = name;
		this.info = info;
		this.createTime = createTime;
		this.fatherId = fatherId;
	}
	public T_area() {
	}
	@Override
	public String toString() {
		return "T_area [id=" + id + ", code=" + code + ", name=" + name + ", info=" + info + ", createTime="
				+ createTime + ", fatherId=" + fatherId + "]";
	}
}
