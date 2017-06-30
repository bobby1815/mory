package com.kh.mory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CommunityMyPostController implements Controller
{
	ICommunityDAO dao;

	public void setDao(ICommunityDAO dao) 
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView modelandview = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		
		
		
		return modelandview;
	}
	
}
