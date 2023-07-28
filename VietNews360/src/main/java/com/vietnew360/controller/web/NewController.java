package com.vietnew360.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vietnew360.dto.NewDTO;
import com.vietnew360.entity.NewEntity;
import com.vietnew360.service.ICategoryService;
import com.vietnew360.service.INewService;

@Controller(value = "newControllerOfWeb")
public class NewController {
	//@Autowired
	//private PostService postService;
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@RequestMapping(value = {"/bai-viet/tim-kiem"})
	public ModelAndView thanTrang(@RequestParam(value ="keyword", required = false) String keyword ,@RequestParam(value ="categoryId", required = false )Long categoryId ,@RequestParam("page") int page , @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("web/home");
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page-1, limit);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		//List<NewDTO> posts=newService.searchNewByCategoryAndKeyword(categoryId, keyword);
		//model.setListResult(posts);
		mav.addObject("model", model);
		
		return mav;
	}
}
