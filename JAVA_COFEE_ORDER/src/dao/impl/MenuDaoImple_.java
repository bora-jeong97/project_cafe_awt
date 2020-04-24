package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MenuDao_;
import db.DBClose;
import db.DBConnection;
import dto.MenuDto;
import dto.OrderDto;

public class MenuDaoImple_ implements MenuDao_{
	
	public List<MenuDto> getMenuList(){
		List<MenuDto> list = new ArrayList<MenuDto>();
		
		String sql = "SELECT SEQ, MENU, SHORT_PRICE, TALL_PRICE, GRANDE_PRICE"
				+ " FROM MENU_TABLE";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MenuDto menuDto = new MenuDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5));
				list.add(menuDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}	
		
		return list;
	}

	@Override
	public MenuDto getMenuInfo(String menu) {
		String sql = " SELECT SEQ, MENU, SHORT_PRICE, TALL_PRICE, GRANDE_PRICE "
				+ " FROM MENU_TABLE "
				+ " WHERE MENU = ?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MenuDto menuDto = null;
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, menu);
			rs = psmt.executeQuery();
			while(rs.next()) {
				menuDto = new MenuDto(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4),
							rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}	
		
		
		return menuDto;
	}
}












