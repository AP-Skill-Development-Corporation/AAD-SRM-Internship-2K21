package com.example.profileexample;

public class MyModel {
    String img,name,mail,roll,phone;

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getRoll() {
        return roll;
    }

    public String getPhone() {
        return phone;
    }

    public MyModel() {
    }

    public MyModel(String img, String name, String mail, String roll, String phone) {
        this.img = img;
        this.name = name;
        this.mail = mail;
        this.roll = roll;
        this.phone = phone;
    }
}
