package com.kh.mory.Model;

public class Admin_DeclarationUserDTO
{
	//TBL_작성내용 변수---------------------------------------------------------------------
	private String Write_Seq;
	private String Write_User_Id;
	private String Page_Code;
	private String Write_Cont;
	private String Write_Reg_Dtm;
	
	
	//TBL_뉴스피드---------------------------------------------------------------------
	private String Peed_Seq;
	private String Peed_Love_Cnt;
	
	
	//TBL_커뮤니티---------------------------------------------------------------------
	private String Community_Type_Code;
	private String Community_Title;
	private String Community_Love_Cnt;
	private String Community_Hits;
	
	//TBL_커뮤니티 유형 구분---------------------------------------------------------------------
	
	private String Community_Type_Name;
	
	//TBL_블라인드 게시글---------------------------------------------------------------------
	private String Blind_Seq;
	private String Blind_Code;
	private String Blind_Reg_Dtm;
	
	//TBL_블라인드 사유코드구분--------------------------------------------------------------------
	private String Blind_Name;
	
	//TBL_게시물 신고--------------------------------------------------------------------
	private String Repo_Seq;
	private String Repo_Type_Code;
	private String Repo_User_Id;
	private String Repo_Reason;
	private String Reg_Dtm;
	
	//TBL_신고 유형 구분--------------------------------------------------------------------
	private String Repo_Type_Name;
	
	
	
	
	
	//작성내용 set,getter---------------------------------------------------------------------
	public String getWrite_Seq()
	{
		return Write_Seq;
	}
	public void setWrite_Seq(String write_Seq)
	{
		Write_Seq = write_Seq;
	}
	public String getWrite_User_Id()
	{
		return Write_User_Id;
	}
	public void setWrite_User_Id(String write_User_Id)
	{
		Write_User_Id = write_User_Id;
	}
	public String getPage_Code()
	{
		return Page_Code;
	}
	public void setPage_Code(String page_Code)
	{
		Page_Code = page_Code;
	}
	public String getWrite_Cont()
	{
		return Write_Cont;
	}
	public void setWrite_Cont(String write_Cont)
	{
		Write_Cont = write_Cont;
	}
	public String getWrite_Reg_Dtm()
	{
		return Write_Reg_Dtm;
	}
	public void setWrite_Reg_Dtm(String write_Reg_Dtm)
	{
		Write_Reg_Dtm = write_Reg_Dtm;
	}
	
	//TBL_뉴스피드setter,getter---------------------------------------------------------------------
	public String getPeed_Seq()
	{
		return Peed_Seq;
	}
	public void setPeed_Seq(String peed_Seq)
	{
		Peed_Seq = peed_Seq;
	}
	public String getPeed_Love_Cnt()
	{
		return Peed_Love_Cnt;
	}
	public void setPeed_Love_Cnt(String peed_Love_Cnt)
	{
		Peed_Love_Cnt = peed_Love_Cnt;
	}
	
	//TBL_커뮤니티setter,getter---------------------------------------------------------------------
	public String getCommunity_Type_Code()
	{
		return Community_Type_Code;
	}
	public void setCommunity_Type_Code(String community_Type_Code)
	{
		Community_Type_Code = community_Type_Code;
	}
	public String getCommunity_Title()
	{
		return Community_Title;
	}
	public void setCommunity_Title(String community_Title)
	{
		Community_Title = community_Title;
	}
	public String getCommunity_Love_Cnt()
	{
		return Community_Love_Cnt;
	}
	public void setCommunity_Love_Cnt(String community_Love_Cnt)
	{
		Community_Love_Cnt = community_Love_Cnt;
	}
	public String getCommunity_Hits()
	{
		return Community_Hits;
	}
	public void setCommunity_Hits(String community_Hits)
	{
		Community_Hits = community_Hits;
	}
	public String getCommunity_Type_Name()
	{
		return Community_Type_Name;
	}
	public void setCommunity_Type_Name(String community_Type_Name)
	{
		Community_Type_Name = community_Type_Name;
	}
	
	
	//TBL_블라인드setter,getter---------------------------------------------------------------------
	public String getBlind_Seq()
	{
		return Blind_Seq;
	}
	public void setBlind_Seq(String blind_Seq)
	{
		Blind_Seq = blind_Seq;
	}
	public String getBlind_Code()
	{
		return Blind_Code;
	}
	public void setBlind_Code(String blind_Code)
	{
		Blind_Code = blind_Code;
	}
	public String getBlind_Reg_Dtm()
	{
		return Blind_Reg_Dtm;
	}
	public void setBlind_Reg_Dtm(String blind_Reg_Dtm)
	{
		Blind_Reg_Dtm = blind_Reg_Dtm;
	}
	public String getBlind_Name()
	{
		return Blind_Name;
	}
	public void setBlind_Name(String blind_Name)
	{
		Blind_Name = blind_Name;
	}
	
	
	
	//TBL_게시물 신고setter,getter---------------------------------------------------------------------
	public String getRepo_Seq()
	{
		return Repo_Seq;
	}
	public void setRepo_Seq(String repo_Seq)
	{
		Repo_Seq = repo_Seq;
	}
	public String getRepo_Type_Code()
	{
		return Repo_Type_Code;
	}
	public void setRepo_Type_Code(String repo_Type_Code)
	{
		Repo_Type_Code = repo_Type_Code;
	}
	public String getRepo_User_Id()
	{
		return Repo_User_Id;
	}
	public void setRepo_User_Id(String repo_User_Id)
	{
		Repo_User_Id = repo_User_Id;
	}
	public String getRepo_Reason()
	{
		return Repo_Reason;
	}
	public void setRepo_Reason(String repo_Reason)
	{
		Repo_Reason = repo_Reason;
	}
	public String getReg_Dtm()
	{
		return Reg_Dtm;
	}
	public void setReg_Dtm(String reg_Dtm)
	{
		Reg_Dtm = reg_Dtm;
	}
	public String getRepo_Type_Name()
	{
		return Repo_Type_Name;
	}
	public void setRepo_Type_Name(String repo_Type_Name)
	{
		Repo_Type_Name = repo_Type_Name;
	}

	
	
	
}
