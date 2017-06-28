package com.kh.mory.newsfeed;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	// 뉴스피드 등록
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
	
	// 뉴스피드 조회
	@Override
	public ArrayList<Newsfeed_NewsfeedDTO> newsFeedLists(String user_id)
	{
		ArrayList<Newsfeed_NewsfeedDTO> res = new ArrayList<Newsfeed_NewsfeedDTO>();
		
		try
		{
			Connection connection = dataSource.getConnection();
			
			String sql = "SELECT"
					+ "        T.WRITE_SEQ"
					+ "        ,T.WRITE_USER_ID"
					+ "        ,U.USER_NIC"
					+ "        ,T.WRITE_CONT"
					+ "        ,T.WRITE_REG_DTM"
					+ "        ,T.FEED_LOVE_CNT"
					+ "        ,T.UPLO_LOCA"
					+ "    FROM"
					+ "    ("
					+ "        SELECT"
					+ "            A.WRITE_SEQ"
					+ "            ,A.WRITE_USER_ID"
					+ "            ,A.PAGE_CODE"
					+ "            ,A.WRITE_CONT"
					+ "            ,A.WRITE_REG_DTM"
					+ "            ,A.FEED_SEQ"
					+ "            ,A.FEED_LOVE_CNT"
					+ "            ,A.UPLO_SEQ"
					+ "            ,A.UPLO_LOCA"
					+ "        FROM"
					+ "        ("
					+ "            ("
					+ "                SELECT"
					+ "                     W.WRITE_SEQ"
					+ "         AS WRITE_SEQ"
					+ "                    , W.WRITE_USER_ID   AS WRITE_USER_ID"
					+ "                    , W.PAGE_CODE       AS PAGE_CODE"
					+ "                    , W.WRITE_CONT      AS WRITE_CONT"
					+ "                    , W.WRITE_REG_DTM   AS WRITE_REG_DTM"
					+ "                      , N.FEED_SEQ        AS FEED_SEQ"
					+ "                    , N.FEED_LOVE_CNT   AS FEED_LOVE_CNT"
					+ "                    , U.UPLO_SEQ        AS UPLO_SEQ"
					+ "                     , U.UPLO_LOCA       AS UPLO_LOCA"
					+ "                FROM TBL_WRITE W JOIN TBL_NEWSFEED N"
					+ "                ON W.WRITE_SEQ = N.FEED_SEQ"
					+ "                JOIN TBL_UPLOAD_FILE U"
					+ "                ON W.WRITE_SEQ = U.WRITE_SEQ"
					+ "                WHERE W.WRITE_USER_ID IN (SELECT NEI_USER_ID FROM TBL_NEIGHBOR WHERE USER_ID=?)"
					+ "                AND W.PAGE_CODE = 'N'"
					+ "            )"
					+ "            UNION ALL"
					+ "            ("
					+ "                SELECT"
					+ "                     W.WRITE_SEQ         AS WRITE_SEQ"
					+ "                    , W.WRITE_USER_ID   AS WRITE_USER_ID"
					+ "                    , W.PAGE_CODE       AS PAGE_CODE"
					+ "                    , W.WRITE_CONT      AS WRITE_CONT"
					+ "                    , W.WRITE_REG_DTM   AS WRITE_REG_DTM"
					+ "                      , N.FEED_SEQ        AS FEED_SEQ"
					+ "                    , N.FEED_LOVE_CNT   AS FEED_LOVE_CNT"
					+ "                    , U.UPLO_SEQ        AS UPLO_SEQ"
					+ "                       , U.UPLO_LOCA       AS UPLO_LOCA"
					+ "                FROM TBL_WRITE W JOIN TBL_NEWSFEED N"
					+ "                ON W.WRITE_SEQ = N.FEED_SEQ"
					+ "                JOIN TBL_UPLOAD_FILE U"
					+ "                ON W.WRITE_SEQ = U.WRITE_SEQ"
					+ "                WHERE W.WRITE_USER_ID =?"
					+ "                AND W.PAGE_CODE = 'N'"
					+ "            )"
					+ "        ) A"
					+ "    )T JOIN TBL_USER U"
					+ "    ON T.WRITE_USER_ID = U.USER_ID"
					+ "    ORDER BY T.WRITE_REG_DTM DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				Newsfeed_NewsfeedDTO dto = new Newsfeed_NewsfeedDTO();
				dto.setWrite_seq(resultSet.getString("WRITE_SEQ"));
				dto.setWrite_user_id(resultSet.getString("WRITE_USER_ID"));
				dto.setUser_nic(resultSet.getString("USER_NIC"));
				dto.setWrite_cont(resultSet.getString("WRITE_CONT"));
				dto.setWrite_reg_dtm(resultSet.getString("WRITE_REG_DTM"));
				dto.setFeed_love_cnt(resultSet.getString("FEED_LOVE_CNT"));
				dto.setUplo_loca(resultSet.getString("UPLO_LOCA"));
				
				res.add(dto);
			}
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return res;
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
