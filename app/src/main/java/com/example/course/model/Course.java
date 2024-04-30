package com.example.course.model;

public class Course {

    private int course_id;
    private String course_name;
    private String start_date;
    private String end_date;
    private double fee;
    private String description;
    private int maximum_part;

    public Course(int course_id, String course_name, String start_date, String end_date, double fee, String description, int maximum_part) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.fee = fee;
        this.description = description;
        this.maximum_part = maximum_part;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaximum_part() {
        return maximum_part;
    }

    public void setMaximum_part(int maximum_part) {
        this.maximum_part = maximum_part;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", fee=" + fee +
                ", description='" + description + '\'' +
                ", maximum_part=" + maximum_part +
                '}';
    }
}
