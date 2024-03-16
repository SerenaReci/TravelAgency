package com.sda.TravelAgency.dtos.tourDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateTourDto {

    @NotBlank(message = "Destination cannot be blank")
    private String destination;

    @NotNull(message = "Departure date cannot be null")
    private LocalDate departureDate;

    @NotNull(message = "Return date cannot be null")
    private LocalDate returnDate;

    @NotNull(message = "Duration cannot be null")
    private Integer duration;

    @Min(value = 20, message = "Price for children must be at least 20")
    private Integer priceAdult;

    @Min(value = 10, message = "Price for children must be at least 10")
    private Integer priceChild;

    @NotNull(message = "Promotion cannot be null")
    private Integer promotion;

    @NotBlank(message = "Accommodation type cannot be blank")
    private String accommodationType;
}
