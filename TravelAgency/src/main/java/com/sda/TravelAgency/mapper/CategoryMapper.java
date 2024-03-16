package com.sda.TravelAgency.mapper;

import com.sda.TravelAgency.dtos.categoryDto.CreateCategoryDto;
import com.sda.TravelAgency.dtos.categoryDto.ResponseCategoryDto;
import com.sda.TravelAgency.entity.Category;
import org.springframework.stereotype.Component;
@Component
public class CategoryMapper {

        public ResponseCategoryDto CategoryDto(Category category) {
            ResponseCategoryDto responseCategoryDto= new ResponseCategoryDto();
            responseCategoryDto.setId(category.getId());
            responseCategoryDto.setDescription(category.getDescription());
            responseCategoryDto.setTour_Type(category.getTour_Type());
            return responseCategoryDto;
        }

        public Category toEntity(CreateCategoryDto createCategoryDto) {
            Category category = new Category();
            category.setDescription(createCategoryDto.getDescription());
            category.setTour_Type(createCategoryDto.getTour_Type());

            return category;
        }
    }

