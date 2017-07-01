package com.kh.mory.Model;

import java.sql.SQLException;
import java.util.ArrayList;

/*=============================================================
	화면명 : Setup_IFamily_ManagementDAO
	화면설명 : 멤버 초대 인터페이스
	최초작성일 : 2017-07-01
	작성자 : 박아영
=============================================================*/
public interface Setup_IFamily_Management
{
	public int memberInsert(Setup_Family_ManagementDTO dto) throws SQLException;
	public ArrayList<Setup_Family_ManagementDTO> memberList(String requ_user_id) throws SQLException;
}
