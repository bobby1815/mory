package com.kh.mory.Model;

/*===================================================
파일명 : Admin_LeaveDTO.java
기능 : 탈퇴유예기간 사용자정의 자료형 클래스
최초작성일 : 2017-06-26
작성자 : 박아영 
===================================================*/

public class Admin_LeaveDTO
{
	// 주요 속성 구성
	private String leave_code, leave_name;
	private int leave_seq;

	// getter / settrer 구성
	public String getLeave_code()
	{
		return leave_code;
	}

	public void setLeave_code(String leave_code)
	{
		this.leave_code = leave_code;
	}

	public String getLeave_name()
	{
		return leave_name;
	}

	public void setLeave_name(String leave_name)
	{
		this.leave_name = leave_name;
	}

	public int getLeave_seq()
	{
		return leave_seq;
	}

	public void setLeave_seq(int leave_seq)
	{
		this.leave_seq = leave_seq;
	}
	
}
