<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


            <div id="reply-area">

                <!-- 댓글 목록 -->


                <div class="reply-list-area">
                    <ul id="reply-list">

                        <c:forEach var="i" begin="0" end="${fn:length(rList)-1}">

                            <li class="reply-row">
                                <p class="reply-writer">

                                    <c:if test="${empty reply.profileImage}">

                                        <img src="${contextPath}/resources/images/user.png">

                                    </c:if>

                                    <c:if test="${!empty reply.profileImage}">

                                        <img src="${contextPath}${reply.profileImage}">

                                    </c:if>


                                    <span>${rList[i].memberNick}</span>
                                    <span class="reply-date">(${rList[i].createDate})</span>
                                </p>
                                <p class="reply-content">
                                    ${rList[i].replyContent}
                                </p>

                                <c:if test="${loginMember.memberNo == rList[i].memberNo}">
                                    <div class="reply-btn-area">
                                        <button>수정</button>
                                        <button onclick="deleteReply(${rList[i].replyNo})">삭제</button>
                                    </div>
                                </c:if>
                            </li>

                        </c:forEach>

                        <!-- 
            <li class="reply-row">
                <p class="reply-writer">
                    <img src="${contextPath}/resources/images/user.png">
                    <span>댓글 작성자 닉네임</span>
                    <span class="reply-date">(2024.07.11 10:09:30)</span>
                </p>
                <p class="reply-content">
                    댓글 내용입니다. <br>
                    댓글 내용입니다. <br>
                </p>
                <div class="reply-btn-area">
                    <button>수정</button>
                    <button>삭제</button>
                </div>
            </li>

            <li class="reply-row">
                <p class="reply-writer">
                    <img src="${contextPath}/resources/images/user.png">
                    <span>댓글 작성자 닉네임</span>
                    <span class="reply-date">(2024.07.11 10:09:30)</span>
                </p>
                <p class="reply-content">
                    댓글 내용입니다. <br>
                    댓글 내용입니다. <br>
                </p>
                <div class="reply-btn-area">
                    <button>수정</button>
                    <button>삭제</button>
                </div>
            </li> -->

                    </ul>
                </div>

                <!-- 댓글 작성 부분 -->
                <div class="reply-write-area">
                    <textarea id="replyContent"></textarea>
                    <button id="addReply">댓글<br>등록</button>
                </div>


            </div>