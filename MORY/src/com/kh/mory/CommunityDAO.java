package com.kh.mory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CommunityDAO implements ICommunityDAO
{
	private DataSource dataSource;
	
	
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	@Override
	public int add(CommunityDTO community) throws SQLException 
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		
		String sql = "{CALL PRC_COMMUNITY_INSERT(?,?,?,?)}";	
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, community.getWrite_user_id());
		cstmt.setString(2, community.getWrite_cont());
		cstmt.setInt(3, community.getCommunity_type_code());
		cstmt.setString(4, community.getCommunity_title());
		result = cstmt.executeUpdate();
		cstmt.close();
			
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, community.getWrite_user_id());
		pstmt.setString(2, community.getWrite_cont());
		pstmt.setInt(3, community.getCommunity_type_code());
		pstmt.setString(4, community.getCommunity_title());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int count() throws SQLException 
	{
			
		return 0;
	}

	@Override
	public int remove(int write_seq) throws SQLException 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(CommunityDTO community) throws SQLException 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommunityDTO searchId(int write_seq) throws SQLException
	{
		
		CommunityDTO dto = new CommunityDTO();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "	SELECT WRITE_SEQ ,"
				+ " COMMUNITY_TYPE_CODE,"
				+ " COMMUNITY_TITLE , "
				+ "	COMMUNITY_LOVE_CNT ,"
				+ "	COMMUNITY_HITS "
				+ "FROM TBL_COMMUNITY WHERE WRITE_SEQ = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println(sql);
		pstmt.setInt(1, write_seq);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) 
		{
			dto = new CommunityDTO();
			
			dto.setWrite_seq(rs.getString("WRITE_SEQ"));
			dto.setCommunity_type_code(rs.getInt("COMMUNITY_TYPE_CODE"));
			dto.setCommunity_title(rs.getString("COMMUNITY_TITLE"));
			dto.setCommunity_love_cnt(rs.getInt("COMMUNITY_LOVE_CNT"));
			dto.setCommunity_hits(rs.getInt("COMMUNITY_HITS"));
			
			
		}
		rs.close();
		pstmt.close();
		return dto;
	}

	@Override
	public ArrayList<CommunityDTO> list(int community_type_code) throws SQLException {
		
		ArrayList<CommunityDTO> result = new ArrayList<CommunityDTO>();
		
		Connection conn = dataSource.getConnection();
		
		String sql ="SELECT WRITE_SEQ,"
				+ " COMMUNITY_TYPE_CODE,"
				+ " COMMUNITY_TITLE,"
				+ " COMMUNITY_LOVE_CNT,"
				+ " WRITE_USER_ID,"
				+ " WRITE_CONT,"
				+ " WRITE_REG_DTM,"
				+ " UPLO_LOCA,"
				+ " COMMUNITY_TYPE_NAME "
				+ " FROM COMMUNITYMAINVIEW "
				+ " WHERE COMMUNITY_TYPE_CODE= ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, community_type_code);
		

		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) 
		{
			 CommunityDTO dto = new CommunityDTO();
			
			dto.setWrite_seq(rs.getString("WRITE_SEQ"));
			dto.setCommunity_type_code(rs.getInt("COMMUNITY_TYPE_CODE"));
			dto.setCommunity_title(rs.getString("COMMUNITY_TITLE"));
			dto.setCommunity_love_cnt(rs.getInt("COMMUNITY_LOVE_CNT"));
			dto.setWrite_user_id(rs.getString("WRITE_USER_ID"));
			dto.setWrite_cont(rs.getString("WRITE_CONT"));
			dto.setWrite_reg_dtm(rs.getString("WRITE_REG_DTM"));
			dto.setWrite_user_id(rs.getString("UPLO_LOCA"));
			dto.setCommunity_type_name(rs.getString("COMMUNITY_TYPE_NAME"));			
			result.add(dto);
			
		}
		
		conn.close();
		pstmt.close();
		rs.close();
		
		
		
		
		return result;
	}

	@Override
	public ArrayList<CommunityDTO> type_list() throws SQLException 
	{
		ArrayList<CommunityDTO> result = new ArrayList<CommunityDTO>();
		
		Connection conn = dataSource.getConnection();
		
		
		String sql = "SELECT COMMUNITY_TYPE_CODE, COMMUNITY_TYPE_NAME FROM TBL_COMMUNITY_TYPE";
		
		PreparedStatement pstmt = conn.prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) 
		{
			CommunityDTO dto = new CommunityDTO();
			
			dto.setCommunity_type_code(rs.getInt("COMMUNITY_TYPE_CODE"));
			dto.setCommunity_type_name(rs.getString("COMMUNITY_TYPE_NAME"));
			
			result.add(dto);
			
		
		}
		rs.close();
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override
	public int type_Add(CommunityDTO dto) throws SQLException 
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT COMMUNITY_TYPE_CODE, COMMUNITY_TYPE_NAME"
				+ " FROM TBL_COMMUNITY_TYPE"
				+ " WHERE COMMUNITY_TYPE_CODE=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, dto.getCommunity_type_code());
		
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		
		
		return result;
	}

	@Override
	public ArrayList<CommunityDTO> mypost_list(CommunityDTO dto) throws SQLException 
	{
		
		ArrayList<CommunityDTO> result = new ArrayList<CommunityDTO>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT C.COMMUNITY_TITLE AS COMMUNITY_TITLE ,"
				+ "  W.WRITE_USER_ID AS WRITE_USER_ID ,"
				+ " W.WRITE_CONT AS WRITE_CONT ,"
				+ " W.WRITE_REG_DTM AS WRITE_REG_DTM "
				+ " FROM TBL_COMMUNITY C LEFT JOIN TBL_WRITE W  "
				+ " ON C.WRITE_SEQ = W.WRITE_SEQ WHERE W.WRITE_USER_ID = '?'"
				+ " ORDER BY W.WRITE_REG_DTM DESC";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, dto.getWrite_user_id());
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) 
		{
			
			 dto = new CommunityDTO();
			 
			 dto.setCommunity_title(rs.getString("COMMUNITY_TITLE"));
			 dto.setWrite_user_id(rs.getString("WRITE_USER_ID"));
			 dto.setWrite_cont(rs.getString("WRITE_CONT"));
			 dto.setWrite_reg_dtm(rs.getString("WRITE_REG_DTM"));
			 
			 result.add(dto);
			
			
			
		}
		rs.close();
		conn.close();
		pstmt.close();
		
		
		return result;
	}

	

	@Override
	public ArrayList<CommunityDTO> search_list(CommunityDTO dto) throws SQLException 
	{
		ArrayList<CommunityDTO> result = new ArrayList<CommunityDTO>();
		
		Connection conn = dataSource.getConnection();
		
		
		String sql = " SELECT COMMUNITY_TITLE ,"
				+ " WRITE_UWER_ID, "
				+ " WRITE_CONT "
				+ " FROM GOOGLEVIEW"
				+ " WHERE WRITE_USER_ID=? "
				+ " AND COMMUNITY_TITLE LIKE ?  "
				+ " AND WRITE_CONT LIKE ?   ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		
		pstmt.setString(1, dto.getWrite_user_id());
		pstmt.setString(2, dto.getCommunity_title());
		pstmt.setString(3, dto.getWrite_cont());
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			
			dto = new CommunityDTO();
			
			dto.setWrite_user_id(rs.getString("WRITE_USER_ID"));
			dto.setCommunity_title(rs.getString("COMMUNITY_TITLE"));
			dto.setWrite_cont(rs.getString("WRITE_CONT"));
			result.add(dto);
			
			
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		
		
		return result;
	}

	


	
	
	
}
