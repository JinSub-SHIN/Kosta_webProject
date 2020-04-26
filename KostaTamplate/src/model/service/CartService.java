package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CartDAO;
import model.dao.impl.CartDAOImpl;
import model.domain.Product;

public class CartService {
	static CartDAO dao = new CartDAOImpl();
	
	/**
	 * 장바구니에 담긴 상품 조회
	 * @return List<Product>
	 * @throws SQLException
	 */
	public static List<Product> selectAll(String customerId) throws SQLException {
		List<Product> list = dao.selectAll(customerId);
		return list;
	}
	
	/**
	 * 장바구니 담기
	 * @param product
	 * @throws SQLException
	 */
	public static void insert(String customerId, String prodId) throws SQLException {
		int result = dao.insert(customerId, prodId);
		if(result==0) { //실패
			throw new SQLException("장바구니 담기에 실패했습니다.");
		}
	}
	
	/**
	 * 장바구니 목록 전체 삭제
	 * @throws SQLException 
	 */
	public static void deleteAll(String customerId) throws SQLException {
		int result = dao.deleteAll(customerId);
		if(result==0) {
			throw new SQLException("장바구니 모두 비우기에 실패했습니다.");
		}
	}
	
	/**
	 * 선택 상품 장바구니에서 제거
	 * @param userId, prodId
	 * @throws SQLException
	 */
	public static void deleteById(String customerId, String prodId) throws SQLException {
		int result = dao.deleteById(customerId, prodId);
		if(result==0) {
			throw new SQLException("장바구니에서 삭제하는데 실패했습니다.");
		}
	}
	
	/**
	 * 선택 상품 장바구니 목록에서 삭제 - 여러 개
	 */
	public static void delete(String customerId, List<Product> list) throws SQLException {
		int result = dao.delete(customerId, list);
		if(result==0) {
			throw new SQLException("삭제하는데 실패했습니다.");
		}
	}
	
}
