package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IUserDAO;
import com.kh.mory.Model.Admin_UserDTO;

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
		ArrayList<Admin_UserDTO>  result = new ArrayList<Admin_UserDTO>();
		
		//유저조회 페이지로 이동
		
		result = dao.UserList();
		
		modelAndView.addObject("result" ,result);
		
		modelAndView.setViewName("WEB-INF/admin/Admin_UserList.jsp");
		return modelAndView;
	}

}
