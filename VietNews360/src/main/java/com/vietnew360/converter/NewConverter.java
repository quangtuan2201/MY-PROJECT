package com.vietnew360.converter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.vietnew360.dto.NewDTO;
import com.vietnew360.entity.NewEntity;
@Component
public class NewConverter {
	public NewDTO toDto(NewEntity entity) {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setCategoryCode(entity.getCategory().getCode());
		result.setCreatedBy(entity.getCreatedBy());
		result.setCreatedDate(convertToTimestamp(entity.getCreatedDate()));
		result.setModifiedDate(convertToTimestamp(entity.getModifiedDate()));
		result.setModifiedBy(entity.getModifiedBy());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	public NewEntity toEntity(NewEntity result , NewDTO dto ) {
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	 public static Timestamp convertToTimestamp(Date date) {
	        if (date == null) {
	            return null;
	        }
	        return new Timestamp(date.getTime());
	    }


}
