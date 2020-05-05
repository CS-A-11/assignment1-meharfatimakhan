package com.example.eduguide.ui.home;

public class Course {
    String ID;
    String courseName;
    String departmentID;
    String universityID;
    String picture;

    public Course(String ID, String courseName, String departmentID, String universityID,String picture) {
        this.ID = ID;
        this.courseName = courseName;
        this.departmentID = departmentID;
        this.universityID = universityID;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getUniversityID() {
        return universityID;
    }

    public void setUniversityID(String universityID) {
        this.universityID = universityID;
    }
}
