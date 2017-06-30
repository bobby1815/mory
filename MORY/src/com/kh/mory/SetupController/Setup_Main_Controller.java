package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Model.Setup_MainDTO;
import com.kh.mory.Setup_DAO.Setup_MainDAO;

public class Setup_Main_Controller implements Controller
{
	private Setup_MainDAO mainDAO;

	public void setMainDAO(Setup_MainDAO mainDAO)
	{
		this.mainDAO = mainDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		String user_id = request.getParameter("user_Id");
		String user_pw = request.getParameter("user_Pw");
		
<<<<<<< Upstream, based on origin/master
		System.out.println(user_id);
		System.out.println(user_pw);
		
		if(request.getRequestURI().indexOf("/userlogin_setmain.do") > -1)
		{
			
			System.out.println("login");
			Setup_MainDTO mainDTO = mainDAO.userLogin(user_id, user_pw);
			System.out.println(user_id);
			System.out.println(user_pw);
			if(mainDTO.getUser_id() != null)
			{
				System.out.println(user_id);
				System.out.println(user_pw);
				System.out.println("Sucess");
				HttpSession session = request.getSession();
				session.setAttribute("mainDTO",mainDTO);
				session.setAttribute("user_id", mainDTO.getUser_id());
				session.setAttribute("acc_grade_code", mainDTO.getAcc_grade_code());;
				
				modelAndView.addObject("mainDTO",mainDTO);
				modelAndView.setViewName("redirect:profile.do");
				
			}
			
		}
		
=======
>>>>>>> 1b49a7d 지섭이폭탄
		modelAndView.setViewName("WEB-INF/Source/Setup_Main.jsp");
		return modelAndView;
	}

}
