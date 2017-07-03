package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Newsfeed_CommentDeleteController implements Controller
{
	   // DAO �������̽� ����
	   private Newsfeed_INewsfeedDAO feed_commentdao;
	  
	   // setter ����
		public void setFeed_commentdao(Newsfeed_INewsfeedDAO feed_commentdao)
		{
			this.feed_commentdao = feed_commentdao;
		}

	@Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
	      ModelAndView modelAndView = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      String user_id = (String) session.getAttribute("user_id");
	      
	      String comment_seq = request.getParameter("comment_seq");
	      String write_seq = request.getParameter("write_seq");
	      
	      int result = feed_commentdao.newsFeedCommentDelete(comment_seq);
	      
	      System.out.println(result);
	      
	      
	      modelAndView.setViewName("redirect:newsfeed_post.do?write_seq="+write_seq);
	      
	      return modelAndView;
	      
	      
	   }



	   
	   
	   
	   
	}