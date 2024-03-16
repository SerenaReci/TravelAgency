package com.sda.TravelAgency.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name ="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "Id cannot be null")
    private Long id;

    @NotBlank(message = "Tour_Type cannot be empty")
    private String Tour_Type;

    @NotBlank(message = "Description cannot be empty")
    private String Description;

}
