package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_dict {
	private BigInteger dict_id;
	private int keyy;
	private String valuee;
	private String field_name;
	private String table_name;
	public BigInteger getDict_id() {
		return dict_id;
	}
	public void setDict_id(BigInteger dict_id) {
		this.dict_id = dict_id;
	}
	public int getKeyy() {
		return keyy;
	}
	public void setKeyy(int keyy) {
		this.keyy = keyy;
	}
	public String getValuee() {
		return valuee;
	}
	public void setValuee(String valuee) {
		this.valuee = valuee;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public T_dict(BigInteger dict_id, int keyy, String valuee, String field_name, String table_name) {
		this.dict_id = dict_id;
		this.keyy = keyy;
		this.valuee = valuee;
		this.field_name = field_name;
		this.table_name = table_name;
	}
	public T_dict(int keyy, String valuee, String field_name, String table_name) {
		this.keyy = keyy;
		this.valuee = valuee;
		this.field_name = field_name;
		this.table_name = table_name;
	}
	public T_dict() {
	}
	@Override
	public String toString() {
		return "T_dict [dict_id=" + dict_id + ", keyy=" + keyy + ", valuee=" + valuee + ", field_name=" + field_name
				+ ", table_name=" + table_name + "]";
	}
}
