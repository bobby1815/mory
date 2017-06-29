package com.kh.mory.Diarycontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;

public class Diary_ContentController implements Controller 
{
	private IDiaryDAO dao;
	private ICommentDAO commentdao;
	private IRecommentDAO recommentdao;
	
	
	public void setCommentdao(ICommentDAO commentdao)
	{
		this.commentdao = commentdao;
	}



	public void setRecommentdao(IRecommentDAO recommentdao)
	{
		this.recommentdao = recommentdao;
	}



	public void setDao(IDiaryDAO dao)
	{
		this.dao = dao;
	}
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		String write_seq = request.getParameter("write_seq");
		
		
		HttpSession session = request.getSession();
		
		
		
		
		try
		{
			ArrayList<DiaryDTO> commentList = new ArrayList<DiaryDTO>();
			ArrayList<DiaryDTO> recommentList = new ArrayList<DiaryDTO>();
			
			
			DiaryDTO diaryDTO = new DiaryDTO();
			
			
			//write_seq = "1";
			
			diaryDTO = dao.cont(write_seq);
			
			
			
			
			recommentList = recommentdao.recommentList(write_seq);
			commentList= commentdao.commentList(write_seq);
			
			modelAndView.addObject("write_seq",write_seq);
			modelAndView.addObject("diaryDTO",diaryDTO);
			modelAndView.addObject("diaryDTO",diaryDTO);
			modelAndView.addObject("recommentList",recommentList);		
			modelAndView.addObject("commentList",commentList);		
			modelAndView.setViewName("WEB-INF/Diary/DiaryPost.jsp");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
		
		
		return modelAndView;
	}

}
