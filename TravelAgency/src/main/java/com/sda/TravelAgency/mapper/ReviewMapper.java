package com.sda.TravelAgency.mapper;

import com.sda.TravelAgency.dtos.reviewsDto.CreateReviewDto;
import com.sda.TravelAgency.dtos.reviewsDto.ResponseReviewDto;
import com.sda.TravelAgency.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review mapToEntity(CreateReviewDto createReviewDto) {

        Review review = new Review();
        review.setName(review.getName());
        review.setFeedback(review.getFeedback());
        review.setEmail(review.getEmail());
        review.setDescription(review.getDescription());
        review.setNr_Of_stars(review.getNr_Of_stars());
        return review;
    }


    public ResponseReviewDto mapToDto(Review review) {

        ResponseReviewDto responseReviewDto = new ResponseReviewDto();
            responseReviewDto.setId(review.getId());
            responseReviewDto.setName(review.getName());
            responseReviewDto.setFeedback(review.getFeedback());
            responseReviewDto.setEmail(review.getEmail());
            responseReviewDto.setDescription(review.getDescription());
            responseReviewDto.setNr_Of_stars(review.getNr_Of_stars());
            return responseReviewDto;
        }
    }


