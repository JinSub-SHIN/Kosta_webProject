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

import model.dao.ProductDetailDAO;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import model.domain.ProductDetail;
import model.domain.Storage;
import util.DbUtil;

public class ProductDetailDAOImpl implements ProductDetailDAO {

	Properties pro = new Properties();

	public ProductDetailDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(ProductDetail productDetail) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertProdDetail");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDetail.getProduct().getId());
			ps.setString(2, productDetail.getStorage().getId());
			ps.setString(3, productDetail.getUrl());
			ps.setString(4, productDetail.getTitle());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(ProductDetail productDetail) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateProdDetail");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDetail.getStorage().getId());
			ps.setString(2, productDetail.getProduct().getId());
			ps.setString(3, productDetail.getChapter());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(String prodId, String chapter) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("deleteProdDetail");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			ps.setString(2, chapter);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<ProductDetail> selectAll(String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDetail> list = new ArrayList<ProductDetail>();
		String sql = pro.getProperty("selectProdDetail");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(prodId);
				product.setName(rs.getString("prod_name"));

				Storage storage = new Storage();
				storage.setName(rs.getString("file_name"));

				ProductDetail prodDetail = new ProductDetail(rs.getString("chapter"), rs.getString("prod_url"),
						rs.getString("prod_title"), storage, product);

				list.add(prodDetail);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public OrderItem selectProdStartEndDay(String customerId, String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderItem item = null;
		String sql = pro.getProperty("selectProdStartEndDay");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			ps.setString(2, customerId);
			rs = ps.executeQuery();
			if (rs.next()) {
				OrderLine line = new OrderLine();
				line.setPayDate(rs.getDate("pay_date"));
				
				item = new OrderItem();
				item.setOrderLine(line);
				item.setEndDate(rs.getDate("end_date"));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return item;
	}

}
