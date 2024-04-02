package com.sda.TravelAgency.mapper;

import com.sda.TravelAgency.dtos.roleDtos.CreateRoleDto;
import com.sda.TravelAgency.dtos.userDtos.CreateUserDto;
import com.sda.TravelAgency.dtos.userDtos.ResponseUserDto;
import com.sda.TravelAgency.entity.Role;
import com.sda.TravelAgency.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserMapper {

    private final RoleMapper roleMapper;

    public ResponseUserDto mapToResponseUserDto(User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setPassword(user.getPassword());
        Set<Role> roles = user.getRoles();
        responseUserDto.setRoles(roles.stream().map(roleMapper::mapToResponseRoleDto).collect(Collectors.toList()));

        return responseUserDto;
    }

    public User mapToUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(createUserDto.getPassword());
        user.setEmail(createUserDto.getEmail());
        List<CreateRoleDto> roles = createUserDto.getRoles();
        user.setRoles(roles.stream().map(roleMapper::mapToRole).collect(Collectors.toSet()));
        return user;
    }

}


