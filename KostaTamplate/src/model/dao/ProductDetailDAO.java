package model.dao;

import java.sql.SQLException;

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
	int delete(ProductDetail productDetail) throws SQLException;
}
