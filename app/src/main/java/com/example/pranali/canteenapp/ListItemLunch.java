package com.example.pranali.canteenapp;

public class ListItemLunch {


    private String menuname;
    private int imgid;

    public ListItemLunch(String menuname, int imgid)
    {
        this.menuname=menuname;
        this.imgid=imgid;

    }

    public String getMenuname() {
        return menuname;
    }

    public int getImgid() {
        return imgid;
    }




}