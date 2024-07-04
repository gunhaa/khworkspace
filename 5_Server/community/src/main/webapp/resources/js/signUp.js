// 전화번호 유효성 검사

const memberTel= document.querySelector("input[name='memberTel']");
const telMessage = document.querySelector("#telMessage");

// 유효성 검사 여부를 기록할 객체 생성

const checkObj = {
    "memberEmail" : false,
    "memberPw" : false , 
    "memberPwConfirm" : false,
    "memberNickname" : false,
    "memberTel" : false 
};


// **input 이벤트 : 입력과 관련된 모든 동작(key 관련, mouse 관련, 붙여넣기)
memberTel.addEventListener("input", ()=>{


    // 전화 번호 정규식

    if(memberTel.value.trim().length==0){
        telMessage.innerText = "전화번호를 입력해주세요. (-제외)";
        // telMessage.classList.remove("error");
        // telMessage.classList.remove("confirm");
        telMessage.classList.remove("confirm", "error");
        checkObj.memberTel=false; //유효하지 않은 상태임을 기록
        return;
    }

    // 전화번호 정규식

    const telreg=/^0(10|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; 

    if(telreg.test(memberTel.value)){//유효한 경우
        // 초록색 글씨 : 유효한 전화번호 형식입니다.
        telMessage.innerText = "유효한 전화번호 형식입니다.";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");
        checkObj.memberTel=true; // 유효한 상태를 기록  
    }else{
        // 빨간색 글씨 : 전화번호 형식이 올바르지 않습니다.
        telMessage.innerText = "전화번호 형식이 올바르지 않습니다.";
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm"); 
        checkObj.memberTel=false;   
    }

});


// 이메일 유효성 검사


const memberEmail = document.querySelector("input[name='memberEmail']");
const emailMessage = document.querySelector(".signUp-message");


memberEmail.addEventListener("input", ()=>{

    const regEmail = /^[\w\-\_]{4,}@[a-z]+(\.\w+){1,3}$/;

    if(memberEmail.value.trim().length==0){
        emailMessage.innerText="이메일을 입력해주세요";
        emailMessage.classList.remove("error");
        emailMessage.classList.remove("confirm");
        checkObj.memberEmail=false;
        return;
    } 
    if(regEmail.test(memberEmail.value)){
        emailMessage.innerText="유효한 이메일 입니다."
        emailMessage.classList.add("confirm");
        emailMessage.classList.remove("error");
        checkObj.memberEmail=true;
    }else{
        emailMessage.innerText="유효하지 않은 이메일 입니다."
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");
        checkObj.memberEmail=false;
    }

});

const nicknameMessage=document.querySelector("#nicknameMsg");
const memberNickname=document.querySelector("#memberNickname");

memberNickname.addEventListener("input", ()=>{

    const regChk = /^[가-힣a-zA-Z0-9]{2,10}$/;

    if(memberNickname.value.trim().length==0){
        nicknameMessage.innerText="닉네임을 입력해주세요";
        nicknameMessage.classList.remove("error");
        nicknameMessage.classList.remove("confirm");
        checkObj.memberNickname=false;
        return;
    } 
    if(regChk.test(memberNickname.value)){
        nicknameMessage.innerText="유효한 닉네임 입니다."
        nicknameMessage.classList.add("confirm");
        nicknameMessage.classList.remove("error");
        checkObj.memberNickname=true;
    }else{
        nicknameMessage.innerText="유효하지 않은 닉네임 입니다."
        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");
        checkObj.memberNickname=false;
    }

});


const pwMessageText=document.querySelector("#pwMessage");
const memberPwInput=document.querySelector("#memberPw");
const memberPwInputConfirm=document.querySelector("#memberPwConfirm");

memberPwInput.addEventListener("input", ()=>{

    const regPw = /^[\w!@#\-]{6,30}$/;

    if(memberPwInput.value == ""){
        pwMessageText.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요";
        pwMessageText.classList.remove("confirm", "error");
        checkObj.memberPw=false;
        return;
    }

    if(regPw.test(memberPwInput.value)){ // 비밀번호가 유효한 경우
        checkObj.memberPw=true;

        if(memberPwInputConfirm.value.length==0){ //비밀번호 유효, 비밀번호 확인 작성 X
            pwMessageText.innerText = "비밀번호 확인을 작성해주세요";
            pwMessageText.classList.remove("confirm");
            pwMessageText.classList.add("error");
        } else{ //비밀번호 유효, 비밀번호 확인 작성 O

            checkPw(); // 비밀번호 일치 검사 함수 호출();
        }



        pwMessageText.innerText = "유효한 비밀번호 형식입니다.";
        pwMessageText.classList.add("confirm");
        pwMessageText.classList.remove("error");


    } else{
        pwMessageText.innerText = "비밀번호 형식이 올바르지 않습니다.";
        pwMessageText.classList.remove("confirm");
        pwMessageText.classList.add("error");
        checkObj.memberPw=false;



    }
});

// 비밀번호 확인 유효성 검사

// 함수명() : 함수 호출(수행)
// 함수명   : 함수에 작성된 코드 반환
memberPwInputConfirm.addEventListener("input", checkPw);
// -> 이벤트가 발생 되었을 때 정의 된 함수를 호출하겠다.


// 비밀번호 일치 검사
function checkPw(){
    const regPw = /^[\w!@#\-]{6,30}$/;
    // 비밀번호 / 비밀번호 확인이 같을 경우
    if(memberPwInput.value==memberPwInputConfirm.value){
        // 초록 글씨 : 비밀번호가 일치 합니다.
        pwMessageText.innerText = "비밀번호가 일치합니다";
        pwMessageText.classList.add("confirm");
        pwMessageText.classList.remove("error");
        checkObj.memberPwConfirm=true;

    } else{

        // 빨간 글씨 : 비밀번호가 일치하지 않습니다.
        pwMessageText.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessageText.classList.remove("confirm");
        pwMessageText.classList.add("error");
        checkObj.memberPwConfirm=false;

    }
}


// 회원 가입 버튼 클릭시 유효성 검사가 완료되었는지 확인



function signUpValidate(){
    let str;
    // checkObj에 있는 모든 속성을 반복 접근하여 
    // false가 하나라도 있는 경우 form 태그의 기본 이벤트 제거
    for (let key in checkObj){

        if(!checkObj[key]){

            // console.log(`${key}가 유효하지 않습니다..`);
            // document.querySelector(`#${key}`).focus();
            // return false;
            // 위 방식으로도 가능

            switch(key){
                case "memberEmail" : str = "이메일이"; break;
                case "memberPw" : str = "비밀번호가"; break;
                case "memberPwConfirm" :  str = "비밀번호 확인이"; break;
                case "memberNickname" : str = "이메일이"; break;
                case "memberTel" : str = "이메일이"; break;
            }

            alert(str+" 유효하지 않습니다.");
            document.getElementById(key).focus();
            return false;


        }
    }
    
    console.log("true로 바꾸면 끝임");
    return false;
}
