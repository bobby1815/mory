/*==================================
   RecommentUpdateController.java
   - ����� ���� ��Ʈ�ѷ� Ŭ����.
==================================*/

package com.kh.mory.Diarycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;


public class Diary_RecommentUpdateController implements Controller
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

		String reco_cont = request.getParameter("reco_cont");
		String reco_seq = request.getParameter("reco_seq");
		String write_seq = request.getParameter("write_seq");
		
		
		try
		{
			DiaryDTO diary = new DiaryDTO();
			
			diary.setReco_cont(reco_cont);
			diary.setReco_seq(reco_seq);
			recommentdao.recommentUpdate(diary);
			modelAndView.setViewName("redirect:diarypost.do?write_seq="+write_seq);

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return modelAndView;
      
   }


   
   

}