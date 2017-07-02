package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_QuestionDAO;
import com.kh.mory.Model.Admin_QuestionDTO;

public class Admin_AnswaddController implements Controller
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
		Admin_QuestionDTO dto = new Admin_QuestionDTO();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("user_id");
		String seq = request.getParameter("seq");
		String answ = request.getParameter("answ");
		
		dto.setAnsw_User_Id(id);
		dto.setSeq(seq);
		dto.setAnsw_Cont(answ);
		
		dao.addanw(dto);
		
		modelAndView.setViewName("WEB-INF/admin/Admin_Question.jsp");
		return modelAndView;
	}

}
