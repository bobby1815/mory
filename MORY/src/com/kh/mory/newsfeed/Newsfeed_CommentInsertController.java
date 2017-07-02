package com.kh.mory.newsfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Newsfeed_CommentInsertController implements Controller
{
	   // DAO �������̽� ����
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
		
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");

		String comment_cont = request.getParameter("commentinsertcont");
		String write_seq = request.getParameter("write_seq");
		try
		{
			Newsfeed_NewsfeedDTO newsfeedDTO = new Newsfeed_NewsfeedDTO();
			newsfeedDTO.setComment_cont(comment_cont);
			newsfeedDTO.setUser_id(user_id);
			newsfeedDTO.setWrite_seq(write_seq);
			
			commentdao.newsFeedCommentInsert(newsfeedDTO);
			modelAndView.setViewName("newsfeed_post.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;

	}



}