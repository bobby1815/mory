package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_QuestionDTO;

public class Admin_QuestionDAO implements Admin_IQuestionDAO
{
	
	private DataSource dataSource;
	

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}


	//1:1���� ���ҷ�����(�˻�,���̵�,�亯����)
	@Override
	public ArrayList<Admin_QuestionDTO> QueSearch(String term, String select, String id) throws SQLException
	{
		ArrayList<Admin_QuestionDTO> result = new ArrayList<Admin_QuestionDTO>();
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql ="";
		
		
		//--�亯���οϷ��ϋ�
		if (select.equals("3"))
		{
			sql ="SELECT NUM,QUES_USER_ID,QUES_TITLE,QUES_REG_DTM,CHECKS,ANSW_USER_ID,QUES_CONT,ANSW_CONT"
				+" FROM QUESTIONVIEW "
				+" WHERE QUES_USER_ID LIKE '%%"+id+"%%' AND QUES_REG_DTM LIKE '%%"+term+"%%' AND CHECKS !='�̿Ϸ�' ";
			
		}
		//--�亯���ι̿Ϸ��϶�
		else if (select.equals("2"))
		{
			sql ="SELECT NUM,QUES_USER_ID,QUES_TITLE,QUES_REG_DTM,CHECKS,ANSW_USER_ID,QUES_CONT,ANSW_CONT"
					+" FROM QUESTIONVIEW "
					+" WHERE QUES_USER_ID LIKE '%%"+id+"%%' AND QUES_REG_DTM LIKE '%%"+term+"%%' AND CHECKS LIKE '%%�Ϸ�%%' ";
			
		}
		//--��ü���
		else if (select.equals("1"))
		{
			sql = "SELECT NUM,QUES_USER_ID,QUES_TITLE,QUES_REG_DTM,CHECKS,ANSW_USER_ID,QUES_CONT,ANSW_CONT "
			+" FROM QUESTIONVIEW "
			+" WHERE QUES_USER_ID LIKE '%%"+id+"%%' AND QUES_REG_DTM LIKE '%%"+term+"%%' ";
			
		}
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Admin_QuestionDTO dto = new Admin_QuestionDTO();
			dto.setNum(rs.getInt("NUM"));
			dto.setQues_User_Id(rs.getString("QUES_USER_ID"));
			dto.setQues_Title(rs.getString("QUES_TITLE"));
			dto.setQues_Reg_Dtm(rs.getString("QUES_REG_DTM"));
			dto.setChecks(rs.getString("CHECKS"));
			dto.setAnsw_User_Id(rs.getString("ANSW_USER_ID"));
			dto.setQues_Cont(rs.getString("QUES_CONT"));
			dto.setAnsw_Cont(rs.getString("ANSW_CONT"));
			
			result.add(dto);
			
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return result;
	}

	
	
	//�亯 �Է�
	@Override
	public int addanw(Admin_QuestionDTO dto) throws SQLException
	{
		int result =0;
		Connection conn =dataSource.getConnection();
		String sql = " INSERT INTO TBL_ANSWERS (QUES_SEQ,ANSW_USER_ID,ANSW_CONT,ANSW_REG_DTM) "
				+ " VALUES(?,?,?,SYSDATE)";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(2,dto.getAnsw_User_Id());
		pstmt.setString(1,dto.getSeq());
		pstmt.setString(3,dto.getAnsw_Cont());
		result = pstmt.executeUpdate();
		System.out.println(sql);
		
		
		
		System.out.println(result);
		return result;
	}

	
	//--���̵�޾� �ش� ����Ʈ ��ȸ
	@Override
	public Admin_QuestionDTO AjaxSearch(String id) throws SQLException
	{

		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql ="SELECT NUM,QUES_SEQ,QUES_USER_ID,QUES_TITLE,TO_DATE(QUES_REG_DTM,'YY-MM-DD')AS QUES_REG_DTM,CHECKS,ANSW_USER_ID,QUES_CONT,ANSW_CONT "
					+" FROM QUESTIONVIEW WHERE QUES_USER_ID ='"+id+"' ";
		System.out.println(sql);	
		ResultSet rs =  stmt.executeQuery(sql);
		Admin_QuestionDTO dto = new Admin_QuestionDTO();
		while (rs.next())
		{
			dto.setNum(rs.getInt("NUM"));
			dto.setSeq(rs.getString("QUES_SEQ"));
			dto.setQues_User_Id(rs.getString("QUES_USER_ID"));
			dto.setQues_Title(rs.getString("QUES_TITLE"));
			dto.setQues_Reg_Dtm(rs.getString("QUES_REG_DTM"));
			dto.setChecks(rs.getString("CHECKS"));
			dto.setAnsw_User_Id(rs.getString("ANSW_USER_ID"));
			dto.setQues_Cont(rs.getString("QUES_CONT"));
			dto.setAnsw_Cont(rs.getString("ANSW_CONT"));
			
		}
		rs.close();
		stmt.close();
		conn.close();
		
		return dto;
	}
	

}
