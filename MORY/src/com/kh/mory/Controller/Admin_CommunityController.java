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
		
		if (request.getRequestURL().indexOf("communitylist.do") > -1 )
		{
			System.out.println("--------------------");
			System.out.println("communitylist.do");
			System.out.println("--------------------");
			
			
			ArrayList<Admin_CommunityDTO> lists = new ArrayList<Admin_CommunityDTO>();
			
			lists = communityDao.lists();
			
			System.out.println(lists.size());
			
			modelAndView.addObject("list", lists);
			
			modelAndView.setViewName("WEB-INF/admin/Admin_Community.jsp");
		}
		else if(request.getRequestURL().indexOf("communitysearch.do") > -1 )
		{
			System.out.println("--------------------");
			System.out.println("communitysearch.do");
			System.out.println("--------------------");
			
			String community_type_code = request.getParameter("community_type_code");
			System.out.println("community_type_code : "+community_type_code);
			Admin_CommunityDTO dto = new Admin_CommunityDTO();
			
			dto = communityDao.searchList(community_type_code);
			
			modelAndView.addObject("community_code", dto.getCommunity_type_code());
			modelAndView.addObject("community_name", dto.getCommunity_type_name());
			
			System.out.println(dto.getCommunity_type_code());
			System.out.println(dto.getCommunity_type_name());
			
			modelAndView.setViewName("WEB-INF/admin/Admin_DetailCommunuity.jsp");
			
			
		}
		else if (request.getRequestURI().indexOf("communityseqsearch.do") > -1)
		{
			System.out.println("--------------------");
			System.out.println("communityseqsearch.do");
			System.out.println("--------------------");
			
			int seqcnt = communityDao.seqSearch();
			System.out.println("seqcnt : "+seqcnt);
			
			modelAndView.addObject("seqcnt", seqcnt);
			modelAndView.setViewName("WEB-INF/admin/Admin_CommunitySeqSearch.jsp");
		}
		
		
		return modelAndView;
	}

}
