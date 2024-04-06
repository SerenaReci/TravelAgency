package com.sda.TravelAgency.service;


import com.sda.TravelAgency.dtos.categoryDto.CreateCategoryDto;
import com.sda.TravelAgency.dtos.categoryDto.ResponseCategoryDto;
import com.sda.TravelAgency.entity.Category;
import com.sda.TravelAgency.mapper.CategoryMapper;
import com.sda.TravelAgency.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService{

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    public ResponseCategoryDto save(CreateCategoryDto createCategoryDto) {
        Category newCategory = categoryMapper.toEntity(createCategoryDto);
        Category savedCategory = categoryRepository.save(new Category());
        return categoryMapper.CategoryDto(savedCategory) ;
    }
    public List<ResponseCategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<ResponseCategoryDto> responseCategoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            responseCategoryDtoList.add(categoryMapper.CategoryDto(category));
        }
        return responseCategoryDtoList;
    }
    public ResponseCategoryDto findById(Long categoryId) {
        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException("Category with id: " + categoryId + " was not found!"));
        return categoryMapper.CategoryDto(foundCategory);
    }
    public ResponseCategoryDto updateById(CreateCategoryDto createCategoryDto, Long existingId) {
        Category foundCategory = categoryRepository.findById(existingId).orElseThrow(
                () -> new RuntimeException("Category with id: " + existingId + " was not found!"));
        foundCategory.setId(existingId);
        foundCategory.setName(createCategoryDto.getName());
        foundCategory.setDescription(createCategoryDto.getDescription());
        Category savedCategory = categoryRepository.save(foundCategory);
        return categoryMapper.CategoryDto(savedCategory);
    }
    public void deleteById(Long existingId) {
        Category foundCategory = categoryRepository.findById(existingId).orElseThrow(
                () -> new RuntimeException("Category with id: " + existingId + " was not found!"));
       categoryRepository.delete(foundCategory);
    }
}