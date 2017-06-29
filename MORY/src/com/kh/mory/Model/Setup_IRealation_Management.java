package com.kh.mory.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Setup_IRealation_Management
{
	public ArrayList<Setup_Realation_ManagementDTO> searchuser (String user_id) throws SQLException;
	public int Negihbor(String user_Id, String nei_user_id) throws SQLException;
	public int UnNegibor(String user_Id, String nei_user_Id) throws SQLException; 
	
}
