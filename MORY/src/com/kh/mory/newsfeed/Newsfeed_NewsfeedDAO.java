package com.kh.mory.newsfeed;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

/*===============================================

	화면명 : Newsfeed_INewsfeedDAO.java
	화면설명 : 데이터베이스 액션 처리
	작성자 : 박아영

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
			System.out.println("newsfeed_NewsfeedDTO.getWrite_cont()) : "+ newsfeed_NewsfeedDTO.getWrite_cont());
			callableStatement.setString(1, newsfeed_NewsfeedDTO.getWrite_user_id());
			//callableStatement.setString(2, newsfeed_NewsfeedDTO.getWrite_cont());
			callableStatement.setString(2, uplo_loca);
			
			res = callableStatement.executeUpdate();
			
			callableStatement.close();
			connection.close();
			
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

	// 뉴스피드 수정
	@Override
	public int newsFeedModify(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	// 뉴스피드 삭제
	@Override
	public int newsFeedRemove(String write_seq)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	// 뉴스피드 댓글 입력
	@Override
	public int newsFeedCommentInsert(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "INSERT INTO TBL_COMMENT"
				+ " (COMMENT_SEQ, WRITE_SEQ, COMMENT_CONT"
				+ ", COMMENT_REG_DTM, USER_ID)"
				+ " VALUES (SEQ_COMMENT.NEXTVAL, TO_CHAR(?), ?, SYSDATE, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		try
		{
			preparedStatement.setString(1, newsfeed_newsfeedDto.getWrite_seq());
			preparedStatement.setString(2, newsfeed_newsfeedDto.getComment_cont());
			preparedStatement.setString(3, newsfeed_newsfeedDto.getUser_id());

			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// 뉴스피드 댓글 수정
	@Override
	public int newsFeedCommentUpdate(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		System.out.println( newsfeed_newsfeedDto.getComment_cont());
		System.out.println( newsfeed_newsfeedDto.getComment_seq());
		
		String sql = "UPDATE TBL_COMMENT SET COMMENT_CONT = ? WHERE COMMENT_SEQ = ?";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, newsfeed_newsfeedDto.getComment_cont());
			preparedStatement.setString(2, newsfeed_newsfeedDto.getComment_seq());
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// 뉴스피드 댓글 삭제
	@Override
	public int newsFeedCommentDelete(String comment_seq) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "{CALL DELETE_COMMENT(?)}";

		try
		{
			CallableStatement callableStatement = connection.prepareCall(sql);

			callableStatement.setString(1, comment_seq);

			result = callableStatement.executeUpdate();
			callableStatement.close();
			connection.close();

		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// 뉴스피드 답글 입력
	@Override
	public int newsFeedRecommentInsert(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "INSERT INTO TBL_RECOMMENT"
				+ " (RECO_SEQ, COMMENT_SEQ, RECO_CONT, RECO_REG_DTM, USER_ID)"
				+ " VALUES(?, ?, ?, SYSDATE, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		try
		{
			preparedStatement.setString(1, newsfeed_newsfeedDto.getRecomment_seq());
			preparedStatement.setString(2, newsfeed_newsfeedDto.getRecomment_cont());
			preparedStatement.setString(3, newsfeed_newsfeedDto.getRecomment_cont());
			preparedStatement.setString(4, newsfeed_newsfeedDto.getUser_id());
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		return result;
	}

	// 뉴스피드 답글 수정
	@Override
	public int newsFeedRecommentUpdate(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "UPDATE TBL_RECOMMENT"
				+ " SET RECO_CONT = ? WHERE RECO_SEQ = ?";
		System.out.println(newsfeed_newsfeedDto.getRecomment_cont());
		System.out.println(newsfeed_newsfeedDto.getRecomment_seq());
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newsfeed_newsfeedDto.getRecomment_cont());
			
			preparedStatement.setString(2, newsfeed_newsfeedDto.getRecomment_seq());
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	// 뉴스피드 답글 삭제
	@Override
	public int newsFeedRecommentDelete(String reco_seq) throws SQLException
	{
		int result = 0;

		Connection connection = dataSource.getConnection();

		String sql = "DELETE FROM TBL_RECOMMENT WHERE RECO_SEQ = ? ";

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, reco_seq);
			
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}

	// 뉴스피드 댓글 리스트 출력
	@Override
	public ArrayList<Newsfeed_NewsfeedDTO> commentList(String write_seq) throws SQLException
	{
		ArrayList<Newsfeed_NewsfeedDTO> result = new ArrayList<Newsfeed_NewsfeedDTO>();

		Connection connection = dataSource.getConnection();

		String sql = "SELECT A.COMMENT_SEQ AS COMMENT_SEQ, A.WRITE_SEQ AS WRITE_SEQ , "
				+ " A.COMMENT_CONT AS COMMENT_CONT , SUBSTR(TO_CHAR(A.COMMENT_REG_DTM),0,10) AS COMMENT_REG_DTM, "
				+ " B.USER_NIC AS USER_NIC , B.USER_ID AS USER_ID "
				+ " FROM TBL_COMMENT A, TBL_USER B "
				+ " WHERE A.USER_ID = B.USER_ID "
				+ " AND A.WRITE_SEQ = ? "
				+ " ORDER BY COMMENT_SEQ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, write_seq);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next())
		{
			Newsfeed_NewsfeedDTO newsfeed = new Newsfeed_NewsfeedDTO();
			newsfeed.setWrite_seq(resultSet.getString("WRITE_SEQ"));
			newsfeed.setComment_seq(resultSet.getString("COMMENT_SEQ"));
			String cont = resultSet.getString("COMMENT_CONT");
			cont = cont.replaceAll("\\\\n", "<br>");
			newsfeed.setUser_id(resultSet.getString("USER_ID"));
			newsfeed.setComment_cont(cont);
			newsfeed.setComment_reg_dtm(resultSet.getString("COMMENT_REG_DTM"));
			newsfeed.setUser_nic(resultSet.getString("USER_NIC"));
			result.add(newsfeed);

		}
		connection.close();
		preparedStatement.close();
		resultSet.close();

		return result;
	}

	// 뉴스피드 답글 리스트 출력
	@Override
	public ArrayList<Newsfeed_NewsfeedDTO> recommentList(String write_seq) throws SQLException
	{
		ArrayList<Newsfeed_NewsfeedDTO> result = new ArrayList<Newsfeed_NewsfeedDTO>();

		Connection connection = dataSource.getConnection();

		String sql = "SELECT  A.RECO_SEQ AS RECO_SEQ , A.RECO_CONT AS RECO_CONT , A.USER_ID AS USER_ID, "
				+ "SUBSTR(TO_CHAR(A.RECO_REG_DTM),0,10) AS RECO_REG_DTM , A.COMMENT_SEQ AS COMMENT_SEQ , C.USER_NIC AS USER_NIC ,C.USER_ID AS USER_ID "
				+ " FROM TBL_RECOMMENT A , TBL_COMMENT B , TBL_USER C"
				+ " WHERE A.COMMENT_SEQ = B.COMMENT_SEQ "
				+ "AND A.USER_ID = C.USER_ID "
				+ "AND B.WRITE_SEQ = ?"
				+ " ORDER BY A.RECO_SEQ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, write_seq);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next())
		{
			Newsfeed_NewsfeedDTO newsfeed = new Newsfeed_NewsfeedDTO();
			newsfeed.setRecomment_seq(resultSet.getString("RECO_SEQ"));
			newsfeed.setRecomment_cont(resultSet.getString("RECO_CONT").replaceAll("\\\\n", "<BR>"));
			newsfeed.setRequ_user_id(resultSet.getString("USER_ID"));
			
			newsfeed.setRecomment_reg_dtm(resultSet.getString("RECO_REG_DTM"));

			newsfeed.setUser_id(resultSet.getString("USER_ID"));
			newsfeed.setComment_seq(resultSet.getString("COMMENT_SEQ"));
			
			newsfeed.setUser_nic(resultSet.getString("USER_NIC"));
			
			
			result.add(newsfeed);
		}
		connection.close();
		preparedStatement.close();
		resultSet.close();

		return result;
	}
	
	
	
}
