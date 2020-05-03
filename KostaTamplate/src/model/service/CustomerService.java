package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.AddException;
import exception.DuplicatedException;
import model.dao.CustomerDAO;
import model.dao.PersonDAO;
import model.dao.impl.CustomerDAOImpl;
import model.dao.impl.PersonDAOImpl;
import model.domain.Customer;
import model.domain.Person;

public class CustomerService {
	private static CustomerDAO customerDAO = new CustomerDAOImpl();
	private static PersonDAO personDAO = new PersonDAOImpl();

	/**
	 * CustomerDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	public static List<Customer> selectAll() throws SQLException {
		List<Customer> list = customerDAO.selectAll();
		return list;
	}

	/**
	 * CustomerDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	public static void insert(Customer customer) throws Exception {
		
		int result = customerDAO.insert(customer);
		if (result == 0)
			throw new AddException("등록되지 않았습니다.");
	}
	
	/**
	 * CustomerDAOImpl의 id 체크하는 메소드호출
	 */
	public static int idCheck(String id) throws Exception{
		int result = customerDAO.idCheck(id);
		
		return result;
	}

	/**
	 * CustomerDAOImpl의 Id에 해당하는 레코드 검색하는 메소드 호출
	 */
	public static Customer selectById(String id) throws SQLException {

		Customer dbcus = customerDAO.selectById(id);
		if (dbcus == null)
			throw new SQLException("Id에 해당하는 정보를 검색할수 없습니다.");

		return dbcus;
	}

	/**
	 * id에 해당하는 회원정보수정
	 */
	public static void update(Customer customer) throws SQLException {
		int result = personDAO.update(customer);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");

		result = customerDAO.update(customer);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");

	}

	/**
	 * 회원탈퇴
	 */
	public static void withdrawal(String id) throws SQLException {
		int result = personDAO.updateStatus(id);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");
	}

	/**
	 * 이름과 전화번호로 id찾기
	 */
	public static String findId(String name, String phone) throws SQLException {
		String id = personDAO.selectByNameAndPhone(name, phone);
		if (id == null)
			throw new SQLException("해당 정보가 없습니다");

		return id;
	}

	/**
	 * id 이름 전화번호로 패스워드 찾기
	 */
	public static String findPwd(String id, String name, String phone) throws SQLException {
		String pwd = personDAO.selectByIdAndNameAndPhone(id, name, phone);

		if (pwd == null) {
			throw new SQLException("해당 정보가 없습니다");
		}
		return pwd;
	}
}