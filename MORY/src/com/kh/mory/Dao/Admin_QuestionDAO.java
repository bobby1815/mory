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


	//1:1문의 값불러오기(검색,아이디,답변여부)
	@Override
	public ArrayList<Admin_QuestionDTO> QueSearch(String term, String select, String id) throws SQLException
	{
		ArrayList<Admin_QuestionDTO> result = new ArrayList<Admin_QuestionDTO>();
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql ="";
		
		
		//--답변여부완료일떄
		if (select.equals("3"))
		{
			sql ="SELECT NUM,QUES_USER_ID,QUES_TITLE,QUES_REG_DTM,CHECKS,ANSW_USER_ID,QUES_CONT,ANSW_CONT"
				+" FROM QUESTIONVIEW "
				+" WHERE QUES_USER_ID LIKE '%%"+id+"%%' AND QUES_REG_DTM LIKE '%%"+term+"%%' AND CHECKS !='미완료' ";
			
		}
		//--답변여부미완료일때
		else if (select.equals("2"))
		{
			sql ="SELECT NUM,QUES_USER_ID,QUES_TITLE,QUES_REG_DTM,CHECKS,ANSW_USER_ID,QUES_CONT,ANSW_CONT"
					+" FROM QUESTIONVIEW "
					+" WHERE QUES_USER_ID LIKE '%%"+id+"%%' AND QUES_REG_DTM LIKE '%%"+term+"%%' AND CHECKS LIKE '%%완료%%' ";
			
		}
		//--전체출력
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
			
			result.add(dto);
			
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return result;
	}

	
	
	//답변 입력
	@Override
	public int addanw()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	//-- 1:1문의 Ajax처리를 위한 사용자검색기능

	@Override
	public Admin_QuestionDTO AjaxSearch(String term, String select, String id) throws SQLException
	{
		Connection conn=dataSource.getConnection();
		
		String sql =String.format(""
				
				
				
				
				
				
				
				);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Admin_QuestionDTO dto = new Admin_QuestionDTO();

			
		}
		
		
		
		return null;
	}
	

}
