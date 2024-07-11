package edu.kh.community.board.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {
	private int replyNo;
	private String replyContent;
	private String createDate;
	private String memberNick;
	private int boardNo;
	private int memberNo;
	private String profileImage;
}
