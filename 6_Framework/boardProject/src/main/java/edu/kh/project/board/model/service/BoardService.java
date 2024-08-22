package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	/** 게시판 종류 목록 조회 반환
	 * @return boardTypeList
	 */
	List<Map<String, Object>> selectBoardTypeList();

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);

	
	/**게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board selectBoard(Map<String, Object> map);

	
	
	int boardLikeCheck(Map<String, Object> map);

	
	int boardLikeInsert(Map<String, Integer> paramMap);

	
	int boardLikeDelete(Map<String, Integer> paramMap);

	
	int countBoardLike(Map<String, Integer> paramMap);

	
	int updateReadCount(int boardNo);

	
	/** 게시글 조회 검색
	 * @param paramMap
	 * @param cp
	 * @return boardList
	 */
	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);

	
}
