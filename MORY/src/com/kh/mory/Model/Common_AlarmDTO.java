package com.kh.mory.Model;
/*======================================================

	화면명 : Common_AlarmDTO.java
	화면 설명 : 공통 알람 사용자정의 클래스
	최초작성일 : 2017-07-03
	작성자 : 박아영

 ======================================================*/
public class Common_AlarmDTO
{
	// 주요 변수 선언
	private String requ_user_id, acce_user_id, mem_rel_code, mem_rel_name, result_yn, requ_user_nic;
	private String share_diary_name;
	private int requ_seq;
	
	// getter / setter 구성
	public String getRequ_user_id()
	{
		return requ_user_id;
	}
	public void setRequ_user_id(String requ_user_id)
	{
		this.requ_user_id = requ_user_id;
	}
	public String getAcce_user_id()
	{
		return acce_user_id;
	}
	public void setAcce_user_id(String acce_user_id)
	{
		this.acce_user_id = acce_user_id;
	}
	public String getMem_rel_code()
	{
		return mem_rel_code;
	}
	public void setMem_rel_code(String mem_rel_code)
	{
		this.mem_rel_code = mem_rel_code;
	}
	public String getMem_rel_name()
	{
		return mem_rel_name;
	}
	public void setMem_rel_name(String mem_rel_name)
	{
		this.mem_rel_name = mem_rel_name;
	}
	public String getResult_yn()
	{
		return result_yn;
	}
	public void setResult_yn(String result_yn)
	{
		this.result_yn = result_yn;
	}
	public String getRequ_user_nic()
	{
		return requ_user_nic;
	}
	public void setRequ_user_nic(String requ_user_nic)
	{
		this.requ_user_nic = requ_user_nic;
	}
	public String getShare_diary_name()
	{
		return share_diary_name;
	}
	public void setShare_diary_name(String share_diary_name)
	{
		this.share_diary_name = share_diary_name;
	}
	public int getRequ_seq()
	{
		return requ_seq;
	}
	public void setRequ_seq(int requ_seq)
	{
		this.requ_seq = requ_seq;
	}
	
	
}
