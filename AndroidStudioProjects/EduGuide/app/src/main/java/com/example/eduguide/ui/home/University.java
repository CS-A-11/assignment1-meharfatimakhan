package com.example.eduguide.ui.home;

public class University {
    String ID;
    String universityName;
    String picture;
    String location;

    public University(String ID, String universityName, String picture, String location) {
        this.ID = ID;
        this.universityName = universityName;
        this.picture = picture;
        this.location = location;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
