package edu.kh.jdbc.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;

import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;
import edu.kh.jdbc.common.JDBCTemplate;

public class BoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop = new Properties();
	// Map인데 k,v가 모두 String , 외부 XML파일 입출력 특화

	//memberDao 기본 생성자
	public BoardDAO() {
		//MemberDAO객체 생성시
		//member-sql.xml파일의 내용을 읽어와서 
		//properties 객체 생성

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}



	public List<Board> selectAll(Connection conn) throws Exception {

		List<Board> boardList = new ArrayList<>();		

		try {

			//1) sql 작성
			String sql = prop.getProperty("selectAll");
			//2) statement 생성
			stmt = conn.createStatement();
			//3) sql 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			//4) ResultSet에 한 행씩 접근
			while(rs.next()) {
				// 5) 해당 행에서 컬럼명을 이용해 컬럼 값 얻어오기
				int board_no = rs.getInt("BOARD_NO");
				String board_title = rs.getString("BOARD_TITLE");
				Date create_date = rs.getDate("CREATE_DATE");
				int read_count = rs.getInt("READ_COUNT");
				String member_nm = rs.getString("MEMBER_NM");
				int reply_count = rs.getInt("REPLY_COUNT");
				// 6) Board 객체를 생성하여 컬럼 값 담기
				Board board = new Board(board_no, board_title, create_date, read_count, member_nm,reply_count);
				// 7) Board 객체를 boardList에 추가
				boardList.add(board);

			}


		} finally {
			close(rs);
			close(stmt);
		}





		return boardList;
	}



	public Board selectOne(Connection conn , int boardNo) throws Exception {

		Board board = null;

		try {

			String sql = prop.getProperty("selectOne");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				int board_no = rs.getInt("BOARD_NO");
				String board_title = rs.getString("BOARD_TITLE");
				String board_content = rs.getString("BOARD_CONTENT");
				Date create_date = rs.getDate("CREATE_DATE");			
				int read_count = rs.getInt("READ_COUNT");
				int member_no = rs.getInt("MEMBER_NO");
				String member_nm = rs.getString("MEMBER_NM");			
				// int boardNo = rs.getInt("BOARD_NO");
				//-> 입력 받은 boardNo와 조회된 BOARD_NO는 같은 값이므로
				// 굳이 db조회 결과에서 얻어오지않아도 된다.
				board = new Board(board_no,board_title,create_date,read_count,member_nm,board_content,member_no);
				// set을 이용한 방법으로도 가능하다.

			}

		} finally {
			close(rs);
			close(pstmt);
		}


		return board;
	}



	public List<Reply> selectReplyList(int boardNo, Connection conn) throws Exception {


		List<Reply> replyList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectReplyList");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1,boardNo);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				int replyNo = rs.getInt("REPLY_NO");
				String replyContent = rs.getString("REPLY_CONTENT");
				Date createDate=rs.getDate("CREATE_DATE");
				int memberNo=rs.getInt("MEMBER_NO");
				String memberNm=rs.getString("MEMBER_NM");
				// + boardNo
				Reply reply = new Reply(replyNo, replyContent, createDate,memberNo,boardNo, memberNm);
				replyList.add(reply);
			}



		} finally {
			close(rs);
			close(pstmt);
		}


		return replyList;

	}



	public int increaseReadCount(Connection conn, int boardNo) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("increaseReadCount");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();


		} finally {
			close(pstmt);
		}


		return result;
	}



	/** 게시글 삭제 DAO
	 * @param boardNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo, Connection conn) throws Exception {
		int result = 0 ;

		try {
			String sql = prop.getProperty("deleteBoard");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}



	public int updateBoard(Connection conn , int boardNo, String boardTitle, String boardContent) throws Exception {
		int result =0;

		try {

			String sql = prop.getProperty("updateBoard");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);

			result = pstmt.executeUpdate();

		}finally {
			close(pstmt);
		}

		return result;
	}



	public int insertReply(Connection conn, Reply reply) throws Exception{
		int result = 0;

		try {
			String sql = prop.getProperty("insertReply");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
			
			result =pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}



	public int updateReply(Connection conn,String replyContent, int replyNo) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateReply");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,replyContent);
			pstmt.setInt(2,replyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



	public int deleteReply(Connection conn, int replyNo) throws Exception {
		int result = 0;
		try {
			
			String sql = prop.getProperty("deleteReply");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public int insertBoard(Connection conn, Board board) throws Exception {
		int result = 0 ;
		
		try {
			
			String sql = prop.getProperty("insertBoard");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public List<Board> titleSearch(Connection conn, int menuNum, String keyword) throws Exception {

		List<Board> boardList = new ArrayList<>();		

		try {
			//SQL 작성(menuNum에 따라서 SQL 조합)
			String sql = prop.getProperty("searchBoard1")+prop.getProperty("condition"+menuNum)+prop.getProperty("searchBoard2");
			
			pstmt = conn.prepareStatement(sql);
			
			// 위치 홀더에 알맞은 값 세팅
			//*주의*
			// -> 제목+내용을 검색하는 조건은 혼자만 위치홀더가 2개!!
			pstmt.setString(1, keyword);	
			
			if(menuNum==3) {
				pstmt.setString(2, keyword);
			} 
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int board_no = rs.getInt("BOARD_NO");
				String board_title = rs.getString("BOARD_TITLE");
				Date create_date = rs.getDate("CREATE_DATE");
				int read_count = rs.getInt("READ_COUNT");
				String member_nm = rs.getString("MEMBER_NM");
				Board board = new Board();
				board.setBoardNo(board_no);
				board.setBoardTitle(board_title);
				board.setCreateDate(create_date);
				board.setReadCount(read_count);
				board.setMemberName(member_nm);
				
				boardList.add(board);				
				
			}
			
			
			
		}finally {
			close(pstmt);
		}
		
		
		return boardList;
	}

}
