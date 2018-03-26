package com.example.pranali.canteenapp;


public class ListItemBreakfast {

    private String heading;
    private String price;
    private int imgid;
    private String itemcnt;

    public ListItemBreakfast(String heading,String price,int imgid,String itemcnt)
    {
        this.heading=heading;
        this.price=price;
        this.imgid=imgid;
        this.itemcnt=itemcnt;
    }

    public void setItemcnt(String itemcnt) {
        this.itemcnt = itemcnt;
    }

    public String getItemcnt() {
        return itemcnt;
    }

    public String getHeading() {
        return heading;
    }

    public String getPrice() {
        return price;
    }

    public int getImgid() {
        return imgid;
    }
}