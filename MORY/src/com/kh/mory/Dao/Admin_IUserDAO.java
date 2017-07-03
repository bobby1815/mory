package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_UserDTO;

public interface Admin_IUserDAO
{
	public ArrayList<Admin_UserDTO> QueryUser(String user_Value,String user_Search,int start,int end) throws SQLException;
	public ArrayList<Admin_UserDTO> UserList()throws SQLException;
	public Admin_UserDTO SearchUser(String User_Id) throws SQLException;
	public int UserModify(String id , String sanc_Type_Code,String nic) throws SQLException;
}
