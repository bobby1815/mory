package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Common_AlarmDAO;
import com.kh.mory.Dao.Common_IAlarmDAO;

/*======================================================

	화면명 : Common_AlarmController.java
	화면 설명 : 공통 알람 컨트롤러
	최초작성일 : 2017-07-03
	작성자 : 박아영

======================================================*/
public class Common_AlarmController implements Controller
{
	private Common_IAlarmDAO alarmDAO;
	
	public void setAlarmDAO(Common_IAlarmDAO alarmDAO)
	{
		this.alarmDAO = alarmDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		// 로그인한 사용자 id
		String user_id = (String)session.getAttribute("user_id");
		
		System.out.println("=========================================");
		System.out.println("Common_AlarmController");
		System.out.println("=========================================");
		System.out.println(request.getRequestURI());
		if (request.getRequestURI().indexOf("commonalarmlist.do") > -1)
		{
			modelAndView.addObject("alarmList", alarmDAO.alarmList(user_id));
			
			modelAndView.setViewName("WEB-INF/Source/Common_AlarmList.jsp");
		}
		else if (request.getRequestURI().indexOf("commonalarmresult.do") > -1)
		{
			String result_yn = request.getParameter("result_yn");
			String requ_seq = request.getParameter("requ_Seq");
			int irequ_seq = Integer.parseInt(requ_seq);
			alarmDAO.alarmConfirm(irequ_seq, result_yn);
			
			modelAndView.setViewName("commonalarmlist.do");
		}
		
		
		return modelAndView;
	}
	
}
