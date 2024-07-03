

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
