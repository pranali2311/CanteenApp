package com.example.pranali.canteenapp;


public class TypeDetails {

    public String typeName;
    public String time1;
    public int imageId;

    public TypeDetails(String typeName, String time1,int imageId) {
        this.typeName=typeName;
        this.time1=time1;
        this.imageId=imageId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTime1() {
        return time1;
    }

    public int getImageId() {
        return imageId;
    }


}
