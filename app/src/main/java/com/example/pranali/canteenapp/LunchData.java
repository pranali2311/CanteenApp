package com.example.pranali.canteenapp;

import java.util.ArrayList;

/**
 * Created by pranali on 14/3/18.
 */

public class LunchData {

    String day;
    String veg1,veg2;
    String riceName;
    String desertName;
    String currDate;

    LunchData(){
    }

    LunchData(String currDate,String day,String veg1, String veg2, String riceName, String desertName){
        this.currDate=currDate;
        this.day=day;
        this.veg1=veg1;
        this.veg2=veg2;
        this.desertName=desertName;
        this.riceName=riceName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getVeg1() {
        return veg1;
    }

    public void setVeg1(String veg1) {
        this.veg1 = veg1;
    }

    public String getVeg2() {
        return veg2;
    }

    public void setVeg2(String veg2) {
        this.veg2 = veg2;
    }

    public String getRiceName() {
        return riceName;
    }

    public void setRiceName(String riceName) {
        this.riceName = riceName;
    }

    public String getDesertName() {
        return desertName;
    }

    public void setDesertName(String desertName) {
        this.desertName = desertName;
    }
}
