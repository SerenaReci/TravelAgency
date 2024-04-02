package com.sda.TravelAgency.controller;
import com.sda.TravelAgency.dtos.roleDtos.CreateRoleDto;
import com.sda.TravelAgency.dtos.roleDtos.ResponseRoleDto;
import com.sda.TravelAgency.service.RoleService;
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
@RequestMapping("/api/roles")
@Tag(
        name = "CRUD REST APIs for Role Resource"
)
@SecurityRequirement(name = "basicAuth")
public class RoleController {

    private final RoleService roleService;

    @Operation(
            summary = "Create Role REST API",
            description = "Create Role REST API is used to save a role into the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<ResponseRoleDto> saveRole(@Valid @RequestBody CreateRoleDto createRoleDto) {
        return new ResponseEntity<>(roleService.save(createRoleDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find Role By Id REST API",
            description = "Find Role By Id REST API is used to get a single role from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseRoleDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @Operation(
            summary = "Find All Roles REST API",
            description = "Find All Roles REST API is used to fetch all the roles from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseRoleDto>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @Operation(
            summary = "Update Role REST API",
            description = "Update Role REST API is used to update a role in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseRoleDto> updateRole(@Valid @RequestBody CreateRoleDto createRoleDto, @PathVariable Long id) {
        return ResponseEntity.ok(roleService.update(id, createRoleDto));
    }

    @Operation(
            summary = "Delete Role REST API",
            description = "Delete Role REST API is used to delete a role from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
