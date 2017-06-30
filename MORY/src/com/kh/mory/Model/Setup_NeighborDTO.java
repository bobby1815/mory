package com.kh.mory.Model;

/*===============================================
	화면명 : Setup_NeighborDTO.java
	화면설명 : 이웃기웃 사용자 정의 자료형 클래스
	최초작성일 : 2017-06-30
	작성자 : 박아영
 ===============================================*/

public class Setup_NeighborDTO
{
	// 주요 속성 구성
	private int nei_seq;
	private String user_id, nei_user_id, nei_reg_dtm;

	// getter / setter 구성
	public int getNei_seq()
	{
		return nei_seq;
	}
	public void setNei_seq(int nei_seq)
	{
		this.nei_seq = nei_seq;
	}
	public String getUser_id()
	{
		return user_id;
	}
	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}
	public String getNei_user_id()
	{
		return nei_user_id;
	}
	public void setNei_user_id(String nei_user_id)
	{
		this.nei_user_id = nei_user_id;
	}
	public String getNei_reg_dtm()
	{
		return nei_reg_dtm;
	}
	public void setNei_reg_dtm(String nei_reg_dtm)
	{
		this.nei_reg_dtm = nei_reg_dtm;
	}
}
