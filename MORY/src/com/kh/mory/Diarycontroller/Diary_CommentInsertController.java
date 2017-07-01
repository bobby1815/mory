/*==================================
   CommentInsertController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
==================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;

public class Diary_CommentInsertController implements Controller
{
	   // DAO �������̽� ����
	   private ICommentDAO commentdao;

	   // setter ����
	  

	   public void setCommentdao(ICommentDAO commentdao)
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
			DiaryDTO diary = new DiaryDTO();
			diary.setComment_cont(comment_cont);
			diary.setUser_id(user_id);
			diary.setWrite_seq(write_seq);
			
			commentdao.commentInsert(diary);
			modelAndView.setViewName("diarypost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;

	}

}