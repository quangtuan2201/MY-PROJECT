package com.vietnew360.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vietnew360.entity.CategoryEntity;
import com.vietnew360.repository.CategoryRepository;
import com.vietnew360.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entitis = categoryRepository.findAll();
		for(CategoryEntity item : entitis ) {
			result.put(item.getCode(),item.getName());
		}	
		return result;
	}
}
