package model.lsy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.BM_MemberDTO;
/*
CREATE TABLE BM_MEMBER(
SEQ NUMBER(8) PRIMARY KEY,
ID VARCHAR2(50) NOT NULL,
PWD VARCHAR2(50) NOT NULL,
NAME VARCHAR2(20) NOT NULL,
PHONENUM VARCHAR2(20) NOT NULL,
EMAIL VARCHAR2(30) NOT NULL
);
*/

public class MemberDAO {

	public BM_MemberDTO loginPwCheck(String id, String pw) {
		BM_MemberDTO BM_memberDto = null;

		String sql = " SELECT ID " + " FROM BM_MEMBER " + " WHERE ID=? AND PWD=? AND DEL = 0";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				BM_memberDto = new BM_MemberDTO();
				BM_memberDto.setId(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BM_memberDto;
	}

	public BM_MemberDTO selectOneMember(String id) {
		BM_MemberDTO dto = null;

		String sql = " SELECT SEQ, ID, NAME, PHONENUM, EMAIL " + " FROM BM_MEMBER " + " WHERE ID = ? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println("1");
			psmt.setString(1, id);
			System.out.println("2");
			rs = psmt.executeQuery();
			System.out.println("3");

			if (rs.next()) {
				dto = new BM_MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return dto;
	}

	public BM_MemberDTO getMyPage(String loginId) {
		String sql = " SELECT SEQ, ID, PWD, NAME, PHONENUM, EMAIL " + " FROM BM_MEMBER " + " WHERE ID=? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BM_MemberDTO dto = null;

		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getMyPage success");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, loginId);
			System.out.println("2/6 getMyPage success");

			rs = psmt.executeQuery();
			System.out.println("3/6 getMyPage success");
			if (rs.next()) {
				int i = 1;
				dto = new BM_MemberDTO(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++));
			}
			System.out.println("4/6 getMyPage success");
		} catch (SQLException e) {
			System.out.println("getMyPage fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}

	public int userRegistration(BM_MemberDTO bm_MemberDTO) {

		String sql = " INSERT INTO BM_MEMBER " + " (SEQ, ID, PWD, NAME, PHONENUM, EMAIL, AUTH, DEL) "
				+ " VALUES (SEQ_BM_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, 0, 0)";

		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bm_MemberDTO.getId());
			psmt.setString(2, bm_MemberDTO.getPwd());
			psmt.setString(3, bm_MemberDTO.getName());
			psmt.setString(4, bm_MemberDTO.getPhoneNum());
			psmt.setString(5, bm_MemberDTO.getEmail());

			count = psmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return count;
	}

	public int memBerDeleteOne(String loginId) {

		String sql = " UPDATE BM_MEMBER " + " SET DEL = 1 " + " WHERE ID = ? ";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, loginId);

			return psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}

		return -1;
	}

}
