

// 좋아요 버튼이 클릭되었을 때
const boardLike = document.getElementById("boardLike");
let likeCount = document.querySelector("#likeCount").innerText;

boardLike.addEventListener("click", e => {

    // 로그인 여부 검사
    if (loginMemberNo == "") {
        alert("로그인 후 이용해주세요");
        return;
    }


    let check; // 기존에 좋아요 X(빈하트) : 0
    //       좋아요 O(꽉찬하트) : 1

    //contains("클래스명") : 클래스가 있으면 true, 없으면 false 반환
    if (e.target.classList.contains("fa-regular")) {
        check = 0;
    } else {
        check = 1;
    }

    // ajax로 서버에 제출할 파라미터를 모아둔 js 객체
    const data = {
        "boardNo": boardNo,
        "memberNo": loginMemberNo,
        "check": check
    }

    // ajax 코드 작성
    fetch("/board/like", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data)
    }).then(response => response.text() // 응답 객체를 필요한 형태로 파싱해서 리턴 // return값만 들어가있으면 생략이 가능하다. 

    ).then(result => {//파싱된 데이터를 받아서 처리하는 코드

        console.log(likeCount);

        if (result == -1) {
            alert("좋아요 도중 에러가 발생했습니다.");
        } else {

            if (result == likeCount) {
                // alert("좋아요가 눌러졌습니다.");
                document.querySelector("#likeCount").innerText = result;
            } else {
                // alert("좋아요가 취소되었습니다.");
                document.querySelector("#likeCount").innerText = result;
            }

        }



        // toggle() : 클래스가 있으면 제거, 없으면 추가
        e.target.classList.toggle("fa-regular");
        e.target.classList.toggle("fa-solid");

    }).catch(e => {
        console.log("예외 발생");
    })
});

// 게시글 수정 버튼 클릭 시
const updateBtn = document.getElementById("updateBtn");

if (updateBtn) {

    updateBtn.addEventListener("click", e => {
        location.href = `${location.pathname.replace("board", "board2")}/update${location.search}`;

    });

};

// 게시글 삭제 버튼 클릭 시


// "정말 삭제 하시겠습니까?"
// yes -> /board2/1/1555/delete(GET)

// 삭제 서비스 호출 성공 시 -> 해당 게시판 목록 / "게시글이 삭제 되었습니다."
// 삭제 서비스 호출 실패 시 -> 게시글 상세 조회 페이지 "게시글 삭제 실패"
const deleteBtn = document.querySelector("#deleteBtn");
if (deleteBtn) {

    deleteBtn.addEventListener("click", e => {
        if (confirm("정말 삭제하시겠습니까?")) {
            location.href = `${location.pathname.replace("board", "board2")}/delete`;
        }
    });

}




const goToListBtn = document.querySelector("#goToListBtn");

if (goToListBtn) {

    goToListBtn.addEventListener("click", e => {
        // console.log("클릭됨");
        // const params = new URL(location.href).searchParams;
        // const key = params.get("key"); // t,c,tc,w 중 하나
        // const query = params.get("query"); // 검색어
        // const cp = params.get("cp"); // cp
        // let qs = [];
        // let str;
        // (function makeQS(){

        //     if(key!=null){
        //         qs.push(`key=${key}`)
        //         console.log("key는" + key);
        //         console.log(qs);
        //     }
        //     if(query!=null){
        //         qs.push(`query=${query}`)
        //         console.log("query는" +query);
        //         console.log(qs);
        //     }
        //     if(cp!=null){
        //         qs.push(`key=${cp}`)
        //         console.log("cp는"+ cp)
        //         console.log(qs);
        //     }

        // if(qs.length==1){
        //     str+=`?${qs[0]}`
        // } else if(qs.length==2){
        //     str+=`?${qs[0]}`
        //     str+=`&${qs[1]}`
        // } else if(qs.length==3){
        //     str+=`?${qs[0]}`
        //     str+=`&${qs[1]}`
        //     str+=`&${qs[2]}`
        // }

        // })(key, query, cp);


        // 셋다 같은 결과임

        //history.back();
        // const referer = document.referrer;
        // location.href = `${referer}`;
        location.href = "/board/" + boardCode + location.search;
        // location.search : 쿼리스트링만 반환
    });

}