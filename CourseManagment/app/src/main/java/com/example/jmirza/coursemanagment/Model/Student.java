package com.example.jmirza.coursemanagment.Model;

public class Student {
    private int studentId;
    private String studentName;
    private String studentDept;
    private String studentPassword;
    private String studentContactNumber;
    private String studentEmail ;

    public Student(String studentName, String studentDept, String studentPassword, String studentContactNumber, String studentEmail) {
        this.studentName = studentName;
        this.studentDept = studentDept;
        this.studentPassword = studentPassword;
        this.studentContactNumber = studentContactNumber;
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }
    

    public String getStudentDept() {
        return studentDept;
    }
    

    public String getstudentPassword() {
        return studentPassword;
    }


    public String getstudentContactNumber() {
        return studentContactNumber;
    }


    public String getStudentEmail() {
        return studentEmail;
    }
    


 
}
