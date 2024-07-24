package edu.kh.community.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
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
				board.setThumbnail(rs.getString("THUMBNAIL"));
				
				boardList.add(board);
			}
			
			
		} finally {
			
		}
		
		
		return boardList;
	}

	/** 게시글 상세 조회
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo, Connection conn) throws Exception {
		
		BoardDetail detail = new BoardDetail();
		
		try {
			
			String sql = prop.getProperty("selectBoardDetail");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				detail.setBoardNo(rs.getInt(1));
				detail.setBoardTitle(rs.getString(2));
				detail.setBoardContent(rs.getString(3));
				detail.setCreateDate(rs.getString(4));
				detail.setUpdateDate(rs.getString(5));
				detail.setReadCount(rs.getInt(6));
				detail.setMemberNickname(rs.getString(7));
				detail.setProfileImage(rs.getString(8));
				detail.setMemberNo(rs.getInt(9));
				detail.setBoardName(rs.getString(10));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return detail;
	}

	/**
	 * @param boardNo
	 * @param conn
	 * @return imageList
	 * @throws Exception
	 */
	public List<BoardImage> selectBoardImg(int boardNo, Connection conn) throws Exception {

		List<BoardImage> imageList = new ArrayList<>();

		try {
			
			String sql = prop.getProperty("selectBoardImg");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardImage image= new BoardImage();
				image.setImageNo(rs.getInt(1));
				image.setImageRename(rs.getString(2));
				image.setImageOriginal(rs.getString(3));
				image.setImageLevel(rs.getInt(4));
				image.setBoardNo(rs.getInt(5));
				
				imageList.add(image);
				
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return imageList;
	}

	/** 다음 게시글 번호 조회
	 * @param conn
	 * @return nextBoardNo 
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception {
		
		int nextBoardNo = 0;
		try {
			String sql = prop.getProperty("nextBoardNo");
			
			stmt=conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				nextBoardNo=rs.getInt(1);
			}
			
		} finally {
			close(stmt);
			close(rs);
		}
		
		return nextBoardNo;
	}

	/**
	 * @param conn
	 * @param detail
	 * @param boardCode
	 * @return result
	 * @throws exception
	 */
	public int insertBoard(Connection conn, BoardDetail detail, int boardCode) throws Exception {
		
		int result =0; 
		try {
			
	         String sql = prop.getProperty("insertBoard");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, detail.getBoardNo());
	         pstmt.setString(2, detail.getBoardTitle());
	         pstmt.setString(3, detail.getBoardContent());
	         pstmt.setInt(4, detail.getMemberNo());
	         pstmt.setInt(5, boardCode);
	         
	         result = pstmt.executeUpdate();

			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 이미지 삽입 서비스
	 * @param conn
	 * @param image
	 * @return result
	 * @throws Exception
	 */
	public int insertBoardImage(Connection conn, BoardImage image) throws Exception {
		
		int result = 0;
		
		try {
	         String sql = prop.getProperty("insertBoardImage");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, image.getImageRename());
	         pstmt.setString(2, image.getImageOriginal());
	         pstmt.setInt(3, image.getImageLevel());
	         pstmt.setInt(4, image.getBoardNo());
	         
	         result = pstmt.executeUpdate();

			
		} finally {
			close(pstmt);
		}
				
		
		
		return result;
	}
	
	
	/** 게시판 삭제
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteBoard");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 내용 수정 제목/내용
	 * @param conn
	 * @param detail
	 * @return result
	 */
	public int updateBoard(Connection conn, BoardDetail detail) throws SQLException {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateBoard");
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, detail.getBoardTitle());
			pstmt.setString(2, detail.getBoardContent());
			pstmt.setInt(3, detail.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 게시글 사진 파일 수정
	 * @param conn
	 * @param img
	 * @return result
	 */
	public int updateBoardImage(Connection conn, BoardImage img) throws SQLException{
		
		int result = 0;
		try {
			
			String sql = prop.getProperty("updateBoardImage");
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, img.getImageRename());
			pstmt.setString(2, img.getImageOriginal());
			pstmt.setInt(3, img.getImageLevel());
			pstmt.setInt(4, img.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} finally{
			close(pstmt);
		}
		
		return result;
	}

	/** 게시글 수정- 이미지 삭제
	 * @param conn
	 * @param deleteList
	 * @param boardNo
	 * @return result
	 */
	public int deleteBoardImage(Connection conn, String deleteList, int boardNo) throws SQLException {
		
		int result = 0;
		
		try {
								// 완성되지 않은 SQL
			String sql = prop.getProperty("deleteBoardImage")+deleteList+")";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result=pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 특정 게시판에서 조건을 만족하는 게시글 수 조회 DAO
	 * @param type
	 * @param conn
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int searchListCount(int type, Connection conn, String condition) throws Exception {
		int listCount = 0;

		try {
			

			String sql = prop.getProperty("searchListCount") + condition;
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	/** 특정 게시판에서 조건을 만족하는 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param type
	 * @param condition
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchBoardList(Connection conn, Pagination pagination, int type, String condition) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			
			String sql = prop.getProperty("searchBoardList-a")+condition+prop.getProperty("searchBoardList-b");
			
			int start = (pagination.getCurrentPage()-1) * pagination.getLimit()+1;
	
			int end = start + pagination.getLimit()-1;
			
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickname(rs.getString("MEMBER_NICK"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setThumbnail(rs.getString("THUMBNAIL"));
				
				boardList.add(board);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}
	
}
