package com.sda.TravelAgency.mapper;

import com.sda.TravelAgency.dtos.CreateTourDto;
import com.sda.TravelAgency.dtos.ResponseTourDto;
import com.sda.TravelAgency.entity.Tour;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {
    public ResponseTourDto tourDto(Tour tour){
        ResponseTourDto responseTourDto=new ResponseTourDto();
        responseTourDto.setId(tour.getId());
        responseTourDto.setDuration(tour.getDuration());
        responseTourDto.setDestionation(tour.getDestination());
        responseTourDto.setPromotion(tour.getPromotion());
        responseTourDto.setDepartureDate(tour.getDepartureDate());
        responseTourDto.setPriceAdult(tour.getPriceAdult());
        responseTourDto.setPriceChild(tour.getPriceChild());
        responseTourDto.setAccomodationType(tour.getAccomodationType());
        responseTourDto.setReturnDate(tour.getReturnDate());
        return responseTourDto;
    }

    public Tour toEntity(CreateTourDto createTourDto){
        Tour tour=new Tour();
        tour.setId(createTourDto.getId());
        tour.setDuration(createTourDto.getDuration());
        tour.setPromotion(createTourDto.getPromotion());
        tour.setDestination(createTourDto.getDestination());
        tour.setDepartureDate(createTourDto.getDepartureDate());
        tour.setAccomodationType(createTourDto.getAccomodationType());
        tour.setPriceAdult(createTourDto.getPriceAdult());
        tour.setPriceChild(createTourDto.getPriceChild());
        tour.setReturnDate(createTourDto.getReturnDate());
        return tour;
    }
}
