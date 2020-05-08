package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.domain.Customer;

public interface CustomerDAO {
	/**
	 * 회원 등록
	 */
	int insert(Customer customer) throws SQLException;
	
	
	/**
	 * pwd 수정
	 */
	int updatePwd(String id, String pwd)throws SQLException;
	
	/**
	 * 회원정보수정(비밀번호, 전화번호, 이메일, 상태(가입or탈퇴회원))
	 */
	int update(Customer customer) throws SQLException;
	
	/**
	 * id 중복체크
	 * @return : true이면 중복, false이면 중복아님
	 */
	int idCheck(String id) throws SQLException;
	
	/**
	 * 회원 전체검색
	 *  : 결과 레코드가 0개이상 가능 - List
	 */
	List<Customer> selectAll() throws SQLException;
	
	/**
	 * id에 해당하는 레코드 검색
	 *  : 결과 레코드가 0 또는 1이면 Member
	 */
	Customer selectById(String id) throws SQLException;
}
