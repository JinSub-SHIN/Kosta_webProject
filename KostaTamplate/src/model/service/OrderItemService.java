package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderItemDAO;
import model.dao.impl.OrderItemDAOImpl;
import model.domain.OrderItem;

public class OrderItemService {
	public static OrderItemDAO itemDAO = new OrderItemDAOImpl();
	
	public static List<OrderItem> selectAll() throws SQLException{
		return itemDAO.selectAll();
	}
	
	public static void insert(List<OrderItem> list) throws SQLException{
		int result = itemDAO.insert(list);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}
	
	public static void update(List<OrderItem> list) throws SQLException{
		
	}
}
