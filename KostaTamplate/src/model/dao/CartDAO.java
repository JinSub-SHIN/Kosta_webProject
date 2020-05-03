package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Cart;

public interface CartDAO {
	/**
	 * 장바구니 전체조회
	 * @return List<Product>
	 */
	List<Cart> selectAll(String customerId) throws SQLException;
	
	/**
	 * 장바구니 상품 추가 전 이미 장바구니에 있는 상품인지 확인
	 * @return int - 0: 장바구니에 없음 / 1:이미 장바구니에 담겨있음
	 */
	int checkCart(String customerId, String prodId) throws SQLException;
	
	/**
	 * 장바구니 상품 추가
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int insert(String customerId, String prodId) throws SQLException;
	
	/**
	 * 장바구니 상품 삭제
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int delete(String customerId, String prodId) throws SQLException;

	/**
	 * 장바구니 상품 전체 삭제
	 * @return int - 0: 실패 / 0이 아니면 성공
	 * @throws SQLException 
	 */
	int deleteAll(String customerId) throws SQLException;
}
