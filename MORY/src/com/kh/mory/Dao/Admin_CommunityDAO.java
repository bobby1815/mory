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
	public Admin_CommunityDTO searchList(String community_type_code)
	{
		Admin_CommunityDTO res = new Admin_CommunityDTO();
		
		try
		{
			Connection connection = dataSource.getConnection();
			
			String sql = "SELECT COMMUNITY_TYPE_CODE, COMMUNITY_TYPE_NAME FROM TBL_COMMUNITY_TYPE WHERE COMMUNITY_TYPE_CODE = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next())
			{
				res.setCommunity_type_code(resultSet.getString("COMMUNITY_TYPE_CODE"));
				res.setCommunity_type_name(resultSet.getString("COMMUNITY_TYPE_NAME"));
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

	// 커뮤니티 이름 수정
	@Override
	public int modify(Admin_CommunityDTO dto)
	{
		int res = 0;
		
		try
		{
			Connection connection = dataSource.getConnection();
			
			String sql = "UPDATE TBL_COMMUNITY_TYPE SET COMMUNITY_TYPE_NAME = ? WHERE COMMUNITY_TYPE_CODE = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getCommunity_type_name());
			preparedStatement.setString(2, dto.getCommunity_type_name());
			
			res = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	// 커뮤니티 삭제
	@Override
	public int delete(String community_type_code)
	{
		int res = 0;
		
		try
		{
			Connection connection = dataSource.getConnection();
			
			String sql = "DELETE FROM TBL_COMMUNITY_TYPE WHERE COMMUNITY_TYPE_CODE = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, community_type_code);
			
			res = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

}
