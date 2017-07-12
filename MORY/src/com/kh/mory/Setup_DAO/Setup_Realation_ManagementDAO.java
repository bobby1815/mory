
package com.kh.mory.Setup_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Setup_IRealation_Management;
import com.kh.mory.Model.Setup_Realation_ManagementDTO;

public class Setup_Realation_ManagementDAO implements Setup_IRealation_Management
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Setup_Realation_ManagementDTO> searchuser(String user_Id) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		System.out.println(user_Id);
		ArrayList<Setup_Realation_ManagementDTO> user_list = new ArrayList<Setup_Realation_ManagementDTO>();
		String sql = "SELECT USER_ID, USER_NIC , BASIC_ADDR FROM TBL_USER WHERE USER_ID LIKE '%"+user_Id+"%'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			Setup_Realation_ManagementDTO dto = new Setup_Realation_ManagementDTO();
			dto.setUser_id(rs.getString("USER_ID"));
			dto.setUser_nic(rs.getString("USER_NIC"));
			dto.setBasic_addr(rs.getString("BASIC_ADDR"));
			user_list.add(dto);
		}
		return user_list;
	}
	
	// 이웃 추가
	@Override
	public int Negihbor(String user_Id , String nei_user_id) throws SQLException
	{
		int result=0;
		Connection conn = dataSource.getConnection();
		
		String sql ="INSERT INTO TBL_NEIGHBOR (NEI_SEQ,USER_ID,NEI_USER_ID,NEI_REG_DTM) "
				+ "VALUES (SEQ_NEIGHBOR.NEXTVAL,?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_Id);
		pstmt.setString(2, nei_user_id);
		result=pstmt.executeUpdate();
		pstmt.close();
		
		
		return result;
	}

	@Override
	public int UnNegibor(String user_Id,String nei_user_Id) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		String sql ="DELETE FROM TBL_NEIGHBOR WHERE USER_ID =? AND NEI_USER_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_Id);
		pstmt.setString(2, nei_user_Id);
		result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

	// 이웃 목록 조회
	@Override
	public ArrayList<Setup_Realation_ManagementDTO> neighborList(String user_id) throws SQLException
	{
		ArrayList<Setup_Realation_ManagementDTO> res = new ArrayList<Setup_Realation_ManagementDTO>();
		
		Connection conn = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT NEI_SEQ, USER_ID, NEI_USER_ID, NEI_REG_DTM FROM TBL_NEIGHBOR WHERE USER_ID=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				Setup_Realation_ManagementDTO dto = new Setup_Realation_ManagementDTO();
				dto.setNei_seq(rs.getInt("NEI_SEQ"));
				dto.setUser_id(rs.getString("USER_ID"));
				dto.setNei_user_id(rs.getString("NEI_USER_ID"));
				dto.setNei_reg_dtm(rs.getString("NEI_REG_DTM"));
				
				res.add(dto);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	@Override
	public ArrayList<Setup_Realation_ManagementDTO> neighborgiList(String nei_user_id) throws SQLException
	{
		ArrayList<Setup_Realation_ManagementDTO> res = new ArrayList<Setup_Realation_ManagementDTO>();
		
		Connection conn = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT NEI_SEQ, USER_ID, NEI_USER_ID, NEI_REG_DTM FROM TBL_NEIGHBOR WHERE NEI_USER_ID=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nei_user_id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				Setup_Realation_ManagementDTO dto = new Setup_Realation_ManagementDTO();
				dto.setNei_seq(rs.getInt("NEI_SEQ"));
				dto.setUser_id(rs.getString("USER_ID"));
				dto.setNei_user_id(rs.getString("NEI_USER_ID"));
				dto.setNei_reg_dtm(rs.getString("NEI_REG_DTM"));
				
				res.add(dto);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	
	
	
	
}
