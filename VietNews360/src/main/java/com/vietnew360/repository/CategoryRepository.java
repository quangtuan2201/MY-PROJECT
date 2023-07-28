package com.vietnew360.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vietnew360.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
	CategoryEntity findByCode(String code);
	

}
