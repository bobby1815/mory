package com.kh.mory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class Community_Type_DAO implements ICommunity_Type_DAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
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
	public int add(CommunityDTO dto) throws SQLException 
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
	
	
}
