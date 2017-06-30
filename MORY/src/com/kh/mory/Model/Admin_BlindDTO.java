package com.kh.mory.Model;
/*========================================================

	파일명 : Admin_BlindDTO.java
	파일 설명 : 블라인드 처리 설정 사용자 정의 클래스
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/
public class Admin_BlindDTO
{
	// 주요 속성 구성
	private String setup_seq, page_code; 
	private int decl_cnt;

	// getter / setter 구성
	public String getSetup_seq()
	{
		return setup_seq;
	}
	public void setSetup_seq(String setup_seq)
	{
		this.setup_seq = setup_seq;
	}
	public String getPage_code()
	{
		return page_code;
	}
	public void setPage_code(String page_code)
	{
		this.page_code = page_code;
	}
	public int getDecl_cnt()
	{
		return decl_cnt;
	}
	public void setDecl_cnt(int decl_cnt)
	{
		this.decl_cnt = decl_cnt;
	}

}
