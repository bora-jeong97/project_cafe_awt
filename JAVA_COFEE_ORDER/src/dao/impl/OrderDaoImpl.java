package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import dao.OrderDao;
import db.DBConnection;
import dto.MenuDto;
import dto.OrderDto;

public class OrderDaoImpl implements OrderDao {
	public boolean order(OrderDto orderDto) {
		String sql = " INSERT INTO ORDER_TABLE(SEQ, ID, MENU, SYRUP, CUP_SIZE, SHOT, "
				+ " WHEEPING, CUP, PRICE, WDATE) " + " VALUES(SEQ_ORDER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, orderDto.getId());
			psmt.setString(2, orderDto.getMenu());
			psmt.setString(3, orderDto.getSyrup());
			psmt.setString(4, orderDto.getSize());
			psmt.setString(5, orderDto.getShot());
			psmt.setString(6, orderDto.getWheeping());
			psmt.setInt(7, orderDto.getCup());
			psmt.setInt(8, orderDto.getPrice());
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count > 0 ? true : false;
	}



	@Override
	public List<OrderDto> orderedList(String id) {
		List<OrderDto> list = new ArrayList<OrderDto>();
		String sql = "select SEQ, ID, MENU, SYRUP, CUP_SIZE, SHOT, " + " WHEEPING, CUP, PRICE, WDATE "
				+ "FROM ORDER_TABLE" + " WHERE ID = ? ORDER BY WDATE DESC";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				OrderDto orderDto = new OrderDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),
						rs.getString(10));
				list.add(orderDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}



	@Override
	public int allSum(String id) {
		String sql = "select sum(price) from ORDER_TABLE WHERE ID = ?";
		int num = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}










