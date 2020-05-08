package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import exception.AddException;
import model.dao.OrderItemDAO;
import model.dao.OrderLineDAO;
import model.domain.Customer;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import model.domain.Teacher;
import util.DbUtil;

public class OrderLineDAOImpl implements OrderLineDAO {

	Properties pro = new Properties();

	public OrderLineDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderLine> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderLine> list = new ArrayList<OrderLine>();
		String sql = pro.getProperty("selectLines");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("user_id"));

				OrderLine orderLine = new OrderLine(rs.getInt("order_no"), rs.getInt("total_price"),
						rs.getDate("pay_date"), customer);

				list.add(orderLine);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int selectAlreadyInsertOrder(String customerId, String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int itemNo = 0;
		String sql = pro.getProperty("selectAlreadyInsertOrder");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, prodId);
			rs = ps.executeQuery();
			if(rs.next()) {
				itemNo = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return itemNo;
	}

	@Override
	public void insert(OrderItem orderItem) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int lineNo = 0;
		// 테이블 : OrderLine, OrderItem
		// 트랜잭션 시작, Connection의 autoCommit을 해제
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);

			String sql = pro.getProperty("makeOrderNo");
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				lineNo = rs.getInt(1);
			}
			OrderLine orderLine = orderItem.getOrderLine();
			orderLine.setLineNo(lineNo);
			orderItem.setOrderLine(orderLine);

			if (insert(con, orderItem.getOrderLine()) != 0) {
				OrderItemDAO itemDAO = new OrderItemDAOImpl();
				if (itemDAO.insert(con, orderItem) != 0) {
					// 트랜잭션 완료
					con.commit();
				}
			}
		} catch (Exception e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
					throw new AddException(e1.getMessage());
				}
			}
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			DbUtil.dbClose(con, null);
		}
	}

//	publi void insertEst() {
//		String sql="insert 1";
//		String sql="insert i";
//		try {
//			con = Dbutiol.getConection();
//			con.setAutoCommit(false);
//			
//			con.prepareSatement(sql);
//			
//			result = ps.executeUpdate();
//			
//			if(result>0) {
//				con.prepareSatement(sql2);
//				
//				
//				result = ps.executeUpdate();
//			    if(result>0) con.commit();
//			    else com.rollback();
//			}
//			
//			
//		}catch(Exception e) {
//			com.rollback();
//		}finally {
//			com.rollback();
//			
//			닫기
//		}
//		
//		
//	}

	@Override
	public int insert(Connection con, OrderLine orderLine) throws SQLException {
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertLine");

		try {

			ps = con.prepareStatement(sql);

			ps.setInt(1, orderLine.getLineNo());
			ps.setInt(2, orderLine.getTotalPrice());
			ps.setString(3, orderLine.getCustomer().getId());

			result = ps.executeUpdate();
			if (result == 0)
				throw new SQLException();

		} finally {
			DbUtil.dbClose(null, ps);
		}
		return result;
	}

	@Override
	public int update(int lineNo, int totalPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateLine");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, totalPrice);
			ps.setInt(2, lineNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public OrderLine selectBylLineNo(int lineNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderLine orderLine = null;
		String sql = pro.getProperty("selectLineByLineNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, lineNo);
			rs = ps.executeQuery();

			Customer customer = new Customer();

			if (rs.next()) {
				orderLine = new OrderLine(rs.getInt(lineNo), rs.getInt("total"), rs.getDate("payDate"), customer);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return orderLine;
	}

	@Override
	public List<OrderItem> selectByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderItem> list = new ArrayList<OrderItem>();
		String sql = pro.getProperty("selectMyOrderList");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(customerId);

				OrderLine orderLine = new OrderLine(rs.getInt("order_no"), rs.getInt("total_price"),
						rs.getDate("pay_date"), customer);

				Teacher teacher = new Teacher();
				teacher.setName(rs.getString("name"));

				Product product = new Product();
				product.setId(rs.getString("prod_id"));
				product.setName(rs.getString("prod_name"));
				product.setPrice(rs.getInt("prod_price"));
				product.setTeacher(teacher);

				OrderItem orderItem = new OrderItem();
				orderItem.setItemNo(rs.getInt("orderitem_no"));
				orderItem.setOrderLine(orderLine);
				orderItem.setProduct(product);
				orderItem.setEndDate(rs.getDate("end_date"));
				orderItem.setIsRefund(rs.getInt("isrefund"));

				list.add(orderItem);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public OrderItem selectMyLecture(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderItem orderItem = null;
		String sql = pro.getProperty("selectMyOrderList");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			if (rs.next()) {
				Customer customer = new Customer();
				customer.setId(customerId);

				OrderLine orderLine = new OrderLine(rs.getInt("order_no"), rs.getInt("total_price"),
						rs.getDate("pay_date"), customer);

				Teacher teacher = new Teacher();
				teacher.setName(rs.getString("name"));

				Product product = new Product();
				product.setName(rs.getString("prod_name"));
				product.setTeacher(teacher);

				orderItem = new OrderItem();
				orderItem.setItemNo(rs.getInt("orderitem_no"));
				orderItem.setOrderLine(orderLine);
				orderItem.setProduct(product);
				orderItem.setEndDate(rs.getDate("end_date"));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return orderItem;
	}

}
