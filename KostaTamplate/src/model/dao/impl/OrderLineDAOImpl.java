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

import model.dao.OrderLineDAO;
import model.domain.Customer;
import model.domain.OrderLine;
import util.DbUtil;

public class OrderLineDAOImpl implements OrderLineDAO {

Properties pro = new Properties();
	
	public OrderLineDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<OrderLine> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderLine> list = new ArrayList<OrderLine>();
		String sql = pro.getProperty("");
		/**
		 * selectOrder=select l.user_id, i.orderitem_no, i.end_date, i.order_no, 
		 * i.prod_id, i.isrefund, p.prod_name, p.prod_price from orderline l 
		 * join orderitem i on l.order_no = i.order_no join product p 
		 * on i.prod_id = p.prod_id where l.user_id=?
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderLine orderLine = new OrderLine();
				
				list.add(orderLine);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(OrderLine orderLine) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("");
		/**
		 * insertLine=insert into orderline (order_no, total_price, pay_date,
		 *  user_id) values (order_seq.nextval, ?, sysdate, ?)
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, orderLine.getTotalPrice());
			ps.setString(2, orderLine.getCustomer().getId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(int totalPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public OrderLine selectBylLineNo(int lineNo) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderLine orderLine = null;
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, lineNo);
			rs = ps.executeQuery();
			
			Customer customer = new Customer();
			
			if(rs.next()) {
				
				orderLine = new OrderLine(rs.getInt(lineNo),
						rs.getInt("total"), rs.getDate("payDate"), customer);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return orderLine;
	}


}
