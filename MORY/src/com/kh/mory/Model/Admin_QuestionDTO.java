package com.kh.mory.Model;

public class Admin_QuestionDTO
{
	//�ֿ� ���� ����
	
	private int num;
	private String ques_User_Id; //--���̵�
	private String ques_Title;	 //--���� 
	private String ques_Reg_Dtm; //--�ۼ���
	private String checks;       //--�亯����
	private String answ_User_Id; //--�亯��
	private String ques_Cont;    //--����
	private String answ_Cont;    //--�亯����
	private int seq;
	
	

	//setter, getter ����
	
	
	
	public int getNum()
	{
		return num;
	}
	public int getSeq()
	{
		return seq;
	}
	public void setSeq(int seq)
	{
		this.seq = seq;
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
