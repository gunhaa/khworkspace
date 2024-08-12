// 회원 가입 JS
/* 정규 표현식(Regular Expression)
    https://regexper.com/
    https://regexr.com/
    https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/%EC%A0%95%EA%B7%9C%EC%8B%9D

    - 특정한 규칙을 가진 문자열 집합을 표현하는데 사용하는 형식 언어
    - 문자열에 대한 검색, 일치 여부, 치환 등을 수행할 수 있음


    *** JS 정규표현식 객체 생성 방법 ***

    1.  const regEx = new RegExp("정규표현식");
    2.  const regEx = /정규표현식/;


    *** 정규표현식 객체가 제공하는 메서드(함수) ***
    1.  regEx.test(문자열)
        -> 문자열이 정규표현식 패턴에 부합하면 true, 아니면 false

    2.  regEx.exec(문자열)
        -> 문자열이 정규표현식 패턴에 부합하면
            첫 번째 매칭되는 문자열을 반환,
            없으면 null 반환


     *** 정규 표현식의 메타 문자***
        
    문자열의 패턴을 나타내는 문자.
    문자마다 지정된 특별한 뜻이 담겨있다.
    
    a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
    [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
    ^(캐럿) : 문자열의 시작을 의미
    $(달러) : 문자열의 끝을 의미

    \w (word, 단어) : 아무 글자(단, 띄어쓰기, 특수문자, 한글 X)
    \d (digit, 숫자) : 아무 숫자(0~9 중 하나)
    \s (space, 공간) : 아무 공백 문자(띄어쓰기, 엔터, 탭 등)

    [0-9]  : 0부터 9까지 모든 숫자
    [ㄱ-힣] : ㄱ부터 힣까지  모든 한글

    [가-힣] : 가부터 힣까지  모든 한글(자음만, 모음만 있는 경우 제외)

    [a-z] : 모든 영어 소문자
    [A-Z] : 모든 영어 대문자

    * 특수문자의 경우 각각을 입력하는 방법밖엔 없음
    단, 메타문자와 중복되는 특수문자는 
    앞에 \(백슬래시)를 추가하여 탈출 문자(Escape)로 만들어 사용

    * 수량 관련 메타 문자
    a{5} : a문자가 5개 존재 == aaaaa
    a{2,5} : a가 2개 이상 5개 이하 ==  aa, aaa, aaaa, aaaaa
    a{2,} : a가 2개 이상
    a{,5} : a가 5개 이하


    * : 0개 이상 == 0번 이상 반복 == 있어도되고, 없어도 되고

    + : 1개 이상 == 1번 이상 반복

    ? : 0개 또는 1개

    . : 1칸 (개행문자를 제외한 문자 하나)
*/


// JS 객체 : { "K" : V , "K" : V}

// 특징
// 1) 원하는 객체의 value
//    - 객체명.key
//    - 객체명[key]

// 2) 객체에 특정 key가 존재하지 않을 때 추가하기
// ex) const obj = {"a" :1, "b" :2}
//     obj.c = 3; // {"a" : 1, "b" : 2, "c" : 3}

// 3) 객체에 특정 key 삭제하기 (delete 연산자)
// ex) const obj = {"a" : 1 , "b" : 2}
// delete obj.b; // {"a" : 1}

// 유효성 검사 진행 여부를 위한 확인용 객체

const checkObj = {
    isCheckedEmail: false,
    isCheckedPw: false,
    isCheckedPwConfirm: false,
    isCheckedNick: false,
    isCheckedTel: false,
    isCheckedAddr: true,
    authKey: false
}




// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");
// 이메일이 입력될 때 마다
memberEmail.addEventListener("input", e => {

    // 입력된 이메일이 없을 경우
    if (memberEmail.value.trim().length == 0) {
        emailMessage.innerText = "이메일을 받을 수 있는 이메일을 입력해주세요.";
        memberEmail.value = "";
        emailMessage.classList.remove("confirm");
        emailMessage.classList.remove("error");
        checkObj.isCheckedEmail = false;
        return;
    }

    // 정규 표현식을 이용해서 유효한 형식인지 판별
    // 1) 정규 표현식 객체 생성
    // 앞에 4글자 이상 , @ , 아무 글자.아무글자

    const regEx = /^[\w\-\_]{4,}@[a-z]+(\.\w+){1,3}$/;

    // 입력 받은 이메일과 정규 표현식의 일치 확인
    if (regEx.test(memberEmail.value)) {

        // emailMessage.innerText = "유효한 이메일 형식입니다.";
        // emailMessage.classList.add("confirm");
        // emailMessage.classList.remove("error");
        // checkObj.isCheckedEmail = true;

        //이메일 중복 판별
        selectEmail(memberEmail.value);

    } else {

        emailMessage.innerText = "유효하지 않은 이메일 형식입니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");
        checkObj.isCheckedEmail = false;
    }

});
// 입력된 이메일이 없을 경우
// 메일을 받을 수 있는 이메일을 입력해주세요. 문구 출력

//비밀번호 유효성 검사
const memberPw1 = document.querySelector("#memberPw");
const memberPw2 = document.querySelector("#memberPwConfirm");
const pwMessage = document.querySelector("#pwMessage");

memberPw1.addEventListener("input", e => {

    if (memberPw1.value.trim().length == 0) {

        pwMessage.innerText = "비밀번호를 입력해주세요."
        memberPw1.value = "";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.isCheckedPw = false;
        return;
    }

    const regEx = /^[a-zA-Z!@#-_]{6,20}$/;
    // 입력 받은 비밀번호와 정규표현식 일치 확인
    if (regEx.test(memberPw1.value)) { // 유효한 경우

        checkObj.isCheckedPw = true;

        if (checkObj.isCheckedPwConfirm == false) {

            pwMessage.innerText = "유효한 형식 입니다.";
            pwMessage.classList.remove("error");
            pwMessage.classList.add("confirm");
        } else {
            // 비밀번호가 유효하게 작성된 상태에서
            // 비밀번호 확인이 입력된 경우
            if (memberPw1.value == memberPw2.value) {
                pwMessage.innerText = "비밀번호가 일치합니다.";
                pwMessage.classList.remove("error");
                pwMessage.classList.add("confirm");
            } else {
                pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
                pwMessage.classList.remove("confirm");
                pwMessage.classList.add("error");
            }
        }



    } else {

        pwMessage.innerText = "유효하지 않은 비밀번호 형식입니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.add("confirm");
        checkObj.isCheckedPw = false;

    }


});
// 비밀번호 확인 유효성 검사
memberPw2.addEventListener("input", e => {


    if (checkObj.isCheckedPw) { //비밀번호가 유효하게 작성된 경우

        // 비밀번호 == 비밀번호 확인
        if (memberPw1.value == memberPw2.value) {
            pwMessage.innerText = "비밀번호가 일치합니다.";
            pwMessage.classList.remove("error");
            pwMessage.classList.add("confirm");
            checkObj.isCheckedPwConfirm = true;
        } else {
            pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
            pwMessage.classList.remove("confirm");
            pwMessage.classList.add("error");
            checkObj.isCheckedPwConfirm = false;
        }
    } else { //비밀번호가 유효하지 않은 경우
        pwMessage.innerText = "비밀번호를 확인해주세요";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.add("error");
        checkObj.isCheckedPwConfirm = false;
    }

    if (memberPw2.value.trim().length == 0) {

        pwMessage.innerText = "비밀번호 확인을 입력해주세요."
        memberPw2.value = "";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.remove("error");
        checkObj.isCheckedPwConfirm = false;
        return;
    }

});

//닉네임 유효성 검사
const memberNick = document.querySelector("#memberNickname");
const nickMessage = document.querySelector("#nickMessage");

memberNick.addEventListener("input", e => {

    if (memberNick.value.trim().length == 0) {

        nickMessage.innerText = "닉네임을 입력해주세요."
        memberNick.value = "";
        nickMessage.classList.remove("confirm");
        nickMessage.classList.remove("error");
        checkObj.isCheckedNick = false;
        return;
    }

    const regEx = /^[가-힣a-zA-Z0-9]{2,10}$/;
    // 입력 받은 비밀번호와 정규표현식 일치 확인
    if (regEx.test(memberNick.value)) {

        // nickMessage.innerText = "유효한 닉네임 형식입니다.";
        // nickMessage.classList.add("confirm");
        // nickMessage.classList.remove("error");
        // checkObj.isCheckedNick = true;


        selectNick(memberNick.value);

    } else {

        nickMessage.innerText = "유효하지 않은 닉네임 형식입니다.";
        nickMessage.classList.add("error");
        nickMessage.classList.add("confirm");
        checkObj.isCheckedNick = false;
    }
});

//전화번호 유효성 검사
const memberTel = document.querySelector("#memberTel");
const telMessage = document.querySelector("#telMessage");

memberTel.addEventListener("input", e => {

    if (memberTel.value.trim().length == 0) {

        telMessage.innerText = "전화번호를 입력해주세요."
        memberTel.value = "";
        telMessage.classList.remove("confirm");
        telMessage.classList.remove("error");
        checkObj.isCheckedTel = false;
        return;
    }

    const regTel = VerEx()
        .startOfLine()
        .range('0', '9')
        .repeatPrevious(3)
        .range('0', '9')
        .repeatPrevious(4)
        .range('0', '9')
        .repeatPrevious(4)
        .endOfLine()

    const regEx = /^[0-9]{10,11}$/;
    // 입력 받은 비밀번호와 정규표현식 일치 확인
    if (regTel.test(memberTel.value)) {

        telMessage.innerText = "유효한 전화번호 형식입니다.";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");
        checkObj.isCheckedTel = true;

    } else {

        telMessage.innerText = "유효하지 않은 전화번호 형식입니다.";
        telMessage.classList.add("error");
        telMessage.classList.add("confirm");
        checkObj.isCheckedTel = false;
    }
});


// -------------------------- 이메일 인증 ---------------------------


// 인증번호 발송
const sendAuthKeyBtn = document.getElementById("sendAuthKeyBtn");
const authKeyMessage = document.getElementById("authKeyMessage");
let authTimer;
let authMin = 4;
let authSec = 59;


// 인증번호를 발송한 이메일 저장
let tempEmail;


sendAuthKeyBtn.addEventListener("click", function () {
    authMin = 4;
    authSec = 59;


    checkObj.authKey = false;


    if (checkObj.isCheckedEmail) { // 중복이 아닌 이메일인 경우


        sendAuthKeyBtn.disabled = true;


        /* fetch() API 방식 ajax */
        fetch("/sendEmail/signUp?email=" + memberEmail.value)
            .then(resp => resp.text())
            .then(result => {
                if (result > 0) {
                    console.log("인증 번호가 발송되었습니다.")
                    tempEmail = memberEmail.value;
                    //****** */

                } else {
                    console.log("인증번호 발송 실패")
                }
            })
            .catch(err => {
                console.log("이메일 발송 중 에러 발생");
                console.log(err);
            });


        alert("인증번호가 발송 되었습니다.");

        clearInterval(authTimer);


        authKeyMessage.innerText = "05:00";
        authKeyMessage.classList.remove("confirm");


        authTimer = window.setInterval(() => {


            authKeyMessage.innerText = "0" + authMin + ":" + (authSec < 10 ? "0" + authSec : authSec);

            // 남은 시간이 0분 0초인 경우
            if (authMin == 0 && authSec == 0) {
                checkObj.authKey = false;
                clearInterval(authTimer);
                return;
            }


            // 0초인 경우
            if (authSec == 0) {
                authSec = 60;
                authMin--;
            }




            authSec--; // 1초 감소


        }, 1000)


    } else {
        alert("중복되지 않은 이메일을 작성해주세요.");
        memberEmail.focus();
    }


});




// 인증 확인
const authKey = document.getElementById("authKey");
const checkAuthKeyBtn = document.getElementById("checkAuthKeyBtn");


checkAuthKeyBtn.addEventListener("click", function () {


    if (authMin > 0 || authSec > 0) { // 시간 제한이 지나지 않은 경우에만 인증번호 검사 진행
        /* fetch API */
        const obj = {
            "inputKey": authKey.value,
            "email": tempEmail
        }

        const query = new URLSearchParams(obj).toString()
        authKey.disabled = true;

        fetch("/sendEmail/checkAuthKey?" + query)
            .then(resp => resp.text())
            .then(result => {
                if (result > 0) {
                    clearInterval(authTimer);
                    authKeyMessage.innerText = "인증되었습니다.";
                    authKeyMessage.classList.add("confirm");
                    checkObj.authKey = true;
                    // *****************

                } else {
                    alert("인증번호가 일치하지 않습니다.")
                    checkObj.authKey = false;
                }
            })
            .catch(err => console.log(err));




    } else {
        alert("인증 시간이 만료되었습니다. 다시 시도해주세요.")
    }


});



// 주소 

// form 태그 제출 시 

// checkObj에 모든 value가 true인지 검사

// 유효하지 않은 input 태그로 focus 이동
// form 태그 기본 이벤트 제거
// 알림창 띄우기

document.querySelector("#signUpBtn").addEventListener("click", e => {

    for (let key in checkObj) {

        if (!checkObj[key]) {

            switch (key) {
                case "isCheckedEmail":
                    memberEmail.focus();
                    alert("이메일을 확인해주세요.");
                    break;
                case "isCheckedPw":
                    memberPw1.focus();
                    alert("비밀번호를 확인해주세요.");
                    break;
                case "isCheckedPwConfirm":
                    memberPw2.focus();
                    alert("비밀번호 확인을 확인해주세요.");
                    break;
                case "isCheckedNick":
                    memberNick.focus();
                    alert("닉네임을 확인해주세요.");
                    break;
                case "isCheckedTel":
                    memberTel.focus();
                    alert("번호를 확인해주세요.");
                    break;
                case "authKey":
                    sendAuthKeyBtn.focus();
                    alert("메일을 인증해주세요.");
                    break;
            }

            e.preventDefault();
            return;
        }

    }

});

function selectEmail(email) {

    fetch("/selectEmail?email=" + email)
        .then(response => response.text())
        // resp: 응답 객체
        // resp.text():응답 객체 내용을 문자열로 변환하여 반환(parsing, 데이터 형태 변환)
        .then(countEmail => {
            // tel: 파싱되어 반환된 값이 저장된 변수

            // 비동기 요청 후 수행할 코드
            if (countEmail == 1) {
                emailMessage.innerText = "이미 사용중인 이메일입니다.";
                emailMessage.classList.add("error");
                emailMessage.classList.remove("confirm");
                checkObj.isCheckedEmail = false;
            } else {
                emailMessage.innerText = "사용 가능한 이메일입니다.";
                emailMessage.classList.add("confirm");
                emailMessage.classList.remove("error");
                checkObj.isCheckedEmail = true;
            }
        })
        .catch(e => {
            console.log(e);
        })

}

//닉네임 중복 검사
function selectNick(nick) {

    fetch(`/selectNick?nick=${nick}`)
        .then(resp => resp.text())
        .then(nick => {

            if (nick == 0) {
                nickMessage.innerText = "사용할 수 있는 닉네임 입니다.";
                nickMessage.classList.add("confirm");
                nickMessage.classList.remove("error");
                checkObj.isCheckedNick = true;
            } else {
                nickMessage.innerText = "중복된 닉네임 입니다.";
                nickMessage.classList.add("error");
                nickMessage.classList.add("confirm");
                checkObj.isCheckedNick = false;
            }
        })
        .catch(e => {
            console.log(e);
        })

}


const curry = fn => fn2 => a => b => fn(a, b) + fn2(a, b);

const curry$1 =
 function(fn) {
    return function (fn2) {
        return function (a) {
            return function (b) {
                return fn(a, b) + fn2(a, b)
            }
        }
    }
}


const add = (a, b) => a + b;

const multiply = (a, b) => a * b;

console.log(curry(add)(multiply)(3)(5));
console.log("$1 : " + curry$1(add)(multiply)(3)(5));