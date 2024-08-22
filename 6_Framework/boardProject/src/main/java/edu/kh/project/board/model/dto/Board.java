package edu.kh.project.board.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	   
	   private int boardNo;
	   private String boardTitle;
	   private String boardContent;
	   private String boardCreateDate;
	   private String boardUpdateDate;
	   private int readCount;
	   private int boardCode;
	   
	   private String boardName;
	   
	   // 서브쿼리
	   private int commentCount; // 댓글 수
	   private int likeCount;    // 좋아요 수
	   
	   // 회원 join
	   private String memberNickname; 
	   private int memberNo;
	   private String profileImage;
	   private String thumbnail;
	   
	   // 이미지 목록
	   private List<BoardImage> imageList;
	   
	   // 댓글 목록
	   private List<Comment> commentList;


	}
