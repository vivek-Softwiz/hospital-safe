package com.practos.hospital.controller;


import com.practos.hospital.helper.CustomException;
import com.practos.hospital.helper.OtpSender;
import com.practos.hospital.model.Doctor;
import com.practos.hospital.model.Status;
import com.practos.hospital.model.USerDoctor;
import com.practos.hospital.model.User;
import com.practos.hospital.repository.DoctorRepository;
import com.practos.hospital.repository.UserDoctorRep;
import com.practos.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDoctorRep userDoctorRep;


    @CrossOrigin()
    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        newUser.setRole("patent");
        System.out.println(newUser);
        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @CrossOrigin()
    @PostMapping("/users/login")
    public User loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                other.setLoggedIn(true);
                userRepository.save(other);
//                return Status.SUCCESS;
                return other;
            }
        }

        return null;
    }

    @CrossOrigin()
    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                other.setLoggedIn(false);
                userRepository.save(other);

                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }


    @CrossOrigin()
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

//    @CrossOrigin()
//    @PutMapping("/{doctorid}/user/{userid}")
//    public Doctor prescriptionUser(@PathVariable Long doctorid,@PathVariable Long userid ) {
//       User user =userRepository.findById(userid).get();
//    Doctor doctor=doctorRepository.findById(doctorid).get();
//    doctor.getAppointment(user);
//    return doctorRepository.save(doctor);
//    }

    //used for setting appointment and medication
    @CrossOrigin()
    @PutMapping("/{doctorid}/user/{userid}")
    public User prescriptionUser(@PathVariable Long doctorid,@PathVariable Long userid ,@RequestBody USerDoctor userDoctor) {
        User user =userRepository.findById(userid).get();
        Doctor doctor=doctorRepository.findById(doctorid).get();
        Optional<USerDoctor> uDoctors=userDoctorRep.getUserByUidDid(doctorid,userid);
        USerDoctor uDoctor = null;
        System.out.println(!uDoctors.isEmpty());
        if(!uDoctors.isEmpty()) {
             uDoctor = uDoctors.get();
        }
        USerDoctor uSerDoctors;
//        System.out.println(uDoctor.getAppointment()+"  "+userDoctor.getAppointment());
//        System.out.println(!uDoctor.getAppointment().equals(userDoctor.getAppointment()));
//

        if(uDoctors.isEmpty()){
            System.out.println("1");
            uSerDoctors=new USerDoctor(doctor,user,userDoctor.getAppointment(),userDoctor.getMedicationDetails());
            user.addprescription(uSerDoctors);
        }
        else if(uDoctor.getAppointment()==null){
            System.out.println("2");
            uDoctor.setAppointment(userDoctor.getAppointment());
            user.addprescription(uDoctor);
        }
       else{
            System.out.println("3");
            uDoctor.setMedicationDetails(userDoctor.getMedicationDetails());
            user.addprescription(uDoctor);
        }



//
//
//
//        if(uDoctor==null||(uDoctor.getAppointment()!=null&&uDoctor.getMedicationDetails()!=null))
//        {
//            uSerDoctors=new USerDoctor(doctor,user,userDoctor.getAppointment(),userDoctor.getMedicationDetails());
//            user.addprescription(uSerDoctors);
//        }
//        else if(uDoctor.getAppointment()==null){
//            uDoctor.setAppointment(userDoctor.getAppointment());
//            user.addprescription(uDoctor);
//        }
//       else{
//            uDoctor.setMedicationDetails(userDoctor.getMedicationDetails());
//            user.addprescription(uDoctor);
//        }

        return userRepository.save(user);

    }

    @CrossOrigin()
    @GetMapping("/send/otp/{phoneno}")
    public String send(@PathVariable("phoneno") String phone) {
        OtpSender otpSender=new OtpSender();

        OtpSender.sendOtp(phone);
        return "SUCCESS";

    }
}
