package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_DeclarationUserDAO;

public class Admin_DeclarationNewSpeedUserListController implements Controller
{

	private Admin_DeclarationUserDAO dao;
	//setter
	public void setDao(Admin_DeclarationUserDAO dao)
	{
		this.dao = dao;
	}

	//-- 신고뉴스피드 조회 Controller
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		
			ModelAndView modelAndView = new ModelAndView();
			
			
			modelAndView.setViewName("WEB-INF/admin/Admin_DeclarationNewSpeedUserList.jsp");
			return modelAndView;
		
	}
}

