<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <!-- map에 저장된 값을 각각 변수에 저장 -->

        <c:set var="boardName" value="${map.boardName}"></c:set>
        <c:set var="pagination" value="${map.pagination}"></c:set>
        <c:set var="boardList" value="${map.boardList}"></c:set>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>${boardName}</title>
            <link rel="stylesheet" href="${contextPath}/resources/css/boardList-style.css">
            <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

            <script src="https://kit.fontawesome.com/5c3cbb6981.js" crossorigin="anonymous"></script>
        </head>

        <body>
            ${loginMember}

            <main>

                <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

                 <!-- 검색을 진행한 경우 key,query를 쿼리스트링 형태로 저장할 변수 생성 -->
                 <c:if test="${!empty param.key}">
                    <c:set var="sURL" value="&key=${param.key}&query=${param.query}"></c:set>
                 </c:if>


                <section class="board-list">
                    <h1 class="board-name">${boardName}</h1>

                    <c:if test="${!empty param.key}">
                        <h4>"${param.query}" 검색 결과</h4>
                    </c:if>
                    
                    <div class="list-wrapper">
                        <table class="list-table">
                            <thead>
                                <tr>
                                    <th>글번호</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성일</th>
                                    <th>조회수</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:choose>
                                    <c:when test="${empty boardList}">
                                        <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                        <tr>
                                            <th colspan="5"> 게시글이 존재하지 않습니다.</th>
                                        </tr>

                                    </c:when>

                                    <c:otherwise>
                                        <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->
                                        <!-- <c:forEach var="i" begin="0" end="9" step="1">
                                            <tr>
                                                <td>${boardList[i].boardNo}</td>
                                                <td>
                                                    <a href="#">${boardList[i].boardTitle}</a>
                                                </td>
                                                <td>${boardList[i].memberNickname}</td>
                                                <td>${boardList[i].createDate}</td>
                                                <td>${boardList[i].readCount}</td>
                                            </tr>
                                        </c:forEach> -->
                                        <c:forEach var="board" items="${boardList}">
                                            <tr>
                                                <td>${board.boardNo}</td>
                                                <td>
                                                    <c:if test="${!empty board.thumbnail}">
                                                        <img src="${contextPath}${board.thumbnail}" class="list-thumbnail">
                                                    </c:if>
                                                    <a
                                                        href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardTitle}</a>
                                                </td>
                                                <td>${board.memberNickname}</td>
                                                <td>${board.createDate}</td>
                                                <td>${board.readCount}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                            </tbody>
                        </table>
                    </div>
                    <div class="btn-area">

                        <c:if test="${!empty loginMember}">
                            <button id="insertBtn" onclick="location.href='write?mode=insert&type=${param.type}'">글쓰기</button>
                        </c:if>

                    </div>
                    <div class="pagination-area">

                        <!-- 페이지네이션 a태그에 사용될 공통 주소를 저장할 변수 선언 -->
                        <c:set var="url" value="list?type=${param.type}&cp="></c:set>
                        <!-- qs에 type값을 불러온다 -->


                        <ul class="pagination">

                            <li><a href="${url}1${sURL}">&lt;&lt;</a></li>
                            <li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li>

                            <!-- 범위가 정해진 일반 for문 사용 -->
                            <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

                                <c:choose>
                                    <c:when test="${i == pagination.currentPage}">
                                        <li><a class="current">${i}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${url}${i}${sURL}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>



                            <li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li>
                            <li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li>


                        </ul>
                    </div>

                    <!-- 일반 목록 조회 요청 시 : /community/board/list?type=2 -->
                    <!-- 검색 내용 목록 조회 : /community/board/list?type=2?key=tc&query=검색어 -->

                    <form action="list" method="get" id="boardSearch" onsubmit="return searchValidate()">
                        <select name="key" id="search-key">
                            <option value="t">제목</option>
                            <option value="c">내용</option>
                            <option value="tc">제목+내용</option>
                            <option value="w">작성자</option>
                        </select>

                        <input type="text" name="query" placeholder="검색어를 입력해주세요"  id="search-query">

                        <button>검색</button>

                        <input type="hidden" name="type" value="${param.type}">

                    </form>
                </section>
            </main>

            <div class="modal">
                <span id="modal-close">&times;</span>
                <img src="${contextPath}/resources/images/user.png" id="modal-image">
            </div>

            <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

            <script src="${contextPath}/resources/js/board/board.js"></script>

        </body>

        </html>