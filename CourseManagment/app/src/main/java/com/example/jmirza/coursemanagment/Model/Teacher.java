package com.example.jmirza.coursemanagment.Model;

public class Teacher {
    private int Id;
    private String teacherName;
    private String teacherDept;
    private String teacherPassword;
    private String teacherContactNumber;
    private String teacherEmail ;

    public Teacher(String teacherName, String teacherDept, String teacherPassword, String teacherContactNumber, String teacherEmail) {
        this.teacherName = teacherName;
        this.teacherDept = teacherDept;
        this.teacherPassword = teacherPassword;
        this.teacherContactNumber = teacherContactNumber;
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherDept() {
        return teacherDept;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public String getteacherContactNumber() {
        return teacherContactNumber;
    }

    public String getteacherEmail() {
        return teacherEmail;
    }
}
