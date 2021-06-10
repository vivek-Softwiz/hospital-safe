package com.practos.hospital.controller;

import com.practos.hospital.model.Doctor;

import com.practos.hospital.model.Status;
import com.practos.hospital.model.User;
import com.practos.hospital.model.UserDoctorJoin;
import com.practos.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class DoctorController{


    @Autowired
    DoctorRepository doctorRepository;




    @CrossOrigin()
    @PostMapping("/doctor/login")
    public Doctor loginDoctor(@Valid @RequestBody Doctor doctor) {
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor other : doctors) {
            if (other.equals(doctor)) {
                other.setLoggedIn(true);
                doctorRepository.save(other);
                System.out.println(other);
                return other;
            }
        }
        return null;
    }




    @CrossOrigin()
    @PostMapping("/doctor/logout")
    public Status logUserOut(@Valid @RequestBody Doctor doctor) {
        List<Doctor> doctors = doctorRepository.findAll();

        for (Doctor other : doctors) {
            if (other.equals(doctor)) {
                other.setLoggedIn(false);
                doctorRepository.save(other);

                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }






    @CrossOrigin()
    @PostMapping("/doctor/login/{id}")
    public Optional<Doctor> loginUser(@PathVariable Long id) {
        Optional<Doctor> doctor=doctorRepository.findById(id);



        return null;
    }
  @CrossOrigin()
  @GetMapping("doctor/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
    List<Doctor> doctors = doctorRepository.findAll();
    System.out.println(doctors);
    return new ResponseEntity<>(doctors, HttpStatus.OK);
}

    @CrossOrigin()
    @GetMapping("patient/doctor/{id}")
    public ResponseEntity<List<Map<String,Object>>> getAllDoctorsPatient(@PathVariable Long id) {
        List<Map<String,Object>> doctorsjoin = doctorRepository.getUserByJoin(id);

        return new ResponseEntity<>(doctorsjoin, HttpStatus.OK);
    }


    @CrossOrigin()
    @GetMapping("/doctor/city/{city}/specialist/{specialist}")
    public List<Doctor> getDoctorByCityAndSpec(@PathVariable("city") String city, @PathVariable("specialist")  String specialist) {

        System.out.println(city +"  "+ specialist);
        List<Doctor> doctors = doctorRepository.getDoctorByCityAndSpecialist(city,specialist);
        return doctors;
    }






}


