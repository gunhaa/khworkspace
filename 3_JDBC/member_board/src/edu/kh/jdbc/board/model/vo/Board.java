package edu.kh.jdbc.board.model.vo;

import java.sql.Date;
import java.util.List;

//VO(Value Object) : 값 저장용 객체
// * 꼭 테이블과 같은 모양일 필요는 없다.
// -> 어떤 데이터를 저장하여 옮기고 싶은지에 따라 필드 구성이 달라짐
public class Board {

	//게시글 목록 조회
	private int boardNo;
	private String boardTitle;
	private Date createDate;
	private int readCount;
	private String memberName;
	private int replyCount;

	// 게시글 상세 조회
	private List<Reply> replyList;
	private String boardContent;

	//게시글 수정, 삭제
	private int memberNo;

	// 목록/검색용 생성자





	public Board() {
		super();
	}
	public Board(int boardNo, String boardTitle, Date createDate, int readCount, String memberName, String boardContent,
			int memberNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.readCount = readCount;
		this.memberName = memberName;
		this.boardContent = boardContent;
		this.memberNo = memberNo;
	}
	public Board(int boardNo, String boardTitle, Date createDate, int readCount, String memberName, int replyCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.readCount = readCount;
		this.memberName = memberName;
		this.replyCount = replyCount;
	}
	public Board(int boardNo, String boardTitle, Date createDate, int readCount,  int replyCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.readCount = readCount;
		this.replyCount = replyCount;
	}
	@Override
	public String toString() {


		System.out.println();
		System.out.println();
		System.out.println("");

		return String.format("--------------------------------------------------------------------\n"+
				"      글번호  ||       게시글     ||   작성일    ||   작성자  || 조회수       \n"+
				"--------------------------------------------------------------------\n" +
				" %8s %15s [%1s]    %10s  %8s     %1s\n 내용 : \n%30s ", getBoardNo() , getBoardTitle(), getReplyCount(),getCreateDate(),getMemberName(),getReadCount() ,getBoardContent()  );
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



}
