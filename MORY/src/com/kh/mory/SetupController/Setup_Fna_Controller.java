package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Setup_Fna_Controller implements Controller

{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelandview = new ModelAndView();
		
		modelandview.setViewName("WEB-INF/Source/Resource/Setup_CS_FnA.jsp");		
		return modelandview;
	}

}
