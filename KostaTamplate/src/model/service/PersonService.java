package model.service;

import java.sql.SQLException;

import exception.NotFoundException;
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
				
		if(person==null) throw new NotFoundException("잘못된 입력값입니다.");
		
		return person;
	}
	/**
	 * 관리자가 유저(강사, 관리자) 등록
	 * @throws SQLException 
	 */

	public static void insert(String id, String pwd, String name, String phone, String gender, int status) throws SQLException {
		int result = personDAO.insert(id, pwd, name, phone, gender, status);
		if(result == 0) {
			throw new SQLException("등록에 실패하였습니다.");
		}
	}
}
