
const loginForm = document.querySelector("#loginFrm");
const memberEmail = document.querySelector("#memberEmail");
const memberPw = document.querySelector("#memberPw");

if(loginForm != null) {

    //로그인 시도를 할때
    loginForm.addEventListener("submit", e=>{

        // 이메일이 입력되지 않은 경우


        if(memberEmail.value.trim().length==0){
            e.preventDefault();
            memberEmail.focus();
            memberEmail.value="";
            alert("이메일을 입력해주세요.");
            return;
        }

        // 비밀번호가 입력되지 않은 경우
        if(memberPw.value.trim().length==0){
            e.preventDefault();
            memberPw.focus();
            alert("비밀번호를 입력해주세요");
            return;
        }

    });

}