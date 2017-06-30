package com.kh.mory;

public class CommunityDTO 
{
	 
		private	int community_type_code, community_love_cnt, community_hits; // 작성번호 , 커뮤니티 유형코드 , 사랑해요 수 , 조회수
		private String write_user_id , page_code 
		, write_cont, write_reg_dtm , community_title, community_type_name;    // 사용자 ID ,페이지구분코드, 작성내용, 작성일시,제목, 커뮤니티유형명
		private int uplo_seq;  //첨부파일 번호
		private String uplo_loca ,write_seq  ;// 파일경로
	
		
		
		
		
		public int getCommunity_type_code() {
			return community_type_code;
		}
		public void setCommunity_type_code(int community_type_code) {
			this.community_type_code = community_type_code;
		}
		public int getCommunity_love_cnt() {
			return community_love_cnt;
		}
		public void setCommunity_love_cnt(int community_love_cnt) {
			this.community_love_cnt = community_love_cnt;
		}
		public int getCommunity_hits() {
			return community_hits;
		}
		public void setCommunity_hits(int community_hits) {
			this.community_hits = community_hits;
		}
		public String getWrite_user_id() {
			return write_user_id;
		}
		public void setWrite_user_id(String write_user_id) {
			this.write_user_id = write_user_id;
		}
		public String getPage_code() {
			return page_code;
		}
		public void setPage_code(String page_code) {
			this.page_code = page_code;
		}
		public String getWrite_cont() {
			return write_cont;
		}
		public void setWrite_cont(String write_cont) {
			this.write_cont = write_cont;
		}
		public String getWrite_reg_dtm() {
			return write_reg_dtm;
		}
		public void setWrite_reg_dtm(String write_reg_dtm) {
			this.write_reg_dtm = write_reg_dtm;
		}
		public String getCommunity_title() {
			return community_title;
		}
		public void setCommunity_title(String community_title) {
			this.community_title = community_title;
		}
		public String getCommunity_type_name() {
			return community_type_name;
		}
		public void setCommunity_type_name(String community_type_name) {
			this.community_type_name = community_type_name;
		}
		public int getUplo_seq() {
			return uplo_seq;
		}
		public void setUplo_seq(int uplo_seq) {
			this.uplo_seq = uplo_seq;
		}
		public String getUplo_loca() {
			return uplo_loca;
		}
		public void setUplo_loca(String uplo_loca) {
			this.uplo_loca = uplo_loca;
		}
		public String getWrite_seq() {
			return write_seq;
		}
		public void setWrite_seq(String write_seq) {
			this.write_seq = write_seq;
		}
		
	
	
		
		
		
	
		
		
		
		
		
}
