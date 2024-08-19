package edu.kh.project.common.utility;

import java.text.SimpleDateFormat;

public class Util {

	// Cross Site Scripting (XSS) 방지 처리
	// - 웹 애플리케이션에서 발생하는 취약점
	// - 권한이 없는 사용자가 사이트에 스크립트를 작성하는 것
	// Cross Site Scripting(XSS , 크로스 사이트 스크립팅) 공격 방지 메소드
	public static String XSSHandling(String content) {
		// <, >, *, " 문자를 HTML 코드가 아닌 문자 그대로 보이도록 변경

		content = content.replaceAll("&", "&amp;"); // 제일 위로가야함.. 순서 중요 <h1>
		content = content.replaceAll("<", "&lt;"); // &lt;h1> 
		content = content.replaceAll(">", "&gt;"); // &lt;h1&gt;
		content = content.replaceAll("\"", "&quot;"); 
		
		return content;
	}
	
	// a.jpg 
	
	// 파일명 변경 메소드
	public static String fileRename(String originFileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

		int ranNum = (int) (Math.random() * 100000); // 5자리 랜덤 숫자 생성

		String str = "_" + String.format("%05d", ranNum);

		String ext = originFileName.substring(originFileName.lastIndexOf("."));

		return date + str + ext;
	}
	
}
