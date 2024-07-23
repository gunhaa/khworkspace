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
                    <form action="write" enctype="multipart/form-data" method="POST" class="board-write"
                        onsubmit="return writeValidate()">

                        ${detail.imageList}
                        <!-- 제목 -->
                        <h1 class="board-title">
                            <input type="text" name="boardTitle" placeholder="제목을 입력해주세요" value="${detail.boardTitle}">
                        </h1>

                        <!-- imageList에 존재하는 이미지레벨을 이용해서 변수 생성 -->

                        <c:forEach items="${detail.imageList}" var="boardImage">

                            <c:choose>

                                <c:when test="${boardImage.imageLevel==0}">
                                    <c:set var="img0" value="${contextPath}${boardImage.imageRename}"></c:set>
                                </c:when>


                                <c:when test="${boardImage.imageLevel==1}">
                                    <c:set var="img1" value="${contextPath}${boardImage.imageRename}"></c:set>
                                </c:when>


                                <c:when test="${boardImage.imageLevel==2}">
                                    <c:set var="img2" value="${contextPath}${boardImage.imageRename}"></c:set>
                                </c:when>


                                <c:when test="${boardImage.imageLevel==3}">
                                    <c:set var="img3" value="${contextPath}${boardImage.imageRename}"></c:set>
                                </c:when>


                                <c:when test="${boardImage.imageLevel==4}">
                                    <c:set var="img4" value="${contextPath}${boardImage.imageRename}"></c:set>
                                </c:when>

                            </c:choose>

                        </c:forEach>

                        <!-- 썸네일 -->
                        <h5>썸네일</h5>
                        <div class="img-box">
                            <div class="boardImage thumbnail">
                                <label for="img0">
                                    <img class="preview" src="${img0}">
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
                                    <img class="preview" src="${img1}">
                                </label>
                                <input type="file" class="inputImage" id="img1" accept="image/*" name="1">
                                <span class="delete-image">&times;</span>
                                <!-- &times : X모양의 문자 -->
                            </div>

                            <div class="boardImage">
                                <label for="img2">
                                    <img class="preview" src="${img2}">
                                </label>
                                <input type="file" class="inputImage" id="img2" accept="image/*" name="2">
                                <span class="delete-image">&times;</span>
                                <!-- &times : X모양의 문자 -->
                            </div>

                            <div class="boardImage">
                                <label for="img3">
                                    <img class="preview" src="${img3}">
                                </label>
                                <input type="file" class="inputImage" id="img3" accept="image/*" name="3">
                                <span class="delete-image">&times;</span>
                                <!-- &times : X모양의 문자 -->
                            </div>

                            <div class="boardImage">
                                <label for="img4">
                                    <img class="preview" src="${img4}">
                                </label>
                                <input type="file" class="inputImage" id="img4" accept="image/*" name="4">
                                <span class="delete-image">&times;</span>
                                <!-- &times : X모양의 문자 -->
                            </div>
                        </div>

                        <!-- 내용 -->

                        <div class="board-content">
                            <!-- 
                    XSS 처리로 인해서 &lt; 과 같은 형태로 변한 문자들은
                    HTML에 출력될 때 해석된 형태 "<"로 출력된다.
                    -> 이 특징을 이용하면 별도로 XSS처리 해제코드를 작성할 필요가 없다.

                    하지만 개행문자<br> -> \n 으로 변경하는 코드 필요!
                -->
                            <textarea name="boardContent">${detail.boardContent}</textarea>
                        </div>

                        <!-- 버튼 -->
                        <div class="board-btn-area">
                            <button type="submit" id="writeBtn">등록</button>


                            <!-- insert모드 -->
                            <c:if test="${param.mode == 'insert'}">
                                <button type="button" id="goToListBtn">목록으로</button>
                            </c:if>
                            <!-- update 모드 -->
                            <c:if test="${param.mode == 'update'}">
                                <button type="button" onclick="location.href='${header.referer}'">이전으로</button>
                            </c:if>
                        
    
                        </div>
                        <!-- 숨겨진 값(hidden) -->
                        <!--동작 구분  -->
                        <input type="hidden" name="mode" value="${param.mode}">

                        <!-- 게시판 구분 -->
                        <input type="hidden" name="type" value="${param.type}">

                        <!-- 게시글 번호 -->
                        <input type="hidden" name="no" value="${param.no}">

                        <!-- 현재 페이지 -->
                        <input type="hidden" name="cp" value="${param.cp}">

                        <!-- 존재하던 이미지가 제거되었음을 기록하여 전달하는 input -->
                        <!-- value 제거된 이미지의 레벨을 기록 -->
                        <!-- DELETE FROM BOARD_IMG WHERE IMG_LEVEL IN ( ? ) AND BOARD_NO=? -->
                        <input type="hidden" name="deleteList" value="" id="deleteList">

                    </form>
                    <!--  -->
                </main>
                <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
                <script src="${contextPath}/resources/js/board/boardWriteForm.js"></script>

            </body>

            </html>