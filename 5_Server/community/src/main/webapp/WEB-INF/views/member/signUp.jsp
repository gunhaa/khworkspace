<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티</title>
    <link rel="stylesheet" href="../resources/css/signUp-style.css">
    <link rel="stylesheet" href="../resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/5c3cbb6981.js" crossorigin="anonymous"></script>
</head>

<body>


    <main>
       	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
        <!-- 회원 가입 -->
        <section class="signUp-content">


            <!-- 회원 가입 전환 주소(GET)와 같은 주소로 실제 회원가입을 요청(POST)
                 -> 요청 주소가 같아도 데이터 전달 방식이 다르면 중복 허용
            -->
            <!--절대 경로 : /community/member/signUp
                 
                현재 경로 : /community/member/signUp
                상대 경로 : signUp 
            -->
            <form action="signUp" method="post" name="signUp-form" onsubmit="return signUpValidate()">
                <label for="memberEmail">
                    <span class="required">*</span> 아이디(이메일)
                </label>

                <div class="signUp-input-area">

                    <input type="text" id="memberEmail" name="memberEmail"
                        placeholder="아이디(이메일)" maxlength="30" autocomplete="off" required>
                    <!-- autocomplete="off" : 자동 완성 미사용 -->
                    <!-- required : 필수 작성 input 태그 -->
                    <button type="button">인증번호 받기</button>
                </div>

                <span class="signUp-message">메일을 받을 수 있는 이메일을 입력해주세요</span>

                <label for="emailCheck">
                    <span class="required">*</span> 인증번호
                </label>

                <div class="signUp-input-area">
                    <input type="text" id="emailCheck"
                        placeholder="인증번호 입력" maxlength="6" autocomplete="off">
                    <button type="button">인증하기</button>
                </div>

                <span class="signUp-message confirm" id="nicknameMessage">인증 되었습니다.</span>


                <label for="memberPw">
                    <span class="required">*</span> 비밀번호
                </label>

                <div class="signUp-input-area">
                    <input type="password" id="memberPw" name="memberPw"
                        placeholder="비밀번호" maxlength="30">
                </div>

                <div class="signUp-input-area">
                    <input type="password" id="memberPwConfirm"
                        placeholder="비밀번호확인" maxlength="30">
                </div>

                <span class="signUp-message error" id="pwMessage">영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요</span>


                <label for="memberNickname">
                    <span class="required">*</span> 닉네임
                </label>

                <div class="signUp-input-area">
                    <input type="text" id="memberNickname" name="memberNickname"
                        placeholder="닉네임" maxlength="10">
                </div>

                <span class="signUp-message confirm" id="nicknameMsg">영어/숫자/한글 2~10글자 사이로 작성해주세요.</span>



                <label for="memberTel">
                    <span class="required">*</span> 전화번호
                </label>

                <div class="signUp-input-area">
                    <input type="text" id="memberTel" name="memberTel"
                        placeholder="(-없이 숫자만 입력)" maxlength="11">
                </div>

                <span class="signUp-message" id="telMessage">전화번호를 입력해주세요.(- 제외)</span>


                <label for="memberAddress">
                     주소
                </label>

                <div class="signUp-input-area">
                    <input type="text" id="memberAddress" name="memberAddress"
                        placeholder="주소" maxlength="6">

                    <button type="button">검색</button>
                </div>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress"
                        placeholder="도로명 주소">

                </div>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress"
                        placeholder="상세 주소">

                </div>


                <button type="submit" id="signUp-btn">가입하기</button>

            </form>
        </section>
    </main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <!-- signUp.js -->
	<script src="${contextPath}/resources/js/signUp.js"></script>


</body>

</html>