package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IUserDAO;
import com.kh.mory.Model.Admin_UserDTO;

public class Admin_DetailUserListController implements Controller
{
	// ���� �� ��ȸ Controller
	private Admin_IUserDAO dao;
	
		
	public void setDao(Admin_IUserDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView();
		ArrayList<Admin_UserDTO> list = new ArrayList<Admin_UserDTO>();
		String value = request.getParameter("value");
		String name = request.getParameter("name");
		list =dao.QueryUser(value,name);
		
		modelAndView.addObject("list",list);
		modelAndView.setViewName("WEB-INF/menu/Admin_Detail.jsp");
		return modelAndView;
	}
}