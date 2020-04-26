package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderLineDAO;
import model.dao.ProductDAO;
import model.dao.impl.OrderLineDAOImpl;
import model.dao.impl.ProductDAOImpl;
import model.domain.OrderLine;

public class OrderLineService {
	private static OrderLineDAO lineDAO = new OrderLineDAOImpl();
	private static ProductDAO prodDAO = new ProductDAOImpl();
	
	public static List<OrderLine> selectAll() throws SQLException {
		return lineDAO.selectAll();
	}
	
	public static void insert(OrderLine orderLine) throws SQLException {
		int result = lineDAO.insert(orderLine);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}
	
	/**
	 * 반품 전 주문내역의 총금액을 알아오기 위해 주문번호로 총결제금액을 알아온다.
	 * @param lineNo : 주문번호
	 * @param prodId : 반품상품의 아이디
	 * @throws SQLException
	 */
	public static void update(int lineNo, String prodId) throws SQLException {
		int beforePrice = lineDAO.selectBylLineNo(lineNo).getTotalPrice();
		int prodPrice = prodDAO.selectById(prodId).getPrice();
		int totalPrice = beforePrice - prodPrice;
		int result = lineDAO.update(totalPrice);
		if(result==0) throw new SQLException("수정되지 않았습니다.");
	}
}
