package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.MenuDto;
import dto.OrderDto;


public interface MenuDao_ {
	
	public List<MenuDto> getMenuList();
	
	public MenuDto getMenuInfo(String menu);
}


















