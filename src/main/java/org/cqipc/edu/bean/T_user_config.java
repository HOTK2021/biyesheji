package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_user_config {
	private BigInteger user_id;
	private String theme;
	private String layout;
	private String multi_page;
	private String fix_siderbar;
	private String fix_header;
	private String color;
	public BigInteger getUser_id() {
		return user_id;
	}
	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getMulti_page() {
		return multi_page;
	}
	public void setMulti_page(String multi_page) {
		this.multi_page = multi_page;
	}
	public String getFix_siderbar() {
		return fix_siderbar;
	}
	public void setFix_siderbar(String fix_siderbar) {
		this.fix_siderbar = fix_siderbar;
	}
	public String getFix_header() {
		return fix_header;
	}
	public void setFix_header(String fix_header) {
		this.fix_header = fix_header;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public T_user_config(BigInteger user_id, String theme, String layout, String multi_page, String fix_siderbar,
			String fix_header, String color) {
		this.user_id = user_id;
		this.theme = theme;
		this.layout = layout;
		this.multi_page = multi_page;
		this.fix_siderbar = fix_siderbar;
		this.fix_header = fix_header;
		this.color = color;
	}
	public T_user_config(String theme, String layout, String multi_page, String fix_siderbar, String fix_header,
			String color) {
		this.theme = theme;
		this.layout = layout;
		this.multi_page = multi_page;
		this.fix_siderbar = fix_siderbar;
		this.fix_header = fix_header;
		this.color = color;
	}
	public T_user_config() {
	}
	@Override
	public String toString() {
		return "T_user_config [user_id=" + user_id + ", theme=" + theme + ", layout=" + layout + ", multi_page="
				+ multi_page + ", fix_siderbar=" + fix_siderbar + ", fix_header=" + fix_header + ", color=" + color
				+ "]";
	}
}
