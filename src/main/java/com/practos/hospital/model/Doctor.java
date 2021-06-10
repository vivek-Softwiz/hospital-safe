package com.practos.hospital.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private @NotBlank String username;
    private @NotBlank String password;
    private String name;
    private boolean loggedIn;
    private String role;
    private String specialist ;
    private String city ;
    private int fee ;
    private int experience ;
    private String area ;
    private String mobileNo;
    private String emailId;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<USerDoctor> doctoruser;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<USerDoctor> getDoctoruser() {
        return doctoruser;
    }

    public void setDoctoruser(List<USerDoctor> doctoruser) {
        this.doctoruser = doctoruser;
    }

    public Doctor() {

    }
    public Doctor(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    public Doctor(Long id, String username, String password, String name, boolean loggedIn, String role, String specialist, String city, int fee, int experience, String area, String mobileNo, String emailId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.loggedIn = loggedIn;
        this.role = role;
        this.specialist = specialist;
        this.city = city;
        this.fee = fee;
        this.experience = experience;
        this.area = area;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
    }

    public Doctor(String name, String specialist, String city, int fee, int experience, String area, String mobileNo, String emailId) {
        this.name = name;
        this.specialist = specialist;
        this.city = city;
        this.fee = fee;
        this.experience = experience;
        this.area = area;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, loggedIn);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(username, doctor.username) &&
                Objects.equals(password, doctor.password);
    }
}
