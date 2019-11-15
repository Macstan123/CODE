package infordb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBManager.DBhelper;

public class UserDBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/library?&serverTimezone=UTC&useSSL=false";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String DriverClassName = "com.mysql.cj.jdbc.Driver";

	/**
	 * 根据密码查询学生id
	 * 
	 * @param pwd
	 * @return 是否成功查询到(-1为失败）
	 */
	public static int getStuIdByPwd(String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int Id = 0;
		try {
			conn = DBhelper.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT user_id FROM lib_student where user_pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				Id = rs.getInt("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
			DBhelper.closePreparedStatement(ps);
			DBhelper.closeResultSet(rs);
		}
		return Id;
	}

	/**
	 * 根据密码查询学生name
	 * 
	 * @param pwd
	 * @return 是否成功查询到(-1为失败）
	 */
	public static String getStuNmByPwd(String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = null;
		try {
			conn = DBhelper.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT user_name FROM lib_student where user_pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("user_name");
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

}
