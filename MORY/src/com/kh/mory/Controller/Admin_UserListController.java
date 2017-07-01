package com.kh.mory.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IUserDAO;

public class Admin_UserListController implements Controller
{
	private Admin_IUserDAO dao;
	public void setDao(Admin_IUserDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setCharacterEncoding("UTF-8");
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("WEB-INF/admin/Admin_UserList.jsp");
		return modelAndView;
	}

}
