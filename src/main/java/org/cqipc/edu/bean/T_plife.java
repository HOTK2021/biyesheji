package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_plife {
    private int tp_id;
    private int tp_count;
    private BigInteger userID;
    private String tp_description;
    private String tp_time;
    private BigInteger user_c_id;

    public int getTp_id() {
        return tp_id;
    }

    public int getTp_count() {
        return tp_count;
    }

    public BigInteger getUserID() {
        return userID;
    }

    public String getTp_description() {
        return tp_description;
    }

    public String getTp_time() {
        return tp_time;
    }

    public void setTp_id(int tp_id) {
        this.tp_id = tp_id;
    }

    public void setTp_count(int tp_count) {
        this.tp_count = tp_count;
    }

    public void setUserID(BigInteger userID) {
        this.userID = userID;
    }

    public void setTp_description(String tp_description) {
        this.tp_description = tp_description;
    }

    public void setTp_time(String tp_time) {
        this.tp_time = tp_time;
    }

    public BigInteger getUser_c_id() {
        return user_c_id;
    }

    public void setUser_c_id(BigInteger user_c_id) {
        this.user_c_id = user_c_id;
    }

    public T_plife() {
    }

    public T_plife(int tp_id, int tp_count, BigInteger userID, String tp_description, String tp_time,BigInteger user_c_id) {
        this.tp_id = tp_id;
        this.tp_count = tp_count;
        this.userID = userID;
        this.tp_description = tp_description;
        this.tp_time = tp_time;
        this.user_c_id=user_c_id;
    }

    public T_plife(int tp_count, BigInteger userID, String tp_description, String tp_time,BigInteger user_c_id) {
        this.tp_count = tp_count;
        this.userID = userID;
        this.tp_description = tp_description;
        this.tp_time = tp_time;
        this.user_c_id=user_c_id;
    }

    @Override
    public String toString() {
        return "T_plife{" +
                "tp_id=" + tp_id +
                ", tp_count=" + tp_count +
                ", userID=" + userID +
                ", tp_description='" + tp_description + '\'' +
                ", tp_time='" + tp_time + '\'' +
                ", user_c_id=" + user_c_id +
                '}';
    }
}
