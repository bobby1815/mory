package com.kh.mory.Model;
/*========================================================

	파일명 : Admin_SanctionTypeDTO.java
	파일 설명 : 계정상태 사용자 정의 클래스
	최초작성일 : 2017-06-29
	작성자 : 박아영

========================================================*/
public class Admin_SanctionTypeDTO
{
	// 주요 속성 구성
	private String sanc_type_code, sanc_type_name;
	private int sanc_blind_cnt;

	// getter / setter 구성
	public String getSanc_type_code()
	{
		return sanc_type_code;
	}

	public void setSanc_type_code(String sanc_type_code)
	{
		this.sanc_type_code = sanc_type_code;
	}

	public String getSanc_type_name()
	{
		return sanc_type_name;
	}

	public void setSanc_type_name(String sanc_type_name)
	{
		this.sanc_type_name = sanc_type_name;
	}
	
	public int getSanc_blind_cnt()
	{
		return sanc_blind_cnt;
	}

	public void setSanc_blind_cnt(int sanc_blind_cnt)
	{
		this.sanc_blind_cnt = sanc_blind_cnt;
	}
	
}
