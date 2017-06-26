package com.kh.mory;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CommunityMainController implements Controller
{
	private ICommunityDAO dao;

	public void setDao(ICommunityDAO dao) 
	{
		this.dao = dao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
			
		ModelAndView modelAndView = new ModelAndView();
		
		ArrayList<CommunityDTO> communitydto = new ArrayList<CommunityDTO>();
		try 
		{
			
			communitydto = dao.list();
			
			

		} catch (Exception e) 
		{
				System.out.println(e.toString());
		}
		

		modelAndView.addObject("communitydto", communitydto);
		modelAndView.setViewName("/WEB-INF/community/CommunityMain.jsp");
		return modelAndView;
		
		
		
		
		
	}

	
	
}
