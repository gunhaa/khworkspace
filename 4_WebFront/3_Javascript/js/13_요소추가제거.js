
// 추가 버튼이 클릭 되었을 때
document.querySelector("#add").addEventListener("click", function () {

    // div요소 생성
    const div = document.createElement("div");

    // div에 row클래스 추가

    div.classList.add("row");

    // -----------------------------------------------

    // input 요소 생성
    const input = document.createElement("input");

    input.classList.add("in");

    // input에 "type" 속성, "number" 속성 값 추가(type="number")

    // - 요소.setAttribute("속성", "속성 값") : 요소에 속성/속성값 추가

    input.setAttribute('type', 'number');

    // span 요소 생성
    const span = document.createElement("span");
    span.classList.add("remove")
    span.innerText = 'X';

    // span이 클릭되었을 때에 대한 이벤트 동작 추가

    span.addEventListener("click", function () {
        // 요소.parentElement : 부모요소
        // 요소.remove() :요소 제거
        span.parentElement.remove();
    })

    // div 내부에(자식으로) input, span 순서대로 추가

    div.append(input);
    div.append(span);

    // #container에 div를 마지막 자식으로 추가    
    const container = document.querySelector("#container");
    container.append(div);


})


// 게산버튼 클릭 시 이벤트 동작

document.querySelector("#calc").addEventListener("click", function () {
    const input = document.querySelectorAll("input");

    let sum = 0;
    // input.forEach(function (input) {
    //     sum += Number(input.value);
    // })
    // console.log(sum);
    // alert(sum + '입니다');

    // 선생님의 풀이
    // in 클래스 요소를 모두 얻어옴 -> 배열 형태
    const list = document.getElementsByClassName("in");

    // 배열용 향상된 for 문

    for(let input of list ){
        // sum에 입력값 누적
        // -> input에 작성된 값은 모두 String -> 숫자 변환 필요
        sum+=Number(input.value);

        // Number("") ==0 // 빈칸은 0으로 변환됨
    }

    alert("합계 : "+ sum)
})