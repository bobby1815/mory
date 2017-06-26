package com.kh.mory.join;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Signup_IUserDAO
{
	public int userInsert(Signup_UserDTO dto) throws SQLException;				// 회원가입
	public int userIdCheck(String user_id) throws SQLException;			// ID중복체크
	public int userNicknameCheck(String user_nic)throws SQLException;	// 닉네임 중복 체크
	public ArrayList<Signup_UserDTO> userLists() throws SQLException;			// 회원 목록 조회
	public Signup_UserDTO userList(String user_id) throws SQLException;		// 회원 정보 조회
	public int userModify(Signup_UserDTO dto) throws SQLException;				// 회원 정보 수정
	public Signup_UserDTO userLogin(String user_id, String user_pw) throws SQLException;	// 로그인
	
}
