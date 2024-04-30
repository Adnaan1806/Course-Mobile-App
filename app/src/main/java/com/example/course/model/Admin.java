package com.example.course.model;

public class Admin {

    private int admin_id;
    private String admin_email;
    private String admin_password;

    public Admin(int admin_id, String admin_email, String admin_password) {
        this.admin_id = admin_id;
        this.admin_email = admin_email;
        this.admin_password = admin_password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_email='" + admin_email + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }

    public String hashPassword(String password) {
        //TODO
        return "";
    }
}
