package com.kh.mory.Dao;
/*========================================================

	파일명 : Admin_ISanctionTypeDAO.java
	파일 설명 : 상태 설정 화면을 위한 인터페이스
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_SanctionTypeDTO;

public interface Admin_ISanctionTypeDAO
{
	public ArrayList<Admin_SanctionTypeDTO> sanctionTypeList() throws SQLException;
	public int santionTypeModify(Admin_SanctionTypeDTO dto) throws SQLException;
	public int sanctionTypeRemove(String sanc_type_code) throws SQLException;
}
