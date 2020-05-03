package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderItemDAO;
import model.dao.impl.OrderItemDAOImpl;
import model.domain.OrderItem;

public class OrderItemService {
	public static OrderItemDAO itemDAO = new OrderItemDAOImpl();
	
	public static int selectAll() throws SQLException{
		return itemDAO.selectAll();
	}
	
	public static int selectSevenDayAll() throws SQLException{
		
		return itemDAO.selectBySevenDay();
	}
	
	public static long selectTotal() throws SQLException{
		
		return itemDAO.selectpriceAll();
	}
	
	public static List<OrderItem> selectBySevenitemlist() throws SQLException{
		
		return itemDAO.selectBySevenitemlist();
	}
	
	public static void update(List<Integer> list) throws SQLException{
		for(int itemNo : list) {
//			int result = itemDAO.update(itemNo);
//			if(result==0) throw new SQLException("수정되지 않았습니다.");		
		}
	}
}
