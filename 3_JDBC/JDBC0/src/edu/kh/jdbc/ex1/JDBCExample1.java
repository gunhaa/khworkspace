package edu.kh.jdbc.ex1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {

	public static void main(String[] args) {
		
		// JDBC : java가 DB와 연결할 수 있게 해주는 java API
	
		// [1단계] JDBC 객체 참조 변수 선언
		
		
		Connection conn = null;
		
		// DB연결 정보를 담은 객체
		// -> Java와 DB사이를 연결해주는 일종의 통로(Stream과 비슷하게 생각)
		
		Statement stmt = null;
		
		//connection 객체를 통해 
		//Java에서 작성된 SQL을 DB로 전달하여 수행한 후
		//결과를 반환 받아 다시 java로 돌아오는 역할의 객체
		
		ResultSet rs = null;
		// SELECT질의 성공 시 반환되는
		// 결과 행의 집합(Result Set)을 나타내는 객체
		
		try {
			// [2단계] 참조변수에 알맞은 객체 대입하기
			
			// 1. DB연결에 필요한 Oracle JDBC Driver 메모리 로드하기
			// --> Oracle JDBC Driver가 어디에 있는지만 알려주면 알아서 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ClassNotFoundException이 발생할 가능성이 있다.
			//생략 가능하다
			
			
			//2. 연결 정보를 담은 Connection을 생성
			//(이때, DriverManager 객체가 필요)
			//DriverManage : JDBC 드라이버를 통해 Connection 객체를 만드는 역할
			
			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			
			String ip = "localhost"; // DB서버 컴퓨터 IP
			// localhost == 127.0.0.1
			
			String port = ":1521";
			
			String sid = ":xe"; // DB이름
			
			String user = "hgh"; // 사용자 명
			
			String pw = "hgh1234"; // 비밀번호
			
			conn = DriverManager.getConnection(type + ip + port + sid , user , pw);
											// jdbc:oracle:thin:@localhost:1521:xe
			
			// 중간 확인
			System.out.println(conn); //oracle.jdbc.driver.T4CConnection@4961f6af 
									 //connection 객체에 대한 주소가 반환됨
			
			// 3. Statement 객체에 적재할 SQL문 작성하기
			//***** JAVA에서 작성된 SQL문은 마지막에 ;(세미콜론)을 찍지 않아야 한다!!! *****
			String sql = "SELECT EMP_ID,EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE ORDER BY 2";
			
			// 4. Statement 객체생성
			stmt = conn.createStatement();
			
			// 5. sql을 statement에 적재 후
			//DB로 전달하여 수행한 후
			//결과르 반환 받아와 rs변수에 대입
			
			rs = stmt.executeQuery(sql);
			//rs는 객체의 주소값이다
			//DB에서 SELECT 수행한 결과(ResultSet)객체를 얻어와 rs가 참조하게 함
			
			// [3단계] SELECT 수행 결과를 한 행씩 접근하여
			// 		  원하는 컬럼 값 얻어오기
			
			while(rs.next()) {
				//rs.next() : 참조하고 있는 ResultSet 객체의
				//            첫 번쨰 컬럼부터 순서대로 한 행씩 이동하며
				//            다음 행이 이을 경우 true를 반환
				
				// rs.get[Type]("컬럼명") : 현재 가리키고 있는 행의 특정 컬럼 값을 얻어옴
				// [Type]은 DB에서 얻어와서 Java에 저장할 자료형(Java쪽 자료형)
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String deptCode= rs.getString("DEPT_CODE");
				//조회 결과 출력
				System.out.printf("사번 : %d 이름 : %s 급여 : %d 부서코드 : %s\n", empId, empName,salary,deptCode);
			}
			
		}catch(SQLException e) {
			//SQLException : DB연결 관련 예외의 최상위 부모
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("OJDBC 라이브러리 미등록 또는 경로 오타");
			e.printStackTrace();
		} finally {
			// [4단계] 사용한 JDBC 객체 자원 반환(close)
			// -> 자원 반환 순서는 객체 생성순서의 "역순"으로
			// 생성 순서 : Connection , Statement,ResultSet
			// 반환 순서 : ResultSet, Statement, Connection
			
			try {
				
				// NullpointerException 방지를 위한 if문 추가
				if(rs !=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
