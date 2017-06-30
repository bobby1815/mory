package com.kh.mory.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Setup_IProfile
{
	public ArrayList<Setup_ProfileDTO> user_info(String user_id,String user_pw) throws SQLException;
	public ArrayList<Setup_ProfileDTO> id_check();
	public int modify(Setup_ProfileDTO  profileDTO) throws SQLException;
	
}
