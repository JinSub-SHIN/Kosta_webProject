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

import model.dao.CartDAO;
import model.domain.Cart;
import model.domain.Product;
import model.domain.Teacher;
import util.DbUtil;

public class CartDAOImpl implements CartDAO {

	Properties pro = new Properties();

	public CartDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Cart> selectAll(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cart> list = new ArrayList<Cart>();
		String sql = pro.getProperty("selectCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getInt("prod_price"), rs.getString("description"));
				
				Teacher teacher = new Teacher();
				teacher.setName(rs.getString("name"));
				
				product.setTeacher(teacher);
				
				Cart cart = new Cart();
				cart.setCartNo(rs.getInt("cart_no"));
				cart.setProduct(product);
				
				list.add(cart);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public int checkCart(String customerId, String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("checkCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, prodId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(String customerId, String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, prodId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int delete(String customerId, String prodId) throws SQLException {
		System.out.println("daoImpl called..");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("deleteCart");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, prodId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int deleteAll(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("deleteAllCart");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			result = ps.executeUpdate(sql);
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
}
