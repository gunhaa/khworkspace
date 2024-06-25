
<!-- Person 클래스 import -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="edu.kh.jsp.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>EL 확인하기</title>
</head>
<body>

	session 범위 sessionValue : ${sessionValue} <br>
	application 범위 appValue : ${appValue}


	<!-- 
	
		EL 특징
		
		1. get이라는 단어 사용 X
			왜? 표현 언어 == 출력용 언어 == 출력은 얻어와서 밖에 못함	
		
		2. EL은 null을 빈칸으로출력함
			(null 과 관련된 것은 모두 빈칸)
	 -->


	<h3>request 에서 Parameter 얻어오기</h3>

	<pre>
		EL로 Parameter 얻어와서 출력하는 방법
		\${param.name 속성값 }
	</pre>

	1) 
		<%=request.getParameter("inputName") %> / <%=request.getParameter("inputAge") %> / <%= request.getParameter("inputAddress") %>
    <br>
    2) EL(표현 언어) :
    ${param.name} 
    ${param.age} 
    ${param.address}
    
    <h3>request에서 속성(Attribute) 얻어오기</h3>
    
    <pre>
    	Servlet에서 추가된 속성을 표현(출력)하려는 경우
    	request에 세팅된 속성(Attribute)의 key값만 작성하여 출력할 수 있다!
    	(import, getAttribute(), 다운캐스팅, 변수 저장 모두 생략)
    	
    	
    	\${속성key}
    	
    	\${속성key.필드명 }
    	(단,getter가 작성되어 있어야지만 가능)
    </pre>
    
<%
	String hobby = (String)request.getAttribute("hobby");
	Person person = (Person)request.getAttribute("user");
%>

    1) JSP 표현식 : <%=hobby %>
    <!-- Person 클래스의 toString() 출력 -->
    <br> <%=person %> <br>
    
    <!--  Person 클래스의 getter를 이용해서 얻어와서 출력 -->
    <br><%=person.getName() %>
    <br><%=person.getAge() %>
    <br><%=person.getAddress() %> <br>
    2) EL(표현 언어) : ${hobby}
    <br>${user} <br>
	${user.getName()};
	${user.getAge()};
	${user.getAddress()};
	
	<hr>
	
	<h3>null 처리 방법</h3>
	
	<pre>
		EL에서 null 을 출력해야되는 경우 ""(빈 문자열)을 출력한다.
		
		+NullPointerException이 발생하는 코드에서도 ""(빈 문자열)을 출력한다.
		
		+EL은 null 경우를 확인할 때 empty를 통해서 확인할 수 있다.
	</pre>
	
	<% List<String> list = null; %>
	
	1) JSP 표현식 : <%= list %> <br>
	<%= list==null %>
	
	<br><br><br>
	
	2) EL(표현 언어) :${list}<br>
	${empty list }
	
	<h3 style="color:red">EL의 empty는 null과 비어있는 컬렉션을 비어있는 것으로 취급함</h3>
	
	<%
		list = new ArrayList<String>();
		// list가 ArrayList 객체를 참조 == null 아님
		// 참조하고 있는 ArrayList에 내용 없음 == 비어있음
	%>
	
	${empty list}
	${list==null}		
	
	
	
</body>
</html>