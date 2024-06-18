
// 색 출력 영역

// 요소를 얻어와서 변수에 저장


const container = document.querySelectorAll('.container');
const area = document.querySelectorAll('.area');
const box = document.querySelectorAll('.box');
const boxColor = document.querySelectorAll('.box-color');

// JS로 CSS 추가하기

// container 클래스 요소에 display : flex 추가
for (let i = 0; i < container.length; i++) {
    container[i].style.display = 'flex';
}
const boxColor1 = [];
console.log(boxColor1);
console.log(boxColor);

// for of문 사용 가능

// area 클래스 요소에
// 높이 170px, 너비 150px, 테두리 1px 검정색 실선
// display : flex, main-axis 방향 : 열(세로)
for (let i = 0; i < area.length; i++) {
    area[i].style.height = '170px';
    area[i].style.width = '150px';
    area[i].style.border = '1px solid black';
    area[i].style.display = 'flex';
    area[i].style.flexDirection = 'column';
}
// box 클래스 요소에 높이 150px, 아랫쪽 테두리 1px 실선 검정색

for (let i = 0; i < box.length; i++) {
    box[i].style.height = '150px';
    box[i].style.borderBottom = '1px dotted black';
}
// box-color 클래스 요소의 테두리와 outline을 없애기
for (let i = 0; i < boxColor.length; i++) {
    boxColor[i].style.outline = 'none';
    boxColor[i].style.borderStyle = 'none';
}

// box-color 클래스 요소의 입력된 값이 변했을 때
// 위에있는 box 클래스 요소의 배경색을 변경
// + 입력된 input요소 글씨색도 변경

for(let i=0; i< boxColor.length; i++){
    boxColor[i].addEventListener('change', function(){
        box[i].style.backgroundColor=`${boxColor[i].value}`;
        boxColor[i].style.color=`${boxColor[i].value}`;
    });
}


// transition-duration 변경 버튼 클릭 시
// #input1에 작성된 값 만큼의 transition-duration을
// 모든 box 요소에 추가
// + #print1 요소의 내용을 #input1에 작성된 값으로 변경
document.querySelector('#btn1').addEventListener('click',function(){
    for(let i=0; i<box.length; i++){
        box[i].style.transitionDuration = `${document.querySelector('#input1').value}s`;
    }
    document.querySelector('#print1').innerText=`${document.querySelector('#input1').value}`;
    document.querySelector('#input1').value= '';
});


// #clearBtn 클릭 시
// .box의 모든 배경색을 없애고
// .box-color에 작성된 값도 없애기

document.querySelector('#clearBtn').addEventListener('click', function(){
    for (let i = 0; i < box.length; i++) {
        box[i].style.backgroundColor = 'white';
    }

    for(let i=0; i< boxColor.length; i++){
        boxColor[i].value = '';
    }



});