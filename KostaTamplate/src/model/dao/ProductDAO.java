package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.domain.EstimateBoard;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.domain.ProductDetail;

public interface ProductDAO {
	/**
	 * 상품 추가
	 */
	int insert(Product product) throws SQLException;
	
	/**
	 * 상품 수정 - 상품명, 가격, 설명, 유효기간 변경
	 */
	int update(Product product) throws SQLException;
		
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
	Product selectById(String prodId) throws SQLException;	
	
	/**
	 *  강의목록 띄울 전체 상품 조회
	 */
	List<GangiMokRok> GangiMokRokAll() throws SQLException;
	
	/**
	 * [강의목록] > [자세히보기] 에 나올 정보 
	 * : 강의명(prod_name), 설명(description), 가격(price), 동영상(url)
	 */
	Map<EstimateBoard, ProductDetail> selectProdInfo(String prodId) throws SQLException;
	
	/**
	 * 같은 카테고리 내 다른 상품 띄워주기
	 */
	List<Product> selectSameCateProd(String prodId) throws SQLException;
	
	/**
	 *  상품삭제 - 관리자기능
	 */
	int deleteProd(String id) throws SQLException;
	
}