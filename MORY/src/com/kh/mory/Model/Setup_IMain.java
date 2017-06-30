package com.kh.mory.Model;

import java.sql.SQLException;

public interface Setup_IMain
{
	public Setup_MainDTO userLogin(String user_id, String user_pw) throws SQLException; 
}
