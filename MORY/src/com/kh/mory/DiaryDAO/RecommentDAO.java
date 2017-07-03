/*===========================================
0 
  RecommentDAO.java
   - �����ͺ��̽� �׼� ó�� Ŭ����.
   - ��� �ۼ� �׼� ó��.
   - ��� ���� �׼� ó��.
   - ��� ���� �׼� ó��.
   - ��� ����Ʈ ��� �׼� ó��.
   - Connection ��ü�� ���� ������ ����.
     �� setter �޼ҵ�
===========================================*/

package com.kh.mory.DiaryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IRecommentDAO;

public class RecommentDAO implements IRecommentDAO
{
	// �������̽� �ڷ��� ����
	private DataSource dataSource;

	// setter �޼ҵ� ����
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// ��� ����Ʈ ���
	@Override
	public ArrayList<DiaryDTO> recommentList(String write_seq) throws SQLException
	{
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();

		Connection connection = dataSource.getConnection();

		String sql = "SELECT  A.RECO_SEQ AS RECO_SEQ , A.RECO_CONT AS RECO_CONT , A.USER_ID AS USER_ID, "
				+ "SUBSTR(TO_CHAR(A.RECO_REG_DTM),0,10) AS RECO_REG_DTM , A.COMMENT_SEQ AS COMMENT_SEQ , C.USER_NIC AS USER_NIC ,C.USER_ID AS USER_ID "
				+ " FROM TBL_RECOMMENT A , TBL_COMMENT B , TBL_USER C"
				+ " WHERE A.COMMENT_SEQ = B.COMMENT_SEQ "
				+ "AND A.USER_ID = C.USER_ID "
				+ "AND B.WRITE_SEQ = ?"
				+ " ORDER BY A.RECO_SEQ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, write_seq);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next())
		{
			DiaryDTO diaryDTO = new DiaryDTO();
			diaryDTO.setReco_seq(resultSet.getString("RECO_SEQ"));
			diaryDTO.setReco_cont(resultSet.getString("RECO_CONT").replaceAll("\\\\n", "<BR>"));
			diaryDTO.setRequ_user_id(resultSet.getString("USER_ID"));
			
			diaryDTO.setReco_reg_dtm(resultSet.getString("RECO_REG_DTM"));

			diaryDTO.setUser_id(resultSet.getString("USER_ID"));
			diaryDTO.setComment_seq(resultSet.getString("COMMENT_SEQ"));
			
			diaryDTO.setUser_nic(resultSet.getString("USER_NIC"));
			
			
			result.add(diaryDTO);
		}
		connection.close();
		preparedStatement.close();
		resultSet.close();

		return result;
	}

	// ��� �Է�
	@Override
	public int recommentInsert(DiaryDTO diaryDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "INSERT INTO TBL_RECOMMENT"
				+ " (RECO_SEQ, COMMENT_SEQ, RECO_CONT, RECO_REG_DTM, USER_ID)"
				+ " VALUES(SEQ_RECOMMENT.NEXTVAL, ?, ?, SYSDATE, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		try
		{
			
			preparedStatement.setString(1, diaryDto.getComment_seq());
			System.out.println(diaryDto.getReco_seq());
			preparedStatement.setString(2, diaryDto.getReco_cont());
			System.out.println(diaryDto.getReco_cont());
			preparedStatement.setString(3, diaryDto.getUser_id());
			System.out.println(diaryDto.getUser_id());
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// ��� ����
	@Override
	public int recommentUpdate(DiaryDTO diaryDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "UPDATE TBL_RECOMMENT"
				+ " SET RECO_CONT = ? WHERE RECO_SEQ = ?";
		System.out.println(diaryDto.getReco_cont());
		System.out.println(diaryDto.getReco_seq());
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, diaryDto.getReco_cont());
			
			preparedStatement.setString(2, diaryDto.getReco_seq());
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	// ��� ����
	@Override
	public int recommentDelete(String reco_seq) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "DELETE FROM TBL_RECOMMENT WHERE RECO_SEQ = ? ";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, reco_seq);
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

}