package com.kh.mory.Model;

public class Admin_QuestionDTO
{
	//주요 변수 구성
	
	private int num;
	private String ques_User_Id; //--아이디
	private String ques_Title;	 //--제목 
	private String ques_Reg_Dtm; //--작성일
	private String checks;       //--답변여부
	private String answ_User_Id; //--답변자
	private String ques_Cont;    //--내용
	private String answ_Cont;    //--답변내용
	
	

	//setter, getter 구성
	
	public int getNum()
	{
		return num;
	}
	public String getAnsw_Cont()
	{
		return answ_Cont;
	}
	public void setAnsw_Cont(String answ_Cont)
	{
		this.answ_Cont = answ_Cont;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	public String getQues_User_Id()
	{
		return ques_User_Id;
	}
	public void setQues_User_Id(String ques_User_Id)
	{
		this.ques_User_Id = ques_User_Id;
	}
	public String getQues_Title()
	{
		return ques_Title;
	}
	public void setQues_Title(String ques_Title)
	{
		this.ques_Title = ques_Title;
	}
	public String getQues_Reg_Dtm()
	{
		return ques_Reg_Dtm;
	}
	public void setQues_Reg_Dtm(String ques_Reg_Dtm)
	{
		this.ques_Reg_Dtm = ques_Reg_Dtm;
	}
	public String getChecks()
	{
		return checks;
	}
	public void setChecks(String checks)
	{
		this.checks = checks;
	}
	public String getAnsw_User_Id()
	{
		return answ_User_Id;
	}
	public void setAnsw_User_Id(String answ_User_Id)
	{
		this.answ_User_Id = answ_User_Id;
	}
	public String getQues_Cont()
	{
		return ques_Cont;
	}
	public void setQues_Cont(String ques_Cont)
	{
		this.ques_Cont = ques_Cont;
	}

	
	
}
