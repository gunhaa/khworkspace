<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>게시판</title>
                <link rel="stylesheet" href="${contextPath}/resources/css/boardDetail-style.css">
                <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
                <link rel="stylesheet" href="${contextPath}/resources/css/reply-style.css">
                <script src="https://kit.fontawesome.com/5c3cbb6981.js" crossorigin="anonymous"></script>
            </head>

            <body>


                <main>
                    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

                    ${detail}

                    ${loginMember}


                    <section class="board-detail">

                        <!-- 제목 -->

                        <div class="board-title">${detail.boardTitle} <span>- ${detail.boardName}</span></div>

                        <!-- 프로필 + 닉네임 + 작성일 + 조회수 -->

                        <div class="board-header">
                            <div class="board-writer">
                                <c:if test="${empty detail.profileImage}">
                                    <!-- 프로필 사진이 없는 경우 -->
                                    <img src="${contextPath}/resources/images/user.png">
                                </c:if>

                                <c:if test="${!empty detail.profileImage}">
                                    <!-- 프로필 사진이 있는 경우 -->
                                    <img src="${contextPath}${detail.profileImage}">
                                </c:if>

                                <span>${detail.memberNickname}</span>
                            </div>

                            <div class="board-info">
                                <p> <span>작성일</span> ${detail.createDate}</p>

                                <c:if test="${empty detail.profileImage}">
                                </c:if>

                                <c:if test="${!empty detail.profileImage}">
                                    <p> <span>마지막 수정일</span> ${detail.updateDate}</p>
                                </c:if>

                                <p> <span>조회수</span> ${detail.readCount}</p>
                            </div>
                        </div>

                        <!-- 이미지가 있을 경우 -->
                        <c:if test="${!empty detail.imageList}">
                            <!-- 썸네일이 있을 경우 변수 생성-->
                            <c:if test="${detail.imageList[0].imageLevel == 0}">
                                <c:set var="thumbnail" value="${detail.imageList[0]}"></c:set>
                                <!-- page scope(페이지 어디서든 사용 가능) -->
                            </c:if>
                        </c:if>

                        <!-- 썸네일 영역(썸네일이 있을 경우)-->

                        <c:if test="${!empty thumbnail}">

                            <h5>썸네일</h5>
                            <div class="img-box">
                                <div class="boardImg thumnail">
                                    <img src="${contextPath}${thumbnail.imageRename}">
                                    <a href="${contextPath}${thumbnail.imageRename}"
                                        download="${thumbnail.imageOriginal}">다운로드</a>
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${empty thumbnail}">
                            <c:set var="start" value="0"></c:set>
                        </c:if>

                        <c:if test="${!empty thumbnail}">
                            <c:set var="start" value="1"></c:set>
                        </c:if>


                        <!-- 업로드 이미지가 있는 경우 -->

                        <c:if test="${start < fn:length(detail.imageList)}">

                            <!-- 업로드 이미지 -->
                            <h5>업로드 이미지</h5>

                            <div class="img-box">

                                <c:forEach var="i" begin="${start}" end="${fn:length(detail.imageList)-1}">
                                    <div class="boardImg">
                                        <img src="${contextPath}${detail.imageList[i].imageRename}">
                                        <a href="${contextPath}${detail.imageList[i].imageRename}"
                                            download="${detail.imageList[i].imageOriginal}">다운로드</a>
                                    </div>
                                </c:forEach>

                            </div>

                        </c:if>

                        <!-- 업로드 이미지가 없을 경우 -->

                        <c:if test="${empty detail.imageList[1]}">
                        </c:if>




                        <!-- 내용 -->

                        <div class="board-content">
                            ${detail.boardContent}
                        </div>

                        <!-- 버튼 영역 -->

                        <div class="board-btn-area">

                            <c:if test="${detail.memberNo==loginMember.memberNo}">
                                <button id="updateBtn">수정</button>
                                <button id="deleteBtn">삭제</button>
                            </c:if>
                            <!-- dom 과 bom에 대해서
                             onclick="history.back();" 뒤로가기
                             history.go(숫자) : 양수(앞으로가기), 음수(뒤로가기) 
                            -->
                            <button id="goToListBtn">목록으로</button>
                        </div>

                    </section>

                    <!-- 댓글 -->

                    <jsp:include page="/WEB-INF/views/board/reply.jsp"></jsp:include>


                </main>
                <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
                <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
                <script src="${contextPath}/resources/js/board/board.js"></script>

                <script>
                    // 댓글 관련 JS코드에 필요한 값을 전역 변수로 선언

                    // jsp 파일 : html, css, js, el ,jstl 사용 가능
                    // js 파일 : js 
                    
                    // ** 중요
                    // 코드 해석 순서 : EL=JSTL > HTML > JS
                    
                    // **JS코드에서 EL/JSTL을 작성하게 된다면 반드시 양쪽에 "" 추가 **

                    // 최상위 주소
                    const contextPath = "${contextPath}";
                    // 게시글 번호
                    const boardNo = "${detail.boardNo}"; // "500"
                    
                    
                    // 로그인한 회원 번호
                    const loginMemberNo = "${loginMember.memberNo}";
                    // 로그인 o : "1";
                    // 로그인 x : "";
                </script>
                
                <script src="${contextPath}/resources/js/board/reply.js"></script>
            </body>

            </html>