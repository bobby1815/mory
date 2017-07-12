package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Model.Setup_IRealation_Management;


public class Setup_Realation_Management_Controller implements Controller
{
	private Setup_IRealation_Management neighbotDAO;
	
	public void setNeighbotDAO(Setup_IRealation_Management neighbotDAO)
	{
		this.neighbotDAO = neighbotDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		// 로그인한 세션 id
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		modelAndView.addObject("neighborLists", neighbotDAO.neighborList(user_id));
		modelAndView.addObject("neighborgiLists", neighbotDAO.neighborgiList(user_id));
		
		modelAndView.setViewName("WEB-INF/Source/Setup_Realation_Management.jsp");
		return modelAndView;
	}

}
