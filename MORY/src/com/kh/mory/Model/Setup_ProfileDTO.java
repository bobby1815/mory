package com.kh.mory.Model;

public class Setup_ProfileDTO
{
	
	/*
		SELECT USER_ID AS ID,GEN_CODE AS GENDER,ACC_STATE_CODE AS STATUS, ACC_GRADE_CODE AS AUTHORITY, USER_NAME AS NAME 
      ,USER_NIC AS NICKNAME, USER_TEL AS TEL, USER_BIRTH AS BRITHDAY,USER_EMAIL AS EMAIL,ZIPCODE AS ZIPCOE
      ,BASIC_ADDR AS BASIC_ADDR,DETAIL_ADDR AS DETAIL_ADDR      
FROM TBL_USER
WHERE USER_ID = '11111111111';
	
	
USER_ID        NOT NULL VARCHAR2(20)  
GEN_CODE                VARCHAR2(1)   
PAGE_CODE               VARCHAR2(1)   
OPEN_CODE               VARCHAR2(1)   
ACC_STATE_CODE          NUMBER(2)     
ACC_GRADE_CODE          NUMBER(2)     
USER_PW        NOT NULL VARCHAR2(30)  
USER_NIC       NOT NULL VARCHAR2(20)  
USER_NAME               VARCHAR2(30)  
USER_TEL                VARCHAR2(11)  
USER_BIRTH              DATE          
USER_EMAIL              VARCHAR2(50)  
ZIPCODE                 VARCHAR2(5)   
BASIC_ADDR              VARCHAR2(100) 
DETAIL_ADDR             VARCHAR2(100) 
LOCA_CODE               NUMBER(2)     
CITY_CODE               NUMBER(5)     
PWQU_CODE               NUMBER(2)     
PWQU_ANSW               VARCHAR2(20)  

	
		*/
	
	private String user_Id,user_Pw,user_name,user_Tel
			,user_birth,user_Email,user_Zipcode,user_basic_Addr
			,user_detail_addr,user_Nicname,gencode;

	public String getUser_Nicname()
	{
		return user_Nicname;
	}

	public void setUser_Nicname(String user_Nicname)
	{
		this.user_Nicname = user_Nicname;
	}

	public String getGencode()
	{
		return gencode;
	}

	public void setGencode(String gencode)
	{
		this.gencode = gencode;
	}

	public String getUser_Id()
	{
		return user_Id;
	}

	public void setUser_Id(String user_Id)
	{
		this.user_Id = user_Id;
	}

	public String getUser_Pw()
	{
		return user_Pw;
	}

	public void setUser_Pw(String user_Pw)
	{
		this.user_Pw = user_Pw;
	}

	public String getUser_name()
	{
		return user_name;
	}

	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}

	public String getUser_Tel()
	{
		return user_Tel;
	}

	public void setUser_Tel(String user_Tel)
	{
		this.user_Tel = user_Tel;
	}

	public String getUser_birth()
	{
		return user_birth;
	}

	public void setUser_birth(String user_birth)
	{
		this.user_birth = user_birth;
	}

	public String getUser_Email()
	{
		return user_Email;
	}

	public void setUser_Email(String user_Email)
	{
		this.user_Email = user_Email;
	}

	public String getUser_Zipcode()
	{
		return user_Zipcode;
	}

	public void setUser_Zipcode(String user_Zipcode)
	{
		this.user_Zipcode = user_Zipcode;
	}

	public String getUser_basic_Addr()
	{
		return user_basic_Addr;
	}

	public void setUser_basic_Addr(String user_basic_Addr)
	{
		this.user_basic_Addr = user_basic_Addr;
	}

	public String getUser_detail_addr()
	{
		return user_detail_addr;
	}

	public void setUser_detail_addr(String user_detail_addr)
	{
		this.user_detail_addr = user_detail_addr;
	}
	
	


}
