package com.kh.mory.Model;
/*===================================================
	파일명 : Admin_CommunityDTO.java
	기능 : 커뮤니티 관리를 위한 사용자정의 자료형 클래스
	최초작성일 : 2017-06-26
	작성자 : 박아영 
 ===================================================*/

public class Admin_CommunityDTO
{
	// 주요 속성 구성
	private String community_type_code, community_type_name;
	private int num;

	// getter / setter 구성
	
	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public String getCommunity_type_code()
	{
		return community_type_code;
	}

	public void setCommunity_type_code(String community_type_code)
	{
		this.community_type_code = community_type_code;
	}

	public String getCommunity_type_name()
	{
		return community_type_name;
	}

	public void setCommunity_type_name(String community_type_name)
	{
		this.community_type_name = community_type_name;
	}
}
