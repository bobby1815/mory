package com.mory.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mory.diary.DiaryDTO;

public interface IDiaryDAO
{
	// 다이어리 출력
	
	// 공유 다이어리
	
	// 게시글 리스트
	
	// 게시글 내용
	
	// 댓글,답글답기
	
	//게시글 작성
	
	// 멤버 초대
	
	// 이웃 추가
	
	public ArrayList<DiaryDTO> list(String write_seq) throws SQLException;
	
	public ArrayList<DiaryDTO> couplelist() throws SQLException;
	
	public ArrayList<DiaryDTO> commentlist(String write_seq) throws SQLException;
	
	public ArrayList<DiaryDTO> recommentlist(String write_seq) throws SQLException;
	
	public DiaryDTO cont(DiaryDTO diary) throws SQLException;
	
	public int add(DiaryDTO diary) throws SQLException;
	
	public int remove(String write_seq) throws SQLException;
	
	public int modyfi(DiaryDTO diary) throws SQLException;
	

}
