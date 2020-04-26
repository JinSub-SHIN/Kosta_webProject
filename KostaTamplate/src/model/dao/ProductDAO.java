package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.domain.Product;

public interface ProductDAO {
	/**
	 * 상품 추가
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * 상품 수정
	 */
	int upate(Product product) throws SQLException;
	
	/**
	 * 상품 삭제
	 */
	int delete(Product product) throws SQLException;
		
	/**
	 *  상품전체조회 (SQL구문에서 최근날짜별로 정렬해서 출력한다)
	 */
	List<Product> selectAll() throws SQLException;
	
	/**
	 * SQL구문예시 SQL SELECT * FROM PRODUCT WHERE category="?" and teacher=? and level="?";
	 *  Map(key, value)
	 *  key category , java
	 *  key teacher , A선생 
	 *  key level , 1레벨
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	List<Product> selectByJogun(Map<String, String> map) throws SQLException;
	
	/**
	 * 상품아이디로 상품조회
	 */
	Product selectById(String id) throws SQLException;	
}