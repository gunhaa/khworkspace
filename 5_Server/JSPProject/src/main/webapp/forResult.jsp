<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:forEach 향상된 for문처럼 사용하기</title>
</head>
<body>

	<h3>EL로 파라미터 얻어오는 방법</h3>
	1. \${param.name속성 값}<br>
	
	-> 단일 파라미터를 얻어와 출력하는 용도<br>
	-> 복수 파라미터에 사용하는 경우 맨 앞(0번 인덱스) 값만 얻어옴<br>
	
	${param.lang}
	
	<br><br>
	
	2.\${paramValues.lang[인덱스] }<br>
	
	${paramValues.lang[0]}<br>
	${paramValues.lang[1]}<br>
	${paramValues.lang[2]}<br>
	
	<hr>
	
	<h3>향상된 for문 사용</h3>
			// 첫 번째 반복인 경우 : 빨간 글씨로 첫번째 문구 출력
			// 마지막 반복인 경우 : 파란 글씨로 마지막 문구 출력
	<ul>
		<c:forEach var="str" items="${paramValues.lang}" varStatus="vs">
			
			<li>
				<c:choose>
					<c:when test="${vs.first}">
						<font color="red">첫 번쨰</font>
					</c:when>
					<c:when test="${vs.last}">
						<font color="blue">마지막</font>
					</c:when>
				</c:choose>
				${str} / ${vs.index} /${vs.count} / ${vs.current}
			</li>
			
			

		</c:forEach>
	</ul>
	
</body>
</html>