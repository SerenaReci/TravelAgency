package com.sda.TravelAgency.controller;

import com.sda.TravelAgency.dtos.userDtos.CreateUserDto;
import com.sda.TravelAgency.dtos.userDtos.ResponseUserDto;
import com.sda.TravelAgency.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@Tag(
        name = "CRUD REST APIs for User Resource"
)
@SecurityRequirement(name = "basicAuth")
public class UserController {

    private UserService userService;


    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save a user into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<ResponseUserDto> saveUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return new ResponseEntity<>(userService.save(createUserDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find User By Id REST API",
            description = "Find User By Id REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseUserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(
            summary = "Find All Users REST API",
            description = "Find All Users REST API is used to fetch all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseUserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@Valid @RequestBody CreateUserDto createUserDto, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(id, createUserDto));
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
