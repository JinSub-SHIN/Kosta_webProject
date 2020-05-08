package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import model.dao.ProductDAO;
import model.domain.Category;
import model.domain.EstimateBoard;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.domain.ProductDetail;
import model.domain.Teacher;
import util.DbUtil;

public class ProductDAOImpl implements ProductDAO {

	Properties pro = new Properties();

	public ProductDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertProd");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getLevel());
			ps.setString(6, product.getTeacher().getId());
			ps.setInt(7, product.getCategory().getId());
			ps.setInt(8, product.getValidDate());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateProd");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getValidDate());
			ps.setString(5, product.getId());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM PRODUCT";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString("teacher_id"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));

				teacher.setCategory(category);

				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"),
						rs.getInt("prod_price"), rs.getString("description"), rs.getString("prod_level"), teacher,
						category, rs.getDate("upload_date"), rs.getInt("valid_Date"), rs.getInt("STATUS"));

				list.add(product);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}
	
	@Override
	public int deleteProd(String id) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
		String sql = "UPDATE PRODUCT SET STATUS=2 WHERE PROD_ID=?";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			i = ps.executeUpdate();
			
		} finally {
			
			DbUtil.dbClose(con, ps);
			
		}
		return i;
	}
	
	
	
	

	@Override
	public List<Product> selectByJogun(Map<String, String> map) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM PRODUCT WHERE category_id=?";
		String keys[] = { "category", "teacher", "level" };
		int value = Integer.parseInt(map.get(keys[0]));
		String value2 = map.get(keys[1]);
		String value3 = map.get(keys[2]);

		if (value2 != null) {
			sql += " and teacher_id=?";
			if (value3 != null) {
				sql += " and prod_level=?";
			}
		}

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, value);

			if (value2 != null) {
				ps.setString(2, value2);
				if (value3 != null) {
					ps.setString(3, value3);
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString("teacher_id"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));

				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"),
						rs.getInt("prod_price"), rs.getString("description"), rs.getString("prod_level"), teacher,
						category, rs.getDate("upload_date"), rs.getInt("valid_date"));

				list.add(product);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public Product selectById(String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		String sql = pro.getProperty("selectProdById");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			rs = ps.executeQuery();

			if (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString("teacher_id"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));

				product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getInt("prod_price"),
						rs.getString("description"), rs.getString("prod_level"), teacher, category,
						rs.getDate("upload_date"), rs.getInt("valid_date"));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return product;
	}

	@Override
	public List<GangiMokRok> GangiMokRokAll() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<GangiMokRok> list = new ArrayList<GangiMokRok>();
		String sql = "select p.TEACHER_ID, T.PICTURE_NAME, p.CATEGORY_ID, CATEGORY_NAME, PROD_ID, PROD_NAME, PROD_PRICE, "
				+ "DESCRIPTION, PROD_LEVEL, UPLOAD_DATE, VALID_DATE, NAME, p.STATUS "
				+ "FROM PRODUCT p JOIN CATEGORY C2 on p.CATEGORY_ID = C2.CATEGORY_ID "
				+ "JOIN TEACHER T on p.TEACHER_ID = T.TEACHER_ID " + "JOIN PERSON pe on pe.id = t.teacher_id " 
				+ "WHERE P.STATUS=1";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString("teacher_id"));
				teacher.setPictureName(rs.getString("picture_name"));
				teacher.setName(rs.getString("name"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));

				teacher.setCategory(category);

				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"),
						rs.getInt("prod_price"), rs.getString("description"), rs.getString("prod_level"), teacher,
						category, rs.getDate("upload_date"), rs.getInt("valid_Date"), rs.getInt("STATUS"));

				GangiMokRok gangimokrok = new GangiMokRok(product, category);

				list.add(gangimokrok);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;

	}

	@Override
	public Map<EstimateBoard, ProductDetail> selectProdInfo(String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<EstimateBoard, ProductDetail> map = new HashMap<EstimateBoard, ProductDetail>();
		String sql = pro.getProperty("selectProdInfo");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			rs = ps.executeQuery();

			if (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setName(rs.getString("name"));
				
				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"),
						rs.getInt("prod_price"), rs.getString("description"));
				product.setTeacher(teacher);
				
				ProductDetail prodDetail = new ProductDetail();
				prodDetail.setProduct(product);
				prodDetail.setUrl(rs.getString("prod_url"));
				
				sql = pro.getProperty("selectProdEstInfo");
				ps = con.prepareStatement(sql);
				ps.setString(1, prodId);
				rs = ps.executeQuery();

				int count = 0;
				
				while(rs.next()) {
					count++;
					
					EstimateBoard estimate = new EstimateBoard();
					estimate.setGrade(rs.getInt("grade"));
					estimate.setSubject(rs.getString("subject"));
					estimate.setWriteDay(rs.getDate("writeday"));
					
					map.put(estimate, prodDetail);
				}
				if(count == 0) {
					EstimateBoard estimate = new EstimateBoard();
					map.put(estimate, prodDetail);
				}
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return map;
	}

	@Override
	public List<Product> selectSameCateProd(String prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = pro.getProperty("selectSameCateIdProd");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			rs = ps.executeQuery();
			if (rs.next()) {
				int cateId = rs.getInt(1);
				
				sql = pro.getProperty("selectSameCateProd");
				ps = con.prepareStatement(sql);
				ps.setInt(1, cateId);
				ps.setString(2, prodId);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Product prod = new Product();
					prod.setId(rs.getString(1));
					prod.setName(rs.getString(2));
					
					list.add(prod);
				}
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}
	
	@Override
	public List<Product> selectByTeahcerId(String id) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM PRODUCT p JOIN TEACHER T on p.TEACHER_ID = T.TEACHER_ID WHERE p.TEACHER_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				Category category = new Category(rs.getInt("CATEGORY_ID"), null);
				Teacher teacher = new Teacher(category, rs.getString("PICTURE_NAME"));
				
				Product product = new Product(rs.getString("PROD_ID"), rs.getString("PROD_NAME"), rs.getInt("PROD_PRICE"), 
						rs.getString("DESCRIPTION"), rs.getString("PROD_LEVEL"), teacher, category, 
						rs.getDate("UPLOAD_DATE"), rs.getInt("VALID_DATE"), rs.getInt("STATUS"));
				
				list.add(product);
								
			}
			
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

}
