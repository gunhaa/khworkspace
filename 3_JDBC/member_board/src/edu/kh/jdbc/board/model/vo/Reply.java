package edu.kh.jdbc.board.model.vo;

import java.sql.Date;
import java.util.List;

public class Reply {
	
	//게시글 목록 조회
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private int memberNo;
	private int boardNo;
	private String memberName;
	

	
	
	public Reply(int replyNo, String replyContent, Date createDate, int memberNo, int boardNo, String memberName) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.memberNo = memberNo;
		this.boardNo = boardNo;
		this.memberName = memberName;
	}
	public Reply() {
		super();
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return String.format("댓글번호:%2s | %10s | 글번호 : %2s 작성자 %2s번 이름: %4s \n %20s\n", getReplyNo() ,  getCreateDate(), getBoardNo(),getMemberNo(),getMemberName(), getReplyContent());
	}

	/*
	@Override
	public String toString() {
		return String.format("댓글번호:%2s | %10s | %10s | 글번호 : %2s 작성자 %2s번 이름: %4s", getReplyNo() , getReplyContent(),  getCreateDate(), getBoardNo(),getMemberNo(),getMemberName());
	}
	*/
	
	
}
