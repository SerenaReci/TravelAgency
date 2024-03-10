package com.sda.TravelAgency.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseTourDto {
    private Long id;
    private String destionation;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int duration;
    private int priceAdult;
    private int priceChild;
    private int promotion;
    private String accomodationType;
}
