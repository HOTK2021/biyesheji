package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_job {
	private BigInteger job_id;
	private String bean_name;
	private String method_name;
	private String params;
	private String cron_expression;
	private String status;
	private String remark;
	private String create_time;
	public BigInteger getJob_id() {
		return job_id;
	}
	public void setJob_id(BigInteger job_id) {
		this.job_id = job_id;
	}
	public String getBean_name() {
		return bean_name;
	}
	public void setBean_name(String bean_name) {
		this.bean_name = bean_name;
	}
	public String getMethod_name() {
		return method_name;
	}
	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getCron_expression() {
		return cron_expression;
	}
	public void setCron_expression(String cron_expression) {
		this.cron_expression = cron_expression;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public T_job() {
	}
	public T_job(BigInteger job_id, String bean_name, String method_name, String params, String cron_expression, String status,
			String remark, String create_time) {
		this.job_id = job_id;
		this.bean_name = bean_name;
		this.method_name = method_name;
		this.params = params;
		this.cron_expression = cron_expression;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
	}
	public T_job(String bean_name, String method_name, String params, String cron_expression, String status,
			String remark, String create_time) {
		this.bean_name = bean_name;
		this.method_name = method_name;
		this.params = params;
		this.cron_expression = cron_expression;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "T_job [job_id=" + job_id + ", bean_name=" + bean_name + ", method_name=" + method_name + ", params="
				+ params + ", cron_expression=" + cron_expression + ", status=" + status + ", remark=" + remark
				+ ", create_time=" + create_time + "]";
	}
}
