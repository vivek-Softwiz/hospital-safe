package com.practos.hospital.controller;

import com.practos.hospital.model.Doctor;
import com.practos.hospital.model.Footer;
import com.practos.hospital.repository.FooterRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Common {
    @Autowired
    FooterRep footerRep;


    @CrossOrigin()
    @GetMapping("common/footer")
    public ResponseEntity<List<Footer>> getAllFooter() {
        List<Footer> footers = footerRep.getFooter();
        return new ResponseEntity<>(footers, HttpStatus.OK);
    }
}
