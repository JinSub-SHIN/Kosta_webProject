package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.PersonDAO;
import model.dao.TeacherDAO;
import model.dao.impl.PersonDAOImpl;
import model.dao.impl.TeacherDAOImpl;
import model.domain.Person;
import model.domain.Teacher;

public class TeacherService {
	private static TeacherDAO teacherDAO = new TeacherDAOImpl();
	private static PersonDAO personDAO = new PersonDAOImpl();

	/**
	 * TeacherDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	public static List<Teacher> selectAll() throws SQLException {
		List<Teacher> list = teacherDAO.selectAll();
		return list;
	}

	/**
	 * TeacherDAOImpl의 이름에 해당하는 레코드 검색하는 메소드 호출
	 */
	public static Teacher selectByName(String teacherName) throws SQLException {

		Teacher dbTea = teacherDAO.selectByName(teacherName);
		if (dbTea == null)
			throw new SQLException("해당하는 정보를 검색할수 없습니다.");

		return dbTea;
	}

	public static void update(Person teacher) throws SQLException {
		int result = personDAO.update(teacher);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");
	}
}
