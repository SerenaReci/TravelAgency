package com.sda.TravelAgency.dtos.reviewsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseReviewDto {
    private Long id;
    private String name;
    private String feedback;
    private String email;
    private String description;
    private int nr_Of_stars;
    private Long bookId;
}
