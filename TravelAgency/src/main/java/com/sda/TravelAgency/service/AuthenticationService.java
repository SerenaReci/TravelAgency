package com.sda.TravelAgency.service;

import com.sda.TravelAgency.dtos.userDtos.CreateLoginDto;
import com.sda.TravelAgency.dtos.userDtos.RegisterUserDto;
import com.sda.TravelAgency.entity.Role;
import com.sda.TravelAgency.entity.User;
import com.sda.TravelAgency.repository.RoleRepository;
import com.sda.TravelAgency.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Service
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public Authentication login(CreateLoginDto createLoginDto) {
        Authentication auth = authenticationManager.authenticate(
                (new UsernamePasswordAuthenticationToken
                        (createLoginDto.getUsernameOrEmail(),createLoginDto.getPassword())));
        SecurityContextHolder.getContext().setAuthentication(auth);

        return auth;
    }

    public User UserRegister(RegisterUserDto registerUserDto) {

        if (userRepository.existsByUsername(registerUserDto.getUsername())) {
            throw new RuntimeException("user with username: " + registerUserDto.getUsername() + " already exist in the database");

        }
        if (userRepository.existsByEmail(registerUserDto.getEmail())) {
            throw new RuntimeException("user with email :" + registerUserDto.getEmail() + "already exist in the database");
        }
        User user = new User();
        user.setEmail(registerUserDto.getEmail());
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        Set<Role>roles = new HashSet<>();
        Role role1 = roleRepository.findByRoleName("ROLE_USER").orElseThrow(()->new RuntimeException("Role not found"));
        roles.add(role1);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
