<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:forEach items="${boardTypeList}" var="boardType">
    <c:if test="${boardType.BOARD_CODE == boardCode}" >
        <c:set var="boardName" value="${boardType.BOARD_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${boardName}</title>

    <link rel="stylesheet" href="/resources/css/board/boardWrite-style.css">
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
                            <%-- @PathVariable에서 얻어온 값이다. --%>
                                            <%--  
                    - 파일 제출 시 무조건 POST 방식
                    - enctype 속성 추가

                    - enctype : form 태그 데이터가 서버로 제출될 때 인코딩 되는 방법을 지정. 
                                (POST 방식일 때만 사용 가능)

                    - application/x-www-form-urlencoded : 모든 문자를 서버로 전송하기 전에 인코딩
                                                          (form태그 기본값)

                    - multipart/form-data : 모든 문자를 인코딩 하지 않음
                                            (원본 데이터가 유지되어 이미지, 파일등을 서버로 전송할 수 있음)

                    multipart/form-data 제출 시 데이터 인코딩 X
                    -> 파일 제출 가능
                    -> MultiPartResolver 가 문자열, 파일 구분
                    -> 문자열 -> String , int, DTO , Map (HttpMessageConverter)
                    -> 파일 -> MultiPartFile 객체 -> transferTo (파일을 서버에 저장)

                --%>
        <form action="/board2/${boardCode}/insert" method="POST" class="board-write" id="boardWriteFrm" enctype="multipart/form-data">  
            <h1 class="board-name">${boardName}</h1>

            <!-- 제목 -->
            <h1 class="board-title">
                <input type="text" name="boardTitle" placeholder="제목" value="" id="boardtitle">
            </h1>


            <!-- 썸네일 영역 -->
            <h5>썸네일</h5>
            <div class="img-box">
                <div class="boardImg thumbnail">
                    <label for="img0">
                        <img class="preview" src="">
                    </label>
                    <input type="file" name="images" class="inputImage" id="img0" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
            </div>


            <!-- 업로드 이미지 영역 -->
            <h5>업로드 이미지</h5>
            <div class="img-box">

                <div class="boardImg">
                    <label for="img1">
                        <img class="preview" src="">
                    </label>
                    <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>

                <div class="boardImg">
                    <label for="img2">
                        <img class="preview" src="">
                    </label>
                    <input type="file" name="images" class="inputImage" id="img2" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>

                <div class="boardImg">
                    <label for="img3">
                        <img class="preview" src="">
                    </label>
                    <input type="file" name="images" class="inputImage" id="img3" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>

                <div class="boardImg">
                    <label for="img4">
                        <img class="preview" src="">
                    </label>
                    <input type="file" name="images" class="inputImage" id="img4" accept="image/*">
                    <span class="delete-image">&times;</span>
                </div>
            </div>

            <!-- 내용 -->
            <div class="board-content">
                <textarea name="boardContent" id="boardContent"></textarea>
            </div>


             <!-- 버튼 영역 -->
            <div class="board-btn-area">
                <button type="submit" id="writebtn">등록</button>
            </div>

            
        </form>

    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="/resources/js/board/boardWrite.js"></script>

</body>
</html>