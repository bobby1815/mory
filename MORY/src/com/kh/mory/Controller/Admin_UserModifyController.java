package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IUserDAO;


public class Admin_UserModifyController implements Controller
{
	private Admin_IUserDAO dao;
	
	public void setDao(Admin_IUserDAO dao)
	{
		this.dao = dao;
	}


	//제재상태 변경 Controller
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		request.setCharacterEncoding("UTF-8");
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		String value = request.getParameter("select");
		String user_nic = request.getParameter("user_nic");

		System.out.println(id);
		System.out.println(value);
		System.out.println(user_nic);
		
		dao.UserModify(id,value,user_nic);
		modelAndView.setViewName("redirect:/userlist.do");
		return modelAndView;
	}
	

}
