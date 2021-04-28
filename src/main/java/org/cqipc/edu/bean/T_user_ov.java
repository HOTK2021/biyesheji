package org.cqipc.edu.bean;

import java.beans.Transient;
import java.math.BigInteger;

public class T_user_ov {
    private BigInteger user_id;
    private String username;
    private String password;
    private BigInteger dept_id;
    private String email;
    private String mobile;
    private int status;
    private int age;
    private int totalAge;
    private int overAge;
    private String dieTime;
    private String create_time;
    private String modify_time;
    private String last_login_time;
    private String ssex;
    private String description;
    private String avatar;


    public BigInteger getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public BigInteger getDept_id() {
        return dept_id;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public int getStatus() {
        return status;
    }

    public int getAge() {
        return age;
    }

    public int getTotalAge() {
        return totalAge;
    }

    public int getOverAge() {
        return overAge;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public String getSsex() {
        return ssex;
    }

    public String getDescription() {
        return description;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDieTime() {
        return dieTime;
    }

    public void setDieTime(String dieTime) {
        this.dieTime = dieTime;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDept_id(BigInteger dept_id) {
        this.dept_id = dept_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTotalAge(int totalAge) {
        this.totalAge = totalAge;
    }

    public void setOverAge(int overAge) {
        this.overAge = overAge;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public T_user_ov() {
    }

    public T_user_ov(BigInteger user_id, String username, String password, BigInteger dept_id, String email, String mobile, int status, int age, int totalAge, int overAge, String dieTime, String create_time, String modify_time, String last_login_time, String ssex, String description, String avatar) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.dept_id = dept_id;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.age = age;
        this.totalAge = totalAge;
        this.overAge = overAge;
        this.dieTime = dieTime;
        this.create_time = create_time;
        this.modify_time = modify_time;
        this.last_login_time = last_login_time;
        this.ssex = ssex;
        this.description = description;
        this.avatar = avatar;
    }

    public T_user_ov(String username, String password, BigInteger dept_id, String email, String mobile, int status, int age, int totalAge, int overAge, String dieTime,String create_time, String modify_time, String last_login_time, String ssex, String description, String avatar) {
        this.username = username;
        this.password = password;
        this.dept_id = dept_id;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.age = age;
        this.totalAge = totalAge;
        this.overAge = overAge;
        this.dieTime = dieTime;
        this.create_time = create_time;
        this.modify_time = modify_time;
        this.last_login_time = last_login_time;
        this.ssex = ssex;
        this.description = description;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "T_user_ov{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dept_id=" + dept_id +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", age=" + age +
                ", totalAge=" + totalAge +
                ", overAge=" + overAge +
                ", dieTime='" + dieTime + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                ", last_login_time='" + last_login_time + '\'' +
                ", ssex='" + ssex + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
