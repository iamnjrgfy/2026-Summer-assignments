package org.example;

public class Sight implements java.io.Serializable{
    private String sightName = null;
    private String zone = null;
    private String category = null;
    private String photoURL = null;
    private String address = null;
    private String description = null;


    public Sight() {}

    public String getSightName() {
        return sightName;
    }

    public String getZone() {
            return zone;
    }

    public String getCategory() {
        return category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SightName: " + sightName + "\n" +
                "Zone: " + zone + "\n" +
                "Category: " + category + "\n" +
                "PhotoURL: " + photoURL + "\n" +
                "Address: " + address + "\n" +
                "Description: " + description + "\n";
    }

}
