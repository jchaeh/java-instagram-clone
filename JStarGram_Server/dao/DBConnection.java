package com.jstargram.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	// MySQL 접속 정보
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jstargram?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	private static final String DB_ID = "root"; // 아이디 (보통 root)
	
	private static final String DB_PW = "password";  //  본인의 MySQL 비밀번호 
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결 시도
			conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			System.out.println("[DB 연결 성공]");
			
		} catch (Exception e) {
			System.out.println("[DB 연결 실패] 드라이버가 없거나, ID/PW가 틀렸습니다.");
			System.out.println("에러 메시지: " + e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}
}
