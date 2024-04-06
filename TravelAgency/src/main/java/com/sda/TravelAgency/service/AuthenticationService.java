package com.sda.TravelAgency.service;

import com.sda.TravelAgency.dtos.userDtos.CreateLoginDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private AuthenticationManager authenticationManager;

    public Authentication login(CreateLoginDto createLoginDto){
        Authentication auth=authenticationManager.authenticate(
                (new UsernamePasswordAuthenticationToken
                        (createLoginDto.getPassword(),createLoginDto.getUsernameOrEmail())));
        SecurityContextHolder.getContext().setAuthentication(auth);

        return auth;
    }
}
