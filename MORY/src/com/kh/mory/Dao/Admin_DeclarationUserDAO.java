package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_DeclarationUserDTO;


public class Admin_DeclarationUserDAO implements Admin_IDeclarationUserDAO
{
	// 인터페이스 자료형 구성
	private DataSource dataSource;

	// setter 메소드 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	//-- 신고목록 조회
	@Override
	public ArrayList<Admin_DeclarationUserDTO> DeclarationSearchList(String term, String Id, String select)
			throws SQLException
	{
		Connection conn = dataSource.getConnection();
		ArrayList<Admin_DeclarationUserDTO> result = new ArrayList<Admin_DeclarationUserDTO>();
		Statement stmt = conn.createStatement();
		String sql=" ";
		
		
		//--term박스 가 1일이면 뉴스피드 조회
		if (term.equals("1"))
		{
			//뉴스피드 신고 조회
			sql= String.format(
					" SELECT ROWNUM AS NUM,W.WRITE_USER_ID AS WRITE_USER_ID , W.WRITE_CONT,W.WRITE_REG_DTM AS WRITE_REG_DTM, "
					+" (SELECT COUNT(*)  FROM  TBL_POST_REPORT  WHERE WRITE_SEQ=W.WRITE_SEQ "
					+" ) AS REPO_COUNT "  
					+" FROM TBL_USER U JOIN TBL_WRITE W "
					+" ON U.USER_ID=W.WRITE_USER_ID " 
					+" JOIN TBL_NEWSFEED N "
					+" ON W.WRITE_SEQ=N.FEED_SEQ "
					+" JOIN TBL_PAGE P ON P.PAGE_CODE=W.PAGE_CODE " 
					+" WHERE W.PAGE_CODE='N' AND W.WRITE_USER_ID LIKE '%%"+Id+"%%' AND W.WRITE_REG_DTM LIKE '%%"+select+"%%'");
					
		}
		
		else if(term.equals("2"))
		{
			//커뮤니티 신고 조회
			sql= String.format(
					" SELECT ROWNUM AS NUM ,W.WRITE_USER_ID AS WRITE_USER_ID,B.COMMUNITY_TYPE_NAME AS COMMUNITY_TYPE_NAME "
					+" ,C.COMMUNITY_TITLE AS COMMUNITY_TITLE ,W.WRITE_REG_DTM AS WRITE_REG_DTM, "
					+" (SELECT COUNT(*)  FROM  TBL_POST_REPORT  WHERE WRITE_SEQ=W.WRITE_SEQ "
					+" ) AS REPO_COUNT " 
					+" FROM TBL_WRITE W  JOIN TBL_COMMUNITY C "
					+" ON W.WRITE_SEQ = C.WRITE_SEQ "
					+" JOIN TBL_COMMUNITY_TYPE B "
					+" ON B.COMMUNITY_TYPE_CODE = C.COMMUNITY_TYPE_CODE "
					+" WHERE W.WRITE_USER_ID LIKE '%%"+Id+"%%' ");
			
		}	
		
		ResultSet rs =  stmt.executeQuery(sql);
		
		
		while (rs.next())
		{
			Admin_DeclarationUserDTO admin_DeclarationUserDTO = new Admin_DeclarationUserDTO();
			
			//-- 커뮤니티일때
			if (term.equals("2"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setWrite_User_Id(rs.getString("WRITE_USER_ID"));
				admin_DeclarationUserDTO.setCommunity_Type_Name(rs.getString("COMMUNITY_TYPE_NAME"));
				admin_DeclarationUserDTO.setCommunity_Title(rs.getString("COMMUNITY_TITLE"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
			}
			//-- 뉴스피드일때
			else if(term.equals("1"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setWrite_User_Id(rs.getString("WRITE_USER_ID"));
				admin_DeclarationUserDTO.setWrite_Cont(rs.getString("WRITE_CONT"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
			}
			
			result.add(admin_DeclarationUserDTO);
		}
		
		conn.close();
		stmt.close();
		rs.close();
		
		return result;
	}

	//-- 신고 Ajax 조회
	@Override
	public Admin_DeclarationUserDTO AjaxSearchUser(String userid) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		Admin_DeclarationUserDTO dto = new Admin_DeclarationUserDTO();
		String sql = 
				"";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
				
				
				
				
				
			
		}
		
		return dto;
	}
	

	//-- 블라인드 조회
	@Override
	public ArrayList<Admin_DeclarationUserDTO> BlindSearchList(String term, String Id, String select) throws SQLException
	{
		Connection conn =dataSource.getConnection();
		ArrayList<Admin_DeclarationUserDTO> result = new ArrayList<Admin_DeclarationUserDTO>();
		Statement stmt = conn.createStatement();
		String sql=" ";
		
		if (select.equals("1"))
		{
			sql = "select ROWNUM AS NUM ,WRITE_USER_ID,WRITE_CONT,TO_CHAR( WRITE_REG_DTM,'YY-MM-DD') AS WRITE_REG_DTM,REPO_COUNT "
				+ " FROM DNEWSFEEDVIEW "
				+" WHERE PAGE_CODE='N' AND WRITE_USER_ID LIKE '%%"+Id+"%%' AND WRITE_REG_DTM LIKE '%%"+term+"%%' AND REPO_COUNT >5 "; 
			
		}
		else if (select.equals("2"))
		{
			
			sql ="SELECT ROWNUM AS NUM , COMMUNITY_TYPE_NAME,WRITE_USER_ID,WRITE_CONT,TO_CHAR( WRITE_REG_DTM,'YY-MM-DD') AS WRITE_REG_DTM,REPO_COUNT "
				+" FROM DCOMMUNITYVIEW "
				+" WHERE REPO_COUNT > 10   AND write_user_id LIKE '%%"+Id+"%%' ";
		}
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Admin_DeclarationUserDTO admin_DeclarationUserDTO = new Admin_DeclarationUserDTO();
			
			//--뉴스피드일때
			if (select.equals("1"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setWrite_User_Id(rs.getString("WRITE_USER_ID"));
				admin_DeclarationUserDTO.setWrite_Cont(rs.getString("WRITE_CONT"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
				
			
				result.add(admin_DeclarationUserDTO);
			}
			
			//--커뮤니티 일때
			else if (select.equals("2"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setCommunity_Type_Name(rs.getString("COMMUNITY_TYPE_NAME"));
				admin_DeclarationUserDTO.setWrite_User_Id(rs.getString("WRITE_USER_ID"));
				admin_DeclarationUserDTO.setWrite_Cont(rs.getString("WRITE_CONT"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
				
				result.add(admin_DeclarationUserDTO);
			}
		}
		conn.close();
		stmt.close();
		rs.close();
		
		return result;
	}
	
	

}
