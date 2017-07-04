package com.kh.mory.newsfeed;

import java.io.File;

/* ==========================================================

	�옉�꽦�옄 : 諛뺤븘�쁺
	理쒖큹�옉�꽦�씪 : 2017-06-18
	

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
		// 로그인한 사용자 id
		String user_id = (String)session.getAttribute("user_id");
		
		// 뉴스피드 작성 폼
		if (request.getRequestURI().indexOf("newsfeedinsertform.do") > -1)
		{
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_Input.jsp");
		}
		// 뉴스피드 작성
		else if (request.getRequestURI().indexOf("newsfeedinsert.do") > -1)
		{
			request.setCharacterEncoding("UTF-8");
			
			// 업로드 파일 경로
			//String path = "D:\\MORY\\mory_ay\\WebContent\\uploads";
			String root = request.getServletContext().getRealPath("/");
			String path = root + "newsfeedupload";
			
			 System.out.println(path);
			// C:\MORY\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MORY\newsfeedupload
			
			// 폴더 경로가 존재하지않으면 생성
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			String encType = "UTF-8";	//-- 인코딩 방식
			int maxFileSize = 5*1024*1024;	//-- 최대 사이즈
			
			MultipartRequest req = null;
			try
			{
				req = new MultipartRequest(request, path, maxFileSize, encType, new DefaultFileRenamePolicy());
				
				Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO = new Newsfeed_NewsfeedDTO();
				
				String write_cont = req.getParameter("write_cont");
				write_cont.replaceAll("\r\n", "<br/>");
				//newsfeed_NewsfeedDTO.setWrite_cont(req.getParameter("write_cont"));
				newsfeed_NewsfeedDTO.setWrite_cont(write_cont);
				newsfeed_NewsfeedDTO.setWrite_user_id(user_id);
				
				// 업로드한 파일명
				String uplo_loca = req.getFilesystemName("profile_pt");
				int res = feedDao.newsFeedInsert(newsfeed_NewsfeedDTO, uplo_loca);

				mav.setViewName("redirect:newsfeedlist.do");
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		// 뉴스피드 리스트
		else if (request.getRequestURI().indexOf("newsfeedlist.do") > -1)
		{
			mav.addObject("list",feedDao.newsFeedLists(user_id));
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_List.jsp");
		}
		// 사랑해요 버튼 클릭
		else if (request.getRequestURI().indexOf("newsfeedloveclick.do") > -1)
		{
			String strwrite_seq = request.getParameter("write_seq");
			int write_seq = Integer.parseInt(strwrite_seq);
			
			feedDao.newsFeedLove(write_seq, user_id);
			
			mav.addObject("cnt",feedDao.newsFeedLoveCnt(write_seq));
			mav.setViewName("redirect:newsfeedlist.do");
		}
		
		return mav;
	}

}
