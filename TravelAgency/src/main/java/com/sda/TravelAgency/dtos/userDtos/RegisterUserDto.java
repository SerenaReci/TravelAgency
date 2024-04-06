package com.sda.TravelAgency.dtos.userDtos;

import com.sda.TravelAgency.dtos.roleDtos.CreateRoleDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class RegisterUserDto {

    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 100, message = "Password must be between 6 and 20 characters")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;


}



