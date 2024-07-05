

// 로그인 시 이메일(아이디)/비밀번호 입력 확인

// -> 미작성 시 alert() 이용해서 메세지를 출력하고
//    로그인 form 태그의 제출을 막는 기본 이벤트 제거 진행

function loginValidate() { //로그인 유효성 검사
    //validate : 유효하다
    //invalidate : 무효하다
    // 이메일 요소

    // 비밀번호 요소

    let email = document.getElementsByName("inputEmail")[0];
    let pw = document.getElementsByName("inputPw")[0];


    //이메일이 입력되지 않은 경우 false 반환

    //비밀번호 입력하지 않은 경우 false 반환

    if (email.value.trim().length == 0) {
        // 문자열.trim() : 문자열 양쪽 공백 제거
        // 문자열.length : 문자열 길이

        alert("이메일 입력해주세요.");
        email.focus();
        return false;
    } else if (pw.value.trim().length == 0) {
        alert("비밀번호 입력해주세요.");
        pw.focus();
        return false;
    }

    return true;
}


document.getElementsByName("saveId")[0].addEventListener("change", function () {
    // 체크 요소 확인
    // this: change 이벤트가 발생한 요소(체크 박스)
    // 체크박스요소.checked : 체크 여부 반환(true/false)

    if (this.checked) { //체크박스가 체크 된 경우

        const str = "개인 정보 보호를 위해 개인 PC에서의 사용을 권장합니다. 개인 PC가 아닌 경우 취소를 눌러주세요.";

        //confirm() : 확인(true) / 취소(false) 대화 상자

        if (!confirm(str)) {
            this.checked = false;
        }
    }
});


// 회원 정보 조회 비동기 통신(AJAX)

document.querySelector("#select1").addEventListener("click", () => {

    const input = document.querySelector("#input1");
    const div = document.querySelector("#result1");


    // AJAX 코드 작성(jQuery) 방식 -> jQuery 라이브러리 추가 되어 있는지 확인
    $.ajax({
        // /community/member/selectOne
        // 현재 주소는 /community/index.jsp
        url : "member/selectOne",
        data : {memberEmail : input.value} , 
        type : "POST" ,
        dataType : "JSON" , // dataType : 응답 데이터 형식을 지정해줌
                          // -> "JSON" 으로 지정 시 자동으로 JS 객체로 변환 , 작성 안할 시 String으로 옴 (JSON이 들어오면 JS객체로 자동 파싱한다(JSON.parse()))
        success : (member)=>{

            console.log(member); // JS 객체 형태 문자열

            // JSON.parse(문자열) : 문자열 -> JS 객체로 변환
            // console.log(JSON.parse(member));
            // console.log(member.memberNickname);

            // 1) div에 작성된 내용 모두 삭제

            div.innerHTML="";


            if(member != null) { // 회원 정보 존재 O

                // 2) ul 요소 생성

                const ul = document.createElement("ul");
                
                // 3) li 요소 생성*5 내용추가
                let li1 = document.createElement("li");
                let li2 = document.createElement("li");
                let li3 = document.createElement("li");
                let li4 = document.createElement("li");
                let li5 = document.createElement("li");
                
                const arr= member.memberAddress;
                const str = arr.split(",,");
                let address = "";
                str.forEach((item)=>{
                    address += item;
                });

                li1.innerText = `이메일 : ${member.memberEmail}`;
                li2.innerText = `닉네임 : ${member.memberNickname}`;
                li3.innerText = `전화번호 : ${member.memberTel}`;
                li4.innerText = `주소 : ${address}`;
                li5.innerText = `가입일 : ${member.enrollDate}`;

                // 4) ul에 li를 순서대로 추가

                ul.append(li1,li2,li3,li4,li5);


                // 5) div에 ul추가 해주면 됨

                div.append(ul);

            } else { // 회원 정보 존재X

                // 1) H4 요소 생성

                const h4=document.createElement("h4");

                // 2) 내용 추가

                h4.innerText="이메일이 일치하는 회원이 없습니다.";
                
                // 3) 색 추가

                h4.style.color = "red";

                // 4) div에 추가
                div.append(h4);
            }


        }, 
        error : (request, status, error)=>{
            console.log("AJAX 에러 발생");

            console.log("상태 코드 : " + request.status); //404(거절 당함), 500(코드 잘못됨)
            console.log(request.responseText); // 에러메세지
            console.log(error); // 에러 객체 출력
        }

    });

});