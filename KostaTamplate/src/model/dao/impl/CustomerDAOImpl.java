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

import model.dao.CustomerDAO;
import model.domain.Customer;
import util.DbUtil;

public class CustomerDAOImpl implements CustomerDAO {

	Properties pro = new Properties();

	public CustomerDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * regdate, coupon, howtocome 3가지 입력받을지 말지 결정필요
	 */
	public int insert(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int result = 0;
		String sql1 = pro.getProperty("insertPerson2");
		String sql2 = pro.getProperty("insertCustomer");
		/**
		 * insertPerson2=insert into person (id, pwd, name, phone, gender, status) values (?,?,?,?,?,1)
		 * insertCustomer=insert into customer (user_id, age, email, regdate, coupon, howtocome) 
		 * values (?, ?, ?, sysdate, null, null)
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql1);

			ps.setString(1, customer.getId());
			ps.setString(2, customer.getPwd());
			ps.setString(3, customer.getName());
			ps.setString(4, customer.getPhone());
			ps.setString(5, customer.getGender());

			result = ps.executeUpdate();
			
			if(customer.getId()!=null) {
				ps1 = con.prepareStatement(sql2);
				
				ps1.setString(1, customer.getId());
				ps1.setInt(2, customer.getAge());
				ps1.setString(3, customer.getEmail());
				result = ps1.executeUpdate();
			}
			System.out.println(result);
		
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	
	
	@Override
	public int updatePwd(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updatePwd");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pwd);
			ps.setString(2, id);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int update(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = pro.getProperty("updateCustomer");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, customer.getEmail());
			ps.setString(1, customer.getId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int idCheck(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = pro.getProperty("selectIdChk");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				result = 1;
			}
			
			//admin 포함되어있는지 확인
			/*String str = rs.getString(id);
			str.toLowerCase();
			boolean flag = str.contains("admin");
			if(flag==true) {
				result  = 1;
			}*/
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

	@Override
	/**
	 * customer와 person 둘다 한곳에서 출력할지 결정필요
	 */
	public List<Customer> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = pro.getProperty("selectAllCustomer");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				Customer customer = new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("gender"), rs.getInt("status"), rs.getInt("age"),
						rs.getString("email"), rs.getString("coupon"), rs.getString("howToCome"),
						rs.getDate("regDate"));

				list.add(customer);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	/**
	 * 출력할 리턴에 person까지 포함시켜서 리턴할지 결정
	 */
	public Customer selectById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		String sql = pro.getProperty("selectCustomer");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("gender"), rs.getInt("status"), rs.getInt("age"),
						rs.getString("email"), rs.getString("coupon"), rs.getString("howToCome"),
						rs.getDate("regDate"));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return customer;
	}

}
