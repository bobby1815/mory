package com.kh.mory.newsfeed;
/*===============================================
	
	파일명 : Newsfeed_INewsfeedDAO.java
	기능 : 인터페이스

 ===============================================*/

import java.util.ArrayList;

public interface Newsfeed_INewsfeedDAO
{
	public int newsFeedInsert(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO, String uplo_loca);	// 피드 추가
	public ArrayList<Newsfeed_NewsfeedDTO> newsFeedLists(String user_id);	// 피드 조회
	public int newsFeedModify(Newsfeed_NewsfeedDTO newsfeed_NewsfeedDTO);	// 피드 수정
	public int newsFeedRemove(String write_seq);	// 피드삭제
	
}
