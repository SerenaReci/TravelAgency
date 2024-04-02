package com.sda.TravelAgency.dtos.roleDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleDto {

    @NotBlank(message = "Role name must not be blank")
    private String roleName;

}
