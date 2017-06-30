package com.kh.mory.Dao;

import java.sql.SQLException;

import com.kh.mory.Model.Admin_LeaveDTO;
/*========================================================

	파일명 : Admin_LeaveDAO.java
	파일 설명 : 탈퇴 유예기간 설정을 위한 인터페이스
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/
public interface Admin_ILeaveDAO
{
	public Admin_LeaveDTO leaveList() throws SQLException;
	public int leaveModify(Admin_LeaveDTO dto) throws SQLException; 
}
