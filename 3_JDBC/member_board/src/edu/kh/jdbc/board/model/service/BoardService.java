package edu.kh.jdbc.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.management.remote.JMXConnectorServerMBean;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;

// import static : static 필드 / 메소드 호출 시 클래스명 생략
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;
import edu.kh.jdbc.common.JDBCTemplate;
// * 기호 : 모두, 전부(ALL)
import edu.kh.jdbc.member.model.vo.Member;


public class BoardService {

	BoardDAO dao = new BoardDAO();


	/** 게시글 목록 조회 Service
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAll() throws Exception {

		List<Board> boardList = new ArrayList<>();		
		// 1) Connection 생성
		Connection conn = getConnection();
		// 2) DAO 메소드 (SELECT) 호출 후 결과 반환 받고
		boardList = dao.selectAll(conn);
		// 3)Connetction 반환
		close(conn);
		// 4) DAO 수행 결과 View에 반환
		return boardList;
	}


	/**게시글 상세 조회
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selctOne(int boardNo) throws Exception {

		// 1) Connection 생성
		Connection conn = getConnection();
		// 2) 특정 게시글 상세 조회 DAO메소드 호출 후 결과 반환 빋기
		Board board = dao.selectOne(conn , boardNo);

		if(board != null) { //게시글 상세 조회 내용이 있을 경우에만 
			//3-1) 특정 게시글 댓글 목록 조회 DAO 메소드 호출 후 결과 반환 받기
			List<Reply> replyList = dao.selectReplyList(boardNo,conn);
			//Board 객체의 replyList필드에 조회한 댓글 목록 세팅

			board.setReplyList(replyList);

			// 3-2 게시글 증가 DAO메소드(UPDATE) 호출 후 (성공한 행의 개수) 반환 받기
			int result = dao.increaseReadCount(conn, boardNo);
			
			// 트랜잭션 제어 처리 + 조회수 동기화
			if(result > 0 ) {
				commit(conn);
				
				// 업데이트 전에 게시글 정보를 조회했기 때문에
				// 조회된 게시글 조회수가 DB의 조회수보다 1낮다.
				// -> 조회된 게시글의 조회수를 +1시켜서 DB와 동기화
				board.setReadCount(board.getReadCount()+1);
			} else {
				rollback(conn);
			}

		}

		//4) 사용한 connection 반환
		close(conn);
		//5) DAO 수행 결과 View로 반환
		return board;//게시글 상세 조회 + 댓글 목록
	}


	/** 게시글 삭제 Service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleterBoard(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(boardNo, conn);
		
		if(result > 0 ) {
			commit(conn);

		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}


	/** 게시글 수정
	 * @param boardNo
	 * @param boardTitle
	 * @param boardContent
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(int boardNo,String boardTitle,String boardContent)  throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateBoard(conn, boardNo,boardTitle, boardContent);
		
		if(result > 0 ) {
			commit(conn);

		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	/** 댓글 삽입 service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception{
		
		Connection conn = getConnection();
		int result = dao.insertReply(conn, reply);
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}


	public int updateReply(String replyContent,int replyNo) throws Exception{
		
		Connection conn = getConnection();
		int result = dao.updateReply(conn, replyContent,replyNo);
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int deleteReply(int replyNo) throws Exception {

		Connection conn = getConnection();
		int result = dao.deleteReply(conn , replyNo);
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		
		close(conn);
		return result;
	}


	public int insertBoard(Board board) throws Exception{
		
		Connection conn = getConnection();
		int result = dao.insertBoard(conn, board);
		
		
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}		
		close(conn);
		return result;
	}


	
	
	public List<Board> titleSearch(int menuNum, String keyword) throws Exception {
	
		Connection conn = getConnection();
		
		List<Board> boardList = dao.titleSearch(conn, menuNum, keyword);
		

		close(conn);
		
		return boardList;
	}






}
