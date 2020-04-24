package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DBConnection;
import dto.OrderDto;

public interface OrderDao {
	public boolean order(OrderDto orderDto);
	
	
	public List<OrderDto> orderedList(String id);
	
	public int allSum(String id);
		
}











