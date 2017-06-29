/*===========================================
   CommentDAO.java
   - 데이터베이스 액션 처리 클래스.
   - 댓글 작성 액션 처리.
   - 댓글 수정 액션 처리.
   - 댓글 삭제 액션 처리.
   - 댓글 리스트 출력 액션 처리.
   - Connection 객체에 대한 의존성 주입.
     → setter 메소드
===========================================*/

package com.kh.mory.DiaryDAO;

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
	// 인터페이스 자료형 구성
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 댓글 입력
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

	// 댓글 수정
	@Override
	public int commentUpdate(DiaryDTO diaryDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

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

	// 댓글 삭제
	@Override
	public int commentDelete(String comment_seq) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "EXEC DELETE_COMMENT(?)";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, comment_seq);

			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// 댓글 리스트 출력
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