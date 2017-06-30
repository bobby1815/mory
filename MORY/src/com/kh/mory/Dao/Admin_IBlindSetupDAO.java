package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_BlindDTO;

/*========================================================

	파일명 : Admin_IBlindSetupDAO.java
	파일 설명 : 블라인드 처리 설정 화면을 위한 인터페이스
	최초작성일 : 2017-06-29
	작성자 : 박아영

 ========================================================*/


public interface Admin_IBlindSetupDAO
{
	public ArrayList<Admin_BlindDTO> blindSetuplists() throws SQLException;
	public int BlindSetupModify(Admin_BlindDTO dto) throws SQLException;
	
}
