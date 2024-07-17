package edu.kh.community.common;

public class Util {

	// 개행 문자-> <br> 변경 메소드
	
	public static String newLineHandling(String content) {		
		return content.replaceAll("(\r\n|\n\r|\n|\r)", "<br>");
		//textarea의 엔터 : \r\n
		// \r : 캐리지 리턴(첫 번째로 돌아가기)
		// \n : new line(다음줄로 이동)
	}
	
	// Cross Site Scripting(XSS , 크로스 사이트 스크립팅) 공격 방지 메소드
	public static String XSSHandling(String content) {
		// <, >, *, " 문자를 HTML 코드가 아닌 문자 그대로 보이도록 변경
		
		
		//<h1>
		content = content.replaceAll("&", "&amp;"); // 제일 위로가야함.. 순서 중요 <h1>
		content = content.replaceAll("<", "&lt;"); // &lt;h1> 
		content = content.replaceAll(">", "&gt;"); // &lt;h1&gt;
		content = content.replaceAll("\"", "&quot;"); 
		
		return content;
	}
}
