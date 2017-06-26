package com.kh.mory.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Setup_IProfile
{
	public ArrayList<Setup_ProfileDTO> nickname_check() throws SQLException;
	public ArrayList<Setup_ProfileDTO> id_check();
	public int modify() throws SQLException;
	
}
