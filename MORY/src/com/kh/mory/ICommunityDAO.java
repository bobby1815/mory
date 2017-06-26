package com.kh.mory;

import java.sql.SQLException;
import java.util.ArrayList;



public interface ICommunityDAO 
{
		public int add(CommunityDTO community) throws SQLException;
		public int count() throws SQLException;
		public int remove(int write_seq) throws SQLException;
		public int modify(CommunityDTO community) throws SQLException;
		public CommunityDTO searchId(int write_seq) throws SQLException;
		
		public ArrayList<CommunityDTO> list() throws SQLException;
		
		
		
		

		 
		
		
}
