package com.kh.mory.newsfeed;

import java.io.File;

/* ==========================================================

	작성자 : 박아영
	최초작성일 : 2017-06-18
	

========================================================== */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Newsfeed_NewsfeedController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		if (request.getRequestURI().indexOf("newsfeedinsert.do") > -1)
		{
			request.setCharacterEncoding("UTF-8");
			
			String path = "D:\\MORY\\mory_ay\\WebContent\\uploads";
			
			File dir = new File(path);
			if(!dir.exists())
				dir.mkdirs();
			
			String encType = "UTF-8";	//-- 인코딩 박싱
			int maxFileSize = 5*1024*1024;	//-- 전송 최대 사이즈
			
			MultipartRequest req = null;
			
			try
			{
				req = new MultipartRequest(request, path, maxFileSize, encType, new DefaultFileRenamePolicy());
				String write_cont = request.getParameter("write_cont");
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}

		}
		else if (request.getRequestURI().indexOf("newsfeedlist.do") > -1)
		{
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_Input.jsp");
		}
		
		return mav;
	}

}
