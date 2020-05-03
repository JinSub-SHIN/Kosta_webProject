package model.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import exception.ModifyException;
import model.dao.OrderItemDAO;
import model.dao.OrderLineDAO;
import model.dao.ProductDAO;
import model.dao.impl.OrderItemDAOImpl;
import model.dao.impl.OrderLineDAOImpl;
import model.dao.impl.ProductDAOImpl;
import model.domain.Customer;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;

public class OrderLineService {
	private static OrderLineDAO lineDAO = new OrderLineDAOImpl();
	private static ProductDAO prodDAO = new ProductDAOImpl();
	private static OrderItemDAO itemDAO = new OrderItemDAOImpl();

	public static List<OrderLine> selectAll() throws SQLException {
		return lineDAO.selectAll();
	}

	public static void insert(OrderItem orderItem) throws Exception {
		Product product = prodDAO.selectById(orderItem.getProduct().getId());
		orderItem.setProduct(product);
		long validDate = 0;

		String customerId = orderItem.getOrderLine().getCustomer().getId();
		int itemNo = lineDAO.selectAlreadyInsertOrder(customerId, orderItem.getProduct().getId());
		if (itemNo != 0) {
			if (itemDAO.update(3, itemNo, customerId) == 0)
				throw new ModifyException("기존구매상품의 isrefund값을 수정하지 못했습니다.");
			Date startDate = itemDAO.selectEndDate(itemNo, customerId);
			validDate = startDate.getTime();
			System.out.println(validDate);
		} else {
			validDate = System.currentTimeMillis();
		}

		validDate += (long) product.getValidDate() * 24 * 60 * 60 * 1000;
		Date endDate = new Date(validDate);
		orderItem.setEndDate(endDate);

		OrderLine orderLine = orderItem.getOrderLine();
		orderLine.setTotalPrice(product.getPrice());
		orderItem.setOrderLine(orderLine);

		lineDAO.insert(orderItem);
	}

	/**
	 * 반품 전 주문내역의 총금액을 알아오기 위해 주문번호로 총결제금액을 알아온다.
	 * 
	 * @param lineNo : 주문번호
	 * @param prodId : 반품상품의 아이디
	 * @throws SQLException
	 */
	public static void update(int lineNo, String prodId) throws SQLException {
		int beforePrice = lineDAO.selectBylLineNo(lineNo).getTotalPrice();
		int prodPrice = prodDAO.selectById(prodId).getPrice();
		int totalPrice = beforePrice - prodPrice;
		int result = lineDAO.update(lineNo, totalPrice);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");
	}

	public static OrderLine selectByLineNo(int lineNo) throws SQLException {
		return lineDAO.selectBylLineNo(lineNo);
	}

	public static List<OrderItem> selectByCustomerId(String customerId) throws SQLException {
		return lineDAO.selectByCustomerId(customerId);
	}
}
