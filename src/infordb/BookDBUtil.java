package infordb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBhelper;
import entity.Book;

public class BookDBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/library?&serverTimezone=UTC&useSSL=false";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String DriverClassName = "com.mysql.cj.jdbc.Driver";

	/**
	 * 根据学生id，在图书借阅表中查询所有图书id
	 * 
	 * @return book_id[]
	 */
	public static String[] getBookInfoByid(String user_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] book_id = new String[10];
		try {
			conn = DBhelper.getConnection(URL, USERNAME,PASSWORD);
			String sql = "select book_id from book_borrow where user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				book_id[i] = (rs.getString("book_id"));
				i++;
			}
			book_id[i] = "0";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != rs) {
					rs.close();
				}
				if (null != ps) {
					ps.close();
				}
				if (null != conn) {
					DBhelper.closeConnection(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return book_id;
	}

	/**
	 * 根据code查询书本的bookid
	 */
	public static String getBookIdByIsbn(String code) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DBhelper.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT book_id FROM book_info where book_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("book_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
			DBhelper.closeResultSet(rs);
		}
		return id;
	}

	/**
	 * 根据code查询书本的book_name
	 */
	public static String getBookNmByIsbn(String code) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = "404";
		try {
			conn = DBhelper.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT book_name FROM book_info where book_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("book_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
			DBhelper.closeResultSet(rs);
		}
		return name;
	}

	/**
	 * 根据code查询书本的book_Author
	 */
	public static String getBookAuByIsbn(String code) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String author = "404";
		try {
			conn = DBhelper.getConnection(URL, USERNAME, DBhelper.PASSWORD);
			String sql = "SELECT book_author FROM book_info where book_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				author = rs.getString("book_author");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
			DBhelper.closeResultSet(rs);
		}
		return author;
	}

	/**
	 * 根据书本的bookid查询馆藏量
	 */
	public static int getBookSavingByIsbn(String bookid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int number = -1;
		try {
			conn = DBhelper.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT book_saving FROM book_info where book_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookid);
			rs = ps.executeQuery();
			while (rs.next()) {
				number = rs.getInt("book_saving");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
			DBhelper.closeResultSet(rs);
		}
		return number;
	}

	/**
	 * 根据id使图书馆馆藏量减一
	 */
	public static void modifyBookSavingOne(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBhelper.getConnection(URL,USERNAME,PASSWORD);
			int saving = getBookSavingByIsbn(id);
			if (saving > 0) {
				String sql = "update book_info set book_saving =" + (saving - 1) + " where book_id=" + "'" + id + "'";
				ps = conn.prepareStatement(sql);
				int count = ps.executeUpdate();
				// System.out.println(DBhelper.isSuccess(count));
			} else {
				System.out.println("馆藏量为0，借阅失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
		}
	}

}
