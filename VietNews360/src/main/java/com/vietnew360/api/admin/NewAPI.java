package com.vietnew360.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vietnew360.dto.NewDTO;
import com.vietnew360.service.INewService;
import com.vietnew360.service.impl.UploadFile;


@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newServices;
	//@Autowired
	//private UploadFile uploadFile;
	
	
	@PostMapping(value = {"/api/new"})
	public NewDTO createNew(@RequestBody NewDTO newDTO , @RequestParam(value = "file",required = false ) MultipartFile file) {
		//MultipartFile multipartFile = newDTO.getFile();
		//newDTO.setFileURL(file.getOriginalFilename());
		//System.out.println("ten file:"+file.getOriginalFilename());
		//uploadFile.saveImage(file);
		return newServices.save(newDTO);
	}
	
	@PutMapping(value = {"/api/new"})
	public NewDTO updateNew(@RequestBody NewDTO updateNew) {
		return newServices.save(updateNew);
	}
	
	@DeleteMapping(value = {"/api/new"})
	public void deleteNew(@RequestBody long[] ids) {
	newServices.delete(ids);
	}
}
