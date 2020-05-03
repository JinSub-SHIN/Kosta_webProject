package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.QnABoardDAO;
import model.dao.impl.QnABoardDAOImpl;
import model.domain.QnABoard;

public class QnAService {
	static QnABoardDAO qaDAO = new QnABoardDAOImpl();
	
	/**
	 * 게시글 등록
	 */
	public static int insert(QnABoard qaBoard) throws SQLException{
		return qaDAO.insert(qaBoard);
	}
	
	/**
	 * 게시글 삭제
	 * @param 게시글 번호
	 */
	public static int delete(int qaBoardNo) throws SQLException{
		return qaDAO.delete(qaBoardNo);
	}
	
	/**
	 * 게시글 내용 수정
	 */
	public static int update(int qaBoardNo, String content) throws SQLException{
		return qaDAO.update(qaBoardNo, content);
		
	}
		
	/**
	 * 전체 게시글 조회
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectAll() throws SQLException {
		return qaDAO.selectAll();
		
	}
	
	/**
	 * 내가 쓴 게시글 조회
	 * @param id
	 * @throws SQLException 
	 */
	public static List<QnABoard> selectById(String id) throws SQLException {
		return qaDAO.selectById(id);
		
	}
	
	public static List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		return qaDAO.selectByKeyword(keyField, keyword);
	}

	public static QnABoard selectByNo(int no) throws SQLException {
		return qaDAO.selectByNo(no);	
	}
}
