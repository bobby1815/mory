package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryIDAO.IRecommentDAO;

public class Newsfeed_RecommentDeleteController implements Controller
{
	   // DAO �������̽� ����
	   private Newsfeed_INewsfeedDAO feed_recommentdao;

	   // setter ����
		public void setFeed_recommentdao(Newsfeed_INewsfeedDAO feed_recommentdao)
		{
			this.feed_recommentdao = feed_recommentdao;
		}
	   
	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
	      ModelAndView modelAndView = new ModelAndView();
	      
	      String reco_seq = request.getParameter("reco_seq");
	      String write_seq =request.getParameter("write_seq");
	      feed_recommentdao.newsFeedCommentDelete(reco_seq);
	      
	      modelAndView.setViewName("redirect:newsfeed_post.do?write_seq="+write_seq);
	      
	      return modelAndView;   

	   }





	   
	   

	}