// 댓글 목록 조회 (AJAX)

function selectReplyList() {


    // 전역 변수 contextPath, boardNo, loginMemberNo 사용 가능
    $.ajax({

        url: contextPath + "/reply/selectReplyList",
        data: {
            "boardNo": boardNo
        },
        type: "GET",
        dataType: "JSON", // JSON 형태의 문자열 응답 데이터를 JS 객체로 자동 변환
        success: function (rList) {
            // rList : 반환 받은 댓글 목록
            // ul.innerHTML = "";
            // const ul = document.querySelector("#reply-list");
            // let str = "";

            // rList.reverse().forEach((item) => {

            //     str +=
            //         `
            //     <li class="reply-row">
            //     <p class="reply-writer">
            //         <img src="${contextPath}/resources/images/user.png">
            //         <span>${item.memberNick}</span>
            //         <span class="reply-date">${item.createDate}</span>
            //     </p>
            //     <p class="reply-content">
            //         ${item.replyContent}
            //     </p>
            //     <div class="reply-btn-area">
            //         <button>수정</button>
            //         <button>삭제</button>
            //     </div>
            // </li>`;

            // });

            // ul.innerHTML = str;





            // 다른 방식

            const replyList = document.getElementById("reply-list"); // ul태그
            replyList.innerHTML = "";

            // rList에 저장된 요소 하나씩 접근

            for (let reply of rList) {
                // 행
                const replyRow = document.createElement("li");
                replyRow.classList.add("reply-row");

                // 작성자
                const replyWriter = document.createElement("p");
                replyWriter.classList.add("reply-writer");

                // 프로필 이미지
                const profileImage = document.createElement("img");

                if (reply.profileImage != null) { // 프로필 이미지가 있는 경우
                    profileImage.setAttribute("src", contextPath + reply.profileImage)
                } else { // 없는 경우 == 기본 이미지

                    profileImage.setAttribute("src", contextPath + "/resources/images/user.png");
                }


                // 작성자 닉네임
                const memberNickname = document.createElement("span");
                memberNickname.innerText = reply.memberNick;

                // 작성일
                const replyDate = document.createElement("span");
                replyDate.innerText = "(" + reply.createDate + ")";
                replyDate.classList.add("reply-date");

                // 작성자 영역(p)에 프로필, 닉네임, 작성일 마지막 자식으로 추가
                replyWriter.append(profileImage, memberNickname, replyDate);

                // 댓글 내용
                const replyContent = document.createElement("p");
                replyContent.classList.add("reply-content");
                replyContent.innerHTML = reply.replyContent;

                // 행에 작성자, 내용, 버튼 추가
                replyRow.append(replyWriter, replyContent);
                // 로그인한 회원 번호와 댓글 작성자의 회원 번호가 같을 때만 버튼 추가
                const replyBtnArea = document.createElement("div");
                replyBtnArea.classList.add("reply-btn-area");

                if (loginMemberNo == reply.memberNo) {
                    // 버튼 영역

                    // 수정 버튼
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    updateBtn.setAttribute("onclick", "showUpdateReply(" + reply.replyNo + ", this)");

                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";


                    // 삭제 버튼에 onclick 이벤트 속성 추가
                    deleteBtn.onclick = function () {
                        deleteReply(reply.replyNo);
                    };

                    // 위와 같은 코드
                    // deleteBtn.setAttribute("onclick", "deleteReply("+reply.replyNo +")");


                    // 버튼 영역 마지막 자식으로 수정/삭제 버튼 추가
                    replyBtnArea.append(updateBtn, deleteBtn);

                    // 행에 버튼 영역 추가
                    replyRow.append(replyBtnArea);

                }



                // 댓글 목록(ul)에 행(li)추가
                replyList.append(replyRow);
            }




        },
        error: function () {
            console.log("에러 발생");
        }
    });

}


// --------------------------------------------------------------
// 댓글 등록
const addReply = document.querySelector("#addReply");
const replyContent = document.querySelector("#replyContent");

addReply.addEventListener("click", () => {

    // 1) 로그인이 되어있는가? -> 전역 변수 loginMemberNo 이용
    if (loginMemberNo == "") { // 로그인이 안되어 있을때
        alert("로그인 후 이용해주세요");
        return;
    }

    // 2) 댓글 내용이 작성되어 있는가?
    if (replyContent.value.trim().length == 0) { //미작성인 경우
        alert("댓글을 작성한 후 버튼을 클릭해주세요");
        replyContent.focus();
        replyContent.value = "";
        return;
    }

    // 3) ajax를 이용해서 댓글 내용 DB에 저장

    $.ajax({

        url: contextPath + "/reply/insert",
        data: {
            "replyContent": replyContent.value,
            "memberNo": loginMemberNo,
            "boardNo": boardNo
        },
        type: "POST",
        // dataType : "JSON" , 반환 받는 데이터 타입이 숫자 한개라서, 굳이 필요가 없음 
        success: (reply) => {

            if (reply > 0) { // 댓글 등록 성공

                alert("댓글이 등록되었습니다.")
                replyContent.value = "";
                selectReplyList();



            } else { // 댓글 등록 실패
                alert("댓글 등록에 실패했습니다.");
            }

        },
        error: (req, status, error) => {
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }

    });

});


// ---------------------------------------------------

// 댓글 삭제

function deleteReply(replyNo) {

    if (confirm("정말로 삭제하시겠습니까?")) {
        // 요청주소 : /community/reply/delete
        // 파라미터 : key : "replyNo", value : 매개변수 replyNo
        // 전달방식 : "GET"
        // success : 삭제 성공 시 -> "삭제되었습니다." alert로 출력 후
        //                          댓글 목록 비동기 조회 함수 호출 

        //          삭제 실패 시 -> "삭제 실패" alert로 출력

        // error : 앞 error 코드 참고

        // DB에서 댓글 삭제 ==> REPLY_ST = 'Y' 변경

        $.ajax({

            url: contextPath + "/reply/delete",
            data: {
                "replyNo": replyNo
            },
            type: "GET",
            success: (reply) => {
                // success : 삭제 성공 시 -> "삭제되었습니다." alert로 출력 후
                //                          댓글 목록 비동기 조회 함수 호출 
                if (reply == 1) {
                    //          삭제 실패 시 -> "삭제 실패" alert로 출력
                    alert("삭제 되었습니다.")
                    selectReplyList();
                } else {
                    alert("삭제 실패");
                }
            },
            error: (req, status, error) => {
                console.log("삭제 실패");
                console.log(req.responseText);
            }

        });
    }
}




//----------------------------------------------------------------------------------

// 댓글 수정 화면 전환

let beforeReplyRow; // 수정 전 원래 행의 상태를 저장할 변수

function showUpdateReply(replyNo, btn) {
    // 해당 댓글 번호, // 이벤트 발생한 요소


    // 1. 댓글 수정이 클릭된 행을 선택
    const replyRow = btn.parentElement.parentElement; //수정 버튼의 부모의 부모 
    // 2. 행 내용 삭제 전 현재 상태를 저장(백업)
    beforeReplyRow = replyRow.innerHTML;
    //취소 버튼 동작 코드
    // replyRow.innerHTML = beforeReplyRow;

    // 3. 댓글에 작성되어 있던 내용만 얻어오기(replyRow 이용) -> 새롭게 생성된 textarea 에 추가 예정
    //console.log(replyRow.children);
    // console.log(replyRow.children[1].innerHTML); // <br> 태그 유지를 위해 innerHTML 사용
    // let beforeContent = replyRow.children[1].innerHTML;

    // btn 이용
    let beforeContent = btn.parentElement.previousElementSibling.innerHTML;
    // 4. 댓글 행 내부 내용 모두 삭제
    replyRow.innerHTML = "";
    // 5. textarea 요소 생성 + 클래스 추가 + ** 내용 추가 **

    const textarea = document.createElement("textarea");
    textarea.classList.add("update-textarea");

    //***************************/
    // XSS 방지 처리 해제
    beforeContent = beforeContent.replaceAll("&amp;", "&");
    beforeContent = beforeContent.replaceAll("&lt;", "<");
    beforeContent = beforeContent.replaceAll("&gt;", ">");
    beforeContent = beforeContent.replaceAll("&quot;", "\"");
    // 개행 문자 처리 해제
    beforeContent = beforeContent.replaceAll("<br>", "\n");
    //***************************/


    textarea.value = beforeContent;
    // 6. replyRow에 생성된 textarea추가
    replyRow.append(textarea);
    // 7. 버튼 영역 + 수정/취소 버튼 생성
    const div = document.createElement("div");
    div.classList.add("reply-btn-area");
    const button1 = document.createElement("button");
    const button2 = document.createElement("button");
    button1.innerText = "수정";
    // button2.onclick = function(){
    //     replyRow.innerHTML=beforeReplyRow;
    // } 
    button1.setAttribute("onclick", "updateReply(" + replyNo + ", this)");
    button2.innerText = "취소";
    button2.setAttribute("onclick", "updateCancel(this)");
    // 8. 버튼 영역에 버튼 추가 후 replyRow에 버튼 영역 추가

    div.append(button1, button2);

    replyRow.append(div);

}


// ------------------------------------------------------------------

// 댓글 수정 취소

function updateCancel(btn) {
    // 매개변수 btn : 클릭 된 취소 버튼(이벤트가 일어난 객체)
    // 전역 변수 beforeReplyRow : 수정 전 원래 행(댓글)을 저장한 변수
    if (confirm("댓글 수정을 취소 하시겠습니까?")) {
        const replyRow = btn.parentElement.parentElement;
        
        btn.parentElement.parentElement.innerHTML = beforeReplyRow;
        // replyRow.innerHTML = beforeReplyRow;
    }
}

// 댓글 수정(AJAX)

function updateReply(replyNo, btn) {
    // console.log(btn.parentElement.previousElementSibling.value);
    const replyContent = btn.parentElement.previousElementSibling.value;
    
    $.ajax({

        url: contextPath + "/reply/update",
        data: {
            "replyNo": replyNo,
            "content": replyContent,
        },
        type: "POST",
        success(res) {

            if (res == 1) {
                alert("댓글 수정 성공");
                selectReplyList();

            } else {
                alert("댓글 수정 실패");
            }

        },
        error() {

        }

    });
}