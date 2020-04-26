package model.dao;

import java.sql.SQLException;

import model.domain.Person;

public interface PersonDAO {
	/**
	 * 회원or강사 정보수정(비밀번호, 전화번호, 상태(가입or탈퇴회원)
	 */
	 int update(Person person) throws SQLException;
}
