package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;

public interface OrderItemDAO {	
	/**
	 * 결제내역 확인
	 */
	int selectAll() throws SQLException;
	
	/**
	 * 주문하기
	 */
	int insert(Connection con, OrderItem orderItem) throws SQLException;	
	
	/**
	 * 환불하기 & 연장하기 시 isRefund값 변경
	 * isRefund - 1:구매상품, 2:환불상품, 3:연장된상품
	 */
	int update(int isRefund, int itemNo, String customerId) throws SQLException;
	
	
	/**
	 * 상품기간연장 전 기존 구매상품의 유효기간 확인
	 */
	Date selectEndDate(int itemNo, String customerId) throws SQLException;
	
	/**
	 * 7일동안판매수량
	 * @return
	 * @throws SQLException
	 */
	int selectBySevenDay() throws SQLException;
	
	/**
	 * 총판매수량
	 * @return
	 * @throws SQLException
	 */
	long selectpriceAll() throws SQLException;
	
	
	/**
	 *  최근판매7개...
	 */
	List<OrderItem> selectBySevenitemlist() throws SQLException;
	
}
