package com.sda.TravelAgency.dtos.userDtos;

import com.sda.TravelAgency.dtos.roleDtos.ResponseRoleDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseUserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<ResponseRoleDto> roles;
}
