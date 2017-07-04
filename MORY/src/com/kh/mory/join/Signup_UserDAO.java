package com.kh.mory.join;

import java.sql.CallableStatement;

/*======================================================================
	
	파일명		: UserDAO.java
	화면 설명 	: 사용자 INSERT
				  회원가입시 Id,닉네임 중복체크
				  사용자 수정
				  사용자 목록조회,
				  사용자 조회
	작성자 		: 박아영
	최초작성일 	: 2017-06-19
	
 ======================================================================*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class Signup_UserDAO implements Signup_IUserDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	// 회원 가입
	@Override
	public int userInsert(Signup_UserDTO dto) throws SQLException
	{
		int res=0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			//String sql = "INSERT INTO TBL_USER (USER_ID, GEN_CODE, ADDR_DIVI_CODE,  USER_PW, USER_NIC, USER_NAME, USER_TEL, USER_BRITH, USER_EMAIL, ZIPCODE, BASIC_ADDR, DETAIL_ADDR)"
			//		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			//PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			String sql = "{call PROC_USER_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			CallableStatement preparedStatement = connection.prepareCall(sql);
			
			preparedStatement.setString(1, dto.getUser_id());
			preparedStatement.setString(2, dto.getGen_code());
			preparedStatement.setString(3, dto.getUser_pw());
			preparedStatement.setString(4, dto.getUser_nic());
			preparedStatement.setString(5, dto.getUser_name());
			preparedStatement.setString(6, dto.getUser_tel());
			preparedStatement.setString(7, dto.getUser_birth());
			preparedStatement.setString(8, dto.getUser_email());
			preparedStatement.setString(9, dto.getZipcode());
			preparedStatement.setString(10, dto.getBasic_addr());
			preparedStatement.setString(11, dto.getDetail_addr());
			preparedStatement.setString(12, dto.getLoca_name());
			preparedStatement.setString(13, dto.getCity_name());
			preparedStatement.setString(14, dto.getPwqu_code());
			preparedStatement.setString(15, dto.getPwqu_answ());
			
			res = preparedStatement.executeUpdate();
			
			System.out.println("res : "+res);
			
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}
	
	// ID 중복 체크
	@Override
	public int userIdCheck(String user_id) throws SQLException
	{
		int res=0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT COUNT(*) CNT FROM TBL_USER WHERE 1=1 AND USER_ID=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				res = rs.getInt("CNT");
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	// 닉네임 중복체크
	@Override
	public int userNicknameCheck(String user_nic) throws SQLException
	{
		int res = 0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT COUNT(*) CNT FROM TBL_USER WHERE 1=1 AND USER_NIC=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_nic);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				res = rs.getInt("CNT");
			}
			rs.close();
			
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}
		
	// 사용자 목록조회
	@Override
	public ArrayList<Signup_UserDTO> userLists() throws SQLException
	{
		ArrayList<Signup_UserDTO> res = new ArrayList<Signup_UserDTO>();
		
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
					+ "    , U.USER_PW AS USER_PW"
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
					+ " WHERE U.ACC_GRADE_CODE = 80";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				Signup_UserDTO dto = new Signup_UserDTO();
				dto.setUser_id(rs.getString("USER_ID"));
				dto.setGen_code(rs.getString("GEN_CODE"));
				dto.setGen_name(rs.getString("GEN_NAME"));
				dto.setPage_code(rs.getString("PAGE_CODE"));
				dto.setPage_name(rs.getString("PAGE_NAME"));
				dto.setOpen_code(rs.getString("OPEN_CODE"));
				dto.setOpen_name(rs.getString("OPEN_NAME"));
				dto.setAcc_state_code(rs.getInt("ACC_STATE_CODE"));
				dto.setAcc_state_name(rs.getString("ACC_STATE_NAME"));
				dto.setAcc_grade_code(rs.getInt("ACC_GRADE_CODE"));
				dto.setUser_pw(rs.getString("USER_PW"));
				dto.setUser_nic(rs.getString("USER_NIC"));
				dto.setUser_name(rs.getString("USER_NAME"));
				dto.setUser_tel(rs.getString("USER_TEL"));
				dto.setUser_birth(rs.getString("USER_BRITH"));
				dto.setUser_email(rs.getString("USER_EMAIL"));
				dto.setZipcode(rs.getString("ZIPCODE"));
				dto.setBasic_addr(rs.getString("BASIC_ADDR"));
				dto.setDetail_addr(rs.getString("DETAIL_ADDR"));
				dto.setLoca_code(rs.getString("LOCA_CODE"));
				dto.setCity_code(rs.getString("CITY_CODE"));
				dto.setPwqu_code(rs.getString("PWQU_CODE"));
				dto.setPwqu_answ(rs.getString("PWQU_ANSW"));
				
				res.add(dto);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}

	// 사용자 조회
	@Override
	public Signup_UserDTO userList(String user_id) throws SQLException
	{
		Signup_UserDTO res = new Signup_UserDTO();
		
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
					+ "    , U.USER_PW AS USER_PW"
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
					+ "    , U.PROFILE_LOCATION AS PROFILE_LOCATION"
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
					+ " WHERE U.ACC_GRADE_CODE = 80"
					+ " AND U.USER_ID = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user_id);
			
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
				res.setUser_pw(rs.getString("USER_PW"));
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
				res.setProfile_location(rs.getString("PROFILE_LOCATION"));
			}
			System.out.println("========================="+res.getProfile_location());
			
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
	
	// 로그인
	@Override
	public Signup_UserDTO userLogin(String user_id, String user_pw) throws SQLException
	{
		Signup_UserDTO res = new Signup_UserDTO();
		
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

	// 사용자 정보 수정
	@Override
	public int userModify(Signup_UserDTO dto) throws SQLException
	{
		int res=0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "{call PROC_USER_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			CallableStatement callableStatement = connection.prepareCall(sql);
			
			callableStatement.setString(1, dto.getUser_id());
			callableStatement.setString(2, dto.getGen_code());
			callableStatement.setString(3, dto.getUser_pw());
			callableStatement.setString(4, dto.getUser_nic());
			callableStatement.setString(5, dto.getUser_name());
			callableStatement.setString(6, dto.getUser_tel());
			callableStatement.setString(7, dto.getUser_birth());
			callableStatement.setString(8, dto.getUser_email());
			callableStatement.setString(9, dto.getZipcode());
			callableStatement.setString(10, dto.getBasic_addr());
			callableStatement.setString(11, dto.getDetail_addr());
			callableStatement.setString(12, dto.getLoca_name());
			callableStatement.setString(13, dto.getCity_name());
			callableStatement.setString(14, dto.getPwqu_code());
			callableStatement.setString(15, dto.getPwqu_answ());
			callableStatement.setString(16, dto.getProfile_location());
			
			res = callableStatement.executeUpdate();
			
			System.out.println("res : "+res);
			
			callableStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}
}
