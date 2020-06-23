package org.cqipc.edu.bean;

import java.math.BigInteger;

public class T_plague_user {
    private BigInteger id;
    private BigInteger userid;
    private String username;
    private BigInteger plague_info_id;

    public BigInteger getId() {
        return id;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public BigInteger getPlague_info_id() {
        return plague_info_id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPlague_info_id(BigInteger plague_info_id) {
        this.plague_info_id = plague_info_id;
    }

    public T_plague_user(BigInteger id, BigInteger userid, String username, BigInteger plague_info_id) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.plague_info_id = plague_info_id;
    }

    public T_plague_user(BigInteger userid, String username, BigInteger plague_info_id) {
        this.userid = userid;
        this.username = username;
        this.plague_info_id = plague_info_id;
    }

    public T_plague_user() {
    }

    @Override
    public String toString() {
        return "T_plague_user{" +
                "id=" + id +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", plague_info_id=" + plague_info_id +
                '}';
    }
}
