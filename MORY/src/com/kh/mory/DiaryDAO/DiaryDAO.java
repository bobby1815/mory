package com.kh.mory.DiaryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.DiaryDTO.DiaryDTO;
import com.kh.mory.DiaryIDAO.IDiaryDAO;



public class DiaryDAO implements IDiaryDAO
{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
		
	@Override
	public ArrayList<DiaryDTO> list(String diary_seq) throws SQLException {

		Connection conn = dataSource.getConnection();
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();
		String sql = "SELECT  B.DIARY_POST_TITLE AS TITLE , "
				+  "SUBSTR(TO_CHAR(A.WRITE_REG_DTM),0,10) AS DTM "
				+ ",A.WRITE_SEQ AS WRITE_SEQ "
				+ " FROM TBL_WRITE A ,TBL_DIARY_POST B "
				+ " WHERE A.WRITE_SEQ= B.WRITE_SEQ AND B.REQU_SEQ = ? "
				+ " AND  DIARY_TYPE_CODE = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, diary_seq);
		ResultSet rs = pstmt.executeQuery();		
		
		
		
		while (rs.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setWrite_seq(rs.getString("WRITE_SEQ"));
			diary.setDiary_post_title(rs.getString("TITLE"));
			diary.setWrite_reg_dtm(rs.getString("DTM"));
			result.add(diary);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result;
	}
	@Override
	public ArrayList<DiaryDTO> couplelist(String requ_seq) throws SQLException {

		Connection conn = dataSource.getConnection();
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();
		String sql = "SELECT  B.DIARY_POST_TITLE AS TITLE , SUBSTR(TO_CHAR(A.WRITE_REG_DTM),0,10) AS DTM ,A.WRITE_SEQ AS WRITE_SEQ  FROM TBL_WRITE A ,TBL_DIARY_POST B WHERE A.WRITE_SEQ= B.WRITE_SEQ AND B.REQU_SEQ = ? AND  DIARY_TYPE_CODE = 2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, requ_seq);
		ResultSet rs = pstmt.executeQuery();		
		
		
		while (rs.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setWrite_seq(rs.getString("WRITE_SEQ"));
			diary.setDiary_post_title(rs.getString("TITLE"));
			diary.setWrite_reg_dtm(rs.getString("DTM"));
			result.add(diary);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result;
	}

	@Override
	public DiaryDTO cont(String write_seq) throws SQLException {
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT A.WRITE_SEQ AS WRITE_SEQ , B.DIARY_POST_TITLE AS TITLE , A.WRITE_USER_ID AS WRITE_USER_ID , A.WRITE_CONT AS CONT , SUBSTR(TO_CHAR(A.WRITE_REG_DTM),0,10) AS DTM FROM TBL_WRITE A ,TBL_DIARY_POST B WHERE A.WRITE_SEQ= B.WRITE_SEQ AND A.WRITE_SEQ = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, write_seq);
		
		ResultSet rs  = pstmt.executeQuery();
		DiaryDTO diary = new DiaryDTO();
		
		while (rs.next())
		{
			diary.setWrite_user_id(rs.getString("WRITE_USER_ID"));
			diary.setWrite_seq(rs.getString("WRITE_SEQ"));
			diary.setDiary_post_title(rs.getString("TITLE"));
			diary.setWrite_cont(rs.getString("CONT").replaceAll("\\\\n", " <BR> "));
			diary.setWrite_reg_dtm(rs.getString("DTM"));
			
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return diary;
	}
	

	@Override
	public int add(DiaryDTO diary) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "{CALL INSERT_MY_DIARY_POST(?,?,?,?,?)}";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try
		{
			
			// ���� ,����,�Ͻ�,���̾��ȣ,������
			pstmt.setString(1, diary.getUser_id());
			System.out.println(diary.getUser_id());
			pstmt.setString(2, diary.getWrite_cont());
			System.out.println(diary.getWrite_cont());
			pstmt.setString(3, diary.getWrite_reg_dtm());
			System.out.println(diary.getWrite_reg_dtm());
			pstmt.setString(4, diary.getDiary_requ_seq());
			System.out.println(diary.getDiary_requ_seq());
			pstmt.setString(5, diary.getDiary_post_title());
			System.out.println(diary.getDiary_post_title());
			
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
		
		String sql = "{CALL DELETE_DIARY_POST(TO_CHAR(?)) }";
		
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, write_seq);
			System.out.println(write_seq);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
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
		
		//���� ���� (����, ���� ,÷������)
		String sql = "{CALL UPDATE_DIARY(?,? ,?, ?)}";
		
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

	@Override
	public int matecheck(String user_id) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		//���� ���� (����, ���� ,÷������)
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEM_REQU A , TBL_MEM_REQU_RESULT B WHERE  A.REQU_SEQ = B.REQU_SEQ AND A.MEM_REL_CODE='10' AND B.RESULT_YN='Y' AND (A.ACCE_USER_ID = ? OR A.REQU_USER_ID = ? )";
		
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_id);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				result = Integer.parseInt(rs.getString("COUNT"));
				System.out.println(result);
				
				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	@Override
	public ArrayList<DiaryDTO> memberdiarylist(String user_id) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		ArrayList<DiaryDTO> result = new ArrayList<DiaryDTO>();
		
		String sql = "SELECT P.REQU_USER_ID AS REQU_USER_ID , P.USER_NIC AS USER_NIC , P.REQU_SEQ AS REQU_SEQ , P.SHARE_DIARY_NAME AS SHARE_DIARY_NAME  FROM ( SELECT A.REQU_USER_ID AS REQU_USER_ID ,A.ACCE_USER_ID AS ACCE_USER_ID ,  B.REQU_SEQ AS REQU_SEQ ,C.USER_NIC AS USER_NIC ,D.SHARE_DIARY_NAME AS SHARE_DIARY_NAME  FROM TBL_MEM_REQU A , TBL_MEM_REQU_RESULT B,TBL_USER C , TBL_SHARE_DIARY D  WHERE A.REQU_SEQ = B.REQU_SEQ  AND A.REQU_USER_ID = C.USER_ID AND B.REQU_SEQ = D.SHARE_DIARY_SEQ ) P , TBL_MEM_REQU A , TBL_MEM_REQU_RESULT B WHERE (P.REQU_USER_ID = A.REQU_USER_ID OR  P.ACCE_USER_ID = A.REQU_USER_ID) AND A.REQU_SEQ = B.REQU_SEQ AND A.MEM_REL_CODE='20' AND B.RESULT_YN='Y' AND A.ACCE_USER_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();		
		

		System.out.println("테스트");
		while (rs.next())
		{
			DiaryDTO diary = new DiaryDTO();
			diary.setRequ_user_id(rs.getString("REQU_USER_ID"));
			diary.setUser_nic(rs.getString("USER_NIC"));
			diary.setRequ_seq(rs.getString("REQU_SEQ"));
			diary.setShar_diary_name(rs.getString("SHARE_DIARY_NAME"));
			result.add(diary);
			System.out.println(result);
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result;
	}

	@Override
	public int diaryname(DiaryDTO diary) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		//���� ���� (����, ���� ,÷������)
		String sql = "UPDATE TBL_MY_DIARY SET  DIRAY_NAME = ? WHERE DIARY_SEQ = ?";
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, diary.getDiary_name());
			pstmt.setString(2, diary.getDiary_seq());
			
			
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
	public int couplediaryname(DiaryDTO diary) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		//���� ���� (����, ���� ,÷������)
		String sql = "UPDATE TBL_SHARE_DIARY SET SHAR_DIARY_NAME = ? WHERE SHARE_DIARY_SEQ= ?";
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, diary.getShar_diary_name());
			pstmt.setString(2, diary.getShare_diary_seq());
			
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
	public DiaryDTO mydiary(String user_id) throws SQLException
	{

		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT A.USER_ID AS USER_ID , B.DIARY_SEQ AS DIARY_SEQ , "
				+  "B.DIARY_NAME AS DIARY_NAME "
				+ " FROM TBL_USER A, TBL_MY_DIARY B"
				+ " WHERE A.USER_ID = B.USER_ID  "
				+ " AND A.USER_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user_id);
		
		ResultSet rs  = pstmt.executeQuery();
		DiaryDTO diary = new DiaryDTO();
		
		while (rs.next())
		{
			diary.setUser_id(rs.getString("USER_ID"));
			diary.setDiary_seq(rs.getString("DIARY_SEQ"));
			diary.setDiary_name(rs.getString("DIARY_NAME"));
			
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return diary;
	}

	@Override
	public DiaryDTO couplediary(String user_id) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT A.ACCE_USER_ID AS ACCE_USER_ID  , A.REQU_USER_ID  AS REQU_USER_ID ,A.REQU_SEQ AS REQU_SEQ ,C.SHARE_DIARY_NAME AS SHARE_DIARY_NAME  FROM TBL_MEM_REQU A , TBL_MEM_REQU_RESULT B , TBL_SHARE_DIARY C WHERE  A.REQU_SEQ = B.REQU_SEQ AND A.MEM_REL_CODE='10' AND B.RESULT_YN='Y' AND A.REQU_SEQ=C.SHARE_DIARY_SEQ AND (A.ACCE_USER_ID = ? OR A.REQU_USER_ID = ? )";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_id);
		
		ResultSet rs  = pstmt.executeQuery();
		DiaryDTO diary = new DiaryDTO();
		
		while (rs.next())
		{//getRequ_seq
			diary.setAcce_user_id(rs.getString("ACCE_USER_ID"));
			diary.setRequ_user_id(rs.getString("REQU_USER_ID"));
			diary.setRequ_seq(rs.getString("REQU_SEQ"));
			diary.setShar_diary_name(rs.getString("SHARE_DIARY_NAME"));

			System.out.println(rs.getString("ACCE_USER_ID"));
			System.out.println(rs.getString("REQU_USER_ID"));
			System.out.println(rs.getString("REQU_SEQ"));
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		
		return diary;
	}

	

	

	

	



}
