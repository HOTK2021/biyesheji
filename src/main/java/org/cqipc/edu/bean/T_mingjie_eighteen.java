package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_mingjie_eighteen {
	private BigInteger id;
	private String eightName;
	private String info;
	private int level;
	private String create_time;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getEightName() {
		return eightName;
	}
	public void setEightName(String eightName) {
		this.eightName = eightName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public T_mingjie_eighteen(BigInteger id, String eightName, String info, int level, String create_time) {
		this.id = id;
		this.eightName = eightName;
		this.info = info;
		this.level = level;
		this.create_time = create_time;
	}
	public T_mingjie_eighteen(String eightName, String info, int level, String create_time) {
		this.eightName = eightName;
		this.info = info;
		this.level = level;
		this.create_time = create_time;
	}
	public T_mingjie_eighteen() {
	}
	@Override
	public String toString() {
		return "T_mingjie_eighteen [id=" + id + ", eightName=" + eightName + ", info=" + info + ", level=" + level
				+ ", create_time=" + create_time + "]";
	}
}
