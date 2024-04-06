package com.sda.TravelAgency.repository;

import com.sda.TravelAgency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;



public interface TourRepository extends JpaRepository<Tour,Long> {

    List<Tour>findByDestination(String destination);
    List<Tour> findByDepartureDate(LocalDate departureDate);
    List<Tour> findByReturnDate(LocalDate returnDate);
    List<Tour> findByDuration(Integer duration);
    List<Tour> findByPriceChild(Integer priceChild);
    List<Tour> findByPriceAdult(Integer priceAdult);
    List<Tour> findByPromotion(Integer promotion);
    List<Tour> findByAccommodationType(String accommodationType);

    @Query("SELECT t FROM Tour t LEFT JOIN t.category c WHERE c.name LIKE %?1%")
    List<Tour> findByCategoryName(String name);



}
