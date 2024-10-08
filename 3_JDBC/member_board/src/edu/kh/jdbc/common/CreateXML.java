package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateXML { // 주의!! 혼자서 막 실행하면 기존 파일 사라짐!!
	
	// XML(eXtensible Markup Language) : 단순화된 데이터 기술 형식
	// map 과 유사하다.
	
	// XML을 사용하려는 이유
	// - DB 연결, SQL같이 수정이 빈번한 내용을 
	//   코드에 직접 작성하면 좋지 않음
	
	// 왜? Java == 컴파일 언어 -> 코드가 조금만 수정되도 전체 컴파일을 다시 한다.
	//                         -> 시간이 오래 걸림
	
	// XML 외부 파일을 이용해서 xml 내용을 바꿔도 
	// java에서 xml 파일을 읽어오는 코드는 변하지 않음 -> 컴파일 X -> 시간 효율 상승
	
	public static void main(String[] args) {
		
		//XML은 K:V 형식 map , XML은 문자열만 저장
		// Key값은 '객체'만 들어갈수있따.
		// Map<String, String> == Properties 
		// * Properties 컬렉션 객체 *
		// 1. <String , String>으로 Key, Value 타입 제한된 map
		// 2. XML파일을 생성하고 읽어오는데 특화
		
		Properties prop = new Properties();
		
		try {
			FileOutputStream fos = new FileOutputStream("member-sql.xml");
														//파일 이름 작성
			
			
			prop.storeToXML(fos, "Member Service SQL");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
}
