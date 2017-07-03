package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_DeclarationUserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;

public class Admin_DetailNewSpeedUserListController implements Controller
{
	
	private Admin_DeclarationUserDAO dao;
	//setter
	public void setDao(Admin_DeclarationUserDAO dao)
	{
		this.dao = dao;
	}
	
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");
		String id = request.getParameter("id");
		String term = request.getParameter("term");
		System.out.println(value);
		
		ArrayList<Admin_DeclarationUserDTO> declarationuser = dao.DeclarationSearchList(value, id, term);
		
		modelAndView.addObject("declarationuser",declarationuser);
		
	
		
		if (value.equals("1"))
		{
			modelAndView.setViewName("WEB-INF/admin/Admin_DeclarationNewSpeedUserList.jsp");
		}
		else if(value.equals("2"))
		{
			modelAndView.setViewName("/declarationcommunity.do");
		}
		
		return modelAndView;
	}

	
}
