package edu.kh.community.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.Pagination;
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

	/**
	 * @param type
	 * @param conn
	 * @return 
	 */
	public String selectBoardName(int type, Connection conn) throws Exception {
		
		String boardName = null;

		try {
			
			String sql = prop.getProperty("selectBoardName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				boardName = rs.getString(1);
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return boardName;
	}

	public int getListCount(int type, Connection conn) throws Exception {
		
		int result = 0;
		
		try {
			
			
			String sql = prop.getProperty("getListCount");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 특정 게시판에서 일정한 범위의 목록을 조회 DAO
	 * @param conn
	 * @param type
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, int type, Pagination pagination) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectBoardList");
			// BETWEEN에 들어갈 범위 계산
			int start = (pagination.getCurrentPage()-1) * pagination.getLimit()+1;

			int end = start + pagination.getLimit()-1;
			
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickname(rs.getString("MEMBER_NICK"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				
				boardList.add(board);
			}
			
			
		} finally {
			
		}
		
		
		return boardList;
	}
}
