/*===========================================
   CommentDAO.java
   - �����ͺ��̽� �׼� ó�� Ŭ����.
   - ��� �ۼ� �׼� ó��.
   - ��� ���� �׼� ó��.
   - ��� ���� �׼� ó��.
   - ��� ����Ʈ ��� �׼� ó��.
   - Connection ��ü�� ���� ������ ����.
     �� setter �޼ҵ�
===========================================*/

package com.kh.mory.DiaryDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.ICommentDAO;

public class CommentDAO implements ICommentDAO
{
	// �������̽� �ڷ��� ����
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// ��� �Է�
	@Override
	public int commentInsert(DiaryDTO diaryDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "INSERT INTO TBL_COMMENT"
				+ " (COMMENT_SEQ, WRITE_SEQ, COMMENT_CONT"
				+ ", COMMENT_REG_DTM, USER_ID)"
				+ " VALUES (SEQ_COMMENT.NEXTVAL, ?, ?, SYSDATE, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		try
		{
			preparedStatement.setString(1, diaryDto.getWrite_seq());
			preparedStatement.setString(2, diaryDto.getComment_cont());
			preparedStatement.setString(3, diaryDto.getUser_id());

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
	public int commentUpdate(DiaryDTO diaryDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		System.out.println( diaryDto.getComment_cont());
		System.out.println( diaryDto.getComment_seq());
		
		String sql = "UPDATE TBL_COMMENT SET COMMENT_CONT = ? WHERE COMMENT_SEQ = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, diaryDto.getComment_cont());
			preparedStatement.setString(2, diaryDto.getComment_seq());
			
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
	public int commentDelete(String comment_seq) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "{CALL DELETE_COMMENT(?)}";

		try
		{
			CallableStatement callableStatement = connection.prepareCall(sql);

			callableStatement.setString(1, comment_seq);

			result = callableStatement.executeUpdate();
			callableStatement.close();
			connection.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// ��� ����Ʈ ���
	@Override
	public ArrayList<DiaryDTO> commentList(String write_seq) throws SQLException
	{
		
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();

		Connection connection = dataSource.getConnection();

		String sql = "SELECT A.COMMENT_SEQ AS COMMENT_SEQ, A.WRITE_SEQ AS WRITE_SEQ , "
				+ " A.COMMENT_CONT AS COMMENT_CONT , SUBSTR(TO_CHAR(A.COMMENT_REG_DTM),0,10) AS COMMENT_REG_DTM,  B.USER_NIC AS USER_NIC "
				+ " FROM TBL_COMMENT A, TBL_USER B "
				+ " WHERE A.USER_ID = B.USER_ID "
				+ " AND A.WRITE_SEQ = ? "
				+ " ORDER BY COMMENT_SEQ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, write_seq);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setWrite_seq(resultSet.getString("WRITE_SEQ"));
			diary.setComment_seq(resultSet.getString("COMMENT_SEQ"));
			String cont = resultSet.getString("COMMENT_CONT");
			cont = cont.replaceAll("\\\\n", "<br>");
			diary.setComment_cont(cont);
			diary.setComment_reg_dtm(resultSet.getString("COMMENT_REG_DTM"));
			diary.setUser_nic(resultSet.getString("USER_NIC"));
			result.add(diary);

		}
		connection.close();
		preparedStatement.close();
		resultSet.close();

		return result;

	}

}