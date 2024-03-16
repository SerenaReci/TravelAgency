package com.sda.TravelAgency.dtos.categoryDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryDto {
    @NotBlank(message = "Tour_Type cannot be empty")
    private String Tour_Type;

    @NotBlank(message = "Description cannot be empty")
    private String Description;
}
