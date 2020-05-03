package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import model.dao.EstimateBoardDAO;
import model.domain.Customer;
import model.domain.EstimateBoard;
import model.domain.Product;
import model.domain.QnABoard;
import util.DbUtil;

public class EstimateBoardDAOImpl implements EstimateBoardDAO {

	Properties pro = new Properties();

	public EstimateBoardDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(EstimateBoard estimate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertEst");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, estimate.getSubject());
			ps.setString(2, estimate.getCustomer().getId());
			ps.setString(3, estimate.getProduct().getId());
			ps.setInt(4, estimate.getGrade());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(EstimateBoard estimate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, estimate.getSubject());
			ps.setInt(2, estimate.getGrade());
			ps.setInt(3, estimate.getEstimateNo());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<EstimateBoard> selectByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EstimateBoard> list = new ArrayList<EstimateBoard>();
		String sql = pro.getProperty("selectEstByCustomerId");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(customerId);

				Product product = new Product();
				product.setId(rs.getString("prod_id"));

				EstimateBoard estBoard = new EstimateBoard(rs.getInt("sequence"), rs.getString("subject"), customer,
						product, rs.getDate("writeday"), rs.getInt("grade"));

				list.add(estBoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<EstimateBoard> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EstimateBoard> list = new ArrayList<EstimateBoard>();
		String sql = pro.getProperty("selectAllEst");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("user_id"));

				Product product = new Product();
				product.setId(rs.getString("prod_id"));
				product.setName(rs.getString("prod_name"));
				
				EstimateBoard estBoard = new EstimateBoard(rs.getInt("sequence"), rs.getString("subject"), customer,
						product, rs.getDate("writeday"), rs.getInt("grade"));
				System.out.println("impl:"+estBoard);
				list.add(estBoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int delete(int estimateNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = pro.getProperty("deleteEst");
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, estimateNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<EstimateBoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EstimateBoard> list = new ArrayList<EstimateBoard>();
		String sql ="";
		
		if("prod".equals(keyField)) {
			sql = pro.getProperty("selectEstByProdName");
		} else if("teacher".equals(keyField)) {
			sql = pro.getProperty("selectEstByTeacherName");
		} else if("grade".equals(keyField)) {
			sql = pro.getProperty("selectEstByGrade");
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, keyField);
			if("grade".equals(keyField)) {
				ps.setInt(2, Integer.parseInt(keyword));
			}else {
				ps.setString(2, keyword);				
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("user_id"));

				Product product = new Product();
				product.setId(rs.getString("prod_id"));

				EstimateBoard estBoard = new EstimateBoard(rs.getInt("sequence"), rs.getString("subject"), customer,
						product, rs.getDate("writeday"), rs.getInt("grade"));
				
				list.add(estBoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public EstimateBoard selectByNo(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EstimateBoard estBoard=null;
		String sql = pro.getProperty("selectEstByNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("user_id"));
				
				Product product = new Product();
				product.setId(rs.getString("prod_id"));
				product.setName(rs.getString("prod_name"));
				
				estBoard = new EstimateBoard(rs.getInt("sequence"), rs.getString("subject"), customer
						,product , rs.getDate("writeday"), rs.getInt("grade"));
				}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return estBoard;
	}

}
