package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IDeclarationUserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;

public class Admin_DeclarationUserSeachController implements Controller
{
	
	private Admin_IDeclarationUserDAO dao;

	public void setDao(Admin_IDeclarationUserDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		String userId =request.getParameter("id");
		Admin_DeclarationUserDTO admin_DeclarationUserDTO = new Admin_DeclarationUserDTO();
		admin_DeclarationUserDTO = dao.AjaxSearchUser(userId);
		
		
		modelAndView.addObject("REPO_USER_ID",admin_DeclarationUserDTO.getRepo_User_Id());
		modelAndView.addObject("WRITE_CONT",admin_DeclarationUserDTO.getWrite_Cont());
		modelAndView.addObject("REG_DTM",admin_DeclarationUserDTO.getReg_Dtm());
		modelAndView.addObject("REPO_REASON",admin_DeclarationUserDTO.getRepo_Reason());
		modelAndView.setViewName("WEB-INF/admin/Admin_DecalarationAjax.jsp");
		return modelAndView;
	}

}
