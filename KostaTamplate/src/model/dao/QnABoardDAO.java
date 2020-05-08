package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.QnABoard;

public interface QnABoardDAO {
	/**
	 * 게시물 등록
	 */
	int insert(QnABoard qaBoard) throws SQLException;
	
	/**
	 * 게시물 수정(글내용만)
	 */
	int update(int qaBoardNo, String content) throws SQLException;
	
	/**
	 * 게시물 삭제
	 */
	int delete(int qaBoardNo) throws SQLException;	
	
	/**
	 * 내글에 해당하는 글을 전부 조회한다.	
	 */
	List<QnABoard> selectById(String id) throws SQLException;
	
	/**
	 *  전체글조회
	 */	
	List<QnABoard> selectAll() throws SQLException;
		
	/**
	 * (내용 or 제목으로 조회) 키워드조회
	 */
	List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException;
	
	/**
	 * 게시글 상세보기
	 */
	QnABoard selectByNo(int no) throws SQLException;
	
	/**
	 * 조회 수 업데이트
	 */
	int addViewCount(int no) throws SQLException;
	
	/**
	 * 답변 등록
	 * @throws SQLException 
	 */
	int insertAnswer(String subject, String title, String prodId, int parentNumber, String id) throws SQLException;
}
