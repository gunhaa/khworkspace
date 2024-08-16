package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시판 종류 목록 조회
	 * @return boardTypeList
	 */
	public List<Map<String, Object>> selectBoardTypeList() {
		return sqlSession.selectList("boardMapper.selectBoardTypeList");
	}

	/**
	 * @param boardCode
	 * @return
	 */
	public int getListCount(int boardCode) {
		return sqlSession.selectOne("boardMapper.getListCount", boardCode);
	}

	/** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
	 * @param boardCode
	 * @param pagination
	 * @return boardList
	 */
	public List<Board> selectBoardList(int boardCode, Pagination pagination) {
		
		// RowBounds 객체
		// - 마이바티스에서 페이징 처리를 위해서 제공하는 객체
		// - offset만큼 건너뛰고 그 다음지정된 행의 갯수(limit) 만큼 조회
		
		// 1) offset 계산
		int offset = (pagination.getCurrentPage()-1)*pagination.getLimit();
		
		// 2) RowBounds 객체 생성
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		
		// 3) selectList("namespace.id값" , boardCode, rowBounds)
		return sqlSession.selectList("boardMapper.selectBoardList" , boardCode, rowBounds);
	}

	
	/** 게시글 상세 조회
	 * @param map
	 * @return Board
	 */
	public Board selectBoard(Map<String, Object> map) {

		return sqlSession.selectOne("boardMapper.selectBoard" , map);
	}

	/** 좋아요 조회
	 * @param map
	 * @return
	 */
	public int boardLikeCheck(Map<String, Object> map) {
		return sqlSession.selectOne("boardMapper.boardLikeCheck" , map);
	}

	public int boardLikeInsert(Map<String, Integer> paramMap) {
		return sqlSession.insert("boardMapper.boardLikeInsert" , paramMap);
	}

	public int boardLikeDelete(Map<String, Integer> paramMap) {
		return sqlSession.delete("boardMapper.boardLikeDelete" , paramMap);
	}

	public int countBoardLike(Map<String, Integer> paramMap) {
		return sqlSession.selectOne("boardMapper.countBoardLike" , paramMap);
	}
	
	public int updateReadCount(int boardNo) {
		return sqlSession.update("boardMapper.updateReadCount" , boardNo);
	}
}
