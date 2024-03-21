package com.markcode.printingshopapp;

import androidx.annotation.NonNull;

public class RegisterModel {
    private int ID;
    private String UserName;

    private String Password;

    private String  FirstName;
    private String LastName;

    private int Age;

    private String BirthDate;


    public RegisterModel(int ID, String userName, String password, String firstName, String lastName, int age, String date) {
        this.ID = ID;
        UserName = userName;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        BirthDate = date;
    }

    public RegisterModel(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public RegisterModel() {
    }



    @Override
    public String toString() {
        return "RegisterModel{" +
                "ID=" + ID +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age=" + Age +
                ", Date='" +  BirthDate + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getBirthDate() {
        return  BirthDate;
    }

    public void setBirthDate (String  BirthDate) {
        BirthDate =  BirthDate;
    }
}
