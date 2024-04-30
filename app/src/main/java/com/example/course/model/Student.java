package com.example.course.model;

public class Student {

    private int student_id;
    private String name;
    private String email;
    private String address;
    private String city;
    private String login_code;
    private String phone;
    private String gender;
    private String DOB;


    public Student(int student_id, String name, String email, String address, String city, String login_code, String phone, String gender, String DOB) {
        this.student_id = student_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.login_code = login_code;
        this.phone = phone;
        this.gender = gender;
        this.DOB = DOB;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogin_code() {
        return login_code;
    }

    public void setLogin_code(String login_code) {
        this.login_code = login_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", login_code='" + login_code + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }
}
