package com.practos.hospital.repository;

import com.practos.hospital.model.Doctor;

import com.practos.hospital.model.UserDoctorJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query(value = "select us.id,us.doctor_id,us.user_id,u.username,u.name,u.contact,u.city,us.appointment from user_doctor as us,users as u where us.doctor_id=:did and u.id=us.user_id and us.medication_deatil is null;",nativeQuery = true)
    public List<Map<String,Object>> getUserByJoin(@Param("did") Long doctorId);

//@Query(value = "select NEW com.practos.hospital.model.UserDoctorJoin(us.doctor_id,us.user_id,u.username,us.appointment)"+" from user_doctor as us,users as u where us.doctor_id=:did",nativeQuery = true)
//public List<UserDoctorJoin> getUserByJoin(@Param("did") Long doctorId);

    @Query(value="select * from doctors where city=:c and specialist=:s" ,nativeQuery = true)
    public List<Doctor> getDoctorByCityAndSpecialist(@Param("c")String city,@Param("s") String specialist );
}
