package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dao.QnABoardDAO;
import model.domain.QnABoard;
import util.DbUtil;

public class QnABoardDAOImpl implements QnABoardDAO {
	Properties pro = new Properties();

	public QnABoardDAOImpl() {
		InputStream input = getClass().getClassLoader().getResourceAsStream("model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(QnABoard qaBoard) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insertQnA");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, qaBoard.getSubject());
			ps.setString(2, qaBoard.getTitle());
			ps.setString(3, qaBoard.getProduct().getId());
			ps.setString(4, qaBoard.getCustomer().getId());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(int qaBoardNo, String content) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("updateQnA");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, qaBoardNo);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int qaBoardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("");
		/**
		 * deleteQnA=delete from qnaboard where sequence=?
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, qaBoardNo);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<QnABoard> selectByName(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoard> list = new ArrayList<QnABoard>();
		String sql = pro.getProperty("");
		/**
		 * selectQnAById=select * from QnAboard where id=? order by sequence desc;
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {

				QnABoard qnABoard = new QnABoard();

				list.add(qnABoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<QnABoard> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoard> list = new ArrayList<QnABoard>();
		String sql = pro.getProperty("");
		/**
		 * selectAllQnA=select * from QnAboard order by sequence desc;
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QnABoard qnABoard = new QnABoard();

				list.add(qnABoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<QnABoard> selectByKeyword(String keyField, String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoard> list = new ArrayList<QnABoard>();
		String sql = pro.getProperty("");
		/**
		 * selectQnABySub=select * from QnAboard where subject LIKE ? order by sequence
		 * desc;
		 * 
		 * selectQnAByTitle=select * from QnAboard where title LIKE ? order by sequence
		 * desc;
		 */
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QnABoard qnABoard = new QnABoard();

				list.add(qnABoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
