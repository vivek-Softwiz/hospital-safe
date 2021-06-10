package com.practos.hospital.repository;

import com.practos.hospital.model.Doctor;
import com.practos.hospital.model.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

public interface FooterRep extends JpaRepository<Footer,Long> {
    @Query(value = "select * from footer order by category;",nativeQuery = true)
    public List<Footer> getFooter();
}
