package edu.kh.community.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardImage {

	private int imageNo;
	private String imageRename;
	private String imageOriginal;
	private int imageLevel;
	private int boardNo;
	
	
}
