package com.markcode.printingshopapp;

public class ServicesModel {
    Integer ImageID;
    String ServiceTitle;

    public ServicesModel(Integer imageID, String serviceTitle) {
        ImageID = imageID;
        ServiceTitle = serviceTitle;
    }

    public ServicesModel() {

    }

    public Integer getImageID() {
        return ImageID;
    }

    public void setImageID(Integer imageID) {
        ImageID = imageID;
    }

    public String getServiceTitle() {
        return ServiceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        ServiceTitle = serviceTitle;
    }
}
