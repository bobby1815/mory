package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;

public class Newsfeed_CommentUpdateController implements Controller
{
	   // DAO �������̽� �ڷ��� ��� ����
	   private Newsfeed_INewsfeedDAO commentdao;

	   // setter ����
		public void setCommentdao(Newsfeed_INewsfeedDAO commentdao)
		{
			this.commentdao = commentdao;
		}

	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
		   request.setCharacterEncoding("UTF-8");

			ModelAndView modelAndView = new ModelAndView();

			String comment_cont = request.getParameter("comment_cont");
			
			String write_seq=request.getParameter("write_seq");
			String comment_seq = request.getParameter("comment_seq");
			try
			{
				Newsfeed_NewsfeedDTO newsfeedDTO = new Newsfeed_NewsfeedDTO();
				
				newsfeedDTO.setComment_cont(comment_cont);
				newsfeedDTO.setComment_seq(comment_seq);
				
				commentdao.newsFeedCommentUpdate(newsfeedDTO);
				modelAndView.setViewName("redirect:newsfeed_post.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	   }




	   
	   
	   

	}