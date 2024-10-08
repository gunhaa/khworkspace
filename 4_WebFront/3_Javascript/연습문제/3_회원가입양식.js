
/* 아이디 : 값이 변했을 때 
영어 소문자로 시작하고, 
영어 대/소문자, 숫자, - , _ 로만 이루어진 6~14 글자 사이 문자열인지 검사
아이디 정규표현식 : (각자 작성)

- 형식이 일치할 경우
입력창의 배경색을 green 으로 변경

- 형식이 일치하지 않은 경우
입력창의 배경색을 red, 글자색을 white 로 변경*/

document.querySelector('#id').addEventListener('keyup', function () {
    const id = document.querySelector('#id');
    const RegExp = /^[a-z]+[a-z0-9A-Z-_]{5,13}$/;

    id.style.backgroundColor = 'red';
    id.style.color = 'white';

    if (RegExp.test(id.value)) {
        id.style.backgroundColor = 'green';
        id.style.color = 'black';
    } else {
        id.style.backgroundColor = 'red';
        id.style.color = 'white';
    }

// exec도 같은 역할을 수행한다.
// exec 메소드가 배열을 반환한다는 점은 맞습니다. 
// 하지만 자바스크립트에서는 배열을 포함한 모든 객체는 논리적으로 참(truthy)로 평가됩니다.
//  따라서 조건문에서 배열이 반환될 경우, 이는 참(true)으로 평가되어 조건이 만족됩니다. 
// 만약 exec 메소드가 일치하는 것을 찾지 못하면 null을 반환하며, null은 논리적으로 거짓(falsy)로 평가됩니다.
})

// ------------------------------------------------------------------

/* 비밀번호, 비밀번호 확인 : 키보드가 올라올 때 
"비밀번호" 를 미입력한 상태에서 "비밀번호 확인"을 작성할 경우
"비밀번호 확인"에 작성된 내용을 모두 삭제하고
'비밀번호를 입력해주세요' 경고창 출력 후
focus 를 "비밀번호" 입력창으로 이동
*/

document.querySelector('#pw2').addEventListener('keyup', () => {
    const pw1 = document.querySelector('#pw1');
    const pw2 = document.querySelector('#pw2');

    if (pw1.value.length == 0) {
        alert('비밀번호를 입력해주세요');
        pw1.focus();
        pw2.value = "";
    }
})


// ------------------------------------------------------------------

/*
- 비밀번호가 일치할 경우
"비밀번호" 입력창 오른쪽에 "비밀번호 일치" 글자를 초록색으로 출력.

- 비밀번호가 일치하지 않을 경우
"비밀번호" 입력창 오른쪽에 "비밀번호가 불일치" 글자를 빨간색으로 출력

- 비밀번호가 작성되지 않은경우 오른쪽에 출력되는 문구 삭제

*/

document.querySelector('#pw1').addEventListener('keyup', () => {
    const pw1 = document.querySelector('#pw1');
    const pw2 = document.querySelector('#pw2');
    const correct = document.querySelector('#correct');
    if (pw1.value.length == 0) {
        correct.innerText = '';
    } else if (pw1.value == pw2.value) {
        correct.innerText = '비밀번호 일치';
        correct.style.color = 'green';
    } else {
        correct.innerText = '비밀번호 불일치';
        correct.style.color = 'red';
    }
})


document.querySelector('#pw2').addEventListener('keyup', () => {
    const pw1 = document.querySelector('#pw1');
    const pw2 = document.querySelector('#pw2');
    const correct = document.querySelector('#correct');
    if (pw1.value.length == 0) {
        correct.innerText = '';
    } else if (pw1.value == pw2.value) {
        correct.innerText = '비밀번호 일치';
        correct.style.color = 'green';
    } else {
        correct.innerText = '비밀번호 불일치';
        correct.style.color = 'red';
    }
})


// -------------------------------------------------------------

/* 이름 : 값이 변화했을 때 
한글 2~5 글자 사이 문자열인지 검사.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "정상입력" 글자를 초록색으로 출력.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "한글만 입력하세요" 글자를 빨간색으로 출력.
*/

document.querySelector('#name').addEventListener('keyup', () => {
    const name = document.querySelector('#name');
    const correct = document.querySelector('#n-correct');
    const RegExp = /^[ㄱ-힣]{2,5}$/;

    if (RegExp.exec(name.value)) {
        correct.innerText = '정상 입력';
        correct.style.color = 'green';
    } else {
        correct.innerText = '한글만 입력하세요';
        correct.style.color = 'red';
    }
})

// -----------------------------------------------------------

/* 회원가입 버튼 클릭 시 : validate() 함수를 호출하여 
성별이 선택 되었는지, 전화번호가 형식에 알맞게 작성되었는지 검사 */

document.querySelector('#login-form').addEventListener('submit', validate)

function validate(e) {
    const signin = document.querySelector('#signin');
    // const loginForm = document.querySelector('#login-form');
    // loginForm.addEventListener('submit', function (e) {

        console.log('prevent');
    // })

    /*- 성별이 선택되지 않은 경우 
    "성별을 선택해주세요." 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.*/
    const check = document.querySelectorAll('[name=gender]')
    
    const regExptel = /^[0][0-9]{2}-[0-9]{3,4}-[0-9]{4}$/;
    const tel = document.querySelector('#tel');
    
    if (check[0].checked || check[1].checked) {
        
        if(regExptel.exec(tel.value)){
            alert('회원 가입이 완료되었습니다.');
            
        } else {
            alert('전화번호 형식이 올바르지 않습니다.');
            alert('전화번호를 입력해주세요')
            e.preventDefault();
            // return false; 도 사용 가능하다
        }
     
        
    } else {
        alert('성별을 선택해주세요');
        e.preventDefault();
    }
    /*
    - 전화번호 형식이 올바르지 않을 경우 
    "전화번호의 형식이 올바르지 않습니다" 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.
    */

}




