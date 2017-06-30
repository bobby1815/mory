package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_BlindDTO;

/*===============================================

	화면명 : Newsfeed_INewsfeedDAO.java
	화면설명 : 블라인드 처리 데이터베이스 액션 처리
	최초작성일 : 2017-06-29
	작성자 : 박아영

===============================================*/
public class Admin_BlindSetupDAO implements Admin_IBlindSetupDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 블라인드 처리 설정 리스트 조회
	@Override
	public ArrayList<Admin_BlindDTO> blindSetuplists() throws SQLException
	{
		ArrayList<Admin_BlindDTO> res = new ArrayList<Admin_BlindDTO>();
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT SETUP_SEQ, PAGE_CODE, DECL_CNT FROM TBL_BLIND_SETUP";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Admin_BlindDTO dto = new Admin_BlindDTO();
				dto.setSetup_seq(resultSet.getString("SETUP_SEQ"));
				dto.setPage_code(resultSet.getString("PAGE_CODE"));
				dto.setDecl_cnt(resultSet.getInt("DECL_CNT"));
				
				res.add(dto);
			}
			// 리소스 반납
			resultSet.close();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	// 블라인드 처리 갯수 수정
	@Override
	public int BlindSetupModify(Admin_BlindDTO dto) throws SQLException
	{
		int res = 0;
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "UPDATE TBL_BLIND_SETUP SET DECL_CNT = ? WHERE SETUP_SEQ = ? AND PAGE_CODE = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, dto.getDecl_cnt());
			preparedStatement.setString(2, dto.getSetup_seq());
			preparedStatement.setString(3, dto.getPage_code());
			
			res = preparedStatement.executeUpdate();
			
			// 리소스 반납
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}
	
}
