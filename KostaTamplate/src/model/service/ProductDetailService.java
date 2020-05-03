package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.NotFoundException;
import model.dao.ProductDAO;
import model.dao.ProductDetailDAO;
import model.dao.impl.ProductDAOImpl;
import model.dao.impl.ProductDetailDAOImpl;
import model.domain.OrderItem;
import model.domain.ProductDetail;

public class ProductDetailService {
	static ProductDetailDAO  productDetailDAO = new ProductDetailDAOImpl();
	static ProductDAO productDAO = new ProductDAOImpl();

	/**
	 * ProductDetailDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static void insert(ProductDetail productDetail) throws Exception {
		if(productDAO.selectById(productDetail.getProduct().getId())==null) {
			throw new NotFoundException("존재하지 않는 강의입니다.");
		}
		int result = productDetailDAO.insert(productDetail);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}

	/**
	 * ProductDetailDAOImpl의 productDetail에 해당하는 비밀번호 수정 메소드 호출
	 */
	public static void update(ProductDetail productDetail) throws SQLException {
		int result = productDetailDAO.update(productDetail);
		if(result==0) throw new SQLException("수정되지 않았습니다.");
	}
		
	/**
	 * ProductDetail 삭제
	 * 
	 */
	public static void delete(String prodId, String chapter) throws SQLException {
		int result = productDetailDAO.delete(prodId, chapter);
		if(result==0) throw new SQLException("삭제되지 않았습니다.");
	}
	
	/**
	 * 챕터페이지 정보 띄우기 - 강의에 대한 정보
	 */
	public static List<ProductDetail> selectAll(String prodId) throws SQLException {
		return productDetailDAO.selectAll(prodId);
	}

	/**
	 * 챕터페이지 정보 띄우기 - 언제부터 언제까지 들을 수 있는지
	 */
	public static OrderItem selectProdStartEndDay(String customerId, String prodId) throws SQLException {
		return productDetailDAO.selectProdStartEndDay(customerId, prodId);
	}
}
