package com.kh.mory.newsfeed;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;

public class Newsfeed_RecommentListController implements Controller
{
	   // DAO �������̽� �ڷ��� ��� ����
	   private Newsfeed_INewsfeedDAO dao;

	   // setter ����
		public void setDao(Newsfeed_INewsfeedDAO dao)
		{
			this.dao = dao;
		}

	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
		   request.setCharacterEncoding("UTF-8");
		      

			ModelAndView modelAndView = new ModelAndView();

			String commentseq = request.getParameter("commentseq");
			String write_seq = request.getParameter("write_seq");

			try
			{
				Newsfeed_NewsfeedDTO newsfeedDTO = new Newsfeed_NewsfeedDTO();
				
				newsfeedDTO.setComment_seq(commentseq);

				ArrayList<Newsfeed_NewsfeedDTO> commentList =  dao.recommentList(commentseq);
				
				modelAndView.addObject(commentList);

				modelAndView.setViewName("DiaryPost.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	  }


	   
	   
	   
	   

	}