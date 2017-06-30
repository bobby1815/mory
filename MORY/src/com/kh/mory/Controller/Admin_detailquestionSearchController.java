package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_QuestionDAO;
import com.kh.mory.Model.Admin_QuestionDTO;

public class Admin_detailquestionSearchController implements Controller
{
	
	private Admin_QuestionDAO dao;
	
	public void setDao(Admin_QuestionDAO dao)
	{
		this.dao = dao;
	}

	//-- 작성목록에 뿌려지는 Controller
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		String user_id = request.getParameter("user_id");
		Admin_QuestionDTO dto = dao.AjaxSearch(user_id);
		
		modelAndView.addObject("ques_User_Id",dto.getQues_User_Id());
		modelAndView.addObject("ques_Title",dto.getQues_Title());
		modelAndView.addObject("ques_Reg_Dtm",dto.getQues_Reg_Dtm());
		modelAndView.addObject("checks",dto.getChecks());
		modelAndView.addObject("answ_User_Id",dto.getAnsw_User_Id());
		modelAndView.addObject("ques_Cont",dto.getAnsw_Cont());
		modelAndView.addObject("answ_Cont",dto.getQues_Cont());
		
		modelAndView.setViewName("WEB-INF/admin/Admin_QuestionDetail.jsp");
		return modelAndView;
	}
}