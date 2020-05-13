package com.example.networking;

import java.util.List;

public class Mountainname {
    private String ID;
    private String type;
    private  String name;
    private String location;
    private int size;
    private int cost;

    public Mountainname(String ID, String type, String name, String location, int size, int cost) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.location = location;
        this.size = size;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Name" + "\n"+  name + "\n" + "Size" + "\n"  + size + "\n" +"Location" + "\n" +location;

    }

}