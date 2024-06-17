// JS와 jQuery 차이점

// 배경 : black
// 글자색 : yellow
// 글자 크기 : 20px

// Javascript


jsBtn.addEventListener('click', () => {
    const jsBtn = document.querySelector('#jsBtn');
    jsBtn.style.backgroundColor = 'black';
    jsBtn.style.color = 'yellow';
    jsBtn.style.fontSize = '20px';
    // 화살표 함수 안에서 this 사용 불가
})

// jQuery

$('#jQueryBtn').on('click', function(){
    $(this).css('backgroundColor' , 'black').css('color' , 'yellow').css('fontSize' , '20px');
})

// window.onload 확인



window.onload = () => { //문서 로딩이 완료 된 후 수행한다.
    console.log("1");
}
// window.onload 중복 작성 -> 앞서 작성한 window.onload를 덮어 씌움
window.onload = () => {
    console.log(3);
}
console.log(2);

// ready() 함수 확인
$(document).ready(function(){
    $('#readyTest').on('click', ()=>{
        alert('클릭');
    })
});

// ready()함수 중복 작성 -> 작성한 모든 내용이 적용됨

$(document).ready(function(){
    $('#readyTest').css('color', 'red');
})

// ready()함수 다른 형태
$(function(){
    console.log('ready 함수 다른 형태')
})

// ready() + 화살표 함수

$(() => { console.log('화살표 함수로도 가능')});