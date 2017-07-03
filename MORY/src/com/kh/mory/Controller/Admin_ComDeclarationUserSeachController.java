package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IDeclarationUserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;

public class Admin_ComDeclarationUserSeachController implements Controller
{

	private Admin_IDeclarationUserDAO dao;

	public void setDao(Admin_IDeclarationUserDAO dao)
	{
		this.dao = dao;
	}

	//--커뮤니티 Ajax처리
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String id= request.getParameter("id");
		ModelAndView modelAndView = new ModelAndView();
		
		Admin_DeclarationUserDTO dto = new Admin_DeclarationUserDTO();
		dto = dao.AjaxCommuSearchUser(id);
		
		modelAndView.addObject("repo_User_Id",dto.getRepo_User_Id());
		modelAndView.addObject("reg_Dtm",dto.getReg_Dtm());
		modelAndView.addObject("community_Title",dto.getCommunity_Title());
		modelAndView.addObject("repo_Reason",dto.getRepo_Reason());
		modelAndView.addObject("write_Cont",dto.getWrite_Cont());
		
		modelAndView.setViewName("WEB-INF/admin/Admin_DetailcomAjax.jsp");
		return modelAndView;
	}
	}
