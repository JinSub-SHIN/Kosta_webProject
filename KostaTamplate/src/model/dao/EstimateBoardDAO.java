package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.EstimateBoard;
import model.domain.QnABoard;

public interface EstimateBoardDAO {
	/**
	 * 게시물 등록
	 */
	int insert(EstimateBoard estimate) throws SQLException;
	
	/**
	 * 게시물 수정
	 */
	int update(EstimateBoard estimate) throws SQLException;
	
	/**
	 * 게시물 삭제
	 */
	int delete(int no) throws SQLException;
	
	/**
	 * 내글에 해당하는 글을 전부 조회한다.	
	 */
	List<EstimateBoard> selectByName(String id) throws SQLException;
	
	/**
	 *  전체글조회
	 */	
	List<EstimateBoard> selectAll() throws SQLException;
		
	/**
	 * (강의명 / 강사명 / 평점 조회) 키워드조회
	 */
	List<EstimateBoard> selectByKeyword(String keyField, String keyword) throws SQLException;
	
	/**
	 * 게시물 등록
	 */
	int insert(String subject, String userId, String prodId, int grade) throws SQLException;

	int delete(EstimateBoard estimate) throws SQLException;

	List<EstimateBoard> selectByGrade() throws SQLException;
	
}
