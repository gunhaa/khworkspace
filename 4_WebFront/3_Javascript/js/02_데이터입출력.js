

function fnAlert(){
    window.alert("alert 버튼 클릭 됨");
}

// window는 브라우저 자체를 나타내는 객체
// -> JS코드는 브라우저(window) 내부에서 실행되는 코드이다보니
//    window를 생략할 수 있다.

function documentWrite(){
    // document.write("document write 확인");

    document.write("<b>이제 곧 </b><br><h3>쉬는시간</h3>");
    // 출력할 문구에 html 태그가 있을 경우 해석해서 시각적인 요소로 보여짐
    
    let a = "<table border='1'>";
    a+="<tr>";
    a+="<td>1</td>";
    a+="<td>2</td>";
    a+="</tr></table>";
    document.write(a);
}

function getInnerText(){
    // HTML 문서 내에서 아이디가 "test1"인 요소를 얻어와
    // test1 변수에 대입

    const test1= document.querySelector("#test1");
   
    // test1 변수에 대입된 요소에서 내용을 얻어와 console에 출력
    console.log(test1.innerText);
}

   
function setInnerText(){
    // id가 "test1"인 요소를 얻어와
    const test1= document.querySelector("#test1");
    // test1 변수에 대입
    test1.innerHTML="innerText로 <br> 변경된 내용입니다.";
}

function getInnerHTML1(){
    const test2=document.querySelector("#test2");
    console.log(test2.innerHTML);
}
// innerHTML로 변경하기

function setInnerHTML2(){
    const test2=document.querySelector("#test2");
    test2.innerHTML='innerHTML로 변경될 내용입니다 <br> <b>변경된 내용</b>';
}

// innerHTML 응용

function add(){
    const area1 = document.querySelector("#area1");
    let content = area1.innerHTML;
    const plus = "<div class='box2'></div>";

    area1.innerHTML += plus;

    // content+=plus;는 왜 작동하지않음?
}

// confirm 확인하기
function fnConfirm(){
    const color = document.querySelector("#confirmBtn");
    if(confirm("버튼 배경색을 바꾸시겠습니까?")){
        color.style.backgroundColor="green";
    } else {
        color.style.backgroundColor="yellow"
    }
}


// prompt 확인하기
function fnPrompt1(){
    var name = prompt("이름은 무엇입니까?");
    var age = prompt("나이는 얼마입니까?");
    const input = document.querySelector("#area2");

    input.innerText = `이름 : ${name} 나이 : ${age}`;
    // input.innerHTML = "<b>"+name+age+"살입니다."+"</b>";
}

function fnPrompt2(){
    const input = prompt("이름을 입력해주세요.");

    // 이름이 입력 되었을 때
    // ~님 환영합니다.

    // 취소 버튼 눌렀을 때
    // 이름을 입력해주세요
    const textarea = document.querySelector("#area3");
    
    if(input === null){
        textarea.innerText = `이름을 입력해주세요`;
    }else {
        textarea.innerText = `${input}님 환영합니다.`;
    }

}

function fnInput(){
    
    const input1 = document.querySelector("#userId");
    const input2 = document.querySelector("#userPw");

    // console.dir(input1); 모든 속성 확인 가능

    const id = input1.value;
    const pwd = input2.value;

    console.log(id);
    console.log(pwd);
    // innerText는 시작태그와 종료태그 사이에 텍스트를 넣어준다.
    const input3= document.querySelector("#area4");
    input3.value=`${id} , ${pwd}`;
    input1.value = "";
    input2.value = "";
}