package com.sda.TravelAgency.repository;

import com.sda.TravelAgency.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
