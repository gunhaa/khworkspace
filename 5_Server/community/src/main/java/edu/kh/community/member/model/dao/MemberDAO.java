package edu.kh.community.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static edu.kh.community.common.JDBCTemplate.*;

import edu.kh.community.member.model.vo.Member;

public class MemberDAO {

	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public MemberDAO() {
		
		try {
			
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/community/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @param conn
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception {
		
		Member loginMember = null;
		
		try {
		
			//sql 얻어오기
			String sql = prop.getProperty("login");
			
			//PreparedStatement 생성 및 SQL 적재
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			
			//SQL 수행
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember=new Member();
				
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
		        loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
		        loginMember.setMemberNickname(rs.getString("MEMBER_NICK"));
		        loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
		        loginMember.setMemberAddress(rs.getString("MEMBER_ADDR"));
		        loginMember.setProfileImage(rs.getString("PROFILE_IMG"));
		        loginMember.setEnrollDate(rs.getString("ENROLL_DT"));
				
			}

			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember; //null 또는 Member 객체 주소
	}


	/** 회원 가입 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberNickname());
			pstmt.setString(4, mem.getMemberTel());
			pstmt.setString(5, mem.getMemberAddress());
			result = pstmt.executeUpdate();
			
			
		} finally {

			close(pstmt);
		}
		
		
		return result;
	}


	public int update(Connection conn, Member mem) throws Exception {
		int result = 0;
		
		try {
			
			
			String sql = prop.getProperty("update");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberNickname());
			pstmt.setString(2, mem.getMemberTel());
			pstmt.setString(3, mem.getMemberAddress());
			pstmt.setInt(4, mem.getMemberNo());
			
			
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	/**
	 * @param mem
	 * @param currentPw
	 * @param newPw
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, Member mem, String currentPw, String newPw) throws Exception {
		
		int result =0;
		
		try {
			
			String sql = prop.getProperty("changePw");
			
			pstmt = conn.prepareStatement(sql);
//			UPDATE MEMBER SET MEMBER_PW='암호화된 새 비밀번호' WHERE MEMBER_PW='암호화된 기존 비밀번호' AND MEMBER_NO='로그인한 회원 번호'
			//세팅
			
			pstmt.setString(1, newPw);
			pstmt.setString(2, currentPw);
			pstmt.setInt(3, mem.getMemberNo());
			
			
			result =pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
