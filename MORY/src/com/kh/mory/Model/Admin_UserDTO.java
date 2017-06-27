package com.kh.mory.Model;

public class Admin_UserDTO
{

	//-- ����� �ֿ亯�� ����(TBL_USER)
	private String user_Id;					//�������̵�
	private String gen_Code;				//�����ڵ�
	private String addr_Divi_Code;			//�ּұ����ڵ�
	private String page_Code;				//�����������ڵ�
	private String open_Code;				//�ǵ� ��������
	private String acc_State_Code;			//�������±����ڵ�
	private String acc_Grade_Code;			//��������ڵ�
	private String user_Pw;					//��й�ȣ
	private String user_Nic;				//�г���
	private String user_Name;				//�̸�
	private String user_Tel;				//��ȭ��ȣ
	private String user_Birth;				//�������
	private String user_Email;				//�̸���
	private String zip_Code;			//�����ȣ
	private String basic_Addr; 		//�⺻�ּ�
	private String detail_Addr;		 //���ּ�
	private int num;				//��ȣ
	
	
	//---����������̷� �ֿ亯�� ����(TBL_USER_SANCTION)
	private String sanc_Seq;
	private String sanc_Type_Code;
	private String sanc_Reg_Dtm;
	
	//---������������ �ֿ亯�� ����(TBL_SANCTION_TYPE)
	private String sanc_Type_Name;
	
	//-- �������±���(TBL_ACC_STATE)
	private String acc_State_Name;

	public String getUser_Id()
	{
		return user_Id;
	}

	public String getGen_Code()
	{
		return gen_Code;
	}

	public String getAddr_Divi_Code()
	{
		return addr_Divi_Code;
	}

	public String getPage_Code()
	{
		return page_Code;
	}

	public String getOpen_Code()
	{
		return open_Code;
	}

	public String getAcc_State_Code()
	{
		return acc_State_Code;
	}

	public String getAcc_Grade_Code()
	{
		return acc_Grade_Code;
	}

	public String getUser_Pw()
	{
		return user_Pw;
	}

	public String getUser_Nic()
	{
		return user_Nic;
	}

	public String getUser_Name()
	{
		return user_Name;
	}

	public String getUser_Tel()
	{
		return user_Tel;
	}

	public String getUser_Birth()
	{
		return user_Birth;
	}

	public String getUser_Email()
	{
		return user_Email;
	}

	public String getZip_Code()
	{
		return zip_Code;
	}

	public String getBasic_Addr()
	{
		return basic_Addr;
	}

	public String getDetail_Addr()
	{
		return detail_Addr;
	}

	public String getSanc_Seq()
	{
		return sanc_Seq;
	}

	public String getSanc_Type_Code()
	{
		return sanc_Type_Code;
	}

	public String getSanc_Reg_Dtm()
	{
		return sanc_Reg_Dtm;
	}

	public String getSanc_Type_Name()
	{
		return sanc_Type_Name;
	}

	public String getAcc_State_Name()
	{
		return acc_State_Name;
	}

	public void setUser_Id(String user_Id)
	{
		this.user_Id = user_Id;
	}

	public void setGen_Code(String gen_Code)
	{
		this.gen_Code = gen_Code;
	}

	public void setAddr_Divi_Code(String addr_Divi_Code)
	{
		this.addr_Divi_Code = addr_Divi_Code;
	}

	public void setPage_Code(String page_Code)
	{
		this.page_Code = page_Code;
	}

	public void setOpen_Code(String open_Code)
	{
		this.open_Code = open_Code;
	}

	public void setAcc_State_Code(String acc_State_Code)
	{
		this.acc_State_Code = acc_State_Code;
	}

	public void setAcc_Grade_Code(String acc_Grade_Code)
	{
		this.acc_Grade_Code = acc_Grade_Code;
	}

	public void setUser_Pw(String user_Pw)
	{
		this.user_Pw = user_Pw;
	}

	public void setUser_Nic(String user_Nic)
	{
		this.user_Nic = user_Nic;
	}

	public void setUser_Name(String user_Name)
	{
		this.user_Name = user_Name;
	}

	public void setUser_Tel(String user_Tel)
	{
		this.user_Tel = user_Tel;
	}

	public void setUser_Birth(String user_Birth)
	{
		this.user_Birth = user_Birth;
	}

	public void setUser_Email(String user_Email)
	{
		this.user_Email = user_Email;
	}

	public void setZip_Code(String zip_Code)
	{
		this.zip_Code = zip_Code;
	}

	public void setBasic_Addr(String basic_Addr)
	{
		this.basic_Addr = basic_Addr;
	}

	public void setDetail_Addr(String detail_Addr)
	{
		this.detail_Addr = detail_Addr;
	}

	public void setSanc_Seq(String sanc_Seq)
	{
		this.sanc_Seq = sanc_Seq;
	}

	public void setSanc_Type_Code(String sanc_Type_Code)
	{
		this.sanc_Type_Code = sanc_Type_Code;
	}

	public void setSanc_Reg_Dtm(String sanc_Reg_Dtm)
	{
		this.sanc_Reg_Dtm = sanc_Reg_Dtm;
	}

	public void setSanc_Type_Name(String sanc_Type_Name)
	{
		this.sanc_Type_Name = sanc_Type_Name;
	}

	public void setAcc_State_Name(String acc_State_Name)
	{
		this.acc_State_Name = acc_State_Name;
	}

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}
	

}
