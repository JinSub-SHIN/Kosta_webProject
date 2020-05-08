package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Customer;
import model.domain.Person;

public interface PersonDAO {
	/**
	 * 이름, 핸드폰번호에 해당하는 아이디 검색
	 */
	String selectByNameAndPhone(String name, String phone) throws SQLException;
	
	/**
	 * id, 이름, 폰에 해당하는 비밀번호 검색
	 */
	String selectByIdAndNameAndPhone(String id, String name, String phone) throws SQLException;
	
	Person selectByIdAndPwd(String id, String pwd) throws SQLException;
	
	/**
	 * 회원or강사 정보수정(비밀번호, 전화번호
	 */
	 int update(Person person) throws SQLException;
	 
	 /**
	  * 회원탈퇴기능(상태값 변경)
	  */
	 int updateStatus(String personId) throws SQLException;
	 
	 /**
	  * 불량회원 강제탈퇴기능(상태값 변경) - 관리자
	  */
	 int updateStatus(String adminId, String customerId) throws SQLException;
	 /**
	  * 강사, 관리자 등록 - 관리자
	  */
	 int insert(Person person) throws SQLException;
	 
	 /**
	  *  관리자 상세정보 가져오기...
	  */	 
	 Person selectAdminById(String id) throws SQLException;
	 
	 /**
	  * id에 해당하는 person 검색
	  */
	 Person selectById(String id) throws SQLException;
}
