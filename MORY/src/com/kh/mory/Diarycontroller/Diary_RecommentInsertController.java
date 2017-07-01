/*==================================
   RecommentInsertController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
==================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;


public class Diary_RecommentInsertController implements Controller
{
   // DAO �������̽� �ڷ��� ��� ����
   private IRecommentDAO recommentdao;

   // setter ����
   public void setRecommentdao(IRecommentDAO recommentdao)
   {
   	this.recommentdao = recommentdao;
   }
      

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      request.setCharacterEncoding("UTF-8");
      

		ModelAndView modelAndView = new ModelAndView();

		String comment_cont = request.getParameter("cont");
		System.out.println(comment_cont);
		String user_id = request.getParameter("id");
		System.out.println(user_id);
		String commentseq = request.getParameter("commentseq");
		System.out.println(commentseq);
		String write_seq = request.getParameter("write_seq");
		System.out.println(write_seq);
		try
		{
			System.out.println("RECOMMENT");
			DiaryDTO diary = new DiaryDTO();
			
			diary.setComment_cont(comment_cont);
			diary.setUser_id(user_id);
			diary.setComment_seq(commentseq);
			
			recommentdao.recommentInsert(diary);
			modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
   }


   
   
}