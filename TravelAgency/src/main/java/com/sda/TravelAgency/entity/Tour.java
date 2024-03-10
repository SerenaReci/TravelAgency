package com.sda.TravelAgency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int duration;
    private int priceAdult;
    private int priceChild;
    private int promotion;
    private String accommodationType;
}