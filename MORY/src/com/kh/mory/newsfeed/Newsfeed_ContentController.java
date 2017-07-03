package com.kh.mory.newsfeed;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Newsfeed_ContentController implements Controller 
{
	private Newsfeed_INewsfeedDAO feedDao;
	
	public void setFeedDao(Newsfeed_INewsfeedDAO feedDao)
	{
		this.feedDao = feedDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		String write_seq = request.getParameter("write_seq");
		
		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("user_id");
		
		try
		{
			ArrayList<Newsfeed_NewsfeedDTO> commentList = new ArrayList<Newsfeed_NewsfeedDTO>();
			ArrayList<Newsfeed_NewsfeedDTO> recommentList = new ArrayList<Newsfeed_NewsfeedDTO>();
			
			Newsfeed_NewsfeedDTO newsfeedDTO = new Newsfeed_NewsfeedDTO();
			
			// 테스트
			//write_seq = "1";
			newsfeedDTO = feedDao.cont(write_seq);
			recommentList = feedDao.recommentList(write_seq);
			commentList= feedDao.commentList(write_seq);
			
			modelAndView.addObject("write_seq",write_seq);
			modelAndView.addObject("Newsfeed_NewsfeedDTO",newsfeedDTO);
			modelAndView.addObject("recommentList",recommentList);		
			modelAndView.addObject("commentList",commentList);		
			modelAndView.setViewName("WEB-INF/newsfeed/NewsFeed_Post.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return modelAndView;
	}

}