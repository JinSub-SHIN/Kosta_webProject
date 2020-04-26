package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dao.OrderItemDAO;
import model.domain.OrderItem;
import util.DbUtil;

public class OrderItemDAOImpl implements OrderItemDAO {

Properties pro = new Properties();
	
	public OrderItemDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<OrderItem> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrderItem> list = new ArrayList<OrderItem>();
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
				
				OrderItem orderItem = new OrderItem();
				
				list.add(orderItem);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(List<OrderItem> list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		OrderItem orderItem = new OrderItem();
		String sql = pro.getProperty("");
		/**
		 * insertItem=insert into orderitem (orderitem_no, end_date, order_no, 
		 * prod_id, isrefund) values (orderItem_seq.nextval, ?, ?, ?, 0)
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setDate(1, (Date) orderItem.getEndDate());
			ps.setInt(2, orderItem.getOrderLine().getLineNo());
			ps.setString(3, orderItem.getProduct().getId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(List<OrderItem> list) throws SQLException {
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

}
