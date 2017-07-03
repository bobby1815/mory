package com.kh.mory.SetupController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Model.Setup_Family_ManagementDTO;
import com.kh.mory.Model.Setup_IFamily_Management;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Setup_Famliy_Management_Controller implements Controller
{
	private Setup_IFamily_Management memberDAO;
	
	public void setMemberDAO(Setup_IFamily_Management memberDAO)
	{
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("------------------------------------");
		System.out.println("Setup_Famliy_Management_Controller");
		System.out.println("------------------------------------");
		
		HttpSession session = request.getSession();
		// 로그인한 세션의 유저 id
		String user_id = (String)session.getAttribute("user_id");
		
		// 가족 초대 메인
		if (request.getRequestURI().indexOf("membermain.do") > -1)
		{
			ArrayList<Setup_Family_ManagementDTO> res = new ArrayList<Setup_Family_ManagementDTO>();
			ArrayList<Setup_Family_ManagementDTO> res2 = new ArrayList<Setup_Family_ManagementDTO>();
			res = memberDAO.memberList(user_id);	// 공유다이어리 멤버 리스트
			res2 = memberDAO.shareDiaryList(user_id);	// 공유다이어리 리스트
					
			
			modelAndView.addObject("memberlist", res);
			modelAndView.addObject("shareDiaryList", res2);
			
			modelAndView.setViewName("WEB-INF/Source/Setup_Family_Managament.jsp");
		}
		else if (request.getRequestURI().indexOf("memberinvite.do") > -1)
		{
			Setup_Family_ManagementDTO dto = new Setup_Family_ManagementDTO();
			
			String nei_user_id = request.getParameter("nei_user_id");	// 초대할 유저 id
			
			// 10	부부
			// 20	멤버
			String mem_rel_code = "20";
			
			dto.setRequ_user_id(user_id);
			dto.setAcce_user_id(nei_user_id);
			dto.setMem_rel_code(mem_rel_code);
			
			if (memberDAO.memberInsert(dto) > 0)
				modelAndView.addObject("result",1);
			else
				modelAndView.addObject("result", 0);
			
			modelAndView.setViewName("WEB-INF/Source/Setup_Family_RequsetResult.jsp");
		}
		
		
		return modelAndView;
	}

}
