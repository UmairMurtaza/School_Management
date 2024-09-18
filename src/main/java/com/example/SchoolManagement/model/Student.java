package com.example.SchoolManagement.model;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "institution")
    private String institution;
    @Column(name = "program")
    private String program;
    @Column(name = "email_id")
    private String email_id;

    public Student() {
    }

    public Student(String full_name, String institution, String program, String email_id) {
        this.full_name = full_name;
        this.institution = institution;
        this.program = program;
        this.email_id = email_id;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
