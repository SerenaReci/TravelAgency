package com.sda.TravelAgency.repository;

import com.sda.TravelAgency.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByTourId(Long tourId);
}
