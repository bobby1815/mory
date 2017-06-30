package com.kh.mory.Dao;
/*===============================================

	화면명 : Admin_LeaveDAO.java
	화면설명 : 탈퇴유예기간  데이터베이스 액션 처리
	최초작성일 : 2017-06-29
	작성자 : 박아영

===============================================*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_LeaveDTO;

import oracle.net.aso.p;

public class Admin_LeaveDAO implements Admin_ILeaveDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	// 탈퇴유예기간 조회
	@Override
	public Admin_LeaveDTO leaveList() throws SQLException
	{
		Admin_LeaveDTO res = new Admin_LeaveDTO();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT LEAVE_SEQ, LEAVE_CODE, LEAVE_NAME FROM TBL_LEAVE";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next())
			{
				res.setLeave_seq(resultSet.getInt("LEAVE_SEQ"));
				res.setLeave_code(resultSet.getString("LEAVE_CODE"));
				res.setLeave_name(resultSet.getString("LEAVE_NAME"));
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
	public int leaveModify(Admin_LeaveDTO dto) throws SQLException
	{
		int res = 0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "UPDATE TBL_LEAVE SET LEAVE_CODE=? ,LEAVE_NAME=? WHERE LEAVE_SEQ=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getLeave_code());
			preparedStatement.setString(2, dto.getLeave_name());
			preparedStatement.setInt(3, dto.getLeave_seq());
			
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
