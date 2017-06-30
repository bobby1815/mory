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
	// 인터페이스 자료형 구성
	private DataSource dataSource;

	// setter 메소드 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 답글 리스트 출력
	@Override
	public ArrayList<DiaryDTO> recommentList(String write_seq) throws SQLException
	{
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();

		Connection connection = dataSource.getConnection();

		String sql = "SELECT  A.RECO_SEQ AS RECO_SEQ , A.RECO_CONT AS RECO_CONT , A.USER_ID AS USER_ID, "
				+ "SUBSTR(TO_CHAR(A.RECO_REG_DTM),0,10) AS RECO_REG_DTM , A.COMMENT_SEQ AS COMMENT_SEQ , C.USER_NIC AS USER_NIC "
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
			
			diaryDTO.setComment_seq(resultSet.getString("COMMENT_SEQ"));
			
			diaryDTO.setUser_nic(resultSet.getString("USER_NIC"));
			
			
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
			preparedStatement.setString(2, diaryDto.getComment_seq());
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