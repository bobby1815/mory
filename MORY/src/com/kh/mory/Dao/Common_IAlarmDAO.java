package com.kh.mory.Dao;
/*======================================================

	화면명 : Common_IAlarmDAO.java
	화면 설명 : 공통 알람 인터페이스
	최초작성일 : 2017-07-03
	작성자 : 박아영

======================================================*/

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Common_AlarmDTO;

public interface Common_IAlarmDAO
{
	public ArrayList<Common_AlarmDTO> alarmList(String user_id) throws SQLException;
	public int alarmConfirm(int requ_seq, String result_yn) throws SQLException;
}
