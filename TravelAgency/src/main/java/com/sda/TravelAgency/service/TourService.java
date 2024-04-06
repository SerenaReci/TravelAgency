package com.sda.TravelAgency.service;
import com.sda.TravelAgency.dtos.tourDto.CreateTourDto;
import com.sda.TravelAgency.dtos.tourDto.ResponseTourDto;
import com.sda.TravelAgency.entity.Tour;
import com.sda.TravelAgency.mapper.TourMapper;
import com.sda.TravelAgency.repository.TourRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TourService{

    private TourRepository tourRepository;
    private TourMapper tourMapper;
    public ResponseTourDto save(CreateTourDto createTourDto) {
        Tour newTour = tourMapper.toEntity(createTourDto);
        Tour savedTour = tourRepository.save(newTour);
        return tourMapper.tourDto(savedTour) ;
    }
    public List<ResponseTourDto> findAll() {
        List<Tour> tourList = tourRepository.findAll();
        List<ResponseTourDto> responseTourDtoList = new ArrayList<>();
        for (Tour tour : tourList) {
            responseTourDtoList.add(tourMapper.tourDto(tour));
        }
        return responseTourDtoList;
    }
    public ResponseTourDto findById(Long tourId) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(
                () -> new RuntimeException("Tour with id: " + tourId + " was not found!"));
        return tourMapper.tourDto(foundTour);
    }
    public ResponseTourDto updateById(CreateTourDto createTourDto, Long existingId) {
        Tour foundTour = tourRepository.findById(existingId).orElseThrow(
                () -> new RuntimeException("Tour with id: " + existingId + " was not found!"));
        foundTour.setId(existingId);
        foundTour.setDestination(createTourDto.getDestination());
        foundTour.setDepartureDate(createTourDto.getDepartureDate());
        foundTour.setReturnDate(createTourDto.getReturnDate());
        foundTour.setDuration(createTourDto.getDuration());
        foundTour.setPriceAdult(createTourDto.getPriceAdult());
        foundTour.setPriceChild(createTourDto.getPriceChild());
        foundTour.setPromotion(createTourDto.getPromotion());
        foundTour.setAccommodationType(createTourDto.getAccommodationType());
        Tour savedTour = tourRepository.save(foundTour);
        return tourMapper.tourDto(savedTour);
    }
    public void deleteById(Long existingId) {
        Tour foundTour = tourRepository.findById(existingId).orElseThrow(
                () -> new RuntimeException("Tour with id: " + existingId + " was not found!"));
        tourRepository.delete(foundTour);
    }

    public List<ResponseTourDto> searchTours(String destination, LocalDate departureDate, LocalDate returnDate,
                                             Integer duration, Integer priceChild, Integer priceAdult, Integer promotion, String accommodationType) {
        List<Tour> tours = new ArrayList<>();
        tours.addAll(tourRepository.findByDestination(destination));
        tours.addAll(tourRepository.findByDepartureDate(departureDate));
        tours.addAll(tourRepository.findByReturnDate(returnDate));
        tours.addAll(tourRepository.findByDuration(duration));
        tours.addAll(tourRepository.findByPriceAdult(priceAdult));
        tours.addAll(tourRepository.findByPriceChild(priceChild));
        tours.addAll(tourRepository.findByPromotion(promotion));
        tours.addAll(tourRepository.findByAccommodationType(accommodationType));

        Set<Tour> uniqueTours = new HashSet<>(tours);
        return uniqueTours.stream().map(tourMapper::tourDto).collect(Collectors.toList());
    }

}
