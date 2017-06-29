package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_DeclarationUserDAO;
import com.kh.mory.Dao.Admin_IDeclarationUserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;

public class Admin_BlidDetailUserController implements Controller
{
	private Admin_DeclarationUserDAO dao;
	

	public void setDao(Admin_DeclarationUserDAO dao)
	{
		this.dao = dao;
	}


	//--블라인드 조회에서 피드,커뮤니티 선택해서 가기
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("value");
		String Id = request.getParameter("id");
		String term = request.getParameter("term");
		
		
		ArrayList<Admin_DeclarationUserDTO> lists = dao.BlindSearchList(term, Id, select);
		
		
		//-- 1번이면 뉴스피드jsp로 이동 
		//-- 2번이면 커뮤니티jsp로 이동
		modelAndView.addObject("lists",lists);
		if (select.equals("1"))
		{
			modelAndView.setViewName("WEB-INF/admin/Admin_BlidUser.jsp");
			
		}
		else if (select.equals("2"))
		{
			modelAndView.setViewName("bliddetailcommunity.do");
		}
		
		return modelAndView;
	}

}
