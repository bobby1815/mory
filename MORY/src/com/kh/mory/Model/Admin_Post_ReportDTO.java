package com.kh.mory.Model;

public class Admin_Post_ReportDTO
{
	private String Repo_Seq;		//신고번호
	private String Write_Seq;		//작성번호
	private String Repo_Type_Code;	//신고유형구분코드	
	private String Repo_User_Id;	//신고자ID
	private String Repo_Reason;		//신고사유
	private String Reg_Dtm;			//신고일시
	
	
	
	
	
	//getter,setter
	public String getRepo_Seq()
	{
		return Repo_Seq;
	}
	public void setRepo_Seq(String repo_Seq)
	{
		Repo_Seq = repo_Seq;
	}
	public String getWrite_Seq()
	{
		return Write_Seq;
	}
	public void setWrite_Seq(String write_Seq)
	{
		Write_Seq = write_Seq;
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
	
	
	
	

	
	
}
