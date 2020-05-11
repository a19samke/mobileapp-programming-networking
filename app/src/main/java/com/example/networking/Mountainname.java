package com.example.networking;

import java.util.List;

public class Mountainname {

    private String ID;
    private String type;
    private String company;
    private String location;
    private String category;
    private int saze;
    private int cost;

    public Mountainname(String ID, String type, String company, String location, String category, int saze, int cost) {
        this.ID = ID;
        this.type = type;
        this.company = company;
        this.location = location;
        this.category = category;

        this.saze = saze;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }


    public int getSaze() {
        return saze;
    }

    public int getCost() {
        return cost;
    }
}