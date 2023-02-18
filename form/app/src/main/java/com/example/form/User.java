package com.example.form;

public class User {

    private String name;
    private String phone;
    private String gender;
    private String education;
    private int age;
    private String sports;
    private String music;

    public User(String name, String phone, String gender, String education, int age, String sports, String music) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.education = education;
        this.age = age;
        this.sports = sports;
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getEducation() {
        return education;
    }

    public int getAge() {
        return age;
    }

    public String getSports() {
        return sports;
    }

    public String getMusic() {
        return music;
    }
}

