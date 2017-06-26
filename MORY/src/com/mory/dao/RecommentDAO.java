/*===========================================
   RecommentDAO.java
   - 데이터베이스 액션 처리 클래스.
   - 답글 작성 액션 처리.
   - 답글 수정 액션 처리.
   - 답글 삭제 액션 처리.
   - 답글 리스트 출력 액션 처리.
   - Connection 객체에 대한 의존성 주입.
     → setter 메소드
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
	// 인터페이스 자료형 구성
	private DataSource dataSource;

	// setter 메소드 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 답글 리스트 출력
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

	// 답글 입력
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

	// 답글 수정
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

	// 답글 삭제
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