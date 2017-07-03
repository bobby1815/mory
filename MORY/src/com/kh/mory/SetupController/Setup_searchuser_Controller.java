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
		System.out.println("user_Id : "+user_Id);
		
		String value = request.getParameter("value");
		System.out.println("value : "+ value);
		
		
		modelAndView.addObject("userlist", managementDAO.searchuser(user_Id));
		
		// 멤버초대 페이지에서 요청한 경우라면..
		if (value.equals("family"))
		{
			modelAndView.setViewName("WEB-INF/Source/Setup_SearchUser.jsp");
		}
		else
		{
			modelAndView.setViewName("WEB-INF/Source/Setup_Realation_Management.jsp");
		}
			
		return modelAndView;
		
		
	}

}
