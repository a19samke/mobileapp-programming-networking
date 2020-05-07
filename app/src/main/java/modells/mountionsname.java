package modells;

import java.util.List;

public class mountionsname {
    private String ID;
    private String type;
    private String company;
    private String location;
    private String category;
    private List<auxdata> auxdataList;
    private int saze;
    private int cost;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<auxdata> getAuxdataList() {
        return auxdataList;
    }

    public void setAuxdataList(List<auxdata> auxdataList) {
        this.auxdataList = auxdataList;
    }

    public int getSaze() {
        return saze;
    }

    public void setSaze(int saze) {
        this.saze = saze;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static class auxdata {
        private String wiki;
        private String img;

        public String getWiki() {
            return wiki;
        }

        public void setWiki(String wiki) {
            this.wiki = wiki;
        }
    }

}

