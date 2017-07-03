package com.kh.mory.newsfeed;
/*===============================================
	
	파일명 : Newsfeed_INewsfeedDAO.java
	기능 : 인터페이스

 ===============================================*/

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.DiaryDTO.DiaryDTO;

public interface Newsfeed_INewsfeedDAO
{
	public int newsFeedInsert(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO, String uplo_loca);	// 피드 추가
	public ArrayList<Newsfeed_NewsfeedDTO> newsFeedLists(String user_id);	// 피드 조회
	public int newsFeedModify(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO);	// 피드 수정
	public int newsFeedRemove(String write_seq);	// 피드삭제
	// 뉴스피드 댓글 리스트 출력
	public ArrayList<Newsfeed_NewsfeedDTO> commentList(String write_seq) throws SQLException;
	// 뉴스피드 댓글 입력
	public int newsFeedCommentInsert(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException;
	// 뉴스피드 댓글 수정
	public int newsFeedCommentUpdate(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException;
	// 뉴스피드 댓글 삭제
	public int newsFeedCommentDelete(String comment_seq) throws SQLException;
	// 뉴스피드 답글 리스트 출력
	public ArrayList<Newsfeed_NewsfeedDTO> recommentList(String write_seq) throws SQLException;
	// 뉴스피드 답글 입력
	public int newsFeedRecommentInsert(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException;
	// 뉴스피드 답글 수정
	public int newsFeedRecommentUpdate(Newsfeed_NewsfeedDTO newsfeed_newsfeedDto) throws SQLException;
	// 뉴스피드 답글 삭제
	public int newsFeedRecommentDelete(String comment_seq) throws SQLException;
	
	
}
