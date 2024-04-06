package com.sda.TravelAgency.controller;

import com.sda.TravelAgency.dtos.userDtos.CreateLoginDto;
import com.sda.TravelAgency.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Operation(
            summary = "Login User Rest API",
            description = "Login User Rest API is used to login"
    )

    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @PreAuthorize("/login")
    public ResponseEntity<Authentication> login(@Valid @RequestBody
                                                CreateLoginDto createLoginDto) {

        return ResponseEntity.ok(authenticationService.login(createLoginDto));
    }
}