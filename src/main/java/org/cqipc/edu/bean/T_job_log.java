package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_job_log {
	private BigInteger log_id;
	private BigInteger job_id;
	private String bean_name;
	private String method_name;
	private String params;
	private String status;
	private String error;
	private double time;
	private String create_time;
	public BigInteger getLog_id() {
		return log_id;
	}
	public void setLog_id(BigInteger log_id) {
		this.log_id = log_id;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public T_job_log() {
	}
	public T_job_log(BigInteger log_id, BigInteger job_id, String bean_name, String method_name, String params, String status,
			String error, double time, String create_time) {
		this.log_id = log_id;
		this.job_id = job_id;
		this.bean_name = bean_name;
		this.method_name = method_name;
		this.params = params;
		this.status = status;
		this.error = error;
		this.time = time;
		this.create_time = create_time;
	}
	public T_job_log(BigInteger job_id, String bean_name, String method_name, String params, String status, String error,
			double time, String create_time) {
		this.job_id = job_id;
		this.bean_name = bean_name;
		this.method_name = method_name;
		this.params = params;
		this.status = status;
		this.error = error;
		this.time = time;
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "T_job_log [log_id=" + log_id + ", job_id=" + job_id + ", bean_name=" + bean_name + ", method_name="
				+ method_name + ", params=" + params + ", status=" + status + ", error=" + error + ", time=" + time
				+ ", create_time=" + create_time + "]";
	}
}
