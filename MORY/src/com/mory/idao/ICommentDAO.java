/*=======================
   ICommentDAO.java
   - 인터페이스
=======================*/

package com.mory.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mory.diary.DiaryDTO;

public interface ICommentDAO
{
	// 댓글 작성
	public int commentInsert(DiaryDTO diaryDto) throws SQLException;

	// 댓글 수정
	public int commentUpdate(DiaryDTO diaryDto) throws SQLException;

	// 댓글 삭제
	public int commentDelete(String comment_seq) throws SQLException;

	// 댓글 리스트
	public ArrayList<DiaryDTO> commentList(String write_seq) throws SQLException;

}
