package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_SanctionTypeDTO;

/*===============================================

	화면명 : Admin_SanctionTypeDAO.java
	화면설명 : 상태설정 데이터베이스 액션 처리
	최초작성일 : 2017-06-29
	작성자 : 박아영

===============================================*/
public class Admin_SanctionTypeDAO implements Admin_ISanctionTypeDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 상태조회
	@Override
	public ArrayList<Admin_SanctionTypeDTO> sanctionTypeList() throws SQLException
	{
		ArrayList<Admin_SanctionTypeDTO> res = new ArrayList<Admin_SanctionTypeDTO>();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT SANC_TYPE_CODE, SANC_TYPE_NAME FROM TBL_SANCTION_TYPE";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Admin_SanctionTypeDTO dto = new Admin_SanctionTypeDTO();
				
				dto.setSanc_type_code(resultSet.getString("SANC_TYPE_CODE"));
				dto.setSanc_type_name(resultSet.getString("SANC_TYPE_NAME"));
				
				res.add(dto);
			}
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}

	// 상태 수정
	@Override
	public int santionTypeModify(Admin_SanctionTypeDTO dto) throws SQLException
	{
		int res = 0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "";
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}

	@Override
	public int sanctionTypeRemove(String sanc_type_code) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
