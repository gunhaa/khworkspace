

// 좋아요 버튼이 클릭되었을 때
const boardLike = document.getElementById("boardLike");
let likeCount=document.querySelector("#likeCount").innerText;

    boardLike.addEventListener("click", e=>{

        // 로그인 여부 검사
        if(loginMemberNo==""){
            alert("로그인 후 이용해주세요");
            return;
        }


        let check; // 기존에 좋아요 X(빈하트) : 0
                   //       좋아요 O(꽉찬하트) : 1

        //contains("클래스명") : 클래스가 있으면 true, 없으면 false 반환
        if(e.target.classList.contains("fa-regular")){
            check=0;
        } else{
            check=1;
        }

        // ajax로 서버에 제출할 파라미터를 모아둔 js 객체
        const data = {
            "boardNo" : boardNo,
            "memberNo" : loginMemberNo,
            "check" : check
        }

        // ajax 코드 작성
        fetch("/board/like", {
            method : "POST",
            headers : {
                "Content-Type": "application/json",
            },
            body : JSON.stringify(data)
        }).then(response =>  response.text() // 응답 객체를 필요한 형태로 파싱해서 리턴 // return값만 들어가있으면 생략이 가능하다. 

        ).then(result => {//파싱된 데이터를 받아서 처리하는 코드
            
            console.log(likeCount);

            if(result==-1){
                alert("좋아요 도중 에러가 발생했습니다.");
            } else {

                if(result==likeCount){
                    alert("좋아요가 눌러졌습니다.");
                    document.querySelector("#likeCount").innerText=result;
                } else{
                    alert("좋아요가 취소되었습니다.");
                    document.querySelector("#likeCount").innerText=result;
                }

            }


            
            // toggle() : 클래스가 있으면 제거, 없으면 추가
            e.target.classList.toggle("fa-regular");
            e.target.classList.toggle("fa-solid");

        }).catch(e=>{
            console.log("예외 발생");
        })

            
        




    });
