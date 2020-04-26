package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * 결제내역 확인
	 */
	List<OrderItem> selectAll() throws SQLException;
	
	/**
	 * 주문하기
	 */
	int insert(List<OrderItem> list) throws SQLException;	
	
	/**
	 * 환불하기
	 */
	int update(List<OrderItem> list) throws SQLException;
}
