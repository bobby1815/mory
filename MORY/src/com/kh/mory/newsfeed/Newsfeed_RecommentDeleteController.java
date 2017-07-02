package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryIDAO.IRecommentDAO;

public class Newsfeed_RecommentDeleteController implements Controller
{
	   // DAO �������̽� ����
	   private Newsfeed_INewsfeedDAO recommentdao;

	   // setter ����
		public void setRecommentdao(Newsfeed_INewsfeedDAO recommentdao)
		{
			this.recommentdao = recommentdao;
		}
	   
	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
	      ModelAndView modelAndView = new ModelAndView();
	      
	      String reco_seq = request.getParameter("reco_seq");
	      String write_seq =request.getParameter("write_seq");
	      recommentdao.newsFeedCommentDelete(reco_seq);
	      
	      modelAndView.setViewName("redirect:newsfeed_post.do?write_seq="+write_seq);
	      
	      return modelAndView;   

	   }



	   
	   

	}