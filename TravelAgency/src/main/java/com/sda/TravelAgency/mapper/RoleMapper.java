package com.sda.TravelAgency.mapper;

import com.sda.TravelAgency.dtos.roleDtos.CreateRoleDto;
import com.sda.TravelAgency.dtos.roleDtos.ResponseRoleDto;
import com.sda.TravelAgency.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public ResponseRoleDto mapToResponseRoleDto(Role role) {
        ResponseRoleDto responseRoleDto = new ResponseRoleDto();
        responseRoleDto.setId(role.getId());
        responseRoleDto.setRoleName(role.getRoleName());
        return responseRoleDto;
    }
    public Role mapToRole(CreateRoleDto createRoleDto) {
        Role role = new Role();
        role.setRoleName(createRoleDto.getRoleName());
        return role;
    }
}