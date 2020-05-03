package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;
import model.domain.OrderLine;

public interface OrderLineDAO {
	/**
	 * 결제내역 확인
	 */
	List<OrderLine> selectAll() throws SQLException;
	
	/**
	 * 이미 구매된 상품인지 확인(유효기간이 남았는지, 환불되지 않았는지)
	 */
	int selectAlreadyInsertOrder(String customerId, String prodId) throws SQLException;
	
	/**
	 * 주문하기(트랜잭션 오픈, 클로즈)
	 */
	void insert(OrderItem orderItem) throws Exception;
	
	/**
	 * 주문하기
	 */
	int insert(Connection con, OrderLine orderLine) throws SQLException;
	
	/**
	 * 환불하기
	 */
	int update(int lineNo, int totalPrice) throws SQLException;
	
	/**
	 * 주문번호로 주문내역 가져오기
	 */
	OrderLine selectBylLineNo(int lineNo) throws SQLException;
	
	/**
	 * 주문자별 주문내역 가져오기
	 * - 출력정보 : 상품구매번호, 상품명, 강사이름, 가격, 결제일자
	 */
	List<OrderItem> selectByCustomerId(String customerId) throws SQLException;	
	
	/**
	 * 현재수강목록
	 * - 출력정보 : 상품명, 강사이름, 강의를 들을 수 있는 날짜
	 */
	OrderItem selectMyLecture(String customerId) throws SQLException;
}
