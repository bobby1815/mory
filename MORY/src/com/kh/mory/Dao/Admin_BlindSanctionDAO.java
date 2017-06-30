package com.kh.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kh.mory.Model.Admin_BlindSanctionDTO;
/*===============================================

	화면명 : Admin_BlindSanctionDAO.java
	화면설명 : 블라인드 처리 횟수에 따른 계정상태 설정 데이터베이스 액션 처리
	최초작성일 : 2017-06-29
	작성자 : 박아영

===============================================*/
public class Admin_BlindSanctionDAO implements Admin_IBlindSanctionDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Admin_BlindSanctionDTO> blindSanctionList() throws SQLException
	{
		ArrayList<Admin_BlindSanctionDTO> res = new ArrayList<Admin_BlindSanctionDTO>();
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "SELECT"
					+ "    BS.BLIND_SANC_SEQ   AS BLIND_SANC_SEQ"
					+ "    ,BS.SANC_TYPE_CODE  AS SANC_TYPE_CODE"
					+ "    ,T.SANC_TYPE_NAME   AS SANC_TYPE_NAME"
					+ "    ,BS.BLIND_CNT   AS BLIND_CNT"
					+ " FROM TBL_BLIND_SANCTION BS JOIN TBL_SANCTION_TYPE T"
					+ " ON BS.SANC_TYPE_CODE = T.SANC_TYPE_CODE";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Admin_BlindSanctionDTO dto = new Admin_BlindSanctionDTO();
				dto.setBlind_sanc_seq(resultSet.getInt("BLIND_SANC_SEQ"));
				dto.setSanc_type_code(resultSet.getString("SANC_TYPE_CODE"));
				dto.setSanc_type_name(resultSet.getString("SANC_TYPE_NAME"));
				dto.setBlind_cnt(resultSet.getInt("BLIND_CNT"));
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
	public int blindSanctionModify(Admin_BlindSanctionDTO dto) throws SQLException
	{
		int res=0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "UPDATE TBL_BLIND_SANCTION SET SANC_TYPE_CODE = ? ,BLIND_CNT= ? WHERE BLIND_SANC_SEQ = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getSanc_type_code());
			preparedStatement.setInt(2, dto.getBlind_cnt());
			preparedStatement.setInt(3, dto.getBlind_sanc_seq());
			
			res = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
	}

	@Override
	public int blindSanctionRemove(int blind_sanc_seq) throws SQLException
	{
		int res = 0;
		
		Connection connection = dataSource.getConnection();
		
		try
		{
			String sql = "DELETE FROM TBL_BLIND_SANCTION WHERE BLIND_SANC_SEQ = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
