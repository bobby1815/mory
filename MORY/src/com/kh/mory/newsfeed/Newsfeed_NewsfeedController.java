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
		// �꽭�뀡�뿉 ���옣�맂 �궗�슜�옄 ID
		String user_id = (String)session.getAttribute("user_id");
		
		if (request.getRequestURI().indexOf("newsfeedinsertform.do") > -1)
		{
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_Input.jsp");
		}
		// �돱�뒪�뵾�뱶 �씤�꽌�듃s
		else if (request.getRequestURI().indexOf("newsfeedinsert.do") > -1)
		{
			request.setCharacterEncoding("UTF-8");
			
			// ���옣 寃쎈줈
			//String path = "D:\\MORY\\mory_ay\\WebContent\\uploads";
			String root = request.getServletContext().getRealPath("/");
			String path = root + "newsfeedupload";
			
			 System.out.println(path);
			// C:\MORY\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MORY\newsfeedupload
			
			// ���옣 �뵒�젆�꽣由�(�뤃�뜑)媛� 議댁옱�븯吏� �븡�쑝硫� �깮�꽦
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			String encType = "UTF-8";	//-- �씤肄붾뵫 諛뺤떛
			int maxFileSize = 5*1024*1024;	//-- �쟾�넚 理쒕� �궗�씠利�
			
			MultipartRequest req = null;
			try
			{
				req = new MultipartRequest(request, path, maxFileSize, encType, new DefaultFileRenamePolicy());
				
				Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO = new Newsfeed_NewsfeedDTO();
				
				//newsfeed_NewsfeedDTO.setWrite_cont(req.getParameter("write_cont"));
				newsfeed_NewsfeedDTO.setWrite_user_id(user_id);
				
				// ���옣寃쎈줈
				String uplo_loca = req.getFilesystemName("profile_pt");
				int res = feedDao.newsFeedInsert(newsfeed_NewsfeedDTO, uplo_loca);

				mav.setViewName("redirect:newsfeedlist.do");
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		// �돱�뒪�뵾�뱶 議고쉶
		else if (request.getRequestURI().indexOf("newsfeedlist.do") > -1)
		{
			
			mav.addObject("list",feedDao.newsFeedLists(user_id));
			mav.setViewName("WEB-INF/newsfeed/NewsFeed_List.jsp");
		}
		
		return mav;
	}

}
