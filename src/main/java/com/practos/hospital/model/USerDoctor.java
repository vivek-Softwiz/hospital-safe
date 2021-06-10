package com.practos.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class USerDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")

    private User user;
    private String Appointment;
    private String medicationDeatil;

    public USerDoctor() {
    }

    public USerDoctor(Doctor doctor, User user, String appointment, String medicationDeatil) {
        this.doctor = doctor;
        this.user = user;
        this.Appointment = appointment;
        this.medicationDeatil = medicationDeatil;
    }
    public USerDoctor(Doctor doctor, User user, String appointment) {
        this.doctor = doctor;
        this.user = user;
        Appointment = appointment;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAppointment() {
        return Appointment;
    }

    public void setAppointment(String appointment) {
        Appointment = appointment;
    }

    public String getMedicationDetails() {
        return medicationDeatil;
    }

    public void setMedicationDetails(String medicationDetails) {
        this.medicationDeatil = medicationDetails;
    }
}
