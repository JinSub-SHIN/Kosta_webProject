package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.OrderItem;
import model.domain.ProductDetail;

public interface ProductDetailDAO {
	/**
	 * 챕터(강의목차) 추가
	 */
	int insert(ProductDetail productDetail) throws SQLException;
	
	/**
	 * 챕터(강의목차) 수정
	 */
	int update(ProductDetail productDetail) throws SQLException;
	
	/**
	 * 챕터(강의목차) 삭제
	 */
	int delete(String prodId, String chapter) throws SQLException;
	
	/**
	 * 챕터페이지 정보 띄우기 - 강의에 대한 정보
	 */
	List<ProductDetail> selectAll(String prodId) throws SQLException;

	/**
	 * 챕터페이지 정보 띄우기 - 언제부터 언제까지 들을 수 있는지
	 */
	OrderItem selectProdStartEndDay(String customerId, String prodId) throws SQLException;
}
