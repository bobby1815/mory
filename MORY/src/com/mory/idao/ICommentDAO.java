/*=======================
   ICommentDAO.java
   - �������̽�
=======================*/

package com.mory.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mory.diary.DiaryDTO;

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
