package com.kh.mory;

import java.util.ArrayList;

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
		
		ArrayList<CommunityDTO> mypost_list = new ArrayList<CommunityDTO>();
		ArrayList<CommunityDTO> search_list = new ArrayList<CommunityDTO>();
		
		String  community_title1 = request.getParameter("community_title1");
		String  community_title = request.getParameter("community_title");
		String  write_cont = request.getParameter("write_cont");
		
		
		
		
		
		
		
		try 
		{
			
			CommunityDTO dto = new CommunityDTO();
			
			
			
			dto.setCommunity_title(community_title);
			dto.setWrite_cont(write_cont);
			dto.setCommunity_title(community_title1);
			
			
			String write_user_id =  (String)session.getAttribute("user_id");
			
			search_list = dao.search_list(dto);
			mypost_list = dao.mypost_list();
			
			
			modelandview.addObject("search_list", search_list);
			modelandview.addObject("mypost_list", mypost_list);
			
			modelandview.setViewName("/WEB-INF/community/CommunityInputForm.jsp");
			
			
		
		
			
			
			
			
		} catch (Exception e) 
		{
				System.out.println(e.toString());
		}
		
		
		
		
		return modelandview;
	}
	
}
