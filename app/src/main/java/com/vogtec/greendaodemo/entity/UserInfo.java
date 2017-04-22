package com.vogtec.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zx on 2017/4/20.
 */
@Entity
public class UserInfo {

    @Id
    private Long id;
    private String username;
    private int watt;
    private double km;
    private double kcal;
    private String time;
    @Generated(hash = 1047098946)
    public UserInfo(Long id, String username, int watt, double km, double kcal,
            String time) {
        this.id = id;
        this.username = username;
        this.watt = watt;
        this.km = km;
        this.kcal = kcal;
        this.time = time;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getWatt() {
        return this.watt;
    }
    public void setWatt(int watt) {
        this.watt = watt;
    }
    public double getKm() {
        return this.km;
    }
    public void setKm(double km) {
        this.km = km;
    }
    public double getKcal() {
        return this.kcal;
    }
    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", watt=" + watt +
                ", km=" + km +
                ", kcal=" + kcal +
                '}';
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
