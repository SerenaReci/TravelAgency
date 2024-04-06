package com.sda.TravelAgency.controller;

import com.sda.TravelAgency.dtos.tourDto.CreateTourDto;
import com.sda.TravelAgency.dtos.tourDto.ResponseTourDto;
import com.sda.TravelAgency.entity.Tour;
import com.sda.TravelAgency.service.TourService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tour")
@Tag(
        name ="tour-controller")

public class TourController {
    private TourService tourService;

    @Operation(
            summary = "Create TourController REST API",
            description = "Create TourController REST API is used to save post into database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @PostMapping("/save")
    public ResponseEntity<ResponseTourDto> save(@Valid @RequestBody CreateTourDto createTourDto){
        return new ResponseEntity<>(tourService.save(createTourDto), HttpStatus.CREATED);
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
    public ResponseEntity<List<ResponseTourDto>>findAll(){
        return  ResponseEntity.ok(tourService.findAll());
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
    public ResponseEntity<ResponseTourDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tourService.findById(id));
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
    public ResponseEntity<ResponseTourDto> update(@Valid @RequestBody CreateTourDto createTourDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(tourService.updateById(createTourDto, id));
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
        tourService.deleteById(id);
        return ResponseEntity.ok("Tour with id: "+ id+ " was successfully deleted!");
    }
    @GetMapping("/search")
    public ResponseEntity<List<ResponseTourDto>>searchTours(
        @RequestParam(value="destination",required = false) String destination,
        @RequestParam(value="departureDate",required = false) LocalDate departureDate,
        @RequestParam(value="returnDate",required = false) LocalDate returnDate,
        @RequestParam(value ="duration ",required = false) Integer duration,
        @RequestParam(value ="priceAdult",required = false) Integer priceAdult,
        @RequestParam(value ="priceChild",required = false) Integer priceChild,
        @RequestParam(value ="promotion",required = false) Integer promotion,
        @RequestParam(value ="accommodationType",required = false) String accommodationType)
    {

            return ResponseEntity.ok(tourService.searchTours(destination,departureDate,returnDate,duration,priceChild, priceAdult,promotion,accommodationType));
        }
}





