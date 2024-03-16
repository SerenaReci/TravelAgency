package com.sda.TravelAgency.dtos.reviewsDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Feedback cannot be empty")
    private String feedback;

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 10, max = 1000, message = "Description length must be between 15 and 500 characters")
    private String description;

    @NotNull(message = "Number of stars must be specified")
    private Integer nr_Of_stars;
}
