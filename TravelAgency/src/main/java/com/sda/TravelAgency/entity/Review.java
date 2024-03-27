package com.sda.TravelAgency.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @NotNull(message = "Id cannot be null")
    private Long id;
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

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name= "tour_id",nullable = false)
    private Tour tour;
    }










