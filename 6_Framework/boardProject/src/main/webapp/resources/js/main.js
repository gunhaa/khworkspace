
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


document.querySelector("#btn1").addEventListener("click" , ()=>{

    const input = document.querySelector("#inputNickname");

    selectTel(input.value);

});

// 비동기로 이메일이 일치하는 회원의 닉네임 조회

function selectNickname(email){

    fetch("/selectNickname?email="+email)
      // 지정된 주소로 GET 방식 비동기요청(ajax)
    // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가
   .then(response => response.text()) // 요청에 대한 응답객체 (response)를 필요한 형태로 파싱
   .then(nickname=> {
        console.log(nickname);
   }) // 첫번째 then 에서 파싱한 데이터를 이용한 동작 작성
   .catch( e => {
        console.log(e);
   }) // 예외 발생 시 처리 할 내용을 작성
}

function selectTel(nickname){
    fetch("/selectTel?nickname="+nickname)
    .then(response=> response.text())
    .then(tel=>{
        document.querySelector("#result1").innerText=tel;
    })
    .catch(e=>{
        console.log(e);
    })
}