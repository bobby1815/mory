package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_BlindSanctionDTO;

/*========================================================

	파일명 : Admin_IBlindSanctionDAO.java
	파일 설명 : 블라인드 처리 수에 따른 계정상태 설정 화면을 위한 인터페이스
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/

public interface Admin_IBlindSanctionDAO
{
	public ArrayList<Admin_BlindSanctionDTO> blindSanctionList() throws SQLException;
	public int blindSanctionModify(Admin_BlindSanctionDTO dto) throws SQLException;
	public int blindSanctionRemove(int blind_sanc_seq) throws SQLException; 
}
