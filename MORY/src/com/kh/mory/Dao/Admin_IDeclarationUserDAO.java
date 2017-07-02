package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_DeclarationUserDTO;

public interface Admin_IDeclarationUserDAO
{
	public ArrayList<Admin_DeclarationUserDTO> DeclarationSearchList(String ing ,String Id,String select) throws SQLException;
	public Admin_DeclarationUserDTO AjaxSearchUser(String userid) throws SQLException;
	public Admin_DeclarationUserDTO AjaxCommuSearchUser(String userid) throws SQLException;
	public ArrayList<Admin_DeclarationUserDTO> BlindSearchList(String ing ,String Id,String select) throws SQLException;
	
}
