package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_plague {
	private BigInteger plague_id;
	private String plague_name;
	private int plague_status;
	private String create_time;
	public BigInteger getPlague_id() {
		return plague_id;
	}
	public void setPlague_id(BigInteger plague_id) {
		this.plague_id = plague_id;
	}
	public String getPlague_name() {
		return plague_name;
	}
	public void setPlague_name(String plague_name) {
		this.plague_name = plague_name;
	}
	public int getPlague_status() {
		return plague_status;
	}
	public void setPlague_status(int plague_status) {
		this.plague_status = plague_status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public T_plague(BigInteger plague_id, String plague_name, int plague_status, String create_time) {
		this.plague_id = plague_id;
		this.plague_name = plague_name;
		this.plague_status = plague_status;
		this.create_time = create_time;
	}
	public T_plague(String plague_name, int plague_status, String create_time) {
		this.plague_name = plague_name;
		this.plague_status = plague_status;
		this.create_time = create_time;
	}
	public T_plague() {
	}
	@Override
	public String toString() {
		return "T_plague [plague_id=" + plague_id + ", plague_name=" + plague_name + ", plague_status=" + plague_status
				+ ", create_time=" + create_time + "]";
	}
}
