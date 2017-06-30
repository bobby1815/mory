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
		request.setCharacterEncoding("UTF-8");

			
		ModelAndView modelAndView = new ModelAndView();		
		ArrayList<CommunityDTO> communitydto = new ArrayList<CommunityDTO>();
		
		String community_type_code = request.getParameter("community_type_code");
				
		
		
		try 
		{
			
			CommunityDTO dto = new CommunityDTO();
			
			
			
			communitydto = dao.list(30);
		
			 
			 
			 
			modelAndView.addObject("communitydto",communitydto );
		
		
		
			modelAndView.setViewName("/WEB-INF/community/CommunityMain.jsp");

		} catch (Exception e) 
		{
				System.out.println(e.toString());
		}

		
		return modelAndView;
	
		
		
		
		
	}

	
	
}
