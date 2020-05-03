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

import model.dao.CategoryDAO;
import model.domain.Category;
import model.domain.Teacher;
import util.DbUtil;

public class CategoryDAOImpl implements CategoryDAO {

	Properties pro = new Properties();

	public CategoryDAOImpl() {
		// sqlQuery.properties파일을 로딩하기
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean nameCheck(String categoryName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = pro.getProperty("nameCheckCate");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("category_name").equals(categoryName))
					result = true;
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public int insert(String categoryName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertCate");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, categoryName);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<Teacher> selectById(int categoryId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = pro.getProperty("selectTeacherByCateId");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category(categoryId, rs.getString("category_name"));
				
				Teacher teacher = new Teacher();
				teacher.setCategory(category);
				
				teacher.setName(rs.getString("name"));

				list.add(teacher);
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public List<Category> selectAll() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		
		String sql = "SELECT * FROM CATEGORY ORDER BY CATEGORY_ID ASC";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
				
				list.add(category);
				
			}
			
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		
		return list;
	}

}
