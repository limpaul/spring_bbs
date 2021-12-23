package com.board.www.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.board.www.bbs.dto.User;


@Component
public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private JdbcTemplate template;
	public UserDao() {
		
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
	public int login(final String userID, final String userPassword) {
		String SQL = "select userPassword from user where userID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("userPassword").equals(userPassword)) {
					return 1; // 로그인성공
				}else {
					return 0; // 비번 불일치 
				}
			}
			return -1; // 아이디가 존재 하지 않음 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2; //db오류 
	}
	public int join(final User user) {
		String SQL = "insert into user values(?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
