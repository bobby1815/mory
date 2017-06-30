package com.kh.mory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AjaxController implements Controller
{
	
	private ICommunityDAO dao;

	public void setDao(ICommunityDAO dao) 
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ModelAndView modelandview = new ModelAndView();
		
		
		
			
		String community_type_code = request.getParameter("community_type_code");
		int result = 0;
		

		
		return modelandview;
	}
	

}
