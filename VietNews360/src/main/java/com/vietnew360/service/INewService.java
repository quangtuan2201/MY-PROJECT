package com.vietnew360.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.vietnew360.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageble);
	int getTotalItem();
	NewDTO findById(Long id);
	NewDTO save(NewDTO newDTO);
	void delete(long []ids);
	List<NewDTO> searchNew(String keyword); 
	
	
}
