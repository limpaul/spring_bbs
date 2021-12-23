package com.board.www.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.board.www.bbs.dto.Bbs;

@Component
public class BbsDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private JdbcTemplate template;
	public BbsDao() {
		
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!!");
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/bbs";
		String dbID = "root";
		String dbPassword = "1234";
		conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
		return conn;
	}
	public int write(Bbs bbs) {
		String SQL = "insert into bbs(bbsTitle, userID, bbsContent, bbsSecret, bbsAvailable) values(?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bbs.getBbsTitle());
			pstmt.setString(2, bbs.getUserID());
			pstmt.setString(3, bbs.getBbsContent());
			pstmt.setString(4, bbs.getBbsSecret());
			pstmt.setInt(5, bbs.getBbsAvailable());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public List<Bbs> getList(){
		List<Bbs> list = new ArrayList<Bbs>();
		String SQL = "select bbsID, bbsTitle, userID, bbsDate, bbsContent from bbs";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bbsID = rs.getInt("bbsID");
				String bbsTitle = rs.getString("bbsTitle");
				String userID = rs.getString("userID");
				String bbsDate = rs.getString("bbsDate");
				String bbsContent = rs.getString("bbsContent");
				Bbs bbs = new Bbs(bbsID, bbsTitle, userID, bbsDate, bbsContent);
				list.add(bbs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Bbs findById(int bbsID){
		
		String SQL = "select bbsID, bbsTitle, userID, bbsDate, bbsContent, bbsSecret from bbs where bbsID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bbsID2 = rs.getInt("bbsID");
				String bbsTitle = rs.getString("bbsTitle");
				String userID = rs.getString("userID");
				String bbsDate = rs.getString("bbsDate");
				String bbsContent = rs.getString("bbsContent");
				String bbsSecret = rs.getString("bbsSecret");
				Bbs bbs = new Bbs(bbsID2, bbsTitle, userID, bbsDate, bbsContent, bbsSecret);
				return bbs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void deleteBoard(int bbsID) {
		String SQL = "delete from bbs where bbsID = "+bbsID;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Map<String, String> findBoardById(int bbsID) {
		String SQL = "select bbsID, bbsSecret from bbs where bbsID = "+bbsID;
		Map<String, String> map = new HashMap<String, String>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("bbsID", Integer.toString(rs.getInt("bbsID")));
				map.put("bbsSecret", rs.getString("bbsSecret"));
				return map;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
