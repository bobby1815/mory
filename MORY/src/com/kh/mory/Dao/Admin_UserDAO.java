//--------------------------------
//       ������ȸDAO
//--------------------------------
package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_UserDTO;

public class Admin_UserDAO implements Admin_IUserDAO
{

	// �������̽� �ڷ��� ����
	private DataSource dataSource;

	// setter �޼ҵ� ����
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}


	// -- ������ȸ(�̸�,�г���,��������)��ȸ
	@Override
	public ArrayList<Admin_UserDTO> QueryUser(String user_Value, String user_Search) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		ArrayList<Admin_UserDTO> list = new ArrayList<Admin_UserDTO>();
		
	  
		   if (user_Value.equals("1"))
		   {	   
			   user_Value = " WHERE U.USER_ID LIKE '%%"+user_Search+"%%' ";
		   }
            else if (user_Value.equals("2"))
            {	
            	user_Value =" WHERE U.USER_NAME LIKE '%%"+user_Search+"%%' ";
            }
			else if(user_Value.equals("3"))
			{
				user_Value ="WHERE U.USER_NIC LIKE '%%"+user_Search+"%%' ";	
			}
			else
			{
				user_Value ="WHERE T.SANC_TYPE_NAME LIKE '%%"+user_Search+"%%' ";
			}
		   
System.out.println(user_Value);
String sql =	
String.format(
			" SELECT U.USER_ID AS USER_ID   ,U.USER_NAME AS USER_NAME   ,U.USER_NIC AS USER_NIC  ,U.USER_TEL AS USER_TEL  "
				+" ,U.BASIC_ADDR AS BASIC_ADDR  ,T.SANC_TYPE_NAME AS SANC_TYPE_NAME ,ST.ACC_STATE_NAME AS ACC_STATE_NAME, U.DETAIL_ADDR AS DETAIL_ADDR "
				+" ,U.USER_BIRTH AS USER_BIRTH "
				+" FROM TBL_USER U JOIN TBL_USER_SANCTION S  ON U.USER_ID = S.USER_ID  JOIN TBL_SANCTION_TYPE T "  
				+" ON S.SANC_TYPE_CODE=T.SANC_TYPE_CODE  JOIN TBL_ACC_STATE ST  ON U.ACC_STATE_CODE=ST.ACC_STATE_CODE "
				+user_Value);
System.out.println(sql);
		Statement stmt = conn.createStatement();
		ResultSet rs = 	stmt.executeQuery(sql);

			while (rs.next())
			{
				Admin_UserDTO userDTO = new Admin_UserDTO();
				
				userDTO.setUser_Id(rs.getString("USER_ID"));
				userDTO.setUser_Name(rs.getString("USER_NAME"));
				userDTO.setUser_Nic(rs.getString("USER_NIC"));
				userDTO.setUser_Tel(rs.getString("USER_TEL"));
				userDTO.setBasic_Addr(rs.getString("BASIC_ADDR"));
				userDTO.setSanc_Type_Name(rs.getString("SANC_TYPE_NAME"));
				userDTO.setDetail_Addr(rs.getString("DETAIL_ADDR"));
				userDTO.setUser_Birth(rs.getString("USER_BIRTH"));
				userDTO.setAcc_State_Name(rs.getString("ACC_STATE_NAME"));
				
				list.add(userDTO);
				
			}
			
		stmt.close();
		conn.close();
		rs.close();
		
		return list;
	}

	
	
	
	
	// --��ü��������Ʈ(����� ��ü)
	@Override
	public ArrayList<Admin_UserDTO> UserList() throws SQLException
	{
		ArrayList<Admin_UserDTO> list = new ArrayList<Admin_UserDTO>();
		Connection conn = dataSource.getConnection();
		String sql =
				" SELECT U.USER_ID AS USER_ID  ,U.USER_NAME AS USER_NAME "
			       		+" ,U.USER_NIC AS USER_NIC  ,U.BASIC_ADDR AS BASIC_ADDR ,U.DETAIL_ADDR AS DETAIL_ADDR "
			       		+" ,U.USER_TEL AS USER_TEL  ,U.USER_EMAIL AS USER_EMAIL  ,U.USER_BIRTH AS USER_BIRTH "
			       		+" ,ST.ACC_STATE_NAME AS ACC_STATE_NAME ,T.SANC_TYPE_NAME AS SANC_TYPE_NAME "
				+" FROM TBL_USER U JOIN TBL_USER_SANCTION S "
		                +" ON U.USER_ID = S.USER_ID " 
		                +" JOIN TBL_SANCTION_TYPE T "
		                +" ON S.SANC_TYPE_CODE=T.SANC_TYPE_CODE  "
		                +" JOIN TBL_ACC_STATE ST "
		                +" ON U.ACC_STATE_CODE=ST.ACC_STATE_CODE ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			Admin_UserDTO userDTO = new Admin_UserDTO();
			
			userDTO.setUser_Id(rs.getString("USER_ID"));
			userDTO.setUser_Name(rs.getString("USER_NAME"));
			userDTO.setUser_Nic(rs.getString("USER_NIC"));
			userDTO.setUser_Tel(rs.getString("USER_TEL"));
			userDTO.setBasic_Addr(rs.getString("BASIC_ADDR"));
			userDTO.setSanc_Type_Name(rs.getString("SANC_TYPE_NAME"));
			
			list.add(userDTO);
		}

		pstmt.close();
		rs.close();
		conn.close();
		return list;
	}

	// --�г��Ӽ���
	@Override
	public int NicModify(String User_Nic, String User_Id) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		int result = 0;
		String sql = " UPDATE TBL_USER  SET USER_NIC=? WHERE USER_ID=? ";
		Admin_UserDTO userDTO = new Admin_UserDTO();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userDTO.getUser_Nic());
		pstmt.setString(2, userDTO.getUser_Id());
		result = pstmt.executeUpdate();

		pstmt.close();
		conn.close();
		return result;
	}

	// --�����˻�
	@Override
	public Admin_UserDTO SearchUser(String User_Id) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		String sql =
				" SELECT U.USER_ID AS USER_ID  ,U.USER_NAME AS USER_NAME "
			       		+" ,U.USER_NIC AS USER_NIC  ,U.BASIC_ADDR AS BASIC_ADDR ,U.DETAIL_ADDR AS DETAIL_ADDR "
			       		+" ,U.USER_TEL AS USER_TEL  ,U.USER_EMAIL AS USER_EMAIL  ,U.USER_BIRTH AS USER_BIRTH "
			       		+" ,ST.ACC_STATE_NAME AS ACC_STATE_NAME ,T.SANC_TYPE_NAME AS SANC_TYPE_NAME "
				+" FROM TBL_USER U JOIN TBL_USER_SANCTION S"
		                +" ON U.USER_ID = S.USER_ID" 
		                +" JOIN TBL_SANCTION_TYPE T"
		                +" ON S.SANC_TYPE_CODE=T.SANC_TYPE_CODE "
		                +" JOIN TBL_ACC_STATE ST"
		                +" ON U.ACC_STATE_CODE=ST.ACC_STATE_CODE"
				+" WHERE U.USER_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		Admin_UserDTO userDTO = new Admin_UserDTO();
		pstmt.setString(1, userDTO.getUser_Id());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			userDTO.setUser_Id(rs.getString("USER_ID"));
			userDTO.setUser_Name(rs.getString("USER_NAME"));
			userDTO.setUser_Nic(rs.getString("USER_NIC"));
			userDTO.setBasic_Addr(rs.getString("BASIC_ADDR"));
			userDTO.setDetail_Addr(rs.getString("DETAIL_ADDR"));
			userDTO.setUser_Tel(rs.getString("USER_TEL"));
			userDTO.setUser_Email(rs.getString("USER_EMAIL"));
			userDTO.setUser_Birth(rs.getString("USER_BIRTH"));
			userDTO.setSanc_Type_Name(rs.getString("SANC_TYPE_NAME"));
			userDTO.setAcc_State_Name(rs.getString("ACC_STATE_NAME"));
		}
		return userDTO;
	}

	// --�������� �Է�
	@Override
	public int UserAddSanction() throws SQLException
	{
		int result = 0;
		Admin_UserDTO userDTO = new Admin_UserDTO();
		Connection conn = dataSource.getConnection();
		String sql = " INSERT INTO TBL_USER_SANCTION VALUES(SEQ_USER_SANCTION.NEXTVAL,?,?,SYSDATE) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userDTO.getUser_Id());
		pstmt.setString(2, userDTO.getSanc_Type_Code());
		result = pstmt.executeUpdate();

		return result;
	}


}
