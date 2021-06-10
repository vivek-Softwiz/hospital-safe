package com.practos.hospital.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    private @Id @GeneratedValue long id;
    private @NotBlank String username;
    private @NotBlank String password;
    private boolean loggedIn;
    private String role;
    private String name;
    private String contact;
    private String city;


//    @JsonIgnore
//    @ManyToMany(mappedBy = "userList")
//    private List<Doctor> doctorList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<USerDoctor> userdoctor;


    public User() {
    }

    public User(String username, String password, boolean loggedIn, List<USerDoctor> userdoctor) {
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
        this.userdoctor = userdoctor;
    }

    public List<USerDoctor> getUserdoctor() {
        return userdoctor;
    }

    public void setUserdoctor(List<USerDoctor> userdoctor) {
        this.userdoctor = userdoctor;
    }

    public User(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    public long getId() {
        return id;
    }

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

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }


public  void addprescription(USerDoctor userdoc){
        userdoctor.add(userdoc);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, loggedIn);
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
