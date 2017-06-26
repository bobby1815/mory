package com.mory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mory.diary.DiaryDTO;
import com.mory.idao.IDiaryDAO;



public class DiaryDAO implements IDiaryDAO
{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
		
	@Override
	public ArrayList<DiaryDTO> list(String requ_seq) throws SQLException {

		Connection conn = dataSource.getConnection();
		requ_seq ="3" ; 
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();
		String sql = "SELECT B.DIARY_POST_TITLE AS TITLE , A.WRITE_REG_DTM AS DTM FROM TBL_WRITE A ,TBL_DIARY_POST B WHERE A.WRITE_SEQ= B.WRITE_SEQ AND B.REQU_SEQ = ? AND  DIARY_TYPE_CODE = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, requ_seq);
		ResultSet rs = pstmt.executeQuery();		
		
		while (rs.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setDiary_post_title(rs.getString("TITLE"));
			diary.setWrite_reg_dtm(rs.getString("DTM"));
			result.add(diary);
		}
		rs.close();
		pstmt.close();
		return result;
	}
	@Override
	public ArrayList<DiaryDTO> couplelist() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiaryDTO cont(DiaryDTO diary) throws SQLException {
		Connection conn = dataSource.getConnection();
		
		String sql = " A.WRITE_SEQ AS WRITE_SEQ ,SELECT B.DIARY_POST_TITLE AS TITLE , A.WRITE_CONT AS CONT , A.WRITE_REG_DTM AS DTM FROM TBL_WRITE A ,TBL_DIARY_POST B WHERE A.WRITE_SEQ= B.WRITE_SEQ AND B.REQU_SEQ = ? AND DIARY_TYPE_CODE = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, diary.getDiary_requ_seq());
		pstmt.setString(2, diary.getDiary_type_code());
		
		ResultSet rs  = pstmt.executeQuery();
		
		while (rs.next())
		{
			diary.setDiary_post_title(rs.getString("TITLE"));
			diary.setWrite_cont(rs.getString("CONT"));
			diary.setWrite_reg_dtm(rs.getString("DTM"));
			diary.setWrite_seq(rs.getString("WRITE_SEQ"));
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return diary;
	}
	
	@Override
	public ArrayList<DiaryDTO> commentlist(String write_seq) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		write_seq ="3" ; 
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();
		String sql = "SELECT COMMENT_SEQ , WRITE_SEQ , COMMENT_CONT, COMMENT_REG_DTM "
				+ " FROM TBL_COMMENT "
				+ " WHERE WRITE_SEQ = 1 "
				+ " ORDER BY COMMENT_SEQ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, write_seq);
		ResultSet rs = pstmt.executeQuery();		
		
		while (rs.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setCommentseq(rs.getString("COMMENT_SEQ"));
			diary.setWrite_seq(rs.getString("WRITE_SEQ"));
			diary.setComment_cont(rs.getString("COMMENT_CONT"));
			diary.setComment_reg_dtm(rs.getString("COMMENT_REG_DTM"));
			result.add(diary);
		}
		rs.close();
		pstmt.close();
		return result;
	}

	@Override
	public ArrayList<DiaryDTO> recommentlist(String write_seq) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		write_seq ="1" ; 
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();
		String sql = "SELECT B.RECO_CONT AS CONT , B.RECO_REG_DTM AS DTM ,"
				+ " B.COMMENT_SEQ AS COMMENT_SEQ "
				+ " FROM  TBL_COMMENT A , TBL_RECOMMENT B "
				+ " WHERE A.COMMENT_SEQ = B.COMMENT_SEQ "
				+ " AND A.WRITE_SEQ = ? "
				+ " ORDER BY B.COMMENT_SEQ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, write_seq);
		ResultSet rs = pstmt.executeQuery();		
		
		while (rs.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setReco_cont(rs.getString("CONT"));
			diary.setReco_reg_dtm(rs.getString("DTM"));
			diary.setCommentseq(rs.getString("COMMENT_SEQ"));
			
			result.add(diary);
		}
		rs.close();
		pstmt.close();
		return result;
	}
	

	@Override
	public int add(DiaryDTO diary) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "EXEC INSERT_SHARE_DIARY_MY_POST(?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try
		{
			
			// 유저 ,내용,일시,다이어리번호,글제목
			pstmt.setString(1, diary.getUser_id());
			pstmt.setString(2, diary.getWrite_cont());
			pstmt.setString(3, diary.getWrite_reg_dtm());
			pstmt.setString(4, diary.getDiary_requ_seq());
			pstmt.setString(5, diary.getDiary_post_title());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public int remove(String write_seq) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "EXEC DELETE_DIARY_POST(?) ";
		
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, write_seq);
			
			
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public int modyfi(DiaryDTO diary) throws SQLException {
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		//수정 가능 (제목, 내용 ,첨부파일)
		String sql = "EXEC UPDATE_DIARY(?,? ,?, ?)";
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, diary.getWrite_seq());
			pstmt.setString(2, diary.getWrite_cont());
			pstmt.setString(3, diary.getWrite_reg_dtm());
			pstmt.setString(4, diary.getDiary_post_title());
			
			
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	

	



}
