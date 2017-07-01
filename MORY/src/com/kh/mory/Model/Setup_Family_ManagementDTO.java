package com.kh.mory.Model;

public class Setup_Family_ManagementDTO
{
	// 주요 속성 구성
	private String requ_user_id, mem_rel_code, acce_user_id, requ_reg_dtm;
	private String acce_user_name;
	private int requ_seq;
	
	// getter / setter 구성
	public String getMem_rel_code()
	{
		return mem_rel_code;
	}
	public String getAcce_user_name()
	{
		return acce_user_name;
	}
	public void setAcce_user_name(String acce_user_name)
	{
		this.acce_user_name = acce_user_name;
	}
	public String getRequ_user_id()
	{
		return requ_user_id;
	}
	public void setRequ_user_id(String requ_user_id)
	{
		this.requ_user_id = requ_user_id;
	}
	public void setMem_rel_code(String mem_rel_code)
	{
		this.mem_rel_code = mem_rel_code;
	}
	public String getAcce_user_id()
	{
		return acce_user_id;
	}
	public void setAcce_user_id(String acce_user_id)
	{
		this.acce_user_id = acce_user_id;
	}
	public String getRequ_reg_dtm()
	{
		return requ_reg_dtm;
	}
	public void setRequ_reg_dtm(String requ_reg_dtm)
	{
		this.requ_reg_dtm = requ_reg_dtm;
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
