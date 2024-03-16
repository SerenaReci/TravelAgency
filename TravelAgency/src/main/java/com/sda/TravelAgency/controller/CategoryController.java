package com.sda.TravelAgency.controller;

import com.sda.TravelAgency.dtos.categoryDto.CreateCategoryDto;
import com.sda.TravelAgency.dtos.categoryDto.ResponseCategoryDto;
import com.sda.TravelAgency.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
@Tag(
        name ="category-controller")

public class CategoryController {
    private CategoryService categoryService;

    @Operation(
            summary = "Create Tour REST API",
            description = "Create Tour REST API is used to save post into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @PostMapping("/save")
    public ResponseEntity<ResponseCategoryDto> save(@Valid @RequestBody CreateCategoryDto createCategoryDto){
        return new ResponseEntity<>(categoryService.save(createCategoryDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find All Tour REST API",
            description = "Find All Tour REST API is used to fetch all the tour from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseCategoryDto>>findAll(){
        return  ResponseEntity.ok(categoryService.findAll());
    }

    @Operation(
            summary = "Get Tour By Id REST API",
            description = "Get Tour By Id REST API is used to get a single tour from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseCategoryDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Operation(
            summary = "update Tour REST API",
            description = "Update Tour REST API is used to update a particular tour in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseCategoryDto> update(@Valid @RequestBody CreateCategoryDto createCategoryDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.updateById(createCategoryDto, id));
    }

    @Operation(
            summary = "Delete Tour REST API",
            description = "Delete Tour REST API is used to delete a particular tour from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Category with id: "+ id+ " was successfully deleted!");
    }
}



