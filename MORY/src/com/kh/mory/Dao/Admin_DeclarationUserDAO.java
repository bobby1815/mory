package com.kh.mory.Dao;
/*package com.mory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mory.Model.UserDTO;
import com.mory.Model.WriteDTO;

public class DeclarationUserDAO implements IDeclarationUserDAO
{
	// �������̽� �ڷ��� ����
	private DataSource dataSource;

	// setter �޼ҵ� ����
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	

	//--�Ű��ھ��̵� ��ȸ
	@Override
	public WriteDTO ReportUser(String Write_User_Id) throws SQLException
	{
		Connection conn= dataSource.getConnection();
		String sql = "SELECT WRITE_USER_ID FROM TBL_WRITE WHERE WRITE_USER_Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		WriteDTO dto = new WriteDTO();
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			dto.setWrite_User_Id(rs.getString("Write_User_Id"));
		//	dto.set
		}
		pstmt.close();
		conn.close();
		rs.close();
		return null;
	}
	
	
	//�Ű���� �����ǵ�,Ŀ�´�Ƽ ����Ʈ��ȸ
	@Override
	public ArrayList<WriteDTO> ReportList(String Page_Code)throws SQLException
	{
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		Connection conn = dataSource.getConnection();
		String sql = "SELECT USER_ID,WRITE_CONT,WRITE_REG_DTM"//--���̺������ؾߴ�
				+ " FROM TBL_WRITE WHERE PAGE_CODE=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		WriteDTO wdto = new WriteDTO();
		while (rs.next())
		{
			
			wdto.setWrite_User_Id(rs.getString("WRITE_USER_ID"));
			wdto.setWrite_Cont(rs.getString("WRITE_CONT"));
			wdto.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
			//�Ű�Ƚ���־����
			//ó��ȭ��
			//list.add(wdto);
		}
		
		pstmt.close();
		conn.close();
		rs.close();
		return null;
	}

	
	
	//--�˻��Ⱓ
	@Override
	public WriteDTO ReportSearch(String Write_Reg_Dtm) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		String sql = " FROM TBL_WRITE WHERE WRITE_REG_DTM LIKE %?% ";
		WriteDTO dto = new WriteDTO();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,dto.getWrite_Reg_Dtm());
		ResultSet rs =pstmt.executeQuery();
		while (rs.next())
		{
			dto.setWrite_Reg_Dtm(rs.getString("WRITE_REG_DTM"));
			
		}
		pstmt.close();
		conn.close();
		rs.close();
		return dto;
	}

}
*/