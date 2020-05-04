package com.example.networking;

import androidx.annotation.NonNull;

class mobilprog_k2{
    //variabler
    private String name;
    private String location;
    private int size;
    private int cost;
    private String type;


    public mobilprog_k2(String inName, String inType, String inCompany, String inLocation, int inSize) {
        name = inName;
        location = inLocation;
        size = inSize;
        type =inType;
    }

    public mobilprog_k2(String matterhorn, String inName) {
        name = inName;
        location = "";
        size = 8611;
        cost = 28251;


    }

    public mobilprog_k2(String k2) {
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    public String info() {
        String str = name;
        str += "det befinner sig";
        str += location;
        str += "storleken";
        str += Integer.toString(size);
        str += "B.";
        return str;

    }
    public void setSize(int newSize) {
        size = newSize;
        location = "";
        size = 4478;

    }
}
