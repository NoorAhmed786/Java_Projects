package com.example.quickreport;

public class DataClass {
    private String DataTitle;
    private String DataDesc;
    private String DataArea;
    private String DataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() {
        return DataTitle;
    }

    public void setDataTitle(String dataTitle) {
        DataTitle = dataTitle;
    }

    public String getDataDesc() {
        return DataDesc;
    }

    public void setDataDesc(String dataDesc) {
        DataDesc = dataDesc;
    }

    public String getDataArea() {
        return DataArea;
    }

    public void setDataArea(String dataArea) {
        DataArea = dataArea;
    }

    public String getDataImage() {
        return DataImage;
    }

    public void setDataImage(String dataImage) {
        DataImage = dataImage;
    }



    public DataClass(String dataTitle, String dataDesc, String dataArea, String dataImage) {
        DataTitle = dataTitle;
        DataDesc = dataDesc;
        DataArea = dataArea;
        DataImage = dataImage;
    }
    public  DataClass(){

    }
}
