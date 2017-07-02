package com.kh.mory.newsfeed;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;

public class Newsfeed_CommentListController implements Controller
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
			
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");

			String write_seq = request.getParameter("write_seq");

			try
			{
				DiaryDTO diary = new DiaryDTO();
				
				diary.setWrite_seq(write_seq);

				ArrayList<Newsfeed_NewsfeedDTO> commentList =  dao.commentList(write_seq);
				
				modelAndView.addObject(commentList);

				modelAndView.setViewName("WEB-INF/newsfeed/newsfeed_post.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	   }


}