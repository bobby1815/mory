package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_UserDTO;

public interface Admin_IUserDAO
{
	public ArrayList<Admin_UserDTO> QueryUser(String user_Value,String user_Search) throws SQLException;
	public ArrayList<Admin_UserDTO> UserList()throws SQLException;
	public int NicModify(String User_Nic,String User_Id) throws SQLException;
	public Admin_UserDTO SearchUser(String User_Id) throws SQLException;
	public int UserAddSanction() throws SQLException;
}
