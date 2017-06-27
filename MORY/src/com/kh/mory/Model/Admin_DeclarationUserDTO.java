package com.kh.mory.Model;

public class Admin_DeclarationUserDTO
{//TBL_USER
	private String user_Id;					//유저아이디
	
	
	//TBL_작성내용 변수---------------------------------------------------------------------
	private String write_Seq;
	private String write_User_Id;
	private String page_Code;
	private String write_Cont;
	private String write_Reg_Dtm;
	
	
	//TBL_뉴스피드---------------------------------------------------------------------
	private String peed_Seq;
	private String peed_Love_Cnt;
	
	
	//TBL_커뮤니티---------------------------------------------------------------------
	private String community_Type_Code;
	private String community_Title;
	private String community_Love_Cnt;
	private String community_Hits;
	
	//TBL_커뮤니티 유형 구분---------------------------------------------------------------------
	
	private String community_Type_Name;
	
	//TBL_블라인드 게시글---------------------------------------------------------------------
	private String blind_Seq;
	private String blind_Code;
	private String blind_Reg_Dtm;
	
	//TBL_블라인드 사유코드구분--------------------------------------------------------------------
	private String blind_Name;
	
	//TBL_게시물 신고--------------------------------------------------------------------
	private String repo_Seq;
	private String repo_Type_Code;
	private String repo_User_Id;
	private String repo_Reason;
	private String reg_Dtm;
	private String repo_Count;
	
	//TBL_신고 유형 구분--------------------------------------------------------------------
	private String repo_Type_Name;

	
	
	
	//----setter,getter--------------------------------------------------------------------------
	public String getUser_Id()
	{
		return user_Id;
	}

	public String getWrite_Seq()
	{
		return write_Seq;
	}

	public String getWrite_User_Id()
	{
		return write_User_Id;
	}

	public String getPage_Code()
	{
		return page_Code;
	}

	public String getWrite_Cont()
	{
		return write_Cont;
	}

	public String getWrite_Reg_Dtm()
	{
		return write_Reg_Dtm;
	}

	public String getPeed_Seq()
	{
		return peed_Seq;
	}

	public String getPeed_Love_Cnt()
	{
		return peed_Love_Cnt;
	}

	public String getCommunity_Type_Code()
	{
		return community_Type_Code;
	}

	public String getCommunity_Title()
	{
		return community_Title;
	}

	public String getCommunity_Love_Cnt()
	{
		return community_Love_Cnt;
	}

	public String getCommunity_Hits()
	{
		return community_Hits;
	}

	public String getCommunity_Type_Name()
	{
		return community_Type_Name;
	}

	public String getBlind_Seq()
	{
		return blind_Seq;
	}

	public String getBlind_Code()
	{
		return blind_Code;
	}

	public String getBlind_Reg_Dtm()
	{
		return blind_Reg_Dtm;
	}

	public String getBlind_Name()
	{
		return blind_Name;
	}

	public String getRepo_Seq()
	{
		return repo_Seq;
	}

	public String getRepo_Type_Code()
	{
		return repo_Type_Code;
	}

	public String getRepo_User_Id()
	{
		return repo_User_Id;
	}

	public String getRepo_Reason()
	{
		return repo_Reason;
	}

	public String getReg_Dtm()
	{
		return reg_Dtm;
	}

	public String getRepo_Count()
	{
		return repo_Count;
	}

	public String getRepo_Type_Name()
	{
		return repo_Type_Name;
	}

	public void setUser_Id(String user_Id)
	{
		this.user_Id = user_Id;
	}

	public void setWrite_Seq(String write_Seq)
	{
		this.write_Seq = write_Seq;
	}

	public void setWrite_User_Id(String write_User_Id)
	{
		this.write_User_Id = write_User_Id;
	}

	public void setPage_Code(String page_Code)
	{
		this.page_Code = page_Code;
	}

	public void setWrite_Cont(String write_Cont)
	{
		this.write_Cont = write_Cont;
	}

	public void setWrite_Reg_Dtm(String write_Reg_Dtm)
	{
		this.write_Reg_Dtm = write_Reg_Dtm;
	}

	public void setPeed_Seq(String peed_Seq)
	{
		this.peed_Seq = peed_Seq;
	}

	public void setPeed_Love_Cnt(String peed_Love_Cnt)
	{
		this.peed_Love_Cnt = peed_Love_Cnt;
	}

	public void setCommunity_Type_Code(String community_Type_Code)
	{
		this.community_Type_Code = community_Type_Code;
	}

	public void setCommunity_Title(String community_Title)
	{
		this.community_Title = community_Title;
	}

	public void setCommunity_Love_Cnt(String community_Love_Cnt)
	{
		this.community_Love_Cnt = community_Love_Cnt;
	}

	public void setCommunity_Hits(String community_Hits)
	{
		this.community_Hits = community_Hits;
	}

	public void setCommunity_Type_Name(String community_Type_Name)
	{
		this.community_Type_Name = community_Type_Name;
	}

	public void setBlind_Seq(String blind_Seq)
	{
		this.blind_Seq = blind_Seq;
	}

	public void setBlind_Code(String blind_Code)
	{
		this.blind_Code = blind_Code;
	}

	public void setBlind_Reg_Dtm(String blind_Reg_Dtm)
	{
		this.blind_Reg_Dtm = blind_Reg_Dtm;
	}

	public void setBlind_Name(String blind_Name)
	{
		this.blind_Name = blind_Name;
	}

	public void setRepo_Seq(String repo_Seq)
	{
		this.repo_Seq = repo_Seq;
	}

	public void setRepo_Type_Code(String repo_Type_Code)
	{
		this.repo_Type_Code = repo_Type_Code;
	}

	public void setRepo_User_Id(String repo_User_Id)
	{
		this.repo_User_Id = repo_User_Id;
	}

	public void setRepo_Reason(String repo_Reason)
	{
		this.repo_Reason = repo_Reason;
	}

	public void setReg_Dtm(String reg_Dtm)
	{
		this.reg_Dtm = reg_Dtm;
	}

	public void setRepo_Count(String repo_Count)
	{
		this.repo_Count = repo_Count;
	}

	public void setRepo_Type_Name(String repo_Type_Name)
	{
		this.repo_Type_Name = repo_Type_Name;
	}
	
	
	
}
