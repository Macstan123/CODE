package infordb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import DBManager.DBhelper;

public class BorrowDBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/library?&serverTimezone=UTC&useSSL=false";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String DriverClassName = "com.mysql.cj.jdbc.Driver";

	/**
	 * 根据学生id，在图书借阅表中查询所有图书id
	 * 
	 * @return book_id[]
	 */
	public static String[] getBookInfoByid(int user_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] book_id = new String[10];
		try {
			conn = DBhelper.getConnection(URL, USERNAME,PASSWORD);
			String sql = "select book_id from book_borrow where user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
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
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
			DBhelper.closeResultSet(rs);
		}
		return book_id;
	}

	/**
	 * 根据id，增加学生借阅信息
	 */
	public static void addBorrowInfoByids(String user_id, String book_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBhelper.getConnection(URL,USERNAME, PASSWORD);
			String sql = "insert into book_borrow (book_id,user_id,borrow_time) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			// 主键自增
			ps.setString(1, book_id);
			ps.setString(2, user_id);
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			int insertCount = ps.executeUpdate();
			// System.out.println(DBhelper.isSuccess(insertCount));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
		}
	}

}
