package com.sda.TravelAgency.service;
import com.sda.TravelAgency.dtos.CreateTourDto;
import com.sda.TravelAgency.dtos.ResponseTourDto;
import com.sda.TravelAgency.entity.Tour;
import com.sda.TravelAgency.mapper.TourMapper;
import com.sda.TravelAgency.repository.TourRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class TourService{
    //    @Autowired
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
}