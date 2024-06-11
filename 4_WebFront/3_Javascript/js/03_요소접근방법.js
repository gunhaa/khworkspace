
// id로 접근하기

function accessId() {

    const div1 = document.getElementById("div1");

    // 접근한 요소의 배경색 얻어오기

    const bgColor = div1.style.backgroundColor;
    // 자바 스크립트는 문자열 비교시에도 비교 연산자를 사용 !!
    if (bgColor === "red") {
        div1.style.backgroundColor = "yellow";
        // div1의 배경색을 yellow로 변경
    } else {
        div1.style.backgroundColor = "red";
        // bgColor="red"; 왜 안됨? -> 변수를 바꾸는건 의미가 없음
        // div1의 배경색을 red 로 변경
    }

}

function accessClass() {
    const arr = document.getElementsByClassName("div2");
    // 요소를 여러개 접근하는 경우 [배열]형태로 반환됨
    console.log(arr);

    // console.log(arr);

    // 인덱스를 이용해서 요소에 하나씩 접근
    arr[0].style.backgroundColor = "red";
    arr[0].innerHTML = "첫번째 요소";
    arr[1].style.backgroundColor = "blue";
    arr[1].innerHTML = "두번째 요소";
    arr[2].style.backgroundColor = "yellow";
    arr[2].innerHTML = "세번째 요소";
}

// 태그 명으로 접근하기
function accessTagName() {

    // 문서 내 모든 li태그 접근
    const arr = document.getElementsByTagName("li");

    console.log(arr);

    // 반복문

    for (let i = 0; i < arr.length; i++) {
        const num = arr[i].innerText; // 요소에 작성된 내용(숫자) 얻어오기
        arr[i].style.backgroundColor = "rgb(130,200," + (50 * num) + ")";
    }

}

function inputTest() {

    const input = document.querySelector("#input-test");

    const value = input.value;

    console.log(value);


    // **innerText / innerHTML은
    //   요소의 내용(시작 태그, 종료 태그 사이에 작성된 내용)을
    //   얻어오거나, 변경할 때만 사용 가능

    // **input은 [value]를 이용해서 값을 얻어오거나 변경할 수 있음
    // input에 작성된 값 변경하기
    input.value = ""; //빈 문자열 === value 지우기

    // input에 초점 맞추기

    input.focus();
    // 계속 초점이 있게 만드는방법

}

function accessName() {

    const hobbyList = document.getElementsByName("hobby");

    let str = "";

    let count =0;
    for (let i = 0; i < hobbyList.length; i++) {


        // *radio/checkbox 전용 속성*
        //.checked : 해당 요소가 체크되어있으면 true, 아니면 false 반환

        if (hobbyList[i].checked) { //현재 요소가 체크되어 있으면

            //str 변수에 값을 누적해준다.
            str += hobbyList[i].value + " ";
            count +=1;

            // count++; 도 가능하다
        }

    }

    const div = document.querySelector("#name-div").innerHTML=`${str} <br> 갯수 : ${count}`;
}

function accessCSS(){
    // querySelector() : 요소 1개 선택 시 사용
    //                   (여러 요소가 선택되면 첫 번째 요소만 선택)

    // 1개만 있는 요소 선택
    const cssdiv=document.querySelector("#css-div");

    cssdiv.style.border = "2px solid red";    

    // 여러개 있는 요소 선택(첫번째 요소 선택 확인)

    document.querySelector("#css-div>div").style.fontSize = "30px";

    // querySelectorAll() : 모든 요소 선택시 사용

    const arr = document.querySelectorAll("#css-div > div");

    // 배경 색을 원하는 색상으로 바꾸고 실행

    for(let i=0 ; i<arr.length ; i++ ){
        arr[i].style.backgroundColor="red";
    }

}