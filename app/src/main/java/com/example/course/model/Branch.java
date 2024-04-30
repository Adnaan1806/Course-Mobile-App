package com.example.course.model;

public class Branch {

    private int branch_id;
    private String branch_name;
    private String branch_location;

    public Branch(int branch_id, String branch_name, String branch_location) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.branch_location = branch_location;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public void setBranch_location(String branch_location) {
        this.branch_location = branch_location;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_id=" + branch_id +
                ", branch_name='" + branch_name + '\'' +
                ", branch_location='" + branch_location + '\'' +
                '}';
    }


}
