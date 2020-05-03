package model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.dao.CustomerDAO;
import model.dao.PersonDAO;
import model.dao.ProductDAO;
import model.dao.impl.CustomerDAOImpl;
import model.dao.impl.PersonDAOImpl;
import model.dao.impl.ProductDAOImpl;
import model.domain.Customer;
import model.domain.EstimateBoard;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.domain.ProductDetail;

public class ProductService {
	private static ProductDAO productDAO = new ProductDAOImpl();

	/**
	 * ProductDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static void insert(Product product) throws SQLException {
		int result = productDAO.insert(product);
		if (result == 0)
			throw new SQLException("등록되지 않았습니다.");
	}

	/**
	 * ProductDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	public static List<Product> selectAll() throws SQLException {
		List<Product> list = productDAO.selectAll();
		return list;
	}

	public static void update(Product product) throws SQLException {
		int result = productDAO.update(product);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");
	}

	/**
	 * ProductDAOImpl의 Id에 해당하는 레코드 검색하는 메소드 호출
	 */
	public static Product selectById(String prodId) throws SQLException {
		return productDAO.selectById(prodId);
	}

	public static List<Product> selectByJogun(Map<String, String> map) throws SQLException {
		return productDAO.selectByJogun(map);
	}
	
	
	/**
	 *  강의목록에 뿌릴 데이터 
	 * 
	 */
	public static List<GangiMokRok> selectGangiMokRokAll() throws SQLException {
		
		return productDAO.GangiMokRokAll();
		
	}
	
	/**
	 * [강의목록] > [자세히보기] 에 나올 정보
	 * : 강의명(prod_name), 설명(description), 가격(price), 동영상(url)
	 */
	public static Map<EstimateBoard, ProductDetail> selectProdInfo(String prodId) throws SQLException {
		return productDAO.selectProdInfo(prodId);
	}
	
	/**
	 * 같은 카테고리 내 다른 상품 띄워주기
	 */
	public static List<Product> selectSameCateProd(String prodId) throws SQLException {
		return productDAO.selectSameCateProd(prodId);
	}
	
	public static int deleteProd(String id) throws SQLException{
		
		return productDAO.deleteProd(id);
	}
	
	
	
	
}
