package com.kh.mory.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;


public class Main_PwquestionDAO	implements Main_IPwquestionDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 비밀번호 찾기 질문
	@Override
	public ArrayList<Main_PwquestionDTO> pwquLists() throws SQLException
	{
		ArrayList<Main_PwquestionDTO> res = new ArrayList<Main_PwquestionDTO>();
		
		try
		{
			Connection connection = dataSource.getConnection();
			
			String sql = "SELECT PWQU_CODE, PWQU_NAME FROM TBL_PWQUESTION";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Main_PwquestionDTO dto = new Main_PwquestionDTO();
				dto.setPwqu_code(resultSet.getString("PWQU_CODE"));
				dto.setPwqu_name(resultSet.getString("PWQU_NAME"));
				
				res.add(dto);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}
}
