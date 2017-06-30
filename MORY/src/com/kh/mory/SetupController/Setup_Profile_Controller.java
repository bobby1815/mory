package com.kh.mory.SetupController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.Model.Setup_ProfileDTO;
import com.kh.mory.Setup_DAO.Setup_ProfileDAO;

public class Setup_Profile_Controller implements Controller
{

	private Setup_ProfileDAO profileDAO;
	
	
	public void setProfileDAO(Setup_ProfileDAO profileDAO)
	{
		this.profileDAO = profileDAO;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String user_Id = (String) session.getAttribute("user_Id");
		String user_Pw = (String) session.getAttribute("user_Pw");
		System.out.println(user_Id);
		System.out.println(user_Pw);
		
		if(request.getRequestURI().indexOf("modifyprofile.do") >-1)
		{
			String user_id = request.getParameter("user_id");				
			String user_pw = request.getParameter("user_pw");
			String user_nic = request.getParameter("user_name");
			String user_name = request.getParameter("user_nic");
			String user_birth = request.getParameter("user_birth");
			String gen_code = request.getParameter("gen_code");
			String user_email = request.getParameter("user_email");
			String user_tel = request.getParameter("user_tel");
			String zipcode = request.getParameter("zipcode");
			String basic_addr = request.getParameter("basic_addr");
			String detail_addr = request.getParameter("detail_addr");
			String pwqu_code = request.getParameter("pwqu_code");
			String pwqu_answ = request.getParameter("pwqu_answ");
			
			String siNm = request.getParameter("siNm");	// 시이름
			String sggNm = request.getParameter("sggNm");	// 시군구
			
			try
			{
			Setup_ProfileDTO profileDTO = new Setup_ProfileDTO();
			profileDTO.setUser_Id(user_id);
			profileDTO.setUser_Pw(user_pw);
			profileDTO.setUser_name(user_name);
			profileDTO.setUser_Nicname(user_nic);
			profileDTO.setUser_birth(user_birth);
			profileDTO.setGencode(gen_code);
			profileDTO.setUser_Email(user_email);
			profileDTO.setUser_Tel(user_tel);
			profileDTO.setUser_Zipcode(zipcode);
			profileDTO.setUser_basic_Addr(basic_addr);
			profileDTO.setUser_detail_addr(detail_addr);
			profileDTO.setLoca_code(siNm);
			profileDTO.setCity_code(sggNm);
			profileDTO.setPwqu_code(pwqu_code);
			profileDTO.setPwqu_answ(pwqu_answ);
						
			profileDAO.modify(profileDTO);
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
			modelAndView.setViewName("redirect:modifyprofile.do");
			return modelAndView;
			
		}
		
		modelAndView.addObject("profile", profileDAO.user_info(user_Id, user_Pw));
		modelAndView.setViewName("WEB-INF/Source/Setup_Profile.jsp");
		return modelAndView;
	}
	
}
