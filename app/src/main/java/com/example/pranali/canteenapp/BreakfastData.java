package com.example.pranali.canteenapp;

import java.util.ArrayList;

/**
 * Created by pranali on 14/3/18.
 */

public class BreakfastData {


    int idli, dosa, samosa, upma, vadapav, poha, sandwich, bournvita, milk, tea, coffee;
    String currDate;

    BreakfastData() {
    }

    public BreakfastData(String currDate,int idli, int dosa, int samosa, int upma, int vadapav, int poha, int sandwich, int bournvita, int milk, int tea, int coffee) {
        this.currDate=currDate;
        this.idli = idli;
        this.dosa = dosa;
        this.samosa = samosa;
        this.upma = upma;
        this.vadapav = vadapav;
        this.poha = poha;
        this.sandwich = sandwich;
        this.bournvita = bournvita;
        this.milk = milk;
        this.tea = tea;
        this.coffee = coffee;
    }

    public int getIdli() {
        return idli;
    }

    public void setIdli(int idli) {
        this.idli = idli;
    }

    public String getCurrDate() {
        return currDate;
    }

    public void setCurrDate(String currDate) {
        this.currDate = currDate;
    }

    public int getDosa() {
        return dosa;
    }

    public void setDosa(int dosa) {
        this.dosa = dosa;
    }

    public int getSamosa() {
        return samosa;
    }

    public void setSamosa(int samosa) {
        this.samosa = samosa;
    }

    public int getUpma() {
        return upma;
    }

    public void setUpma(int upma) {
        this.upma = upma;
    }

    public int getVadapav() {
        return vadapav;
    }

    public void setVadapav(int vadapav) {
        this.vadapav = vadapav;
    }

    public int getPoha() {
        return poha;
    }

    public void setPoha(int poha) {
        this.poha = poha;
    }

    public int getSandwich() {
        return sandwich;
    }

    public void setSandwich(int sandwich) {
        this.sandwich = sandwich;
    }

    public int getBournvita() {
        return bournvita;
    }

    public void setBournvita(int bournvita) {
        this.bournvita = bournvita;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getTea() {
        return tea;
    }

    public void setTea(int tea) {
        this.tea = tea;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }


    /*


    public BreakfastData(String idli, String dosa, String samosa, String upma, String vadapav, String poha, String sandwich, String bournvita, String milk, String tea, String coffee) {
        this.idli = idli;
        this.dosa = dosa;
        this.samosa = samosa;
        this.upma = upma;
        this.vadapav = vadapav;
        this.poha = poha;
        this.sandwich = sandwich;
        this.bournvita = bournvita;
        this.milk = milk;
        this.tea = tea;
        this.coffee = coffee;


    }

    public String getIdli() {
        return idli;
    }

    public void setIdli(String idli) {
        this.idli = idli;
    }

    public String getDosa() {
        return dosa;
    }

    public void setDosa(String dosa) {
        this.dosa = dosa;
    }

    public String getSamosa() {
        return samosa;
    }

    public void setSamosa(String samosa) {
        this.samosa = samosa;
    }

    public String getUpma() {
        return upma;
    }

    public void setUpma(String upma) {
        this.upma = upma;
    }

    public String getVadapav() {
        return vadapav;
    }

    public void setVadapav(String vadapav) {
        this.vadapav = vadapav;
    }

    public String getPoha() {
        return poha;
    }

    public void setPoha(String poha) {
        this.poha = poha;
    }

    public String getSandwich() {
        return sandwich;
    }

    public void setSandwich(String sandwich) {
        this.sandwich = sandwich;
    }

    public String getBournvita() {
        return bournvita;
    }

    public void setBournvita(String bournvita) {
        this.bournvita = bournvita;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }
    */

}


