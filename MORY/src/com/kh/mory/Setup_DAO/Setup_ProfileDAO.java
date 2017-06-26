package com.kh.mory.Setup_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Setup_IProfile;
import com.kh.mory.Model.Setup_ProfileDTO;

public class Setup_ProfileDAO implements Setup_IProfile
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Setup_ProfileDTO> nickname_check() throws SQLException
	{
		
		Connection conn = dataSource.getConnection();
		ArrayList<Setup_ProfileDTO> result = new ArrayList<Setup_ProfileDTO>();
		String sql ="  SELECT USER_ID AS ID,GEN_CODE AS GENDER,ACC_STATE_CODE AS STATUS, "
				+ " ACC_GRADE_CODE AS AUTHORITY, USER_NAME AS NAME "
     			+ ",USER_NIC AS NICKNAME, USER_TEL AS TEL, USER_BIRTH AS BRITHDAY,"
     			+ " USER_EMAIL AS EMAIL,ZIPCODE AS ZIPCOE "
				+ ",BASIC_ADDR AS BASIC_ADDR,DETAIL_ADDR AS DETAIL_ADDR FROM TBL_USER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			Setup_ProfileDTO profiledto = new Setup_ProfileDTO();
			profiledto.setUser_Id(rs.getString("ID"));
			profiledto.setUser_birth(rs.getString("BIRTHDAY"));
			profiledto.setUser_basic_Addr(rs.getString("BASIC_ADDR"));
			profiledto.setUser_detail_addr(rs.getString("DETAIL_ADDR"));
			profiledto.setUser_Tel(rs.getString("TEL"));
			profiledto.setUser_Zipcode(rs.getString("ZIPCODE"));
			profiledto.setUser_Email("EMAIL");
			profiledto.setUser_Pw(rs.getString("PW"));
			profiledto.setUser_name(rs.getString("NAME"));
			result.add(profiledto);
		}
		pstmt.close();
		conn.close();
		rs.close();
		
		
		return result;
	}

	@Override
	public ArrayList<Setup_ProfileDTO> id_check()
	{
		return null;
	}

	@Override
	public int modify() throws SQLException
	{
		int result =0;
		Connection conn = dataSource.getConnection();
		Setup_ProfileDTO profileDTO = new Setup_ProfileDTO();
		String sql ="UPDATE TBL_USER SET USER_ID = ? ,  USER_NIC =? ,USER_NAME = ? , USER_PW = ? ,"
				+ " USER_BIRTH = ? , USER_GENCODE = ? , USER_EMAIL = ? , USER_TEL = ? , ZIPCODE = ? , "
				+ "BASIC_ADDR = ? , DETAIL_ADDR = ?"  
				+" WHERE USER_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, profileDTO.getUser_Id());
		pstmt.setString(2, profileDTO.getUser_Nicname());
		pstmt.setString(3, profileDTO.getUser_name());
		pstmt.setString(4, profileDTO.getUser_Pw());
		pstmt.setString(5, profileDTO.getUser_birth());
		pstmt.setString(6, profileDTO.getGencode());
		pstmt.setString(7, profileDTO.getUser_Email());
		pstmt.setString(8, profileDTO.getUser_Tel());
		pstmt.setString(9, profileDTO.getUser_Zipcode());
		pstmt.setString(10, profileDTO.getUser_basic_Addr());
		pstmt.setString(11, profileDTO.getUser_detail_addr());
		pstmt.setString(12, profileDTO.getUser_Id());
		result = pstmt.executeUpdate();

		return result;
	}
	
	
	
	
}
