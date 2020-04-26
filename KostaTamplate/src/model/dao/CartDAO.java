package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Product;

public interface CartDAO {
	/**
	 * 장바구니 전체조회
	 * @return List<Product>
	 */
	List<Product> selectAll(String customerId) throws SQLException;
	
	/**
	 * 장바구니 상품 추가
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int insert(String customerId, String prodId) throws SQLException;
	
	/**
	 * 장바구니 상품 삭제
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int delete(String customerId, List<Product> list) throws SQLException;
	
	int deleteAll(String customerId) throws SQLException;
	
	int deleteById(String customerId, String prodId) throws SQLException;
}
