package com.kh.mory.Model;

public class Setup_Realation_ManagementDTO
{
	private String user_id,user_nic,profile_location,basic_addr,nei_user_id, nei_reg_dtm ;
	private int nei_seq;
	// NEI_SEQ, USER_ID, NEI_USER_ID, NEI_REG_DTM
	
	
	
	public String getProfile_location()
	{
		return profile_location;
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

	public int getNei_seq()
	{
		return nei_seq;
	}

	public void setNei_seq(int nei_seq)
	{
		this.nei_seq = nei_seq;
	}

	public void setProfile_location(String profile_location)
	{
		this.profile_location = profile_location;
	}

	public String getBasic_addr()
	{
		return basic_addr;
	}

	public void setBasic_addr(String basic_addr)
	{
		this.basic_addr = basic_addr;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getUser_nic()
	{
		return user_nic;
	}

	public void setUser_nic(String user_nic)
	{
		this.user_nic = user_nic;
	}


}
