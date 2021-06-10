package com.practos.hospital.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;


public class UserDoctorJoin  {

    private Long doctorId;
    private long userId;
    private String username;
    private String Appointment;
//    private String medicationDeatil;
//    private String phoneno;
//    private String name;


    public UserDoctorJoin() {

    }

    public UserDoctorJoin(Long doctorId, Long userId, String username, String appointment) {
        this.doctorId = doctorId;
        this.userId = userId;
        this.username = username;
        Appointment = appointment;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAppointment() {
        return Appointment;
    }

    public void setAppointment(String appointment) {
        Appointment = appointment;
    }

    @Override
    public String toString() {
        return "UserDoctorJoin{" +
                "doctorId=" + doctorId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", Appointment='" + Appointment + '\'' +
                '}';
    }
}
