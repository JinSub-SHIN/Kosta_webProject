package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Teacher;

public interface TeacherDAO {
	/**
	 * 강사정보전체조회
	 */
	List<Teacher> selectAll() throws SQLException;
	
	/**
	 * 강사명으로 조회
	 */
	Teacher selectByName(String teacherName) throws SQLException;
}
