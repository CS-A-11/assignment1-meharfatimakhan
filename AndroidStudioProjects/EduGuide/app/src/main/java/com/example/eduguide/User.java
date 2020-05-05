package com.example.eduguide;

public class User {
    String emailID;
    String password;
    String fullName;
    String phoneNumber;
    String universityID;
    String departmentID;
    String userPhoto;
    String rollNumber;
    String degree;

    public User(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }

    public User(String emailID, String password, String fullName, String phoneNumber, String universityID, String departmentID,String rollNumber, String degree) {
        this.emailID = emailID;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.universityID = universityID;
        this.departmentID = departmentID;
        this.rollNumber = rollNumber;
        this.degree = degree;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityID() {
        return universityID;
    }

    public void setUniversityID(String universityID) {
        this.universityID = universityID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
