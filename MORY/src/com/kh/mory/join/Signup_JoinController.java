package com.kh.mory.join;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kh.mory.main.Main_IPwquestionDAO;
import com.kh.mory.main.Main_PwquestionDTO;

public class Signup_JoinController implements Controller
{
	private Signup_IUserDAO userDao;
	
	public void setUserDao(Signup_IUserDAO userDao)
	{
		this.userDao = userDao;
	}

	private Main_IPwquestionDAO pwDao;
	
	public void setPwDao(Main_IPwquestionDAO pwDao)
	{
		this.pwDao = pwDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("----------------------------------");
		System.out.println("JoinController");
		System.out.println(request.getRequestURI());
		System.out.println("----------------------------------");
		if (request.getRequestURI().indexOf("joinprocess.do") > -1)
		{
			modelAndView.setViewName("WEB-INF/join/Signup_Conditions.jsp");
		}
		else if (request.getRequestURI().indexOf("joinformprocess.do") > -1)
		{
			ArrayList<Main_PwquestionDTO> pwquLists = pwDao.pwquLists();
			
			modelAndView.addObject("pwquLists", pwquLists);
			modelAndView.setViewName("WEB-INF/join/Signup_JoinForm.jsp");
		}
		else if (request.getRequestURI().indexOf("joininsert.do") > -1)
		{
			request.setCharacterEncoding("UTF-8");
			
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
				Signup_UserDTO dto = new Signup_UserDTO();
				dto.setUser_id(user_id);
				dto.setUser_pw(user_pw);
				dto.setUser_name(user_name);
				dto.setUser_nic(user_nic);
				dto.setUser_birth(user_birth);
				dto.setGen_code(gen_code);
				dto.setUser_email(user_email);
				dto.setUser_tel(user_tel);
				dto.setZipcode(zipcode);
				dto.setBasic_addr(basic_addr);
				dto.setDetail_addr(detail_addr);
				dto.setLoca_name(siNm);
				dto.setCity_name(sggNm);
				dto.setPwqu_code(pwqu_code);
				dto.setPwqu_answ(pwqu_answ);
				
				userDao.userInsert(dto);
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
			
			modelAndView.setViewName("redirect:main.do");
		}
		
		return modelAndView;
	}

}
