package com.kh.mory;

import java.sql.SQLException;

public class UnitTest 
{
	public static void main(String[] args) throws SQLException 
	{
		CommunityDTO dto = new CommunityDTO();
		dto.setCommunity_title("커뮤니티");
		dto.setCommunity_type_code(30);
		dto.setWrite_user_id("jin10");
		dto.setWrite_cont("안녕하세요");
		
		CommunityDAO dao = new CommunityDAO();
		
		int result = 0;
				
		result = dao.add(dto);
		
		System.out.println(result);
		
	}

}
