package com.sda.TravelAgency.controller;

import com.sda.TravelAgency.dtos.CreateTourDto;
import com.sda.TravelAgency.dtos.ResponseTourDto;
import com.sda.TravelAgency.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tour")

public class TourController {
    private TourService tourService;

    @PostMapping("/save")
    public <ResponseTourDto> save (@RequestBody CreateTourDto createTourDto){
        return tourService.save(createTourDto);
    }

    @GetMapping("/findAll")
    public List<ResponseTourDto>findAll(){
        return tourService.findAll();
    }
    @GetMapping("/findById/{id}")
    public ResponseTourDto findById(@PathVariable("id")Long id) {
        return tourService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseTourDto update(@RequestBody CreateTourDto createTourDto,@PathVariable("id")Long id){
        return tourService.updateById(createTourDto,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        tourService.deleteById(id);
        return "Tour with id: "+ id+ " was successfully deleted!";
    }
}


