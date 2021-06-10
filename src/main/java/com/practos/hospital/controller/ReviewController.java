package com.practos.hospital.controller;

import com.practos.hospital.model.Doctor;
import com.practos.hospital.model.Review;
import com.practos.hospital.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @CrossOrigin()
    @GetMapping("review/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> review =reviewRepository.findAll();
        System.out.println(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}
