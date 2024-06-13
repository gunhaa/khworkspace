// 정규 표현식 객체 생성 + 확인하기

document.querySelector("#check1").addEventListener("click" , function(){
    
    // 정규 표현식 객체 생성

    const regExp1 = new RegExp("script");
                                // "script" 와 일치하는 문자열이 있는지 검사하는 정규 표현식

    const regExp2 = /java/;
                    // "java"와 일치하는 문자열이 있는지 검사하는 정규 표현식

    // 확인하기
    const str1 = "저희는 지금 javascript 공부를 하고 있습니다.";

    const str2 = "servlet/jsp(java server page)도 조만간 합니다.";

    const str3 = "java, java, java";

    console.log("regExp1.test(str1) : "+ regExp1.test(str1) );
    console.log(regExp1.exec(str1) );
    
    console.log("regExp1.test(str2) : "+ regExp2.test(str2) );
    console.log(regExp2.exec(str2) );
    
    // 일치하는게 없는 경우
    console.log("regExp1.test(str2) : "+ regExp1.test(str2) );
    console.log(regExp1.exec(str2) );
    // 일치하는게 여러개 있을 경우
    console.log("regExp1.test(str2) : "+ regExp2.test(str3) );
    console.log(regExp2.exec(str3) );
    

})

document.getElementById("btn1").addEventListener("click", function(){
    const div1 = document.querySelector("#div1");

    // a(일반 문자열) : 문자열 내에서 a라는 문자열이 존재하는지 검색

    const regExp1 = /a/;
    div1.innerHTML = "/a/, apple : " + regExp1.test("apple") + "<hr>";
    div1.innerHTML += "/a/, price : " + regExp1.test("price") + "<hr>";

    // [abcd] : 문자열 내에 a,b,c,d 중에 하나라도 일치하는 문자가 있는지 검색
    const regExp2 = /[abcd]/;
    div1.innerHTML += "/[abcd]/, apple : " +regExp2.test("apple") + "<hr>"; 
    div1.innerHTML += "/[abcd]/, subway : " +regExp2.test("subway") + "<hr>"; 
    div1.innerHTML += "/[abcd]/, qwer : " +regExp2.test("qwer") + "<hr>"; 

    // ^(캐럿) : 문자열의 시작을 의미
    const regExp3 = /^group/; // 문자열의 시작이 "group"인지 확인
    div1.innerHTML += "/^group/, group100 : " + regExp3.test("group100") + "<hr>";
    div1.innerHTML += "/^group/, 100group : " + regExp3.test("100group") + "<hr>";

    // $(달러) : 문자열의 끝을 의미
    const regExp4 = /group$/; // 문자열의 시작이 "group"인지 확인
    div1.innerHTML += "/group$/, group100 : " + regExp4.test("group100") + "<hr>";
    div1.innerHTML += "/group$/, 100group : " + regExp4.test("100group") + "<hr>";

})

// 이름 유효성 검사

document.querySelector("#inputName").addEventListener("keyup", function(){

    // 한글 2~5글자 정규 표현식(정규식)
    const valueName = document.querySelector("#inputName").value;
    // 유효성 검사
    const span = document.querySelector("#inputNameResult");
    const regExp = /^[가-힣]{2,5}$/;

    if(regExp.exec(valueName)){
        // #inputName에 작성된 값이 유효한 경우
        // 초록 굵은 글씨, 유효한 이름 형식 입니다.
        span.innerHTML = "유효한 이름 형식입니다.";
        span.style.color = "green";
        span.style.fontweight = "bold";
    } else {
        // 빨간색 굵은 글씨, 이름 형식이 유효하지 않습니다.
        span.innerHTML = "이름이 유효하지 않습니다..";
        span.style.color = "red";
        span.style.fontweight = "bold";
    }

    // 빈칸 검사
    // 빈칸이라면 span에 작성된 내용 초기화(삭제)
    // if(valueName==""){
    //     span.innerHTML = "";
    // }
    // 또는

    if(this.value.length ==0){
        span.innerText = "";
    }

})


// 주민등록번호 유효성 검사

// 주민등록 번호 미작성인 경우
// -> 주민등록 번호를 작성해주세요

//주민등록번호 정규식
// 생년월일(6) - 고유번호(7)

// 유효한 경우
// -> 유효한 주민등록번호 형식입니다.
// 아닌경우
// 유효하지 않은 주민등록번호 형식입니다.

document.querySelector("#inputPno").addEventListener("keyup" ,function(){

    const spanPno = document.querySelector("#inputPnoResult");


    if(this.value.length == 0){
        spanPno.innerText = "주민등록번호를 작성해주세요."
        spanPno.classList.remove("error");
        spanPno.classList.remove("confirm");
        return; //함수 종료
    }

    // const regExp5 = /^[0-9]{6}-[0-9]{7}$/;
    // const regExp5 = /^\d{6}-\d{7}$/;
                    // 연도(2) 월(2) 일(2)
    // 업그레이드

    const regExp5 = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])-[1-4]\d{6}$/;

    // () : 포획 괄호, 괄호 내부에 대응되는 부분을 찾아서 기억함
    // |  : 또는

    //  비밀번호 8글자 이상 16글자 이하 ,숫자 영어 혼합의 조건
    // ^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$


    // 월
    // 01 ~ 09 -> 0[1-9]
    // 10 ~ 12 -> 1[0-2]

    // (0[1-9]|1[0-2]) : 괄호 내 |기호를 기준으로 구분되며
    // 0이 먼저 입력된 경우 다음 자리 1~9
    // 1이 먼저 입력된 경우 다음 자리 0~2
    
    // 일

    // 01 ~ 09 -> 0[1-9] 
    // 10 ~ 19 -> 1[0-9]
    // 20 ~ 29 -> 2[0-9]
    // 30 ~ 31 -> 3[0-1]

    // 요소.classList : 요소가 가지고 있는 클래스를 배열로 반환
    // 요소.classList.add("클래스명") : 요소의 특정 클래스 추가
    // 요소.classList.remove("클래스명") : 요소의 특정 클래스 제거

    if(regExp5.exec(this.value)){
        spanPno.innerText="유효한 주민등록번호 형식입니다.";
        spanPno.classList.add("confirm"); //confirm 클래스 추가
        spanPno.classList.remove("error");
    }
    else{
        spanPno.innerText="유효하지 않은 주민등록번호 형식입니다.";
        spanPno.classList.add("error");
        spanPno.classList.remove("confirm"); 
    } 
})