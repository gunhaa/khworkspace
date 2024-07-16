<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 문자열 관련 함수(메소드) 제공 JSTL(EL형식으로 작성) -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPage</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <script src="https://kit.fontawesome.com/5c3cbb6981.js" crossorigin="anonymous"></script>
</head>
<body>
    <main>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
        <!-- 마이페이지 -->
        <section class="myPage-content">
        
        	<!-- jsp 액션 태그 -->
			<jsp:include page="/WEB-INF/views/member/sideMenu.jsp"></jsp:include>

            <!-- 오른쪽 마이페이지 주요 내용 부분 -->
            <section class="myPage-main">
                <h1 class="myPage-title">비밀번호 변경</h1>
                <span class="myPage-explanation">현재 비밀번호가 일치하는 경우 새 비밀번호로 변경할 수 있습니다.</span>


				
                <form action="changePw" method="post" name="myPage-form" onsubmit="return pwValidate()">

                    <div class="myPage-row">
                        <label style="width:40%;">현재 비밀번호</label>
                        <input type="password" name="currentPw" id="currentPw" value="" maxlength="30">
                    </div>

                    <div class="myPage-row">
                        <label style="width:40%;">새 비밀번호</label>
                        <input type="password" name="newPw" value="" maxlength="30">
                    </div>
					
				    <div class="myPage-row">
                        <label style="width:40%;">새 비밀번호 확인</label>
                        <input type="password" name="newPwConfirm" value="" maxlength="30">
                    </div>	

					
					


                    <button id="info-update-btn">수정하기</button>

                </form>

            </section>

        </section>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script src="${contextPath}/resources/js/member/mypage.js"></script>
</body>
</html>