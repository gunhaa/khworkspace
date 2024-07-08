package edu.kh.community.board.model.dao;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.community.member.model.dao.MemberDAO;
import static edu.kh.community.common.JDBCTemplate.*;

public class BoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public BoardDAO() {
		
		try {
			
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/community/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
