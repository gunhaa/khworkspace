package edu.kh.jdbc.board.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.member.model.vo.Member;

public class BoardView {

	Scanner sc= new Scanner(System.in);

	BoardService service = new BoardService();

	/** 게시판 전용 메뉴 화면
	 * @param loginMember (로그인한 회원 정보)
	 */
	public void boardMenu(Member loginMember) {

		int menuNum = -1; 

		do {

			try {

				System.out.println("\n*****************게시판 메뉴 *********************");

				System.out.println("1. 게시글 목록 조회");
				System.out.println("2. 게시글 상세 조회(게시글 번호 입력)");
				//게시글 상세 조회 + 댓글 목록 조회

				// 게시글 작성자와 로그인한 회원이 같을 때
				// 게시글 수정(UPDATE), 게시글 삭제(DELETE)
				//댓글 삽입,수정,삭제

				System.out.println("3. 게시글 작성(INSERT)");
				
				System.out.println("4. 게시글 검색(제목/내용/제목+내용/작성자)");

				System.out.println("0. 회원 메뉴로 돌아가기");

				System.out.print("메뉴를 선택해 주세요 >> ");
				menuNum = sc.nextInt();
				sc.nextLine();

				switch(menuNum) {

				case 1:
					selectAll();
					break;
				case 2:
					selectOne(loginMember);
					break;
				case 3:
					insertBoard(loginMember.getMemberNo());
					break;
				case 4:
					titleSearch();
					break;
				case 0:
					System.out.println("회원 메뉴로 돌아갑니다.");
					break;
				default : 
					System.out.println("메뉴에 작성된 번호를 입력해주세요.");

				}


			}catch(InputMismatchException e) {

				System.out.println("\n입력 형식이 올바르지 않습니다. 다시 시도해주세요.");
				sc.nextLine();

			}


		}while(menuNum != 0);



	}











	/**
	 * 게시글 목록 조회
	 */
	private void selectAll() {

		System.out.println("[게시글 목록 조회]");

		try {

			//게시글 목록 조회 Service 호출 후 결과 반환 받기

			List<Board> boardList = new ArrayList<>();

			boardList = service.selectAll();

			if(boardList.isEmpty()) {
				System.out.println("\n [조회된 게시글이 없습니다.]\n");
			} else {
				System.out.println("--------------------------------------------------------------------");
				System.out.println("      글번호  ||       게시글     ||   작성일    ||   작성자  || 조회수       ");
				System.out.println("--------------------------------------------------------------------");
				for (Board b : boardList) {
					System.out.printf("%8s %15s [%1s]    %10s  %8s     %1s\n", b.getBoardNo() , b.getBoardTitle(), b.getReplyCount(),b.getCreateDate(),b.getMemberName(),b.getReadCount() );
				}

			}
		}catch(Exception e) {
			System.out.println("\n<게시글 목록 조회 중 예외 발생>\n");
			e.printStackTrace();
		}

	}

	/** 게시글 상세 조회
	 * @param loginMember
	 */
	private void selectOne(Member loginMember) {

		System.out.println("[게시글 상세 조회]");

		System.out.println("조회할 게시글 번호 입력 : ");

		int boardNo = sc.nextInt();
		sc.nextLine();

		try {

			//게시글 상세 조회 Service 호출 후 결과 반환
			Board board = service.selctOne(boardNo);

			if(board != null) { //조회된 게시글이 있을 경우
				System.out.println(board);

				// 댓글 목록 조회				
				for (Reply r : board.getReplyList()) {
					System.out.println(r);
				}
			}


			//--------------------------------------------------

			// 상세 조회용 메뉴 출력

			System.out.println("==== 상세 조회 메뉴 ====");

			System.out.println("1. 댓글 삽입"); //어떤 회원이든 가능
			//댓글 번호 입력 받아
			//댓글을 작성한 회원 번호 == 로그인한 회원 번호
			// -> 수정/삭제

			System.out.println("2. 댓글 수정"); 
			System.out.println("3. 댓글 삭제");
			// 댓글 번호 입력 -> 댓글이 있는지 확인 -> 해당 댓글이 로그인한 회원의 댓글인지 검사
			
			
			
			//상세 조회된 게시글의 회원 번호 == 로그인한 회원 번호
			// -> 게시글 수정/삭제

			if(loginMember.getMemberNo() == board.getMemberNo()) {

				System.out.println("4. 게시글 수정");

				System.out.println("5. 게시글 삭제");

			}

			System.out.println("0. 게시판 메뉴로 돌아가기");
			System.out.print("메뉴 선택 >> ");
			int menuNum = sc.nextInt();
			sc.nextLine();

			switch(menuNum) {
			case 0:
				System.out.println("\n 게시판 메뉴로 돌아갑니다.. \n");
				break;			
			case 1:
				insertReply(loginMember, boardNo);
				break;
			case 2: case 3: 
				
				String temp = menuNum == 2 ? "[댓글 수정]" : "[댓글 삭제]"; // 삼항연산자
				System.out.println(temp);
				
				System.out.print("댓글 번호 입력 : ");
				int replyNo = sc.nextInt();
				sc.nextLine();
				
				// 입력 받은 댓글 번호가 댓글 목록에 있는지 확인
				Reply reply = null; // 확인된 댓글을 참조할 변수
				for (Reply r : board.getReplyList()) { //반복 접근
					
					if(r.getReplyNo()==replyNo) { // 입력 받은 번호와 일치하는 댓글이 있다면
						reply = r;
						break;
					}	
				}
				if(reply == null) { //같은 댓글 번호가 목록에 없는경우
					System.out.println("\n해당 댓글이 존재하지 않습니다. \n");
				} else { // 같은 댓글 번호가 목록에 있을 경우
					// 해당 댓글의 회원 번호(작성자)와
					// 로그인한 회원의 번호가 같은지 확인
					
					if(reply.getMemberNo()==loginMember.getMemberNo()) {
					
						if(menuNum==2) {
							updateReply(replyNo); //댓글 수정
							
						}else if (menuNum==3) {
							deleteReply(replyNo); //댓글 삭제
						}
						
					} else {
						System.out.println("\n 현재 로그인한 회원의 댓글이 아닙니다. \n");

					}
					
				}
				
				
				break;

			case 4:	case 5: 

				// 게시글 작성자 번호 == 로그인한 회원 번호
				if(loginMember.getMemberNo() == board.getMemberNo()) {

					//4번
					if(menuNum ==4) {
						updateBoard(boardNo);
					}
					else { 
						//5번 게시글 삭제
						deleteBoard(boardNo);


					}

				} else {
					System.out.println("메뉴에 표시된 번호만 입력해주세요.");
				}

				break;
			default:

				break;


			}


		}catch(Exception e) {
			System.out.println("\n<게시글 상세 조회 중 예외 발생>\n");
			e.printStackTrace();
		}


	}
	








	/** 게시글 삭제
	 * @param boardNo
	 */
	private void deleteBoard(int boardNo) {
		
		// "정말 삭제 하시겠습니까? (Y/N) -- 제대로 입력 될 때 까지 무한 반복 "
		// -> "Y" 입력 시
		// -> 보안 문자 생성
		// -> 보안 문자가 일치하는 경우 삭제 진행
		System.out.println("\n[게시글 삭제]\n");
		
		
		char ch = ' ';
		while(true) {
			System.out.println("정말 삭제 하시겠습니까?(Y/N)");
			ch= sc.nextLine().toUpperCase().charAt(0);
			
			if(ch == 'Y' || ch =='N') { // Y또는 N인 경우 반복 종료
				
				break;
			} else {
				System.out.println("Y또는 N을 입력 해주세요. \n");
			}
		}
		
		if(ch == 'Y') { // 삭제를 하려고 하는 경우
			// 보안 문자 생성
			String cap = capcha();
			System.out.println("다음 보안 문자를 입력해주세요 >> " + cap);
			System.out.print("보안 문자 입력 : ");
			String input = sc.next();
			if(input.equals(cap)) { //입력 받은 문자열과 보안 문자가 같을 때
									//삭제 Service 호출
				try {
					int result = service.deleterBoard(boardNo);
					
					if(result > 0 ) {
						System.out.println(boardNo+"번 게시글이 삭제 되었습니다. ");
					} else {
						System.out.println("삭제 실패");
					}
					
					
				} catch (Exception e) {
					System.out.println("\n<게시글 삭제 도중 오류 발생?\n");
					e.printStackTrace();
				}
				
				
			} else {
				System.out.println("\n 보안 문자가 일치하지 않습니다. (삭제 취소) \n");
			}
			
		}
		
		
		
	}

	
	/** 보안 문자 생성 메소드(랜덤 영어 소문자 5개)
	 * @return
	 */
	private String capcha() {
		
		String cap = "";
		
		for(int i=0 ; i<5; i++) {
			cap += (char)((Math.random()*26)+97);
				//int 형변환 : 97 - 122
			
			
		}
		
		
		return cap;
	}
	
	
	private void updateBoard(int boardNo) {
		
		System.out.println("[게시글 수정]");
		
		System.out.println("수정할 제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.println("\n 수정할 내용(종료 시 @exit 입력) : \n");
		
		String boardContent = "";
		
		boardContent = inputContent(); //내용 입력 메소드 호출 후 결과 반환 받기

		System.out.println(boardContent);
		
		try {
			int result = service.updateBoard(boardNo, boardTitle, boardContent);
			
			if(result > 0) {
				System.out.println(boardNo + "번 게시글 수정에 성공하였습니다. \n");
			} else {
				System.out.println("수정 실패");
			}
		} catch (Exception e) {
			System.out.println("\n <수정 중 오류 발생> \n");
			e.printStackTrace();
		}
	}

	/* String(객체)
	 * - 불변성(immutable) <-> 가변성(mutable)
	 * 
	 * -> 한번 생성된 String 객체에 저장된 문자열은 변하지 않는다.
	 * 
	 * ex) String str= "abc"; // heap영역에 String 객체가 생성되고
	 * 						  // 생성된 객체에 "abc"문자열 저장
	 * 
	 *  str = "123"; 
	 *   한번 생성된 String은 문자열이 변하지 않음.
	 *  안쓰는 스트링은 garbacge collector 가 3초마다 청소한다.
	 *  ex)String str = "abc";
	 *  	str += "123";      // "123"이 저장된 String 객체 생성 후
	 *  					   // "abc"와 "123"이 합쳐진 String 객체 추가로 생성후
	 *                         // 객체 주소를 str에 대입
	 *
	 * ** String의 문제점**
	 * String에 저장된 값을 바꾸거나 누적 하려고 할 때 마다
	 * String 객체가 무분별하게 생성됨 --> 메모리 낭비(메모리 누수)
	 * 
	 * ** 해결 방법
	 * - StringBuffer / StringBuilder (가변성)클래스를 자바에서 제공함
	 * -> 사용 방법은 동일
	 * -> 차이점은 동기/비동기 차이밖에 없음
	 */
	
	
	/** 게시글/댓글 내용 입력 메소드
	 * @param boardTile
	 * @param boardContent
	 */
	private String inputContent() {
		//String content = "";
		StringBuffer content = new StringBuffer();
		//StringBuilder content = new StringBuilder -> 사용법 동일
		//@exit가 입력될 때 까지 무한히 문자열을 입력 받아
		// 하나의 변수에 누적 == 게시글 내용
		while(true) {
			String input = sc.nextLine();

			if(input.equals("@exit")) { //@exit가 입력된 경우
				break;
			} else {
				//content += input + "\n"; // 줄 바꾸면서 누적
				content.append(input);
				// content.append(input+"\n")도 가능하지만 String이 생성되는 것이라 메모리 누수가 있음
				content.append("\n");
				
				
				//append : (제일 뒤에) 덧붙이다 , 추가하다, 첨부하다.
				//StringBuffer에 저장된 문자열의 제일 뒤에 input을 추가(누적)
				
				// -> 하나의 StringBuffer객체에 문자열이 계속 누적됨(가변)
				//    == 추가적인 String 객체 생성이 없다.(String의 단점 보완)
			}
		}
		
	 return content.toString();
	 //StringBuffer에 오버라이딩 된 toString()
	 // -> 저장된 문자열을 String 형태로 반환
	}
	
	/** 댓글 작성
	 * @param loginMember
	 * @param boardNo
	 */
	public void insertReply(Member loginMember, int boardNo) {
		System.out.println("[댓글 작성]");
		
		System.out.println("댓글 내용 입력 (종료 시 @exit 입력)  : ");
		
		String replyContent="";
		
		replyContent = inputContent();
		System.out.println(replyContent);
		
		try {
			
			Reply reply = new Reply();
			reply.setBoardNo(boardNo);
			reply.setMemberNo(loginMember.getMemberNo());
			reply.setReplyContent(replyContent);
			
			int result = service.insertReply(reply);
			
			if(result >0) {
				System.out.println("댓글이 작성 되었습니다.");
			} else {
				System.out.println("댓글 작성에 실패했습니다.");
			}
			
			
		}catch(Exception e) {
			System.out.println("\n 댓글 작성 도중 오류 발생 \n");
			e.printStackTrace();
		}
		
		// 회원 번호, 게시글 번호, 댓글 내용 -> 하나의 Reply객체에 저장
		
		//댓글 삽입(Insert)service 호출 후 결과 반환 받기
		
	}


	private void updateReply(int replyNo) {
		
		System.out.println("[댓글 수정]");
		
		System.out.println("댓글 내용 입력 (종료 시 @exit 입력)  : ");
		
		String replyContent="";
		
		replyContent = inputContent();
	
		try {
			
			int result = service.updateReply(replyContent, replyNo);
			
			if(result >0) {
				System.out.println("댓글이 수정 되었습니다.");
			} else {
				System.out.println("댓글 작성에 실패했습니다.");
			}
			
			
		}catch(Exception e) {
			System.out.println("\n 댓글 작성 도중 오류 발생 \n");
			e.printStackTrace();
		}
		
	}
	

	private void deleteReply(int replyNo) {

		// "정말 삭제 하시겠습니까? (Y/N) -- 제대로 입력 될 때 까지 무한 반복 "
		// -> "Y" 입력 시
		// -> 보안 문자 생성
		// -> 보안 문자가 일치하는 경우 삭제 진행
		System.out.println("\n[댓글 삭제]\n");
		
		
		char ch = ' ';
		while(true) {
			System.out.println("정말 삭제 하시겠습니까?(Y/N)");
			ch= sc.nextLine().toUpperCase().charAt(0);
			
			if(ch == 'Y' || ch =='N') { // Y또는 N인 경우 반복 종료
				
				break;
			} else {
				System.out.println("Y또는 N을 입력 해주세요. \n");
			}
		}
		
		if(ch == 'Y') { // 삭제를 하려고 하는 경우
			// 보안 문자 생성
			String cap = capcha();
			System.out.println("다음 보안 문자를 입력해주세요 >> " + cap);
			System.out.print("보안 문자 입력 : ");
			String input = sc.next();
			if(input.equals(cap)) { //입력 받은 문자열과 보안 문자가 같을 때
									//삭제 Service 호출
				try {
					int result = service.deleteReply(replyNo);
					
					if(result > 0 ) {
						System.out.println(replyNo+"번 댓글이 삭제 되었습니다. ");
					} else {
						System.out.println("삭제 실패");
					}
					
					
				} catch (Exception e) {
					System.out.println("\n<게시글 삭제 도중 오류 발생?\n");
					e.printStackTrace();
				}
				
				
			} else {
				System.out.println("\n 보안 문자가 일치하지 않습니다. (삭제 취소) \n");
			}
			
		}
		
	}

	private void insertBoard(int memberNo) {

		System.out.println("[게시글 작성]");
		
		System.out.println("작성할 제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.println("\n 작성할 내용(종료 시 @exit 입력) : \n");
		
		String boardContent = "";
		
		boardContent = inputContent(); //내용 입력 메소드 호출 후 결과 반환 받기

		System.out.println(boardContent);
		
		Board board = new Board();
		board.setMemberNo(memberNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		try {
			int result = service.insertBoard(board);
			
			if(result > 0) {
				System.out.println("제목 : "+ boardTitle +" 게시글 작성에 성공하였습니다. \n");
			} else {
				System.out.println("수정 실패");
			}
		} catch (Exception e) {
			System.out.println("\n <수정 중 오류 발생> \n");
			e.printStackTrace();
		}
	}

	




	private void titleSearch() {

		System.out.println("[게시글 찾기]");
		int menuNum = -1;
		
		do {
			
			
			try {
			
				System.out.println("-- 검색 조건을 선택해주세요 --");
				System.out.println("1. 제목");
				System.out.println("2. 내용");
				System.out.println("3. 제목 + 내용");
				System.out.println("4. 작성자");
				System.out.println("0. 돌아가기");
				System.out.println("선택 >> ");
				menuNum = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {
				case 0 :
				System.out.println("\n 게시판 메뉴로 돌아갑니다.. \n");
				break;
				case 1 : case 2 : case 3 : case 4 :
					//검색어 입력 -> Service 호출
					System.out.println("검색어 : ");
					String keyword = sc.nextLine();
					List<Board> boardList = service.titleSearch(menuNum, keyword);
					
					if(boardList.isEmpty()) {
						System.out.println("검색 결과가 없습니다.");
					} else {
						for (Board b : boardList) {
							System.out.println(b);
						}
					}
					break;
					
				default : System.out.println("\n메뉴에 작성된 번호만 입력해주세요 \n");
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("\n 입력 형식이 올바르지 않습니다. 다시 시도해주세요");
				sc.nextLine();
			} catch(Exception e) {
				System.out.println("\n 게시글 검색 중 에러 발생\n");
				e.printStackTrace();
				
			}
		}while(menuNum!=0);
		

		
	}
		
		
				
		










	
}
