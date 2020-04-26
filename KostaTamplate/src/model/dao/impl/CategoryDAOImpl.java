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
		//sqlQuery.properties파일을 로딩하기
		InputStream input = getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Category category) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = pro.getProperty("insertCate");
		/**
		 * insertCate=insert into category (category_id, category_name) 
		 * values (cate_seq.nextval, ?)
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, category.getName());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<Teacher> selectById(int categoryId) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = pro.getProperty("selectteacherbyid");
		/**
		 * selectteacherbyid = select * from teacher t join category c on
		 * t.category_id = c.category_id where category_id = ?
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);		
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Category category = new Category(rs.getInt("id"),rs.getString("name"));
				
				Teacher teacher = new Teacher(category);
				
				list.add(teacher);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
