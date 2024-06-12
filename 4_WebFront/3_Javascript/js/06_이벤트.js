
//인라인 이벤트 모델 확인하기

function test1(button) {
    button.style.backgroundColor = "green";
    button.style.color = "white";
}

// 고전 이벤트 모델 확인하기
console.log(document.getElementById("test2-1"))
document.getElementById('test2-1').onclick = function () {
    // 익명 함수(이벤트 핸들러에 많이 사용함)
    alert("고전 이벤트 모델 확인");
};

document.getElementById("test2-2").onclick = function () {

    // test2-1 이벤트 제거
    document.getElementById("test2-1").onclick = null;
    alert("test2-1이벤트 제거")
}

// 고전 이벤트 모델 단점
// -> 한 요소에 동일한 이벤트 리스너(onclick)에 대한
//    다수의 이벤트 핸들러(배경색 변경, 폰트크기 변경)를 작성할 수 없다.
//    (마지막으로 해석된 이벤트 핸들러만 적용됨)

document.getElementById("test2-3").onclick = function (event) {


    // 버튼 색 바꾸기
    // 방법1 요소를 문서에서 찾아서 선택
    // document.getElementById("test2-3").style.backgroundColor="red";
    
    // 방법2) 매개변수 e또는 event 활용하기
    // -> 이벤트 핸들러에 e또는 event를 작성하는 경우
    // 해당 이벤트와 관련된 모든 정보가 담긴 이벤트 객체가 반환됨
    // event.target : 이벤트가 발생한 요소
    // console.log(event);
    // event.target.style.backgroundColor="red";

    // 방법3) this 활용하기 -> 이벤트가 발생한요소(event.target과 동일)
    console.log(this);
    this.style.backgroundColor="yellow";
};

// document.getElementById("test2-3").onclick=function(){
//     document.getElementById("test2-3").style.fontSize="50px";
// }

// 표준 이벤트 모델

document.getElementById("test3").addEventListener("click", function(){

    // this : 이벤트가 발생한요소(test3)
    // console.log(this.clientWidth); // 해당 요소의 너비(테두리 제외)
    // console.log(this.offsetWidth); // 해당 요소의 너비(테두리 포함)
    // this.style.width = "300px";

    this.style.width = this.clientWidth + 20+ "px";
});

// test3에 이미 click 이벤트에 대한 동작이 존재하는데
// 중복으로 적용

document.getElementById("test3").addEventListener("click", function(){
    
    // 높이 증가
    this.style.height = this.clientHeight+20+"px";
})

// 연습문제
// document.getElementById("changeBtn1").addEventListener("click", function(){
    
//     const input = document.querySelector("#input1").value;
//     document.querySelector("#div1").style.backgroundColor=input;
//     document.querySelector("#input1").value="";
    
// })

// input1의 값이 변경되었을 때 입력된 값으로 배경색 변경

document.querySelector("#input1").addEventListener("change", function(){
    // change이벤트 
    // -text관련 input태그는
    //  입력된 값이 변할 때는 change라고 하지 않고

    // 입력이 완료 된 후 포커스를 잃거나, 엔터를 입력하는 경우
    // 입력된 값이 이전과 다를 경우 change 이벤트가 발생한걸로 인식한다.
    console.log("change 이벤트 발생");

    const div1 = document.getElementById("div1");

    // input1에 작성된 값 얻어오가
    const bgColor = this.value;
    div1.style.backgroundColor = bgColor;
    this.value = "";
})
