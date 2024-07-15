package edu.kh.community.board.model.service;
import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.community.board.model.dao.ReplyDAO;
import edu.kh.community.board.model.vo.Reply;
import edu.kh.community.common.Util;


public class ReplyService {

	private ReplyDAO dao = new ReplyDAO();

	
	
	
	public List<Reply> selectReplyList(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Reply> replyList = dao.selectReplyList(boardNo,conn);
		
		close(conn);
		
		return replyList;
	}




	public int insertReply(Reply reply) throws Exception {
		
		Connection conn = getConnection();
		
		//Cross Site Scripting(XSS, 크로스 사이트 스크립팅) 공격
		// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격. 웹 취약점 중 하나
		
		
		// - 개행 문자 변경 처리
		// textarea에 줄바꿈 문자 입력시 \n, \r, \r\n, \n\r 중 하나로 입력된다.(브라우저, OS따라 다름)
		// 이 문자들을 HTML에서 줇꿈으로 인식할 수 있도록 "<br>"태그로 변경
//		reply.getReplyContent().replaceAll("정규표현식", "바꿀 문자열");
		
		
		// 댓글 등록/수정
		// 게시글 등록/수정에서 사용
		//reply.setReplyContent(reply.getReplyContent().replaceAll("(\n|\r|\r\n|\n\r)", "<br>"));
		
		
		reply.setReplyContent(Util.XSSHandling(reply.getReplyContent())); // 순서 중요함 
		reply.setReplyContent(Util.newLineHandling(reply.getReplyContent()));
		
		int result = dao.insertReply(conn, reply);
		
		if(result==0) {
			rollback(conn);
		} else {
			commit(conn);
		}
			
			
		close(conn);
		
		return result;
	}




	/**댓글 삭제 서비스
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(int replyNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, replyNo);
		
		if(result==0) {
			rollback(conn);
		} else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}




	/** 댓글 수정 서비스
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo , String Content) throws Exception {
		
		Connection conn = getConnection();
		
		Content = Util.XSSHandling(Content);
		Content = Util.newLineHandling(Content);
		
		int result = dao.updateReply(conn, replyNo, Content);
		
		if(result==0) {
			rollback(conn);
		} else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}

}
