package com.practos.hospital.controller;

import com.practos.hospital.model.Doctor;
import com.practos.hospital.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

//import org.mockito.Mock;
//
//import static org.junit.jupiter.api.Assertions.*;
//@RunWith(MockitoJUnitRunner.class)
class DoctorControllerTest {
//    @Mock
//    DoctorRepository doctorRepository;
//    @InjectMocks
//    DoctorController doctorController;
//
//    @Test
//    public void testGetAllDoctors(){
//        Mockito.when(doctorRepository.findById(1L)).thenReturn(getDoctor());
////        ResponseEntity<List<Doctor>> responseEntity=doctorController.getAllDoctors();
////        Assert.assertNotNull(responseEntity);
////        Assert.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
////        Assert.assertNotNull(responseEntity.getBody());
//
//    }
//
//    public static Optional<Doctor> getDoctor(){
//        Optional<Doctor> doctor= Optional.of(new Doctor(1L, "username", "password", "name", true, "role", "specialist", "city", 40, 22, "area", "903930303", "emailId@gmail.com"));
////        Doctor doctor1=new Doctor(2L,"username", "password","name",true, "role","specialist","city", 40,  22, "area", "903930303", "emailId@gmail.com");
////        List<Doctor> list=new ArrayList<>();
////list.add(doctor);
////list.add(doctor1);
//        return doctor;
//    }
}