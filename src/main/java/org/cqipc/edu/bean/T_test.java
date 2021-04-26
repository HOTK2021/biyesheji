package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_test {
	private BigInteger id;
	private String field1;
	private int field2;
	private String field3;
	private String create_time;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public int getField2() {
		return field2;
	}
	public void setField2(int field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public T_test(BigInteger id, String field1, int field2, String field3, String create_time) {
		this.id = id;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.create_time = create_time;
	}
	public T_test(String field1, int field2, String field3, String create_time) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.create_time = create_time;
	}
	public T_test() {
	}
	@Override
	public String toString() {
		return "T_test [id=" + id + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3
				+ ", create_time=" + create_time + "]";
	}
}
