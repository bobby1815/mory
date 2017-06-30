package com.kh.mory.newsfeed;

import java.io.File;

/* ==========================================================

	작성자 : 박아영
	최초작성일 : 2017-06-18
	

========================================================== */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Newsfeed_NewsfeedController implements Controller
{
	private Newsfeed_INewsfeedDAO feedDao;
	
	public void setFeedDao(Newsfeed_INewsfeedDAO feedDao)
	{
		this.feedDao = feedDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{	
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		// 세션에 저장된 사용자 ID
		String user_id = (String)session.getAttribute("user_id");
		
		if (request.getRequestURI().indexOf("newsfeedinsertform.do") > -1)
		{
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_Input.jsp");
		}
		// 뉴스피드 인서트
		else if (request.getRequestURI().indexOf("newsfeedinsert.do") > -1)
		{
			request.setCharacterEncoding("UTF-8");
			
			// 저장 경로
			//String path = "D:\\MORY\\mory_ay\\WebContent\\uploads";
			String root = request.getServletContext().getRealPath("/");
			String path = root + "newsfeedupload";
			
			 System.out.println(path);
			// C:\MORY\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MORY\newsfeedupload
			
			// 저장 디렉터리(폴더)가 존재하지 않으면 생성
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			String encType = "UTF-8";	//-- 인코딩 박싱
			int maxFileSize = 5*1024*1024;	//-- 전송 최대 사이즈
			
			MultipartRequest req = null;
			try
			{
				req = new MultipartRequest(request, path, maxFileSize, encType, new DefaultFileRenamePolicy());
				
				Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO = new Newsfeed_NewsfeedDTO();
				
				//newsfeed_NewsfeedDTO.setWrite_cont(req.getParameter("write_cont"));
				newsfeed_NewsfeedDTO.setWrite_user_id(user_id);
				
				// 저장경로
				String uplo_loca = req.getFilesystemName("profile_pt");
				int res = feedDao.newsFeedInsert(newsfeed_NewsfeedDTO, uplo_loca);

				mav.setViewName("redirect:newsfeedlist.do");
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		// 뉴스피드 조회
		else if (request.getRequestURI().indexOf("newsfeedlist.do") > -1)
		{
			mav.addObject("list",feedDao.newsFeedLists(user_id));
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_List.jsp");
		}
		
		return mav;
	}

}
