/*===========================================
   RecommentDAO.java
   - �����ͺ��̽� �׼� ó�� Ŭ����.
   - ��� �ۼ� �׼� ó��.
   - ��� ���� �׼� ó��.
   - ��� ���� �׼� ó��.
   - ��� ����Ʈ ��� �׼� ó��.
   - Connection ��ü�� ���� ������ ����.
     �� setter �޼ҵ�
===========================================*/

package com.mory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mory.diary.DiaryDTO;
import com.mory.idao.IRecommentDAO;

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
	public ArrayList<DiaryDTO> recommentList(String comment_seq) throws SQLException
	{
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();

		Connection connection = dataSource.getConnection();

		String sql = "SELECT A.RECO_SEQ, A.COMMENT_SEQ, A.RECO_CONT, A.RECO_REG_DTM"
				+ ", B.USER_NIC"
				+ " FROM TBL_RECOMMENT A, TBL_USER B"
				+ " WHERE A.USER_ID = B.USER_ID"
				+ " ORDER BY RECO_SEQ DESC";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, comment_seq);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next())
		{
			DiaryDTO diaryDTO = new DiaryDTO();
			diaryDTO.setReco_seq("COMMENT_SEQ");
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
				+ " VALUES(?, ?, ?, SYSDATE, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		try
		{
			preparedStatement.setString(1, diaryDto.getReco_seq());
			preparedStatement.setString(2, diaryDto.getCommentseq());
			preparedStatement.setString(3, diaryDto.getReco_cont());
			preparedStatement.setString(4, diaryDto.getUser_id());
			
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
				+ " SET COMMENT_CONT = ? WHERE RECO_SEQ = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, diaryDto.getComment_cont());
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