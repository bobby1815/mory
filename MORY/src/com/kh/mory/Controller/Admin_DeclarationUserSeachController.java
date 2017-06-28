package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IDeclarationUserDAO;

public class Admin_DeclarationUserSeachController implements Controller
{
	
	private Admin_IDeclarationUserDAO dao;

	public void setDao(Admin_IDeclarationUserDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		String userId =request.getParameter("write_User_Id");
		System.out.println("userId : "+userId);
		
		
		return null;
	}

}
