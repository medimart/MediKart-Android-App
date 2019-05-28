package com.medikart.medikart;

import android.view.View;

public class Medicine {
    private int medicine_id;
    private String medicine_name;
    public Medicine(){}
    public Medicine(int id, String name){
        this.medicine_id = id;
        this.medicine_name = name;
    }
    public void setID(int id){
        this.medicine_id = id;
    }
    public int getId(){
        return this.medicine_id;
    }
    public void setName(String name){
        this.medicine_name = name;
    }
    public String getName() {
        return this.medicine_name;
    }

}
