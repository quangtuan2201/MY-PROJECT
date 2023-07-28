package com.vietnew360.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vietnew360.dto.NewDTO;
import com.vietnew360.service.ICategoryService;
import com.vietnew360.service.INewService;
import com.vietnew360.util.MessageUtil;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page , @RequestParam("limit") int limit,HttpServletRequest request) {
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/list" );
		Pageable pageable = new PageRequest(page-1, limit);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessge(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert", message.get("alert"));
			}
		mav.addObject("model",model);
		return mav;
	}

	@RequestMapping(value = "quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView newEdit(@RequestParam(value ="id", required = false) Long id, HttpServletRequest request) {
		NewDTO model =new NewDTO();
		ModelAndView mav = new ModelAndView("admin/new/edit");
		if(id != null) {
			model = newService.findById(id);
		}if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessge(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "quan-tri/bai-viet/tim-kiem" , method = RequestMethod.GET)
	public ModelAndView searchNew(@RequestParam("keyword")String keyword ,HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		return mav;
	}

}
