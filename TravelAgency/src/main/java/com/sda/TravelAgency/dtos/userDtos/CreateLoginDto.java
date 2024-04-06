package com.sda.TravelAgency.dtos.userDtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoginDto {
    @NotEmpty(message = "Username or Email cannot be empty")
    private String UsernameOrEmail;
    private String password;
}
