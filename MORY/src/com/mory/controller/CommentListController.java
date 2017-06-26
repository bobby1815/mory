package com.mory.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mory.diary.DiaryDTO;
import com.mory.idao.ICommentDAO;

public class CommentListController implements Controller
{
	   // DAO �������̽� �ڷ��� ��� ����
	   private ICommentDAO dao;

	   // setter ����
	   public void setDao(ICommentDAO dao)
	   {
	      this.dao = dao;
	   }

	   @Override
	   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
	      request.setCharacterEncoding("UTF-8");
	      

			ModelAndView modelAndView = new ModelAndView();

			String write_seq = request.getParameter("write_seq");

			try
			{
				DiaryDTO diary = new DiaryDTO();
				
				diary.setWrite_seq(write_seq);

				ArrayList<DiaryDTO> commentList =  dao.commentList(write_seq);
				
				modelAndView.addObject(commentList);

				modelAndView.setViewName("DiaryPost.do?write_seq="+write_seq);

			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

			return modelAndView;
	   }
}
