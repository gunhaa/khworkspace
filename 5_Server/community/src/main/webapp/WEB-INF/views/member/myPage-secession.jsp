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
                <h1 class="myPage-title">회원 탈퇴</h1>
                <span class="myPage-explanation">현재 비밀번호가 일치하는 경우 탈퇴할 수 있습니다.</span>


				
                <form action="secession" method="post" name="myPage-form" onsubmit="return secessionValidate()">

                    <div class="myPage-row" style="border-bottom: 3px solid grey">
                        <label>비밀번호</label>
                        <input type="password" name="memberPw" maxlength="30">
                    </div>

                    <div class="myPage-row" style="border-bottom: none">
                        <label>회원탈퇴 약관</label>
                    </div>
					
					
					<div id="myPage-samplebox">
						<pre id="myPage-sample">제1조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4


제2조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4</pre>
					</div>
					<div id="chkbox">
						<input type="checkbox" id="chk" name="agree">
						<label for="agree">위 약관에 동의합니다.</label>
					</div>
                    <button id="info-update-btn">탈퇴</button>

                </form>

            </section>

        </section>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script src="${contextPath}/resources/js/member/mypage.js"></script>
</body>
</html>