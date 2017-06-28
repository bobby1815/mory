package com.kh.mory.Controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IUserDAO;
import com.kh.mory.Dao.Admin_UserDAO;
import com.kh.mory.Model.Admin_UserDTO;


public class Admin_UserlistSearchController implements Controller
{

	private Admin_IUserDAO dao ;
	

	public void setDao(Admin_IUserDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ModelAndView modelAndView = new ModelAndView();
		String userId = request.getParameter("user_Id");
		
		Admin_UserDTO admin_UserDTO = new Admin_UserDTO();
		Admin_UserDAO admin_UserDAO = new Admin_UserDAO();
		admin_UserDTO = dao.SearchUser(userId);

		//-- Id,이름,닉네임,주소,전화번호,생일,계정상태,제재이전상태
		modelAndView.addObject("user_id",admin_UserDTO.getUser_Id());
		modelAndView.addObject("user_name",admin_UserDTO.getUser_Name());
		modelAndView.addObject("user_nic",admin_UserDTO.getUser_Nic());
		modelAndView.addObject("user_basic",admin_UserDTO.getBasic_Addr());
		modelAndView.addObject("user_detail",admin_UserDTO.getDetail_Addr());
		modelAndView.addObject("user_tel",admin_UserDTO.getUser_Tel());
		modelAndView.addObject("user_mail",admin_UserDTO.getUser_Email());
		modelAndView.addObject("user_birth",admin_UserDTO.getUser_Birth());
		modelAndView.addObject("user_astate",admin_UserDTO.getAcc_State_Name());
		modelAndView.addObject("user_sstate",admin_UserDTO.getSanc_Type_Name());
		
		modelAndView.setViewName("WEB-INF/admin/Admin_DetailAjax.jsp");
		
		return modelAndView;
	}


	

}
