package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CategoryDAO;
import model.dao.impl.CategoryDAOImpl;
import model.domain.Category;
import model.domain.Teacher;

public class CategoryService {

	static CategoryDAO dao = new CategoryDAOImpl();
	
	public static void insert(Category category) throws SQLException{
		
		int result = dao.insert(category);
		if(result==0) {
			throw new SQLException("카테고리 추가에 실패했습니다");
		}
	}
	
	public static List<Teacher> selectById(int categoryid) throws SQLException{
		List<Teacher> list = dao.selectById(categoryid);
		return list;
	}
	
	
	
}
