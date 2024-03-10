package com.sda.TravelAgency.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateTourDto {

    private Long id;
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int duration;
    private int priceAdult;
    private int priceChild;
    private int promotion;
    private String accomodationType;


}
