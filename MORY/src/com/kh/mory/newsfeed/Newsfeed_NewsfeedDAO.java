package com.kh.mory.newsfeed;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;

import javax.sql.DataSource;

/*===============================================

	화면명 : Newsfeed_INewsfeedDAO.java
	화면설명 : 데이터베이스 액션 처리

===============================================*/

public class Newsfeed_NewsfeedDAO implements Newsfeed_INewsfeedDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public int newsFeedInsert(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO, String uplo_loca)
	{
		int res = 0;

		try
		{
			Connection connection = dataSource.getConnection();
		
			String sql = "{call PROC_NEWSFEED_INSERT(?, ?)}";
			
			CallableStatement callableStatement = connection.prepareCall(sql);
			
			callableStatement.setString(1, newsfeed_NewsfeedDTO.getWrite_user_id());
			callableStatement.setString(2, uplo_loca);
			
			res = callableStatement.executeUpdate();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return res;
	}

	@Override
	public ArrayList<Newsfeed_NewsfeedDTO> newsFeedLists(String user_id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newsFeedModify(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newsFeedRemove(String write_seq)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
