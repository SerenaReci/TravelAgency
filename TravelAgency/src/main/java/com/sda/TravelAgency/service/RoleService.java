package com.sda.TravelAgency.service;

import com.sda.TravelAgency.dtos.roleDtos.CreateRoleDto;
import com.sda.TravelAgency.dtos.roleDtos.ResponseRoleDto;
import com.sda.TravelAgency.dtos.userDtos.CreateUserDto;
import com.sda.TravelAgency.entity.Role;
import com.sda.TravelAgency.mapper.RoleMapper;
import com.sda.TravelAgency.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public ResponseRoleDto save(CreateRoleDto createRoleDto) {
        Role roleEntity = roleMapper.mapToRole(createRoleDto);
        Role savedRole = roleRepository.save(roleEntity);
        return roleMapper.mapToResponseRoleDto(savedRole);
    }

    public ResponseRoleDto findById(Long id) {
       Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return roleMapper.mapToResponseRoleDto(role);
    }

    public List<ResponseRoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(roleMapper::mapToResponseRoleDto)
                .toList();
    }

    public ResponseRoleDto update(Long id, CreateRoleDto createRoleDto) {
        Role roleEntity = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        roleEntity.setId(id);
        roleEntity.setRoleName(createRoleDto.getRoleName());
        Role savedRole = roleRepository.save(roleEntity);
        return roleMapper.mapToResponseRoleDto(savedRole);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}

