package com.kh.test.Controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoryController
{
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping(value="/setmain.do",method= RequestMethod.POST)
	public String Setup_main()
	{
		String result="";		
		result ="WEB-INF/Source/Setup_Main.jsp";
		return result;
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String Setup_Profile()
	{
		String result="";
		
		result = "WEB-INF/Source/Setup_Profile.jsp";
		return result;
		
	}

}
