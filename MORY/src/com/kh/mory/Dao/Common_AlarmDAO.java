package com.kh.mory.Dao;
/*======================================================

	화면명 : Common_AlarmDAO.java
	화면 설명 : 공통 알람 데이터베이스 액션 처리
	최초작성일 : 2017-07-03
	작성자 : 박아영

======================================================*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Common_AlarmDTO;

public class Common_AlarmDAO implements Common_IAlarmDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 초대 알림 리스트 조회
	@Override
	public ArrayList<Common_AlarmDTO> alarmList(String user_id) throws SQLException
	{
		ArrayList<Common_AlarmDTO> res = new ArrayList<Common_AlarmDTO>();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = " SELECT"
					+ "    T.REQU_SEQ AS REQU_SEQ"
					+ "    , T.REQU_USER_ID AS REQU_USER_ID"
					+ "    , T.REQU_USER_NIC AS REQU_USER_NIC"
					+ "    , T.MEM_REL_CODE AS MEM_REL_CODE"
					+ "    , T.MEM_REL_NAME AS MEM_REL_NAME"
					+ "    , T.ACCE_USER_ID AS ACCE_USER_ID"
					+ "    , T.RESULT_YN AS RESULT_YN"
					+ "    , T.SHARE_DIARY_NAME AS SHARE_DIARY_NAME"
					+ " FROM"
					+ " ("
					+ "    SELECT"
					+ "         MR.REQU_SEQ         AS REQU_SEQ"
					+ "        , MR.REQU_USER_ID   AS REQU_USER_ID"
					+ "        , (SELECT USER_NIC FROM TBL_USER WHERE USER_ID = MR.REQU_USER_ID) AS REQU_USER_NIC"
					+ "        , MR.MEM_REL_CODE   AS MEM_REL_CODE"
					+ "        , M.MEM_REL_NAME    AS MEM_REL_NAME"
					+ "        , MR.ACCE_USER_ID   AS ACCE_USER_ID"
					+ "        , MRR.RESULT_YN AS RESULT_YN"
					+ "        , (SELECT SHARE_DIARY_NAME"
					+ "             FROM TBL_SHARE_DIARY"
					+ "             WHERE SHARE_DIARY_SEQ = (SELECT REQU_SEQ"
					+ "                                     FROM TBL_MEM_REQU A"
					+ "                                     WHERE A.REQU_USER_ID = MR.REQU_USER_ID"
					+ "                                     AND A.MEM_REL_CODE=10"
					+ "                                    )"
					+ "        ) AS SHARE_DIARY_NAME"
					+ "    FROM TBL_MEM_REQU MR LEFT JOIN TBL_MEM_REQU_RESULT MRR"
					+ "    ON MR.REQU_SEQ = MRR.REQU_SEQ"
					+ "    JOIN TBL_MEM_REL M"
					+ "    ON M.MEM_REL_CODE = MR.MEM_REL_CODE"
					+ ") T"
					+ " WHERE T.ACCE_USER_ID = ?"
					+ " AND T.RESULT_YN IS NULL";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Common_AlarmDTO dto = new Common_AlarmDTO();
				
				dto.setRequ_seq(resultSet.getInt("REQU_SEQ"));
				dto.setRequ_user_id(resultSet.getString("REQU_USER_ID"));
				dto.setRequ_user_nic(resultSet.getString("REQU_USER_NIC"));
				dto.setMem_rel_code(resultSet.getString("MEM_REL_CODE"));
				dto.setMem_rel_name(resultSet.getString("MEM_REL_NAME"));
				dto.setResult_yn(resultSet.getString("RESULT_YN"));
				dto.setShare_diary_name(resultSet.getString("SHARE_DIARY_NAME"));
				
				res.add(dto);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	// 초대 수락 / 거절 액션 처리
	@Override
	public int alarmConfirm(int requ_Seq, String result_yn) throws SQLException
	{
		int res = 0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "INSERT INTO TBL_MEM_REQU_RESULT (REQU_SEQ, RESULT_YN, RESULT_REG_DTM) VALUES (?, ?, SYSDATE)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, requ_Seq);
			preparedStatement.setString(2, result_yn);
			
			res = preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}
	
	
	
}
