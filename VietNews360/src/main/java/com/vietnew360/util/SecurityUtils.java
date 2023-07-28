package com.vietnew360.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vietnew360.dto.MyUser;

public class SecurityUtils  {
	public static MyUser getPrincipal() {
		//`getPrincipal`: Đại diện cho thông tin người dùng xác thực , thường là đối tượng UserDetaill hoặc các lớp con của nó .//
		//Thông tin này bao gồm tên đăng nhập , MK , thông tin cá nhân và các thuộc tính khác 
		//vì User extends UserDetaill mà MyUser lại extends User
		MyUser myUser = (MyUser)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return myUser;
	}
	
	@SuppressWarnings("unchecked")// bỏ qua cảnh báo ép kiểu 
	public static List<String> getAuthorities(){
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}
		return results;
	}

}
