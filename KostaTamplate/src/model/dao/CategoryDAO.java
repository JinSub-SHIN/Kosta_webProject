package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.Category;
import model.domain.Teacher;

public interface CategoryDAO {
	/**
	 * 카테고리추가
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int insert(Category category) throws SQLException;
	
	/**
	 * 카테고리별 강사조회(강사의 카테고리 아이디로 검색)
	 */
	List<Teacher> selectById(int categoryId) throws SQLException;
	
}
