package com.example.SchoolManagement.model;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "salary")
    private double salary;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;

    public Teacher() {
    }

    public Teacher(String full_name, String qualification, double salary, String address, String email) {
        this.full_name = full_name;
        this.qualification = qualification;
        this.salary = salary;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
