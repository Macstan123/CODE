package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBhelper {
	public static final String URL = "jdbc:mysql://localhost:3306/face_record?&serverTimezone=UTC&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String DriverClassName = "com.mysql.cj.jdbc.Driver";
    /**
     * ע�����ݿ�����
     */
    static {
        try {
            Class.forName(DriverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * ��ȡ����Դ
     * qv
     * @throws SQLException
     */
    public static Connection getConnection(String url, String user,
            String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * �ر�����Դ
     * 
     * @throws SQLException
     */
    public static void closeConnection(Connection conn) {
        if (null != conn) {
            try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    /**
     * ���Ի�ȡ���ݿ�����
     * 
     * @throws SQLException
     */
    public static void testGetConnection() throws SQLException {
        Connection conn = getConnection(URL,
               USERNAME, PASSWORD);
        System.out.println("conn:" + conn);

    }
    
    /**
     * �ر�PreparedStatement
     * @param ps
     */
    
    public static void closePreparedStatement(PreparedStatement ps) {
    	if(null != ps) {
    		try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    /**
     * �ر�closeResultSet
     * @param rs
     */
    
    public static void closeResultSet(ResultSet rs) {
    	if(null != rs) {
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
