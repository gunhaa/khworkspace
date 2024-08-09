package edu.kh.project.board.model.dto;


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
public class Comment {
	
	private int commentNo;
    private String commentContent;
    private String commentCreateDate;
    private int boardNo;
    private int memberNo;
    private String commentDeleteFlag;
    private int parentNo;
    private String memberNickname;
    private String profileImage;

}
