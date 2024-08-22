package edu.kh.project.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.BoardDAO;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public List<Map<String, Object>> selectBoardTypeList() {
		return dao.selectBoardTypeList();
	}

	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		
		
		// 1. 특정 게시판의 삭제되지 않은 게시글 수 조회

		int listCount = dao.getListCount(boardCode);
//		System.out.println(listCount);
		// 2. 1번에서 조회 해온 결과 + cp를 이용해서 Pagination 객체 생성
		Pagination pagination = new Pagination(cp, listCount);
//		System.out.println(pagination);
		// 3. 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
		// 특정 게시판 : boardCode 
		// 현재 페이지 : pagination.currentPage
		// 게시글 몇 개 : pagination.limit
		
		List<Board> boardList = dao.selectBoardList(boardCode, pagination);
		
		// 4. pagination, boardList를 Map에 담아서 반환
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	
	
	@Override
	public Board selectBoard(Map<String, Object> map) {
		
		return dao.selectBoard(map);
	}
	
	@Override
	public int boardLikeCheck(Map<String, Object> map) {
		return dao.boardLikeCheck(map);
	}

	
	
	@Override
	public int boardLikeInsert(Map<String, Integer> paramMap) {
		return dao.boardLikeInsert(paramMap);
	}

	@Override
	public int boardLikeDelete(Map<String, Integer> paramMap) {
		return dao.boardLikeDelete(paramMap);
	}

	@Override
	public int countBoardLike(Map<String, Integer> paramMap) {
		return dao.countBoardLike(paramMap);
	}

	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateReadCount(int boardNo) {
		return  dao.updateReadCount(boardNo);
	}

	// 게시글 목록 조회(검색)
	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp) {

		// 1. 특정게시판의 삭제되지 않고 검색 조건이 일치하는 게시글 수 조회
		// "key" 랑 "query" 가 추가적으로 전달됨 "boardCode" 도 존재
		int listCount = dao.getListCount(paramMap);
		
		// 2. 1번 조회 결과 + cp 이용해서 Pagination 객체 생성
		Pagination pagination = new Pagination(cp, listCount);
		// 3. 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
		// + 단, 검색 조건이 일치하는 글만
		
		List<Board> boardList = dao.selectBoardList(paramMap, pagination);
		
		// 4. pagination, boardList를 Map에 담아서 반환
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

}




