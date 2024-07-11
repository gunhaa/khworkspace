package edu.kh.community.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Reply;
import edu.kh.community.member.model.dao.MemberDAO;

import static edu.kh.community.common.JDBCTemplate.*;

public class ReplyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReplyDAO() {
		
		try {
			
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/community/sql/reply-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Reply> selectReplyList(int boardNo, Connection conn) throws Exception {
		
		List<Reply> replyList= new ArrayList<>();
		try {
			
			
			String sql = prop.getProperty("selectReplyList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply();	
				
				reply.setReplyNo(rs.getInt(1));
				reply.setReplyContent(rs.getString(2));
				reply.setCreateDate(rs.getString(3));
				reply.setMemberNick(rs.getString(4));
				reply.setMemberNo(rs.getInt(5));
				reply.setMemberNo(rs.getInt(6));
				reply.setProfileImage(rs.getString(7));
				
				replyList.add(reply);
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return replyList;
	}

}
