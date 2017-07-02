/*==================================
   RecommentInsertController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
==================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();

		String comment_cont = request.getParameter("reco_cont");
		String user_id = (String) session.getAttribute("user_id");
		String commentseq = request.getParameter("commentseq");
		String write_seq = request.getParameter("write_seq");
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setReco_cont(comment_cont);
			diary.setUser_id(user_id);
			diary.setComment_seq(commentseq);
			
			int result = recommentdao.recommentInsert(diary);
			System.out.println(result);
			modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
   }


   
   
}