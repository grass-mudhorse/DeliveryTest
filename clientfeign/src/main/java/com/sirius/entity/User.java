package com.sirius.entity;

import lombok.Data;

@Data
public class User extends Account{
    private long userid;
    private String username;
    private String password;
    private String nickname;
    private String telephone;
    private String address;

    public String getPassword() {
        return password;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public long getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }
}
