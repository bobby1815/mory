/*=======================
   IRecommentDAO.java
   - �������̽�
=======================*/

package com.kh.mory.DiaryIDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.mory.DiaryDTO.DiaryDTO;

public interface IRecommentDAO
{
   // ��� �ۼ�
   public int recommentInsert(DiaryDTO diaryDto) throws SQLException;
   
   // ��� ����
   public int recommentUpdate(DiaryDTO diaryDto) throws SQLException;
   
   // ��� ����
   public int recommentDelete(String reco_seq) throws SQLException;
   
   // ��� ����Ʈ ���
   public ArrayList<DiaryDTO> recommentList(String write_seq) throws SQLException;
   

}