package com.kh.mory.Dao;
/*===================================================
	파일명 : Admin_ICommunityDAO.java
	기능 : 커뮤니티 관리를 위한 인터페이스
	최초작성일 : 2017-06-26
	작성자 : 박아영 
===================================================*/
import java.util.ArrayList;

import com.kh.mory.Model.Admin_CommunityDTO;

public interface Admin_ICommunityDAO
{
	public ArrayList<Admin_CommunityDTO> lists();
	public int modify();
	public int delete();
}
