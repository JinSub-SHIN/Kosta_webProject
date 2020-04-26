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
import model.domain.Product;

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

	/**
	 * ProductDAOImpl의 모든레코드 수정하는 메소드 호출
	 */
	public static void update(List<Product> list) throws SQLException {

	}

	/**
	 * ProductDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	 * 
	 * @param path
	 */
	public static void delete() throws SQLException {

	}

	/**
	   * ProductDAOImpl의 Id에 해당하는 레코드 검색하는 메소드 호출
	   * */
//	public static Product selectByJogun(String id) 
//			                        throws SQLException{
//		
//
//		
//		Product pro = ProductDAOImpl.selectByJogun(Map<K, V>);
//		if(pro==null)throw new SQLException("Id에 해당하는 정보를 검색할수 없습니다.");
//		
//		return pro;
//	}

}
