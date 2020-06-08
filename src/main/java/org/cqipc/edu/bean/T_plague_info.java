package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_plague_info {
	private BigInteger plague_info_id;
	private BigInteger plague_id;
	private String area_id;
	private String happen_time;
	private String info;
	public BigInteger getPlague_info_id() {
		return plague_info_id;
	}
	public void setPlague_info_id(BigInteger plague_info_id) {
		this.plague_info_id = plague_info_id;
	}
	public BigInteger getPlague_id() {
		return plague_id;
	}
	public void setPlague_id(BigInteger plague_id) {
		this.plague_id = plague_id;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getHappen_time() {
		return happen_time;
	}
	public void setHappen_time(String happen_time) {
		this.happen_time = happen_time;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public T_plague_info(BigInteger plague_info_id, BigInteger plague_id, String area_id, String happen_time, String info) {
		this.plague_info_id = plague_info_id;
		this.plague_id = plague_id;
		this.area_id = area_id;
		this.happen_time = happen_time;
		this.info = info;
	}
	public T_plague_info(BigInteger plague_id, String area_id, String happen_time, String info) {
		this.plague_id = plague_id;
		this.area_id = area_id;
		this.happen_time = happen_time;
		this.info = info;
	}
	public T_plague_info() {
	}
	@Override
	public String toString() {
		return "T_plague_info [plague_info_id=" + plague_info_id + ", plague_id=" + plague_id + ", area_id=" + area_id
				+ ", happen_time=" + happen_time + ", info=" + info + "]";
	}
}
