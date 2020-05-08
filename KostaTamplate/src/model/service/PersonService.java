package model.service;

import java.sql.SQLException;

import exception.NotLoginExeception;
import model.dao.PersonDAO;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;

public class PersonService {
	private static PersonDAO personDAO = new PersonDAOImpl();
	
	/**
	 * 로그인 기능
	 */
	public static Person login(String id, String pwd) throws Exception {
		Person person = personDAO.selectByIdAndPwd(id, pwd);
				
		if(person==null) throw new NotLoginExeception("아이디 혹은 비밀번호가 틀립니다.");
		
		return person;
	}
	
	/**
	 * 관리자가 유저(강사, 관리자) 등록
	 * @throws SQLException 
	 */
	public static void insert(Person person) throws SQLException {
		int result = personDAO.insert(person);
		if(result == 0) {
			throw new SQLException("등록에 실패하였습니다.");
		}
	}
	
	/**
	 *  강사id에 해당하는 강사정보를 가져온다.
	 */
	public static Person selectByTeacherid(String id) throws SQLException{
		return personDAO.selectById(id);
				
	}
	
	/**
	 * 강제탈퇴 시
	 */
	public static void updateStatus(String adminId, String customerId) throws SQLException {
		int result = personDAO.updateStatus(adminId, customerId);
		if(result == 0) {
			throw new SQLException("등록에 실패하였습니다.");
		}
	}
	
}
