package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_DeclarationUserDTO;

public interface Admin_IDeclarationUserDAO
{
	public ArrayList<Admin_DeclarationUserDTO> DeclarationSearchList(String ing ,String Id,String select) throws SQLException;
	
}
