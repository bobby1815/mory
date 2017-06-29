package com.kh.mory;

import java.sql.SQLException;

/*
private	int community_type_code, community_love_cnt, community_hits; // 작성번호 , 커뮤니티 유형코드 , 사랑해요 수 , 조회수
private String write_user_id , page_code 
, write_cont, write_reg_dtm , community_title, community_type_name;    // 사용자 ID ,페이지구분코드, 작성내용, 작성일시,제목, 커뮤니티유형명
private int uplo_seq;  //첨부파일 번호
private String uplo_loca ,write_seq  ;// 파일경로
*/
public class UnitTest 
{
	public static void main(String[] args) throws SQLException 
	{
		CommunityDTO dto = new CommunityDTO();
		dto.setCommunity_title("커뮤니티");
		dto.setCommunity_type_code(30);
		dto.setWrite_user_id("jin10");
		dto.setWrite_cont("안녕하세요");
		
		CommunityDAO dao = new CommunityDAO();
		
		int result = 0;
				
		result = dao.add(dto);
		
		System.out.println(result);
		
	}

}
