/*=======================
   IRecommentDAO.java
   - 인터페이스
=======================*/

package com.mory.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mory.diary.DiaryDTO;

public interface IRecommentDAO
{
   // 답글 작성
   public int recommentInsert(DiaryDTO diaryDto) throws SQLException;
   
   // 답글 수정
   public int recommentUpdate(DiaryDTO diaryDto) throws SQLException;
   
   // 답글 삭제
   public int recommentDelete(String reco_seq) throws SQLException;
   
   // 답글 리스트 출력
   public ArrayList<DiaryDTO> recommentList(String comment_seq) throws SQLException;
   

}