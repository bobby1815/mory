package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class Newsfeed_RecommentUpdateController implements Controller
{
	   // DAO �������̽� �ڷ��� ��� ����
	   private Newsfeed_INewsfeedDAO feed_recommentdao;

	   // setter ����
		public void setFeed_recommentdao(Newsfeed_INewsfeedDAO feed_recommentdao)
		{
			this.feed_recommentdao = feed_recommentdao;
		}

	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
		   request.setCharacterEncoding("UTF-8");

			ModelAndView modelAndView = new ModelAndView();

			String reco_cont = request.getParameter("reco_cont");
			String reco_seq = request.getParameter("reco_seq");
			String write_seq = request.getParameter("write_seq");
			
			
			try
			{
				Newsfeed_NewsfeedDTO newsfeedDTO = new Newsfeed_NewsfeedDTO();
				
				newsfeedDTO.setRecomment_cont(reco_cont);
				newsfeedDTO.setRecomment_seq(reco_seq);
				feed_recommentdao.newsFeedRecommentUpdate(newsfeedDTO);
				modelAndView.setViewName("redirect:newsfeed_post.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	      
	   }


	


	   
	   

	}