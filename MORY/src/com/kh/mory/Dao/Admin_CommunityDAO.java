package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_CommunityDTO;

/*===================================================
	파일명 : Admin_CommunityDTO.java
	기능 : 커뮤니티 관리를 위한 DAO
	최초작성일 : 2017-06-26
	작성자 : 박아영 
===================================================*/
public class Admin_CommunityDAO	implements Admin_ICommunityDAO
{
	//데이터 소스
	private DataSource dataSource;
	
	// setter 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	// 커뮤니티 리스트 조회
	@Override
	public ArrayList<Admin_CommunityDTO> lists()
	{
		ArrayList<Admin_CommunityDTO> res = new ArrayList<Admin_CommunityDTO>();
		
		try
		{
			Connection connection = dataSource.getConnection();
			
			String sql = "SELECT ROWNUM AS NUM, COMMUNITY_TYPE_CODE, COMMUNITY_TYPE_NAME FROM TBL_COMMUNITY_TYPE";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Admin_CommunityDTO dto = new Admin_CommunityDTO();
				dto.setNum(resultSet.getInt("NUM"));
				dto.setCommunity_type_code(resultSet.getString("COMMUNITY_TYPE_CODE"));
				dto.setCommunity_type_name(resultSet.getString("COMMUNITY_TYPE_NAME"));
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

	@Override
	public int modify()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
