package model.service;

import java.sql.SQLException;
import java.util.List;

import exception.DuplicatedException;
import model.dao.CategoryDAO;
import model.dao.impl.CategoryDAOImpl;
import model.domain.Category;
import model.domain.Teacher;

public class CategoryService {

	static CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	public static void insert(String categoryName) throws Exception{
		if(categoryDAO.nameCheck(categoryName)) {
			throw new DuplicatedException("이미 존재하는 카테고리입니다.");
		}
		int result = categoryDAO.insert(categoryName);
		if(result==0) {
			throw new SQLException("카테고리 추가에 실패했습니다");
		}
	}
	
	public static List<Teacher> selectById(int categoryid) throws SQLException{
		return categoryDAO.selectById(categoryid);
	}
	
	/*
	 *  Category 객체 모두 가져온다.
	 */
	public static List<Category> selectAll() throws SQLException{
		
		return categoryDAO.selectAll();
		
	}
	
	
	
}
