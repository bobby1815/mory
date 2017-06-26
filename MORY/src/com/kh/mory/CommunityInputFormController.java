package com.kh.mory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CommunityInputFormController implements Controller
{
	private ICommunityDAO dao;

	public ICommunityDAO getDao() {
		return dao;
	}

	public void setDao(ICommunityDAO dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{

		return null;
	}
	
	
}
