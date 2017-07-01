package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_DeclarationUserDAO;
import com.kh.mory.Dao.Admin_IDeclarationUserDAO;
import com.kh.mory.Dao.Admin_UserDAO;
import com.kh.mory.Model.Admin_DeclarationUserDTO;
import com.kh.mory.Model.Admin_UserDTO;

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
		String userId =request.getParameter("write_User_Id");
		
		Admin_DeclarationUserDTO admin_DeclarationUserDTO = new Admin_DeclarationUserDTO();
		Admin_DeclarationUserDAO admin_DeclarationUserDAO = new Admin_DeclarationUserDAO();
		admin_DeclarationUserDTO = dao.AjaxSearchUser(userId);
		System.out.println("userId : "+userId);
		
		modelAndView.addObject("WRITE_USER_ID",admin_DeclarationUserDTO.getWrite_User_Id());
		modelAndView.addObject("WRITE_CONT",admin_DeclarationUserDTO.getWrite_Cont());
		modelAndView.addObject("WRITE_REG_DTM",admin_DeclarationUserDTO.getWrite_Reg_Dtm());
		
		
		
		modelAndView.setViewName("WEB-INF/admin/Admin_DetailAjax.jsp");
		
		return modelAndView;
	}

}
