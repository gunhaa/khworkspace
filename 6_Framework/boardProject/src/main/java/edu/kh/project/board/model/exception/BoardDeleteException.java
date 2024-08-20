package edu.kh.project.board.model.exception;

public class BoardDeleteException extends RuntimeException {

	public BoardDeleteException() {
		super("게시글 삭제 중 예외 발생");
	}
	
	public BoardDeleteException(String message) {
		super(message);
	}
	
}
