package com.kh.mory.Setup_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Setup_Family_ManagementDTO;
import com.kh.mory.Model.Setup_IFamily_Management;
/*=============================================================

	화면명 : Setup_Family_ManagementDAO.java
	화면설명 : 멤버 초대 데이터베이스 액션 처리
	최초작성일 : 2017-07-01
	작성자 : 박아영

 =============================================================*/
public class Setup_Family_ManagementDAO implements Setup_IFamily_Management
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 멤버 초대
	@Override
	public int memberInsert(Setup_Family_ManagementDTO dto) throws SQLException
	{
		int res=0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "INSERT INTO TBL_MEM_REQU (REQU_SEQ, REQU_USER_ID, MEM_REL_CODE, ACCE_USER_ID, REQU_REG_DTM)"
					+ " VALUES (SEQ_MEM_REQU.NEXTVAL, ?, ?, ?, SYSDATE)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getRequ_user_id());
			preparedStatement.setString(2, dto.getMem_rel_code());
			preparedStatement.setString(3, dto.getAcce_user_id());
			
			res = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}
	
	// 공유다이어리 멤버 조회
	@Override
	public ArrayList<Setup_Family_ManagementDTO> memberList(String requ_user_id) throws SQLException
	{
		ArrayList<Setup_Family_ManagementDTO> res = new ArrayList<Setup_Family_ManagementDTO>();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT"
					+ "     R.REQU_SEQ AS REQU_SEQ"
					+ "    , R.REQU_USER_ID AS REQU_USER_ID"
					+ "    , R.MEM_REL_CODE AS MEM_REL_CODE"
					+ "    , R.ACCE_USER_ID AS ACCE_USER_ID"
					+ "    , (SELECT USER_NAME FROM TBL_USER WHERE USER_ID=R.ACCE_USER_ID) AS ACCE_USER_NAME"
					+ "    , R.REQU_REG_DTM AS REQU_REG_DTM"
					+ " FROM TBL_MEM_REQU R JOIN TBL_USER U"
					+ " ON R.REQU_USER_ID = U.USER_ID"
					+ " JOIN TBL_MEM_REQU_RESULT RES"
					+ " ON R.REQU_SEQ = RES.REQU_SEQ"
					+ " WHERE RES.RESULT_YN = 'Y'"
					+ " AND R.REQU_USER_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, requ_user_id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Setup_Family_ManagementDTO dto = new Setup_Family_ManagementDTO();
				
				dto.setRequ_seq(resultSet.getInt("REQU_SEQ"));
				dto.setRequ_user_id(resultSet.getString("REQU_USER_ID"));
				dto.setMem_rel_code(resultSet.getString("MEM_REL_CODE"));
				dto.setAcce_user_id(resultSet.getString("ACCE_USER_ID"));
				dto.setAcce_user_name(resultSet.getString("ACCE_USER_NAME"));
				dto.setRequ_reg_dtm(resultSet.getString("REQU_REG_DTM"));
				
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

	// 내가 공유받는 공유다이어리 리스트
	@Override
	public ArrayList<Setup_Family_ManagementDTO> shareDiaryList(String requ_user_id) throws SQLException
	{
		ArrayList<Setup_Family_ManagementDTO> res = new ArrayList<Setup_Family_ManagementDTO>();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT"
					+ "     P.REQU_USER_ID AS REQU_USER_ID"
					+ "     , P.USER_NIC AS USER_NIC"
					+ "     , P.REQU_SEQ AS REQU_SEQ"
					+ "     , P.SHARE_DIARY_NAME AS SHARE_DIARY_NAME"
					+ "  FROM"
					+ "     ("
					+ "         SELECT"
					+ "             A.REQU_USER_ID AS REQU_USER_ID"
					+ "             ,A.ACCE_USER_ID AS ACCE_USER_ID"
					+ "             ,B.REQU_SEQ AS REQU_SEQ"
					+ "             ,C.USER_NIC AS USER_NIC"
					+ "             ,D.SHARE_DIARY_NAME AS SHARE_DIARY_NAME"
					+ "          FROM TBL_MEM_REQU A , TBL_MEM_REQU_RESULT B,TBL_USER C , TBL_SHARE_DIARY D"
					+ "          WHERE A.REQU_SEQ = B.REQU_SEQ"
					+ "          AND A.REQU_USER_ID = C.USER_ID"
					+ "         AND B.REQU_SEQ = D.SHARE_DIARY_SEQ"
					+ "     ) P , TBL_MEM_REQU A , TBL_MEM_REQU_RESULT B "
					+ "WHERE 1=1 "
					+ " AND (P.REQU_USER_ID = A.REQU_USER_ID OR  P.ACCE_USER_ID = A.REQU_USER_ID)"
					+ " AND A.REQU_SEQ = B.REQU_SEQ AND A.MEM_REL_CODE='20'"
					+ " AND B.RESULT_YN='Y'"
					+ " AND A.ACCE_USER_ID=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, requ_user_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Setup_Family_ManagementDTO dto = new Setup_Family_ManagementDTO();
				
				dto.setRequ_seq(resultSet.getInt("REQU_SEQ"));
				dto.setShare_diary_name(resultSet.getString("SHARE_DIARY_NAME"));
				
				res.add(dto);
			}
		
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}
	

	
	
	
}
