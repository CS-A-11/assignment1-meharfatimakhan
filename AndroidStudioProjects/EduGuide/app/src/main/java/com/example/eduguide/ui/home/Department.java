package com.example.eduguide.ui.home;

public class Department {
    String ID;
    String deptName;
    String universityCode;
    String picture;

    public Department(String ID, String deptName, String universityCode, String picture) {
        this.ID = ID;
        this.deptName = deptName;
        this.universityCode = universityCode;
        this.picture = picture;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
