package edu.kh.community.board.model.service;
import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.community.board.model.dao.ReplyDAO;
import edu.kh.community.board.model.vo.Reply;


public class ReplyService {

	private ReplyDAO dao = new ReplyDAO();

	
	
	
	public List<Reply> selectReplyList(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Reply> replyList = dao.selectReplyList(boardNo,conn);
		
		close(conn);
		
		return replyList;
	}

}
