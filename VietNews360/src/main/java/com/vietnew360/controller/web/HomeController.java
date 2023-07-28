package com.vietnew360.controller.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vietnew360.dto.NewDTO;
import com.vietnew360.entity.NewEntity;
import com.vietnew360.service.ICategoryService;
import com.vietnew360.service.INewService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	 private final int PAGE_SIZE = 3;

	@RequestMapping(value = {"/","/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam(value ="page", defaultValue = "1") int page  , Model models) {
		//
		ModelAndView mav = new ModelAndView("web/home");
		NewDTO model = new NewDTO();
		Pageable pageable = new PageRequest(page-1, PAGE_SIZE);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setLimit(PAGE_SIZE);
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model",model);
		models.addAttribute("currentPage", page);//currentPage:trang hiện tại,currentPage : số lượng trang
		models.addAttribute("totalPages", model.getTotalPage());
		mav.addObject("categories", categoryService.findAll());
		return mav;
	}
	@RequestMapping(value={"/dang-nhap"} , method =  RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@RequestMapping(value={"/thoat"} , method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request , HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	@RequestMapping(value={"/accessDenied"} , method =  RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView mav = new ModelAndView("redirect:/dang-nhap");
		return mav;
	}


	
}

