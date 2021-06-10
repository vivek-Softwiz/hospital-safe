package com.practos.hospital.repository;

import com.practos.hospital.model.USerDoctor;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserDoctorRep extends JpaRepository<USerDoctor,Integer> {


//    @Query(value = "select * from user_doctor where doctor_id=:did and user_id=:uid and medication_deatil IS NULL Limit 1,2",nativeQuery = true)
//    public USerDoctor getUserByUidDid(@Param("did") Long doctorId,@Param("uid") Long userId);


    @Query(value = "select * from user_doctor where id= (select MAX(id) from user_doctor where doctor_id=:did and user_id=:uid and medication_deatil is NULL);",nativeQuery = true)
    public Optional<USerDoctor> getUserByUidDid(@Param("did") Long doctorId, @Param("uid") Long userId);

    @Query(value = "select * from user_doctor where user_id=:uid and medication_deatil is not null and appointment IS not NULL;",nativeQuery = true)
    public List<USerDoctor> getUserByUid(@Param("uid") Long userId);
    @Query(value = "select * from user_doctor where user_id=:id AND medication_deatil IS NULL ;",nativeQuery = true)
    public USerDoctor findByUid(@Param("id") Long userId);
}
