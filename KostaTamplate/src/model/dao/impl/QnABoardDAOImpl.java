package model.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import model.dao.QnABoardDAO;
import model.domain.Customer;
import model.domain.Product;
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
			ps.setInt(5, qaBoard.getStatus());
			ps.setInt(6, qaBoard.getPwd());
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
		String sql = pro.getProperty("deleteQnA");
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
	public List<QnABoard> selectById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QnABoard> list = new ArrayList<QnABoard>();
		String sql = pro.getProperty("selectQnAById");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));

				Product product = new Product();
				product.setId(rs.getString("prod_id"));

				QnABoard qaBoard = new QnABoard();
				qaBoard.setQaBoardNo(rs.getInt("parentnumber"));

				QnABoard qnABoard = new QnABoard(rs.getInt("sequence"), rs.getString("subject"), rs.getDate("writeday"),
						customer, product, rs.getString("title"), qaBoard, rs.getInt("status"), rs.getInt("password"), rs.getInt("viewcount"));

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
		String sql = pro.getProperty("selectAllQnA");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));

				Product product = new Product();
				product.setId(rs.getString("prod_id"));

				QnABoard qaBoard = new QnABoard();
				qaBoard.setQaBoardNo(rs.getInt("parentnumber"));

				QnABoard qnABoard = new QnABoard(rs.getInt("sequence"), rs.getString("subject"), rs.getDate("writeday"),
						customer, product, rs.getString("title"), qaBoard, rs.getInt("status"), rs.getInt("password"), rs.getInt("viewcount"));

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
		String field = "";
		if(keyField.equals("subject")) {
			field = "selectQnABySub";
		} else {
			field = "selectQnAByTitle";			
		}
		String sql = pro.getProperty(field);
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));

				Product product = new Product();
				product.setId(rs.getString("prod_id"));

				QnABoard qaBoard = new QnABoard();
				qaBoard.setQaBoardNo(rs.getInt("parentnumber"));

				QnABoard qnABoard = new QnABoard(rs.getInt("sequence"), rs.getString("subject"), rs.getDate("writeday"),
						customer, product, rs.getString("title"), qaBoard, rs.getInt("status"), rs.getInt("password"), rs.getInt("viewcount"));

				list.add(qnABoard);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public QnABoard selectByNo(int no) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = pro.getProperty("selectQnAByNo");
		QnABoard qnaBoard=null; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				
				Product product = new Product();
				product.setId(rs.getString("prod_id"));
				
				QnABoard qna = new QnABoard();
				qnaBoard 
				= new QnABoard(rs.getInt("sequence"), rs.getString("subject"), rs.getDate("writeday")
						, customer, product, rs.getString("title"), qna, rs.getInt("status"), rs.getInt("password"), rs.getInt("viewcount"));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return qnaBoard;
	}

	@Override
	public int addViewCount(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=pro.getProperty("addViewCount");
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insertAnswer(String subject, String title, String prodId, int parentNumber, String id) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=pro.getProperty("insertAnswer");
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, subject);
			ps.setString(2, "[´äº¯]"+title);
			ps.setString(3, prodId);
			ps.setInt(4, parentNumber);
			ps.setString(5, id);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
