package com.sda.TravelAgency.controller;

import com.sda.TravelAgency.dtos.reviewsDto.CreateReviewDto;
import com.sda.TravelAgency.dtos.reviewsDto.ResponseReviewDto;
import com.sda.TravelAgency.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor //per te injektuar te gjitha field qe fusim
@RestController
@RequestMapping("/api/review")
@Tag(
        name ="review-controller")

public class ReviewController {
        private ReviewService reviewService;

        @Operation(
                summary = "Leave a Review For a Particular Tour REST API",
                description = "Leave a Review REST API is used to save a Review for a particular Tour in the database"
        )
        @ApiResponse(
                responseCode = "201",
                description = "Http Status 201 CREATED"
        )
        @PostMapping("/save/{tourId}")
        public ResponseEntity<ResponseReviewDto> save(@PathVariable("tourId") Long tourId,@Valid @RequestBody CreateReviewDto createReviewDto) {
            return new ResponseEntity<>(reviewService.save(tourId,createReviewDto), HttpStatus.CREATED);

        }

        @Operation(
                summary = "Find All Reviews For a Particular Tour REST API",
                description = "Find All Reviews REST API is used to fetch all the reviews for a particular tour from the database"
        )
        @ApiResponse(
                responseCode = "200",
                description = "Http Status 200 SUCCESS"
        )
        @GetMapping("findByTourId/{tourId}")
        public ResponseEntity<List<ResponseReviewDto>> findByTourId(@PathVariable("tourId") Long tourId) {
            return ResponseEntity.ok(reviewService.findByTourId(tourId));
        }


        @Operation(
                summary = "Find a Review By Id For a Particular Tour REST API",
                description = "Find Review  By Id  For a Particular Tour REST API is used to find a single review for a particular tour from the database"
        )
        @ApiResponse(
                responseCode = "200",
                description = "Http Status 200 SUCCESS"
        )
        @GetMapping("/findBy/{tourId}/{reviewId}")
        public ResponseEntity<ResponseReviewDto> findByReviewId(@PathVariable("tourId") Long tourId,@PathVariable("reviewId") Long reviewId) {
            return ResponseEntity.ok(reviewService.findByReviewId(tourId,reviewId));
        }



        @Operation(
                summary = "Update a Review For a Particular Tour REST API",
                description = "Update Review For a Particular Tour REST API is used to update a particular Review for a particular Tour  in the database"
        )
        @ApiResponse(
                responseCode = "200",
                description = "Http Status 200 SUCCESS"
        )
        @PutMapping("/update/{tourId}/{reviewId}")
        public ResponseEntity<ResponseReviewDto> updateById(@PathVariable("tourId") Long tourId,@PathVariable("reviewId") Long reviewId,@Valid @RequestBody CreateReviewDto createReviewDto) {
            return ResponseEntity.ok(reviewService.updateByReviewId(tourId,reviewId,createReviewDto));
        }


        @Operation(
                summary = "Delete a Review For a Particular Tour REST API",
                description = "Delete Review For a Particular Tour REST API is used to delete a particular Review for a particular Tour from the database"
        )
        @ApiResponse(
                responseCode = "200",
                description = "Http Status 200 SUCCESS"
        )
        @DeleteMapping("/delete/{tourId}/{reviewId}")
        public ResponseEntity<String> deleteById(@PathVariable("tourId") Long tourId,@PathVariable("reviewId") Long reviewId) {
            reviewService.deleteById(tourId,reviewId);
            return ResponseEntity.ok("Review successfully deleted!");
        }
    }

