package com.kh.mory.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Dao.Admin_BlindSanctionDAO;
import com.kh.mory.Dao.Admin_BlindSetupDAO;
import com.kh.mory.Dao.Admin_LeaveDAO;
import com.kh.mory.Dao.Admin_SanctionTypeDAO;
import com.kh.mory.Model.Admin_BlindDTO;
import com.kh.mory.Model.Admin_LeaveDTO;
/*========================================================

	파일명 : Admin_SystemController.java
	파일 설명 : 시스템 설정 컨트롤러
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/
public class Admin_SystemController implements Controller
{
	// 탈퇴 유예기간 처리 설정 인터페이스를 구현한 자료형 변수 선언
	private Admin_LeaveDAO leaveDao;
	
	public void setLeaveDao(Admin_LeaveDAO leaveDao)
	{
		this.leaveDao = leaveDao;
	}

	// 블라인드 처리 설정 인터페이스를 구현한 자료형 변수 선언
	private Admin_BlindSetupDAO blindDao;

	public void setBlindDao(Admin_BlindSetupDAO blindDao)
	{
		this.blindDao = blindDao;
	}
	
	// 계정 상태설정 인터페이스를 구현한 자료형 변수 선언
	private Admin_SanctionTypeDAO sanctionDao;
	
	public void setSanctionDao(Admin_SanctionTypeDAO sanctionDao)
	{
		this.sanctionDao = sanctionDao;
	}

	// 블라인드 처리 갯수에 따른 계정상태
	private Admin_BlindSanctionDAO blindsanctionDao;
	
	public void setBlindsanctionDao(Admin_BlindSanctionDAO blindsanctionDao)
	{
		this.blindsanctionDao = blindsanctionDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		if (request.getRequestURI().indexOf("system.do") > -1)
		{
			//블라인드 처리 설정 리스트
			Admin_LeaveDTO ldto = leaveDao.leaveList();
			
			modelAndView.addObject("leave_seq", ldto.getLeave_seq());
			modelAndView.addObject("leave_code", ldto.getLeave_code());
			modelAndView.addObject("blindList", blindDao.blindSetuplists());
			modelAndView.addObject("sanctionList", sanctionDao.sanctionTypeList());
			modelAndView.addObject("blindSanctionList", blindsanctionDao.blindSanctionList());
			
			modelAndView.setViewName("WEB-INF/admin/Admin_Sys.jsp");
		}
		// 탈퇴 유예기간 설정
		else if (request.getRequestURI().indexOf("systemleavesetup.do") > -1)
		{
			String leave_seq = request.getParameter("leave_seq");
			String leave_code = request.getParameter("leave_code");
			String leave_name = leave_code+'일';
			
			Admin_LeaveDTO dto = new Admin_LeaveDTO();
			
			dto.setLeave_seq(Integer.parseInt(leave_seq));
			dto.setLeave_code(leave_code);
			dto.setLeave_name(leave_name);
			
			leaveDao.leaveModify(dto);
			
			modelAndView.setViewName("redirect:system.do");
		}
		// 페이지별 블라인드 처리 횟수 설정
		else if (request.getRequestURI().indexOf("systemblindsetup.do") > -1)
		{
			Admin_BlindDTO dto = new Admin_BlindDTO();
			
			String setup_seq = request.getParameter("setup_seq");
			String decl_cnt = request.getParameter("decl_cnt");
			String page_code = request.getParameter("page_code");
			
			dto.setSetup_seq(setup_seq);
			dto.setDecl_cnt(Integer.parseInt(decl_cnt));
			dto.setPage_code(page_code);
			
			blindDao.BlindSetupModify(dto);
			
			modelAndView.setViewName("redirect:system.do");
		}
		
		return modelAndView;
	}

}
