package com.example.dongyu.myapplicationtest.entity;

import cn.bmob.v3.BmobUser;
/**
 * Created by dongyu on 2/29/16.
 */
public class QXuser extends BmobUser {
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
