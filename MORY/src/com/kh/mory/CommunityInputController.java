package com.kh.mory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CommunityInputController implements Controller
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
		ModelAndView modelandview = new ModelAndView();
		
		String write_user_id = request.getParameter("write_user_id");
		String write_cont = request.getParameter("write_cont");
		int community_type_code = Integer.parseInt(request.getParameter("community_type_code"));
		String community_title = request.getParameter("community_title");
		
		try 
		{
			CommunityDTO dto = new CommunityDTO();
			
			dto.setWrite_user_id(write_user_id);
			dto.setWrite_cont(write_cont);
			dto.setCommunity_type_code(community_type_code);
			dto.setCommunity_title(community_title);
			
			dao.add(dto);
			modelandview.setViewName("/WEB-INF/community/CommunityMain.jsp");
			
			
		} catch (Exception e) 
		{
			
			System.out.println(e.toString());
		}
		
		
		
		return modelandview;
	} 
	

}
