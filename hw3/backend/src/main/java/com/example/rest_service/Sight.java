package com.example.rest_service;

public class Sight implements java.io.Serializable {
    String sightName = null;
    String zone = null;
    String category = null;
    String photoUrl = null;
    String address = null;
    String description = null;

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

    public String getPhotoUrl() {
        return photoUrl;
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

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "sightName='" + sightName + '\'' +
                ", zone='" + zone + '\'' +
                ", category='" + category + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
