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
public class BoardImage {
	   private int imageNo;
	   private String imagePath;
	   private String imageReName;
	   private String imageOriginal;
	   private int imageOrder;
	   private int boardNo;
}
