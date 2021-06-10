package com.practos.hospital.controller;

import com.practos.hospital.model.USerDoctor;
import com.practos.hospital.repository.UserDoctorRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserDoctorController {

    @Autowired
    UserDoctorRep userDoctorRep;


    //
    @CrossOrigin()
    @GetMapping("userdoctor/{id}")
    public Optional<USerDoctor> getDetail(@PathVariable int id)
    {
        return  userDoctorRep.findById(id);
    }

    //used to fetch data from merged data by user and soctor
//    @CrossOrigin()
//    @GetMapping("userdoctor/user/{uid}/doctor/{did}")
//    public USerDoctor getDetailByDocAndUser(@PathVariable Long uid,@PathVariable Long did)
//    {
//        return  userDoctorRep.getUserByUidDid(did,uid);
//    }
//used to fetch data from merged data by user
    @CrossOrigin()
    @GetMapping("userdoctor/user/{uid}")
    public List<USerDoctor> getDetailByUSer(@PathVariable Long uid)
    {
        return  userDoctorRep.getUserByUid(uid);
    }



}
