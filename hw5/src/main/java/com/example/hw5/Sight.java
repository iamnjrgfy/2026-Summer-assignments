package com.example.hw5;
import org.springframework.data.annotation.Id;


public class Sight implements java.io.Serializable {
    @Id
    private String Id;
    private String sightName = null;
    private String zone = null;
    private String photoUrl = null;
    private String address = null;
    private String description = null;

    public Sight() {}

    public String getSightName() {
        return this.sightName;
    }

    public String getZone() {
        return this.zone;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
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
                "sightName='" + this.sightName + '\'' +
                ", zone='" + this.zone + '\'' +
                ", photoUrl='" + this.photoUrl + '\'' +
                ", address='" + this.address + '\'' +
                ", description='" + this.description + '\'' +
                '}';
    }
}
