package com.kh.mory.Model;
/*========================================================

	파일명 : Admin_BlindSanctionDTO.java
	파일 설명 : 블라인드 처리 수에 따른 계정상태 사용자 정의 클래스
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/
public class Admin_BlindSanctionDTO
{
	private String  sanc_type_code, sanc_type_name;
	private int blind_sanc_seq,blind_cnt;
	
	// getter / setter 구성
	public String getSanc_type_code()
	{
		return sanc_type_code;
	}
	public void setSanc_type_code(String sanc_type_code)
	{
		this.sanc_type_code = sanc_type_code;
	}
	public int getBlind_cnt()
	{
		return blind_cnt;
	}
	public void setBlind_cnt(int blind_cnt)
	{
		this.blind_cnt = blind_cnt;
	}
	public int getBlind_sanc_seq()
	{
		return blind_sanc_seq;
	}
	public void setBlind_sanc_seq(int blind_sanc_seq)
	{
		this.blind_sanc_seq = blind_sanc_seq;
	}
	public String getSanc_type_name()
	{
		return sanc_type_name;
	}
	public void setSanc_type_name(String sanc_type_name)
	{
		this.sanc_type_name = sanc_type_name;
	}
}
