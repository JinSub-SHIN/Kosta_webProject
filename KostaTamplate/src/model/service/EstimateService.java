package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.EstimateBoardDAO;
import model.dao.impl.EstimateBoardDAOImpl;
import model.domain.EstimateBoard;

public class EstimateService {
	static EstimateBoardDAO dao = new EstimateBoardDAOImpl();
	
	
	/**
	 * 강의평 등록
	 * @param subject
	 * @param userId
	 * @param prodId
	 * @param parseInt
	 */
	public static void insert(String subject, String userId, String prodId, int grade) {
		try {
			dao.insert(subject, userId, prodId, grade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 강의평 삭제
	 * @param parseInt
	 */
	public static void delete(int no) {
		try {
			dao.delete(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 전체 강의평 별점 순으로 조회
	 * @return
	 */
	public static List<EstimateBoard> selectByGrade() {
		List<EstimateBoard> list=null;
		try {
			list = dao.selectByGrade();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<EstimateBoard> selectAll() {
		List<EstimateBoard> list=null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
