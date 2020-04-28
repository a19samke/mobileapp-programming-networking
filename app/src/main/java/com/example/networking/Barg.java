package com.example.networking;

import androidx.annotation.NonNull;

public class Barg {
    //variabler
    private String name;
    private String location;
    private int size;

    public Barg(String inName, String inType, String inCompany, String inLocation, int inSize) {
        name = inName;
        location = inLocation;
        size = inSize;
    }

    public Barg(String matterhorn, String inName, int i) {
        name = inName;
        location = "";
        size = 8611;

    }

    public Barg(String k2) {
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    public String info() {
        String str = name;
        str += "The Karakoram range";
        str += location;
        str += "8611";
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
