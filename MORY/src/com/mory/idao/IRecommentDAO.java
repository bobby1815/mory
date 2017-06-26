/*=======================
   IRecommentDAO.java
   - �������̽�
=======================*/

package com.mory.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mory.diary.DiaryDTO;

public interface IRecommentDAO
{
   // ��� �ۼ�
   public int recommentInsert(DiaryDTO diaryDto) throws SQLException;
   
   // ��� ����
   public int recommentUpdate(DiaryDTO diaryDto) throws SQLException;
   
   // ��� ����
   public int recommentDelete(String reco_seq) throws SQLException;
   
   // ��� ����Ʈ ���
   public ArrayList<DiaryDTO> recommentList(String comment_seq) throws SQLException;
   

}