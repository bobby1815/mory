package com.kh.mory.main;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Main_IPwquestionDAO
{
	public ArrayList<Main_PwquestionDTO> pwquLists() throws SQLException;
}
