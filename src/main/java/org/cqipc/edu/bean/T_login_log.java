package org.cqipc.edu.bean;

public class T_login_log {
	private String username;
	private String login_time;
	private String location;
	private String ip;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public T_login_log(String username, String login_time, String location, String ip) {
		this.username = username;
		this.login_time = login_time;
		this.location = location;
		this.ip = ip;
	}
	public T_login_log() {
	}
	@Override
	public String toString() {
		return "T_login_log [username=" + username + ", login_time=" + login_time + ", location=" + location + ", ip="
				+ ip + "]";
	}
}
