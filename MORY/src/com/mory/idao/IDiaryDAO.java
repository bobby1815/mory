package com.mory.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mory.diary.DiaryDTO;

public interface IDiaryDAO
{
	// ���̾ ���
	
	// ���� ���̾
	
	// �Խñ� ����Ʈ
	
	// �Խñ� ����
	
	// ���,��۴��
	
	//�Խñ� �ۼ�
	
	// ��� �ʴ�
	
	// �̿� �߰�
	
	public ArrayList<DiaryDTO> list(String write_seq) throws SQLException;
	
	public ArrayList<DiaryDTO> couplelist() throws SQLException;
	
	public ArrayList<DiaryDTO> commentlist(String write_seq) throws SQLException;
	
	public ArrayList<DiaryDTO> recommentlist(String write_seq) throws SQLException;
	
	public DiaryDTO cont(DiaryDTO diary) throws SQLException;
	
	public int add(DiaryDTO diary) throws SQLException;
	
	public int remove(String write_seq) throws SQLException;
	
	public int modyfi(DiaryDTO diary) throws SQLException;
	

}
