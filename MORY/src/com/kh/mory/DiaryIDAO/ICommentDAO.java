/*=======================
   ICommentDAO.java
   - �������̽�
=======================*/

package com.kh.mory.DiaryIDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.DiaryDTO.DiaryDTO;

public interface ICommentDAO
{
	// ��� �ۼ�
	public int commentInsert(DiaryDTO diaryDto) throws SQLException;

	// ��� ����
	public int commentUpdate(DiaryDTO diaryDto) throws SQLException;

	// ��� ����
	public int commentDelete(String comment_seq) throws SQLException;

	// ��� ����Ʈ
	public ArrayList<DiaryDTO> commentList(String write_seq) throws SQLException;

}
