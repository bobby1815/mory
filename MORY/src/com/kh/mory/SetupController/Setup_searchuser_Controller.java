package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Setup_DAO.Setup_Realation_ManagementDAO;

public class Setup_searchuser_Controller implements Controller
{
	
	private Setup_Realation_ManagementDAO managementDAO;

	public void setManagementDAO(Setup_Realation_ManagementDAO managementDAO)
	{
		this.managementDAO = managementDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		String user_Id = request.getParameter("user_Id");
		System.out.println(user_Id);
		
		modelAndView.addObject("userlist", managementDAO.searchuser(user_Id));
		modelAndView.setViewName("WEB-INF/Source/Setup_Realation_Management.jsp");
		return modelAndView;
		
		
	}

}
