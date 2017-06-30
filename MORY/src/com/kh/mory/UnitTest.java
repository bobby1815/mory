package com.kh.mory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UnitTest implements Controller
{
	//@RequestMapping("/test.do")
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception 
	{
		ModelAndView mav = new ModelAndView();
		
		int result = 0;
		
		CommunityDTO dto = new CommunityDTO();
		dto.setCommunity_title("커뮤니티");
		dto.setCommunity_type_code(30);
		dto.setWrite_user_id("jin10");
		dto.setWrite_cont("안녕하세요");
		
		CommunityDAO dao = new CommunityDAO();
		
		result = dao.add(dto);
		
		System.out.println(result);
		
		mav.setViewName("Test.jsp");
			
		return mav;
	}

}
