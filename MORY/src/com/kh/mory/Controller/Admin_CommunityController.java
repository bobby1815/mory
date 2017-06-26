package com.kh.mory.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_ICommunityDAO;
import com.kh.mory.Model.Admin_CommunityDTO;

public class Admin_CommunityController implements Controller
{
	private Admin_ICommunityDAO communityDao;
	
	public void setCommunityDao(Admin_ICommunityDAO communityDao)
	{
		this.communityDao = communityDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		if (request.getRequestURL().indexOf("community.do") > -1 )
		{
			System.out.println("community.do");
			
			ArrayList<Admin_CommunityDTO> lists = new ArrayList<Admin_CommunityDTO>();
			
			lists = communityDao.lists();
			
			System.out.println(lists.size());
			
			modelAndView.addObject("list", lists);
			
			modelAndView.setViewName("WEB-INF/admin/Admin_Community.jsp");
		}
		
		
		return modelAndView;
	}

}
