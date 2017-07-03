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
	// �������̽� �ڷ��� ����
	private DataSource dataSource;

	// setter �޼ҵ� ����
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	//-- �Ű��� ��ȸ
	@Override
	public ArrayList<Admin_DeclarationUserDTO> DeclarationSearchList(String term, String Id, String select)
			throws SQLException
	{
		Connection conn = dataSource.getConnection();
		ArrayList<Admin_DeclarationUserDTO> result = new ArrayList<Admin_DeclarationUserDTO>();
		Statement stmt = conn.createStatement();
		String sql=" ";
		
		//-- term 1이면 뉴스피드일떄
		if (term.equals("1"))
		{
			//�����ǵ� �Ű� ��ȸ
			sql= String.format(
					" SELECT ROWNUM AS NUM,S.REPO_USER_ID AS REPO_USER_ID, W.WRITE_CONT,W.WRITE_REG_DTM AS WRITE_REG_DTM, "
					+" (SELECT COUNT(*)  FROM  TBL_POST_REPORT  WHERE WRITE_SEQ=W.WRITE_SEQ "
					+" ) AS REPO_COUNT,W.WRITE_SEQ AS WRITE_SEQ"  
					+" FROM TBL_USER U JOIN TBL_WRITE W "
					+" ON U.USER_ID=W.WRITE_USER_ID " 
					+" JOIN TBL_NEWSFEED N "
					+" ON W.WRITE_SEQ=N.FEED_SEQ "
					+" JOIN TBL_PAGE P ON P.PAGE_CODE=W.PAGE_CODE "
					+" JOIN TBL_POST_REPORT S ON W.WRITE_SEQ = S.WRITE_SEQ "
					+" WHERE W.PAGE_CODE='N' AND W.WRITE_USER_ID LIKE '%%"+Id+"%%' AND W.WRITE_REG_DTM LIKE '%%"+select+"%%'");
					
		}
		
		//-- term 2이면 커뮤니티일떄
		else if(term.equals("2"))
		{

			sql= String.format(
		     	"SELECT ROWNUM AS NUM ,P.REPO_USER_ID AS REPO_USER_ID,B.COMMUNITY_TYPE_NAME AS COMMUNITY_TYPE_NAME  ,C.COMMUNITY_TITLE AS COMMUNITY_TITLE ,W.WRITE_REG_DTM AS WRITE_REG_DTM"
				+ ",  (SELECT COUNT(*)  FROM  TBL_POST_REPORT  WHERE WRITE_SEQ=W.WRITE_SEQ  ) AS REPO_COUNT, W.WRITE_SEQ AS WRITE_SEQ  FROM TBL_WRITE W " 
			+" JOIN TBL_COMMUNITY C  ON W.WRITE_SEQ = C.WRITE_SEQ  JOIN TBL_COMMUNITY_TYPE B  ON B.COMMUNITY_TYPE_CODE = C.COMMUNITY_TYPE_CODE "
			+" JOIN TBL_POST_REPORT P ON W.WRITE_SEQ=P.WRITE_SEQ "
			+" WHERE W.WRITE_USER_ID LIKE '%%"+Id+"%%' ");
			
		}	
		
		ResultSet rs =  stmt.executeQuery(sql);
		
		while (rs.next())
		{
			Admin_DeclarationUserDTO admin_DeclarationUserDTO = new Admin_DeclarationUserDTO();
			
			//-- Ŀ�´�Ƽ�϶�
			if (term.equals("2"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setRepo_User_Id(rs.getString("REPO_USER_ID"));
				admin_DeclarationUserDTO.setCommunity_Type_Name(rs.getString("COMMUNITY_TYPE_NAME"));
				admin_DeclarationUserDTO.setCommunity_Title(rs.getString("COMMUNITY_TITLE"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
				admin_DeclarationUserDTO.setWrite_Seq(rs.getString("WRITE_SEQ"));
			}
			//-- �����ǵ��϶�
			else if(term.equals("1"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setRepo_User_Id(rs.getString("REPO_USER_ID"));
				admin_DeclarationUserDTO.setWrite_Cont(rs.getString("WRITE_CONT"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
				admin_DeclarationUserDTO.setWrite_Seq(rs.getString("WRITE_SEQ"));
			}
			
			result.add(admin_DeclarationUserDTO);
		}
		
		conn.close();
		stmt.close();
		rs.close();
		
		return result;
	}


	//신고자 ajax처리(뉴스피드)
	@Override
	public Admin_DeclarationUserDTO AjaxSearchUser(String userid) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		Admin_DeclarationUserDTO dto = new Admin_DeclarationUserDTO();
		String sql =
		" SELECT P.WRITE_SEQ,P.REPO_USER_ID, W.WRITE_CONT, P.REG_DTM AS REG_DTM ,P.REPO_REASON "
		+" FROM TBL_WRITE W JOIN TBL_POST_REPORT P ON W.WRITE_SEQ = P.WRITE_SEQ "
		+ " WHERE W.WRITE_SEQ = ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,userid);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			dto.setRepo_User_Id(rs.getString("REPO_USER_ID"));
			dto.setWrite_Cont(rs.getString("WRITE_CONT"));
			dto.setReg_Dtm(rs.getString("REG_DTM"));
			dto.setRepo_Reason(rs.getString("REPO_REASON"));
				
			
		}
		
		return dto;
	}
	

	//-- ����ε� ��ȸ
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
				+" WHERE PAGE_CODE='N' AND WRITE_USER_ID LIKE '%%"+Id+"%%' AND WRITE_REG_DTM LIKE '%%"+term+"%%' AND REPO_COUNT >(SELECT DECL_CNT FROM TBL_BLIND_SETUP WHERE PAGE_CODE = 'N' ) "; 
			
		}
		else if (select.equals("2"))
		{
			
			sql ="SELECT ROWNUM AS NUM , COMMUNITY_TYPE_NAME,WRITE_USER_ID,WRITE_CONT,TO_CHAR( WRITE_REG_DTM,'YY-MM-DD') AS WRITE_REG_DTM,REPO_COUNT "
				+" FROM DCOMMUNITYVIEW "
				+" WHERE REPO_COUNT > (SELECT DECL_CNT FROM TBL_BLIND_SETUP WHERE PAGE_CODE = 'C' )  AND write_user_id LIKE '%%"+Id+"%%' ";
		}
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Admin_DeclarationUserDTO admin_DeclarationUserDTO = new Admin_DeclarationUserDTO();
			
			//--�����ǵ��϶�
			if (select.equals("1"))
			{
				admin_DeclarationUserDTO.setNum(rs.getInt("NUM"));
				admin_DeclarationUserDTO.setWrite_User_Id(rs.getString("WRITE_USER_ID"));
				admin_DeclarationUserDTO.setWrite_Cont(rs.getString("WRITE_CONT"));
				admin_DeclarationUserDTO.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
				admin_DeclarationUserDTO.setRepo_Count(rs.getInt("REPO_COUNT"));
				
			
				result.add(admin_DeclarationUserDTO);
			}
			
			//--Ŀ�´�Ƽ �϶�
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

	
	//커뮤니티 Ajax처리
	@Override
	public Admin_DeclarationUserDTO AjaxCommuSearchUser(String userid) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		Admin_DeclarationUserDTO dto = new Admin_DeclarationUserDTO();
		
		String sql =
				" SELECT P.WRITE_SEQ AS WRITE_SEQ ,P.REPO_USER_ID AS REPO_USER_ID,P.REG_DTM AS REG_DTM ,C.COMMUNITY_TITLE AS COMMUNITY_TITLE,P.REPO_REASON AS REPO_REASON"
				+ " ,W.WRITE_CONT AS WRITE_CONT"
				 +" FROM TBL_WRITE W JOIN TBL_COMMUNITY C" 
				 + "   ON W.WRITE_SEQ = C.WRITE_SEQ "
				 + "  JOIN TBL_COMMUNITY_TYPE D "
				 + "  ON C.COMMUNITY_TYPE_CODE=D.COMMUNITY_TYPE_CODE "
				 + " JOIN TBL_POST_REPORT P ON W.WRITE_SEQ=P.WRITE_SEQ "
				 +" JOIN TBL_REPORT_TYPE G ON P.REPO_TYPE_CODE=G.REPO_TYPE_CODE "
				 +"  JOIN TBL_PAGE A  ON W.PAGE_CODE=A.PAGE_CODE "
				 +" WHERE W.PAGE_CODE='C' AND W.WRITE_SEQ=? ";
				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				
				dto.setWrite_Seq(rs.getString("WRITE_SEQ"));
				dto.setRepo_User_Id(rs.getString("REPO_USER_ID"));
				dto.setReg_Dtm(rs.getString("REG_DTM"));
				dto.setCommunity_Title(rs.getString("COMMUNITY_TITLE"));
				dto.setRepo_Reason(rs.getString("REPO_REASON"));
				dto.setWrite_Cont(rs.getString("WRITE_CONT"));
				
			}
				
		return dto;
	}


}
