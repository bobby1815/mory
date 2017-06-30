package com.kh.mory;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICommunity_Type_DAO 
{
	public ArrayList<CommunityDTO> type_list() throws SQLException;
	public int add(CommunityDTO dto) throws SQLException;
}
