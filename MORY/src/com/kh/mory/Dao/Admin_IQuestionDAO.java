package com.kh.mory.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.Model.Admin_QuestionDTO;

public interface Admin_IQuestionDAO 
{
	public ArrayList<Admin_QuestionDTO>QueSearch(String term , String select,String id) throws SQLException;
	public Admin_QuestionDTO AjaxSearch(String term , String select,String id)throws SQLException;
	public int addanw();

}
