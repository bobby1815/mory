package com.kh.mory.Model;
/*===============================================
	화면명 : Setup_INeighborDAO.java
	화면설명 : 이웃기웃 인터페이스
	최초작성일 : 2017-06-30
	작성자 : 박아영
===============================================*/
 
import java.sql.SQLException;
import java.util.ArrayList;

public interface Setup_INeighborDAO
{
	public ArrayList<Setup_NeighborDTO> neighborList() throws SQLException;
	public ArrayList<Setup_NeighborDTO> myneighborList() throws SQLException;
}
