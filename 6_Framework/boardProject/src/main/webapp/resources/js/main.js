
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


// 이메일을 입력 받아 일치하는 회원의 정보를 조회
const inputEmail=document.getElementById("inputEmail");
const btn2=document.getElementById("btn2");
const result2=document.getElementById("result2");

btn2.addEventListener("click", e=>{

    // JSON "{K:V}"" "문자열" js 객체의 문자열이 JSON 

    // fetch() API를 이용한 POST 방식 요청
    fetch( `/selectMember`, {
        method : "POST" ,
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({"email" : inputEmail.value})
        // JSON.stringify() : JS 객체 -> JSON
        // JSON.parse()     : JSON -> JS 객체
    })
    .then(res => res.json()) // 응답 객체를 매개변수로 얻어와 파싱
    .then(member => {
        // 파싱한 데이터 이용해서 비동기 처리 후 동작할 코드 작성
        // let addr= member.memberAddress;
        // addr = addr.split("^^^");
        // document.querySelector("#result2").innerText="";
        // document.querySelector("#result2").insertAdjacentHTML("afterbegin",
        //     `<table>
        //     <tr>
        //         <td>번호</td>
        //         <td>이메일</td>
        //         <td>닉네임</td>
        //         <td>번호</td>
        //         <td>주소</td>
        //         <td>가입일</td>
        //     </tr>
        //     <tr>
        //         <td>${member.memberNo}</td>
        //         <td>${member.memberEmail}</td>
        //         <td>${member.memberNickname}</td>
        //         <td>${member.memberTel}</td>
        //         <td>${addr}</td>
        //         <td>${member.enrollDate}</td>
        //     </tr>
        //     </table>`
        // )

        // 템플릿 리터럴(Template literals)
        // 내장된 표현식을 허용하는 문자열 리터럴로
        // 표현식이나 문자열 삽입, 여러 줄 문자열, 문자열 형식화 등 다양한 기능 제공
        // ES6부터 사용(`)가능
        //---------------------------------------------------------------------------
        document.querySelector("#result2").innerText="";

        const li1 = document.createElement("li");
        li1.innerText = `회원번호 : ${member.memberNo}`;
        const li2 = document.createElement("li");
        li2.innerText = `회원이메일 : ${member.memberEmail}`;
        const li3 = document.createElement("li");
        li3.innerText = `회원닉네임 : ${member.memberNickname}`;
        const li4 = document.createElement("li");
        li4.innerText = `회원전화번호 : ${member.memberTel}`;
        const li5 = document.createElement("li");
        li5.innerText = `회원주소 : ${member.memberAddress}`;
        const li6 = document.createElement("li");
        li6.innerText = `회원가입일 : ${member.enrollDate}`;

        result2.append(li1, li2,li3,li4,li5,li6);

    })
    .catch(err=>
        result2.innerText="일치하는 회원이 없습니다."
    )

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

//닉네임을 이용해서 전화번호 조회
function selectTel(nickname){
    fetch("/selectTel?nickname="+nickname)
    .then(response=> response.text())
    // resp: 응답 객체
    // resp.text():응답 객체 내용을 문자열로 변환하여 반환
    .then(tel=>{
        // tel: 파싱되어 반환된 값이 저장된 변수
        
        // 비동기 요청 후 수행할 코드
        document.querySelector("#result1").innerText=tel;
    })
    .catch(e=>{
        console.log(e);
    })
}

const input=document.getElementById("input");
const btn3=document.getElementById("btn3");

btn3.addEventListener("click", e=>{

    fetch(`/selectMemberEmail`, {
        method: "POST" , 
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({
            email : input.value
        })

    })
    .then(res=>res.json())
    .then(member=>{

        document.querySelector("#result3").innerText="";

        member.forEach(el => {
            
            document.querySelector("#result3").insertAdjacentHTML("beforeend", 
                `<tr>
                    <td>${el.memberNo}</td>
                    <td>${el.memberEmail}</td>
                    <td>${el.memberNickname}</td>
                </tr>`
            )

        });
        
    })
    .catch(err=>{
        console.log(err);
    })

});

// -----------------------------------------------------------------------------------------------
// 웹 소켓 테스트

// 1. SockJS라이브러리 추가

// 2. SockJS를 이용해서 클라이언트용 웹소켓 객체 생성가능

let testSock = new SockJS("/testSock");

function sendMessage(name, str){


    // 매개변수를 JS 객체에 저장
    let obj = {}; //비어있는 객체

    obj.name = name; //객체에 일치하는 key가 없다면 자동으로 추가
    obj.str = str;

    //console.log(obj);

    // 웹 소켓 연결된 곳으로 메세지 보내기
    let data = JSON.stringify(obj);
              // JS 객체 -> JSON
    
    testSock.send(data);

}
// 웹 소켓 객체(testSock)가 서버로부터 전달받은 메시지가 있을 경우
testSock.onmessage = e =>{
    // e: 이벤트 객체
    // e.data : 전달 받은 메세지

    console.log(`e는 이거임 : ${e}`);
    console.log(`e.data는 이거임 : ${e.data}`);
    let obj = JSON.parse(e.data);
    
    console.log(`보낸 사람 : ${obj.name} / 메시지 : ${obj.str}`);

}