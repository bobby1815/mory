package com.kh.mory.Controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_DeclarationUserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;

public class Admin_DeclarationCommunityUserListController implements Controller
{
	private Admin_DeclarationUserDAO dao;
	//setter
	public void setDao(Admin_DeclarationUserDAO dao)
	{
		this.dao = dao;
	}
	
	
	
	
	//-- 조건문에서 커뮤니티로 넘어올때 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");
		String id = request.getParameter("id");
		String term = request.getParameter("term");
		
		ArrayList<Admin_DeclarationUserDTO> 	declarationuser = dao.DeclarationSearchList(value, id, term);
		
		modelAndView.addObject("declarationuser",declarationuser);
		modelAndView.setViewName("WEB-INF/admin/Admin_DeclarationCommunityUserList.jsp");
		
		return modelAndView;
	}

}
