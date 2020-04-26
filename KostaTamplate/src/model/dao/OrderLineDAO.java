package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderLine;

public interface OrderLineDAO {
	/**
	 * 결제내역 확인
	 */
	List<OrderLine> selectAll() throws SQLException;
	
	/**
	 * 주문하기
	 */
	int insert(OrderLine orderLine) throws SQLException;
	
	/**
	 * 환불하기
	 */
	int update(int totalPrice) throws SQLException;
	
	
	/**
	 * 주문번호로 주문내역 가져오기
	 */
	OrderLine selectBylLineNo(int lineNo) throws SQLException;
	
	
}
