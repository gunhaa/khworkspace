package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.BoardDAO2;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;
import edu.kh.project.board.model.exception.BoardDeleteException;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.board.model.exception.ImageDeleteException;
import edu.kh.project.common.utility.Util;

@Service
public class BoardServiceImpl2 implements BoardService2 {

	
	@Autowired
	private BoardDAO2 dao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath) throws IllegalStateException, IOException {
		
		// 0. 시퀀스 조회
		
		// 1. Board 테이블에 INSERT(제목, 내용, 작성자, 게시판코드)
		// -> boardNo(시퀀스로 생성한 번호) 반환 받기
		
		int boardNo = dao.boardInsert(board);
		
		// 2. 게시글 삽입 성공 시 
		//    업로드 된 이미지가 있다면 BOARD_IMG 테이블에 삽입하는 DAO 호출
		if(boardNo > 0) { // 게시글 삽입 성공
			
			// List<MultipartFile> images
			// -> 업로드된 파일이 담긴 객체 MultipartFile이 5개 존재
			// -> 단, 업로드된 파일이 없어도 MultipartFile 객체는 존재
			
//			for (MultipartFile file : images) {
//				
//				if(file.getSize() > 0) {
//					
//				}
//			
//			}

			// 실제 업로드된 파일의 정보를 기록할 List
			List<BoardImage> uploadList = new ArrayList<BoardImage>();
			
			// images에 담겨있는 파일 중 실제 업로드된 파일만 분류
			for(int i=0; i<images.size(); i++) {
				
				// i번째 요소에 업로드한 파일이 있다면
				if(images.get(i).getSize()>0) {
					
					BoardImage img = new BoardImage();
					
					//img에 파일 정보를 담아서 uploadList에 추가
					img.setImagePath(webPath); // 웹 접근 경로
					
					
					img.setBoardNo(boardNo); // 게시글 번호
					img.setImageOrder(i); // 이미지 순서
					
					// 파일 원본명
					String fileName = images.get(i).getOriginalFilename();
					img.setImageOriginal(fileName); // 원본 파일 이름
					img.setImageReName(Util.fileRename(fileName)); // 변경명
 					
					uploadList.add(img);
				}
				
			} // 분류 for문 종료
			
			// 분류 작업 후 uploadList가 비어있지 않은 경우
			// == 업로드한 파일이 있다.
			if(!uploadList.isEmpty()) {
				
				// BOARD_IMG 테이블에 INSERT하는 DAO 호출
				int result = dao.insertImageList(uploadList);
				// result == 삽입된 행의 개수 == uploadList.size();

				// == 전체 insert 성공
				if(result == uploadList.size()) {
					
					// 서버에 파일 저장(transferTo())

					// images : 실제로 파일이 담긴 객체 리스트
					//          (업로드 안된 인덱스 빈칸)
					
					// uploadList : 업로드 된 파일의 정보 리스트
					//              (원본명, 변경명, 순서, 경로, 게시글 번호)
					
					// 순서 == images 업로드 된 인덱스 번호
					for(int i=0; i<uploadList.size(); i++) {
						
						// 변경된 파일명
						String rename = uploadList.get(i).getImageReName();
						int index = uploadList.get(i).getImageOrder();
						
						images.get(index).transferTo(new File(filePath+rename));;
						
					}
					
					
				}else {// 일부 또는 전체 insert 실패
					// * 웹 서비스 수행 중 1개라도 실패하면 전체 실패 *
					// -> rollback 필요하다
					
					//	@Transactional(rollbackFor = Exception.class)
					//  -> 예외가 발생해야지만 롤백
					
					// [결론] 
					// 예외를 강제로 발생시켜서 rollback 해야함
					// -> 사용자 정의 예외 생성
					
					throw new FileUploadException(); // 예외 강제 발생
					
				}
			}
			
		}
		
		return boardNo;
	}

	/**
	 * 게시글 수정 서비스
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int boardUpdate(Board board, String filePath, List<MultipartFile> images, String webPath,
			String deleteList) throws IllegalStateException, IOException {
		
		// 1. 게시글 제목/내용만 수정
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		int rowCount = dao.boardUpdate(board);
		
		// 2. 게시글 부분이 수정 성공 했을 때
		if(rowCount>0) {
			
			
			if(!deleteList.equals("")) { //삭제 할 이미지가 있을 경우
				
				// 3. deleteList에 작성된 이미지 모두 삭제
				
				Map<String, Object> deleteMap = new HashMap<String, Object>();
				
				deleteMap.put("boardNo", board.getBoardNo());
				deleteMap.put("deleteList", deleteList);
				
				
				
				rowCount = dao.imageDelete(deleteMap);
				
				if(rowCount == 0) { // 이미지 삭제 실패시 전체 롤백
									// -> 예외 강제로 발생
					throw new ImageDeleteException();
				}
			} //안쪽 if문 끝
			
			
			// 4. 새로 업로드 된 이미지 분류 작업
			//images : 실제로 파일이 담긴 List
			//         -> input type="file" 개수 만큼 요소 존재
			//         -> 제출된 파일이 없어도 MultipartFile 객체는 존재
			
			// images에 담겨있는 파일 중 실제로 업로드된 파일만 분류
			List<BoardImage> uploadList = new ArrayList<BoardImage>();

			for(int i=0; i<images.size(); i++) {
				
				// i번째 요소에 업로드한 파일이 있다면
				if(images.get(i).getSize()>0) {
					
					BoardImage img = new BoardImage();
					
					//img에 파일 정보를 담아서 uploadList에 추가
					img.setImagePath(webPath); // 웹 접근 경로
					
					
					img.setBoardNo(board.getBoardNo()); // 게시글 번호
					img.setImageOrder(i); // 이미지 순서
					
					// 파일 원본명
					String fileName = images.get(i).getOriginalFilename();
					img.setImageOriginal(fileName); // 원본 파일 이름
					img.setImageReName(Util.fileRename(fileName)); // 변경명
 					
					uploadList.add(img);
					
					// 오라클은 다중 UPDATE를 지원하지 않기 때문에
					// 하나씩 UPDATE 수행
					
					rowCount = dao.imageUpdate(img);
					
					if(rowCount==0) {
						// 수정 실패 == DB에 이미지가 없었다
						// -> INSERT 진행
						rowCount = dao.imageInsert(img);
					}
					

				}
				
			} // 분류 for문 끝
			
			// 5. uploadList에 있는 이미지들만 서버에 저장 (transferTo())
		
			if(!uploadList.isEmpty()) {
				for(int i=0; i<uploadList.size(); i++) {
					
					String rename = uploadList.get(i).getImageReName();
					int index = uploadList.get(i).getImageOrder();
					
					images.get(index).transferTo(new File(filePath+rename));
					
				}
			}
			
		}
		
		
		return rowCount;
	}

	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int boardDelete(Board board) {
		
		int result = dao.boardDelete(board);
		
		if(result==0) {
			throw new BoardDeleteException();
		}
		
		return result;
	}

	
	
	
}
