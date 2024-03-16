package com.sda.TravelAgency.service;

import com.sda.TravelAgency.dtos.reviewsDto.CreateReviewDto;
import com.sda.TravelAgency.dtos.reviewsDto.ResponseReviewDto;
import com.sda.TravelAgency.entity.Review;
import com.sda.TravelAgency.entity.Tour;
import com.sda.TravelAgency.mapper.ReviewMapper;
import com.sda.TravelAgency.repository.ReviewRepository;
import com.sda.TravelAgency.repository.TourRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;
    private TourRepository tourRepository;


    public ResponseReviewDto save(long tourId, CreateReviewDto createReviewDto) {
       Tour foundTour = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour with id: " + tourId + "was not found"));

        Optional<Tour> existingTour = tourRepository.findById(tourId);
        if (existingTour.isEmpty()) {
            throw new RuntimeException("Tour with id: " + tourId + "was not found");
        } else existingTour.get();

        Review review = reviewMapper.mapToEntity(createReviewDto);
        review.setTour(foundTour);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.mapToDto(savedReview);
    }


    public List<ResponseReviewDto> findByTourId(long tourId) {
        List<Review>reviewList = reviewRepository.findByTourId(tourId);
        List<ResponseReviewDto> responseReviewDto = new ArrayList<>();
        for (Review review:reviewList) {
            responseReviewDto.add(reviewMapper.mapToDto(review));
        }
        return responseReviewDto;
    }

    public ResponseReviewDto findByReviewId(long tourId, long reviewId) {
       Tour foundTour = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour with id: " + tourId + "was not found"));
        Review foundReview = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review with id: " + reviewId + " was not found"));

        if (!(foundReview.getTour().getId() == foundTour.getId())) {
            throw new RuntimeException("Tour with id: " + tourId + " doesn't corresponds to review with id: " + reviewId);
        }
        return reviewMapper.mapToDto(foundReview);
    }


    public ResponseReviewDto updateByReviewId(long tourId, long reviewId, CreateReviewDto createReviewDto) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour with id: " + tourId + "was not found"));
        Review foundReview = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review with id: " + reviewId + " was not found"));

        if (!(foundReview.getTour().getId() == foundTour.getId())) {
            throw new RuntimeException("Tour with id: " + tourId + " doesn't corresponds to review with id: " + reviewId);
        }
        foundReview.setId(reviewId);
        foundReview.setName(createReviewDto.getName());
        foundReview.setFeedback(createReviewDto.getFeedback());
        foundReview.setEmail(createReviewDto.getEmail());
        foundReview.setDescription(createReviewDto.getDescription());
        foundReview.setNr_Of_stars(createReviewDto.getNr_Of_stars());

        Review savedReview = reviewRepository.save(foundReview);
        foundReview.setTour(foundTour);
        return reviewMapper.mapToDto(savedReview);
    }

    public void deleteById(long tourId, long reviewId) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(() -> new RuntimeException("Tour with id: " + tourId + "was not found"));
        Review foundReview = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review with id: " + reviewId + " was not found"));

        if (!(foundReview.getTour().getId() == foundTour.getId())) {
            throw new RuntimeException("Tour with id: " + tourId + " doesn't corresponds to review with id: " + reviewId);
        }
        reviewRepository.delete(foundReview);
    }
}
