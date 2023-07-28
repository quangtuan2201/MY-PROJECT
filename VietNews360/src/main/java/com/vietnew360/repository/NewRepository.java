package com.vietnew360.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vietnew360.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	List<NewEntity> findByTitleContainingIgnoreCase(String keyword);
	List<NewEntity> findByCategory_Id(Long categoryId);
	
	/*@Query("SELECT p FROM NewEntity p WHERE (:categoryId NULL OR p.category.id = :categoryId) AND (p.title LIKE %:keyword% OR :keyword IS NULL)")
    List<NewEntity> searchPostsByCategoryAndKeyword( Long categoryId , String keyword);*/
	
}
