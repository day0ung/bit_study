package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import db.DBClose;
import db.DBConnection;
import dto.MenuDTO;
import dto.OrderDTO;

public class OrderDaoImpl implements OrderDao {
	//orderdao에서 함수만들어준 후 override

	@Override
	public List<MenuDTO> getMenu() {
		String sql = " SELECT BEVERAGES, SHORT, TALL, GRANDE "
				+ "FROM COFFEELIST";
		
		Connection conn = null;
		PreparedStatement psmt = null;	
		ResultSet rs = null;	
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO dto = new MenuDTO( rs.getString(1), //beverages,
										   rs.getInt(2),//	short
										   rs.getInt(3),//tall, 
										   rs.getInt(4));//grande)
				list.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}

	@Override
	public boolean addorder(OrderDTO dto) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " INSERT INTO COFFEE_ORDER(SEQ, ID, BEVERAGES, C_SIZE, SHOT, WHEEPING, CUP, PRICE, WDATE) "
			    	+ " VALUES(SEQ_ORDER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			conn = DBConnection.getConnection();			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getBeverages());
			psmt.setString(3, dto.getCsize());
			psmt.setString(4, dto.getSyrup());
			psmt.setString(5, dto.getShot());
			psmt.setString(6, dto.getWhip());
			psmt.setInt(7, dto.getCup());
			psmt.setInt(8, dto.getPrice());
			psmt.setString(9, dto.getDate());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return count> 0? true: false;
	}

	@Override
	public List<OrderDTO> getOrdered() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "  SELECT SEQ, ID, BEVERAGES, C_SIZE, SHOT, WHEEPING, CUP, PRICE, WDATE "
			    	+ " FROM COFFEE_ORDER ";
		
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				OrderDTO dto = new OrderDTO(rs.getInt(1), rs.getString(2), 
											rs.getString(3), rs.getString(4), 
											rs.getString(5), rs.getString(6),
											rs.getString(7), rs.getInt(8),
											rs.getInt(9), rs.getString(10));
				list.add(dto);
			}
			
			
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
}
