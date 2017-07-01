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
	     //����ڰ� ������ �� ������ �� ���ǰɱ�
			   if (user_Value.equals("1"))
			   {	   
				   user_Value = " AND U.USER_ID LIKE '%%"+user_Search+"%%' ";
			   }
	            else if (user_Value.equals("2"))
	            {	
	            	user_Value =" AND U.USER_NAME LIKE '%%"+user_Search+"%%' ";
	            }
				else if(user_Value.equals("3"))
				{
					user_Value ="AND U.USER_NIC LIKE '%%"+user_Search+"%%' ";	
				}
				else if(user_Value.equals("4"))
				{
					user_Value ="AND T.SANC_TYPE_NAME LIKE '%"+user_Search+"%' ";
				}

		String sql =	
			" SELECT ROWNUM AS NUM, U.USER_ID AS USER_ID, U.USER_NAME AS USER_NAME , U.USER_NIC  AS USER_NIC"
			+ ",U.USER_EMAIL AS USER_EMAIL " 
			+" ,U.USER_TEL AS USER_TEL , U.BASIC_ADDR AS BASIC_ADDR "  
			+"  ,U.DETAIL_ADDR AS DETAIL_ADDR , " 
			+" U.USER_BIRTH AS USER_BIRTH, "
			+" NVL(T.SANC_TYPE_NAME,'활동 중') AS SANC_TYPE_NAME "
			+" FROM TBL_USER U "
			+ " LEFT JOIN TBL_USER_SANCTION S "
		     +" ON U.USER_ID = S.USER_ID "
		     +" LEFT JOIN TBL_SANCTION_TYPE T "
		     +" ON S.SANC_TYPE_CODE = T.SANC_TYPE_CODE WHERE 1=1 "
		     +user_Value;
		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
	
			while (rs.next())
			{
				Admin_UserDTO userDTO=new Admin_UserDTO();
				userDTO.setNum(rs.getInt("NUM"));
				userDTO.setUser_Id(rs.getString("USER_ID"));
				userDTO.setUser_Name(rs.getString("USER_NAME"));
				userDTO.setUser_Nic(rs.getString("USER_NIC"));
				userDTO.setUser_Tel(rs.getString("USER_TEL"));
				userDTO.setUser_Email(rs.getString("USER_EMAIL"));
				userDTO.setBasic_Addr(rs.getString("BASIC_ADDR"));
				userDTO.setSanc_Type_Name(rs.getString("SANC_TYPE_NAME"));
				userDTO.setDetail_Addr(rs.getString("DETAIL_ADDR"));
				userDTO.setUser_Birth(rs.getString("USER_BIRTH"));				
				list.add(userDTO);
				
			}
		
		pstmt.close();
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
			       		+" ,ST.ACC_STATE_NAME AS ACC_STATE_NAME ,NVL(T.SANC_TYPE_NAME,'활동 중') AS SANC_TYPE_NAME "
						+" FROM TBL_USER U "
						+ " LEFT JOIN TBL_USER_SANCTION S "
		                +" ON U.USER_ID = S.USER_ID " 
		                +" LEFT JOIN TBL_SANCTION_TYPE T "
		                +" ON S.SANC_TYPE_CODE=T.SANC_TYPE_CODE  "
		                +" LEFT JOIN TBL_ACC_STATE ST "
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

	
	// --�����˻�
	@Override
	public Admin_UserDTO SearchUser(String User_Id) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		String sql =
				" SELECT U.USER_ID AS USER_ID  ,U.USER_NAME AS USER_NAME "
			       		+" ,U.USER_NIC AS USER_NIC  ,U.BASIC_ADDR AS BASIC_ADDR ,U.DETAIL_ADDR AS DETAIL_ADDR "
			       		+" ,U.USER_TEL AS USER_TEL  ,U.USER_EMAIL AS USER_EMAIL  ,TO_CHAR(U.USER_BIRTH,'YY-MM-DD')AS USER_BIRTH "
			       		+" ,ST.ACC_STATE_NAME AS ACC_STATE_NAME ,NVL(T.SANC_TYPE_NAME,'활동 중') AS SANC_TYPE_NAME "
				+" FROM TBL_USER U "
						+ " LEFT JOIN TBL_USER_SANCTION S"
		                +" ON U.USER_ID = S.USER_ID" 
		                +" LEFT JOIN TBL_SANCTION_TYPE T"
		                +" ON S.SANC_TYPE_CODE=T.SANC_TYPE_CODE "
		                +" LEFT JOIN TBL_ACC_STATE ST"
		                +" ON U.ACC_STATE_CODE=ST.ACC_STATE_CODE"
				+" WHERE U.USER_ID=?";
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		Admin_UserDTO userDTO = new Admin_UserDTO();
		pstmt.setString(1, User_Id);
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


	// --������� ����
	@Override
	public int UserModify(String id,String sanc_Type_Code,String nic) throws SQLException
	{
		int result = 0;
		Connection conn = dataSource.getConnection();
		
		//USER_NIC=? 
		
		String sql = "UPDATE TBL_USER_SANCTION SET SANC_TYPE_CODE=?  WHERE USER_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sanc_Type_Code);
		pstmt.setString(2, nic);
		pstmt.setString(3,id);
		
		
		result = pstmt.executeUpdate();
		System.out.println(result);
		
		return result;
	}


}
