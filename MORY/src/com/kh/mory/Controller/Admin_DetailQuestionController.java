package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_QuestionDAO;
import com.kh.mory.Model.Admin_QuestionDTO;

public class Admin_DetailQuestionController implements Controller
{
	
	
	private Admin_QuestionDAO dao;
		
		public void setDao(Admin_QuestionDAO dao)
		{
			this.dao = dao;
		}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		ModelAndView modelAndView = new ModelAndView();

		//값받아오기
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		String term =request.getParameter("term");
		String id = request.getParameter("id");
		
		
		ArrayList<Admin_QuestionDTO> list = dao.QueSearch(term, select, id);

		System.out.println(list);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("WEB-INF/admin/Admin_Question.jsp");
		
		return modelAndView;
	}
	
	

}
