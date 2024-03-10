package com.sda.TravelAgency.repository;

import com.sda.TravelAgency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour,Long> {
}
