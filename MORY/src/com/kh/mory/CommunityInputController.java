package com.kh.mory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println("CommunityInputController==========================================");
		
		request.setCharacterEncoding("UTF-8");
		ModelAndView modelandview = new ModelAndView();
		
		String write_cont = request.getParameter("write_cont");
		int community_type_code = Integer.parseInt(request.getParameter("community_type_code"));
		String community_title = request.getParameter("community_title");
		HttpSession session = request.getSession();
		
		

		
	
		try 
		{
			
			
			CommunityDTO dto = new CommunityDTO();
			String write_user_id =  (String)session.getAttribute("user_id");
			/*System.out.println((String)session.getAttribute("user_id"));*/
			dto.setWrite_user_id(write_user_id);
			dto.setWrite_cont(write_cont);
			dto.setCommunity_type_code(community_type_code);
			dto.setCommunity_title(community_title);
			
			System.out.println(write_user_id+ " , "+ write_cont+" , "+community_type_code+" , "+community_title);
			
			dao.add(dto);
		
			modelandview.setViewName("redirect:communitymypost.do");
			
			
		} catch (Exception e) 
		{
			
			System.out.println(e.toString());
		}
		
		
		return modelandview;
	}
	

}
