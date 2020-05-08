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

import model.dao.TeacherDAO;
import model.domain.Category;
import model.domain.Teacher;
import util.DbUtil;

public class TeacherDAOImpl implements TeacherDAO {

	Properties pro = new Properties();

	public TeacherDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "SELECT * FROM TEACHER JOIN PERSON P on TEACHER.TEACHER_ID = P.ID";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));

				Teacher teacher = new Teacher(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("gender"), rs.getInt("status"), category, rs.getString("PICTURE_NAME"));
				
				list.add(teacher);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public Teacher selectByName(String teacherName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher teacher = null;
		String sql = pro.getProperty("selectTeacherByName");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, teacherName);
			rs = ps.executeQuery();
			if (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));

				teacher = new Teacher();
						//(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						//rs.getString("phone"), rs.getString("gender"), rs.getInt("status"), category);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return teacher;
	}
	
	
	@Override
	public int insert(Teacher teacher) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO TEACHER(TEACHER_ID, CATEGORY_ID, PICTURE_NAME) VALUES (?,?,?)";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, teacher.getId());
			ps.setInt(2, teacher.getCategory().getId());
			ps.setString(3, teacher.getPictureName());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
		
	}	
	
}
