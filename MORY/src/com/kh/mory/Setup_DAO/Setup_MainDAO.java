package com.kh.mory.Setup_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kh.mory.Model.Setup_IMain;
import com.kh.mory.Model.Setup_MainDTO;

public class Setup_MainDAO implements Setup_IMain
{
	private DataSource dataSource;
	
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}


	public Setup_MainDTO userLogin(String user_id, String user_pw) throws SQLException
	{
		System.out.println(user_id+"/"+user_pw);
		Setup_MainDTO res = new Setup_MainDTO();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = 
					"SELECT"
					+ "    U.USER_ID   AS USER_ID"
					+ "    , U.GEN_CODE    AS GEN_CODE"
					+ "    , G.GEN_NAME    AS GEN_NAME"
					+ "    , U.PAGE_CODE   AS PAGE_CODE"
					+ "    , P.PAGE_NAME   AS PAGE_NAME"
					+ "    , U.OPEN_CODE   AS OPEN_CODE"
					+ "    , O.OPEN_NAME   AS OPEN_NAME"
					+ "    , U.ACC_STATE_CODE  AS ACC_STATE_CODE"
					+ "    , S.ACC_STATE_NAME  AS ACC_STATE_NAME"
					+ "    , U.ACC_GRADE_CODE  AS ACC_GRADE_CODE"
					+ "    , U.USER_NIC    AS USER_NIC"
					+ "    , U.USER_NAME   AS USER_NAME"
					+ "    , U.USER_TEL    AS USER_TEL"
					+ "    , TO_CHAR(U.USER_BIRTH, 'YYYY-MM-DD')   AS USER_BIRTH"
					+ "    , U.USER_EMAIL  AS USER_EMAIL"
					+ "    , U.ZIPCODE AS ZIPCODE"
					+ "    , U.BASIC_ADDR  AS BASIC_ADDR"
					+ "    , U.DETAIL_ADDR AS DETAIL_ADDR"
					+ "    , U.LOCA_CODE   AS LOCA_CODE"
					+ "    , L.LOCA_NAME   AS LOCA_NAME"
					+ "    , U.CITY_CODE   AS CITY_CODE"
					+ "    , C.CITY_NAME   AS CITY_NAME"
					+ "    , U.PWQU_CODE   AS PWQU_CODE"
					+ "    , U.PWQU_ANSW   AS PWQU_ANSW"
					+ " FROM TBL_USER U JOIN TBL_GENDER G"
					+ " ON U.GEN_CODE = G.GEN_CODE"
					+ " JOIN TBL_PAGE P"
					+ " ON U.PAGE_CODE = P.PAGE_CODE"
					+ " JOIN TBL_OPEN_YN O"
					+ " ON U.OPEN_CODE = O.OPEN_CODE"
					+ " JOIN TBL_ACC_STATE S"
					+ " ON U.ACC_STATE_CODE = S.ACC_STATE_CODE"
					+ " JOIN TBL_LOCATION L"
					+ " ON U.LOCA_CODE = L.LOCA_CODE"
					+ " JOIN TBL_CITY C"
					+ " ON U.CITY_CODE = C.CITY_CODE"
					+ " WHERE 1=1"
					+ " AND U.USER_ID = ?"
					+ " AND U.USER_PW = CRYPTPACKAGE.ENCRYPT(?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_pw);
			preparedStatement.setString(3, user_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next())
			{
				res.setUser_id(rs.getString("USER_ID"));
				res.setGen_code(rs.getString("GEN_CODE"));
				res.setGen_name(rs.getString("GEN_NAME"));
				res.setPage_code(rs.getString("PAGE_CODE"));
				res.setPage_name(rs.getString("PAGE_NAME"));
				res.setOpen_code(rs.getString("OPEN_CODE"));
				res.setOpen_name(rs.getString("OPEN_NAME"));
				res.setAcc_state_code(rs.getInt("ACC_STATE_CODE"));
				res.setAcc_state_name(rs.getString("ACC_STATE_NAME"));
				res.setAcc_grade_code(rs.getInt("ACC_GRADE_CODE"));
				res.setUser_nic(rs.getString("USER_NIC"));
				res.setUser_name(rs.getString("USER_NAME"));
				res.setUser_tel(rs.getString("USER_TEL"));
				res.setUser_birth(rs.getString("USER_BIRTH"));
				res.setUser_email(rs.getString("USER_EMAIL"));
				res.setZipcode(rs.getString("ZIPCODE"));
				res.setBasic_addr(rs.getString("BASIC_ADDR"));
				res.setDetail_addr(rs.getString("DETAIL_ADDR"));
				res.setLoca_code(rs.getString("LOCA_CODE"));
				res.setCity_code(rs.getString("CITY_CODE"));
				res.setPwqu_code(rs.getString("PWQU_CODE"));
				res.setPwqu_answ(rs.getString("PWQU_ANSW"));
			}
			rs.close();
			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			
		return res;
	}


}
