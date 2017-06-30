package com.kh.mory;

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
		
		String sql = " EXEC PRC_COMMUNITY_INSERT(?,?,?,?)";
			
		
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
		return null;
	}

	@Override
	public ArrayList<CommunityDTO> list() throws SQLException 
	{
		ArrayList<CommunityDTO> result = new ArrayList<CommunityDTO>();
		
		CommunityDTO dto = new CommunityDTO();
		Connection conn = dataSource.getConnection();
		
		String sql =" SELECT C.WRITE_SEQ AS WRITE_SEQ ,"
				+ " C.COMMUNITY_TYPE_CODE AS COMMUNITY_TYPE_CODE ,"
				+ " C.COMMUNITY_TITLE AS COMMUNITY_TITLE,"
				+ " C.COMMUNITY_LOVE_CNT AS COMMUNITY_LOVE_CNT ,"
				+ " W.WRITE_USER_ID AS WRITE_USER_ID ,"
				+ " W.WRITE_CONT AS WRITE_CONT ,"
				+ " W.WRITE_REG_DTM AS WRITE_REG_DTM,"
				+ "  U.UPLO_LOCA AS UPLO_LOCA,"
				+ " T.COMMUNITY_TYPE_NAME AS COMMUNITY_TYPE_NAME"
				+ " FROM TBL_COMMUNITY C LEFT JOIN  TBL_WRITE W "
				+ " ON C.WRITE_SEQ = W.WRITE_SEQ "
				+ " LEFT JOIN TBL_UPLOAD_FILE U"
				+ " ON C.WRITE_SEQ = U.WRITE_SEQ "
				+ " LEFT JOIN TBL_COMMUNITY_TYPE T"
				+ " ON C.COMMUNITY_TYPE_CODE = T.COMMUNITY_TYPE_CODE "
				+ " ORDER BY COMMUNITY_LOVE_CNT DESC";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) 
		{
			 dto = new CommunityDTO();
			
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





	
	

	
	
}
