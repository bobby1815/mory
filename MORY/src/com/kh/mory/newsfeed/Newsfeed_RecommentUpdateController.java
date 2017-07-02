package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;

public class Newsfeed_RecommentUpdateController implements Controller
{
	   // DAO �������̽� �ڷ��� ��� ����
	   private Newsfeed_INewsfeedDAO recommentdao;

	   // setter ����
	   public void setRecommentdao(Newsfeed_INewsfeedDAO recommentdao)
		{
			this.recommentdao = recommentdao;
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
				recommentdao.newsFeedRecommentUpdate(newsfeedDTO);
				modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	      
	   }

	


	   
	   

	}