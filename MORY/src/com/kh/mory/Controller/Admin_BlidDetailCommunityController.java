package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_DeclarationUserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;

public class Admin_BlidDetailCommunityController implements Controller
{
	private Admin_DeclarationUserDAO dao;
	

	public void setDao(Admin_DeclarationUserDAO dao)
	{
		this.dao = dao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("value");
		String Id = request.getParameter("id");
		String term = request.getParameter("term");
		
		ArrayList<Admin_DeclarationUserDTO> cblid = dao.BlindSearchList(term, Id, select);
		
		
		
		modelAndView.addObject("lists",cblid);
		modelAndView.setViewName("WEB-INF/admin/Admin_BlidCommunityUser.jsp");
		return modelAndView;
	}

}
