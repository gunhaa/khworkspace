<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/boardWriteForm-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/5c3cbb6981.js" crossorigin="anonymous"></script>
</head>

<body>


    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
        <!--  -->
        <form action="write" enctype="multipart/form-data" method="POST" class="board-write">

            <!-- 제목 -->
            <h1 class="board-title">
                <input type="text" name="boardTitle" placeholder="제목을 입력해주세요">
            </h1>

            <!-- 썸네일 -->
            <h5>썸네일</h5>
            <div class="img-box">
                <div class="boardImage thumbnail">
                    <label for="img0">
                        <img class="preview">
                    </label>
                    <input type="file" class="inputImage" id="img0" accept="image/*" name="0">
                    <span class="delete-image">&times;</span>
                    <!-- &times : X모양의 문자 -->
                </div>
            </div>

            <!-- 업로드 이미지 -->
            <h5>업로드 이미지</h5>
            <div class="img-box">
                <div class="boardImage">
                    <label for="img1">
                        <img class="preview">
                    </label>
                    <input type="file" class="inputImage" id="img1" accept="image/*" name="1">
                    <span class="delete-image">&times;</span>
                    <!-- &times : X모양의 문자 -->
                </div>

                <div class="boardImage">
                    <label for="img2">
                        <img class="preview">
                    </label>
                    <input type="file" class="inputImage" id="img2" accept="image/*" name="2">
                    <span class="delete-image">&times;</span>
                    <!-- &times : X모양의 문자 -->
                </div>

                <div class="boardImage">
                    <label for="img3">
                        <img class="preview">
                    </label>
                    <input type="file" class="inputImage" id="img3" accept="image/*" name="3">
                    <span class="delete-image">&times;</span>
                    <!-- &times : X모양의 문자 -->
                </div>

                <div class="boardImage">
                    <label for="img4">
                        <img class="preview">
                    </label>
                    <input type="file" class="inputImage" id="img4" accept="image/*" name="4">
                    <span class="delete-image">&times;</span>
                    <!-- &times : X모양의 문자 -->
                </div>
            </div>

            <!-- 내용 -->

            <div class="board-content">
                <textarea name="boardContent"></textarea>
            </div>

            <!-- 버튼 -->
            <div class="board-btn-area">
                <button type="submit" id="writeBtn">등록</button>
                <button type="button" id="goToListBtn">목록으로</button>
            </div>
            <!-- 숨겨진 값(hidden) -->
            <!--동작 구분  -->
            <input type="hidden" name="mode" value="${param.mode}">

            <!-- 게시판 구분 -->
            <input type="hidden" name="type" value="${param.type}">
        </form>
        <!--  -->
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script src="${contextPath}/resources/js/board/boardWriteForm.js"></script>

</body>

</html>