package com.myapplicationdev.android.p03_ps;

public class Modules {
    String week;
    String grade;

    public Modules(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
