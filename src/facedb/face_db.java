package facedb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBManager.DBhelper;


public class face_db {
	/**
	 * ���ݷ��ص�token(string)�Ƚ����ݿ��е�token,����token��ͬʱ���id(û�ҵ��򷵻�404)
	 * */
	public String compare_token(String a) {
		    Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String id="404";
	        try {
	            conn = DBManager.DBhelper.getConnection(DBManager.DBhelper.URL,
	            		DBManager.DBhelper.USERNAME, DBManager.DBhelper.PASSWORD);
	            String sql = "select name_id from face_infor where face_token = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, a);
	            rs = ps.executeQuery();	 
	            if(rs.next()){
	            	id = (rs.getString("name_id"));
	            	}	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	DBManager.DBhelper.closeConnection(conn);
	        	DBManager.DBhelper.closePreparedStatement(ps);
	        	DBManager.DBhelper.closeResultSet(rs);
	        }
	        return id;
	}
	
	/**
	 * ����name_id��ѯѧ��ע��ͼƬurl
     * @param token
     * @return �Ƿ�ɹ���ѯ��(-1Ϊʧ�ܣ�
     */
    public static String getStuphById(String name_id) {
    	 Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String url=null;
	        try {
	            conn = DBManager.DBhelper.getConnection(DBManager.DBhelper.URL,
	            		DBManager.DBhelper.USERNAME, DBManager.DBhelper.PASSWORD);
	            String sql = "select image_url from face_infor where name_id = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, name_id);
	            rs = ps.executeQuery();	 
	            if(rs.next()){
	            	url = (rs.getString("image_url"));
	            	}	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	DBManager.DBhelper.closeConnection(conn);
	        	DBManager.DBhelper.closePreparedStatement(ps);
	        	DBManager.DBhelper.closeResultSet(rs);
	        }
	        return url;
    }

}
