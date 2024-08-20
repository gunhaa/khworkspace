package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;

public interface BoardService2 {

	int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException;
 
	/** 게시글 수정
	 * @param board
	 * @param filePath
	 * @param images
	 * @param webPath
	 * @param deleteList
	 * @return rowCount
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int boardUpdate(Board board, String filePath, List<MultipartFile> images, String webPath, String deleteList) throws IllegalStateException, IOException;

	/** 게시글 삭제
	 * @param board
	 * @return result
	 */
	int boardDelete(Board board);

}
