package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_IUserDAO;
import com.kh.mory.Model.Admin_UserDTO;

//--���� �˻� ���̵�,�г��� ,�̸�,�������� Controller
public class Admin_UserSeachController implements Controller
{
	private Admin_IUserDAO dao;
	public void setDao(Admin_IUserDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setCharacterEncoding("UTF-8");
		ModelAndView modelAndView = new ModelAndView();
		String value="";
		String name="";
			if ( request.getParameter("value")!=null)
			{
				 value=request.getParameter("value");
				 name = request.getParameter("name");
			}
			else
			{
			}
			
		int start = Integer.parseInt(request.getParameter("start"));
		System.out.println(start);
		int end = Integer.parseInt(request.getParameter("end"));
		
		ArrayList<Admin_UserDTO> userList =  dao.QueryUser(value, name,start,end);

		modelAndView.addObject("result", userList);
		modelAndView.setViewName("WEB-INF/admin/Admin_UserList.jsp");
		
		return modelAndView;
	}

}
