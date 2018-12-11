package com.anwar.bp_expandablelistview;

public class Information {

    private String num, date, imei,model;


    public Information(String num, String date, String imei, String model) {
        this.num = num;
        this.date = date;
        this.imei = imei;
        this.model = model;

    }

    public String getDate() {
        return date;
    }

    public String getImei() {
        return imei;
    }

    public String getNum() {
        return num;
    }

    public String getModel() {
        return model;
    }


}
