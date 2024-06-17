// 태그 선택자

// jQuery 선택자는 css 선택자와 같다.
$('h5').css('color', 'red');

$('p').css('color', 'blue');


// 자바 스크립트로 했을 때
// document.getElementsByTagName('p').style.color = 'green';
// -> 배열에 스타일을 적용할 수 없다.


// 자바 스크립트로 바꾸는 방법
const p = document.getElementsByTagName('p');
// for(let i = 0 ; i< p.length; i++){
//     p[i].style.color = 'green';
// }
for (let item of p) {
    item.style.color = 'green';
}

// h5, p 두 태그 동시에 배경색을 yellow로 지정하기
$('h5, p').css('color', 'yellow');

// 클래스 선택자

// 클래스가 item인 요소의 글자색을 orange로 변경

// 클래스가 select인 요소의 배경색을 red로 변경

// 클래스가 item,select를 동시에 가지고 있는 요소만
// 글자 크기를 50px로 변경

$('.item').css('color', 'orange');
$('.select').css('backgroundColor', 'red');
$('.item').filter('.select').css('fontSize', '50px');
// or
$('.item.select').css('fontSize', '50px');

const regExp = /^[a-z][a-zA-Z0-9]{7,19}$/;

$('#input1').on('input', function () {
    // on() == addEventListener
    // -> 특정 이벤트 발생 시 동작(이벤트 핸들러) 지정

    // input 이벤트 : 입력과 관련된 모든 행위
    if (regExp.test($('#input1').val())) {
        // $('#input').val()
        // : 아이디가 input1인 요소에 작성된 값(value)을 얻어옴

        // 2) 정규식 결과에 따라 내용 출력
        $('#span1').text('유효한 문자열 형식 입니다.');
        $('#span1').css('color', 'green');
    } else {
        $('#span1').text('유효하지 않은 문자열 형식 입니다.').css('color', 'red');
        // method chaining : 하나의 대상에 대하여 여러 메소드를 연달아 작성하는 기술
    }
})

// 자식, 후손 선택자

// 클래스가 area인 요소의 자식 중 h4 글자색 red

// 클래스가 area인 요소의 후손 중 ul 후손 중에
// 클래스가 fruit인 요소의 배경색 원하는 걸로 바꾸기

// 클래스가 area의 요소의 후손 중
// 클래스가 fruit인 요소의 폰트크기를 30px로 변경

// 내용이 "딸기"인 요소를 선택해서
// 배경 빨강색, 글자는 흰색으로 변경

$('.area>h4').css('color', 'red');
$('.area ul .fruit').css('backgroundColor', 'blue');
$('.area .fruit').css('fontSize', '30px');
$('.area> ul> li> h4').css('backgroundColor', 'red').css('color', 'white');


$('#check').on('click', function () {
    // name 속성 값이 gender인 요소 선택
    console.log($("input[name='gender']"));

    // name 속성 값이 gender인 요소 중 check 된 요소를 선택
    // :checked -> check된 요소만 선택
    const gender = $("input[name='gender']:checked");

    console.log(gender.length);
    // 아무것도 check 안함 : 0
    // 하나 check : 1

    // radio 버튼이 하나도 선택되지 않은 경우
    // '남자 또는 여자 중 하나를 선택해 주세요.' 알림창 띄우기

    if (gender.length === 0) {
        alert('남자 또는 여자를 선택해주세요.');
    } else {

        // 1) 체크된 요소를 모두 얻어왔으므로
        //    배열 형태로 저장된 gender 변수에서
        //    0번 인덱스의 value만 얻어오기 (순수 JS)
        console.log(gender[0].value);

        // 2) 체크된 요소를 모두 얻어와도
        //    radio는 한개만 체크되어 있기 때문에
        //    변수 한개랑 같다라고 해석하여
        //    자동으로 0번 인덱스 요소에 있는 value를 얻어옴(JS + JQuery)
        console.log(gender.val());

        // 3) 순수 jQuery
        console.log($(gender).val());
        // $(gender) : 체크된 요소만 담긴 배열 + 요소를 선택해라 기호
        // --> 체크된 radio버튼을 선택하는 jQuery 선택자

        alert($(gender).val() + "자를 선택 하셨습니다.");
    }
});


// prop()메소드

$('#btn1').on('click', function () {
    const arr = $("input[name='hobby']");
    let str=""; //체크된 요소의 value 값을 누적해서 저장할 변수
    console.log(arr.prop("checked"));
    // 배열 명만 적을 경우 0번째 인덱스만 확인 가능하다.
    for (let i = 0; i < arr.length; i++) {
        // 각 인덱스에 저장된 checkbox 요소가 체크되어 있는 상태인지 확인
        console.log(i + " : " + $(arr[i]).prop("checked"));

        if($(arr[i]).prop("checked")) {
            // 체크된 요소의 value값을 얻어와 str변수에 누적
            str += $(arr[i]).val() + " ";
        }
    }

    alert(str)
})