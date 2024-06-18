$(document).ready(function() {
    let count = 0;
    let Interval; // setInterval을 저장할 변수
    
    Interval = setInterval(() => {
        
        $('.area').append(`<span class="text1">${count}</span>`);
        count++;
        if(count==11){
            count = 0;
            // $('.area>span').remove();
            $('.area').empty();
            // 두 개는 같은 동작함
        } 

    }, 300)

    $('#stop').on('click', () => {
        clearInterval(Interval);
    })

    // 클래스가 text1을 클릭했을 때
    // 콘솔에 내용의 요소 출력
    
    // $('.text1').on('click', function(){
        $(document).on('click', '.text1' , function(){
        console.log($(this).text());
    });
    /*
        1. HTML 문서는 위에서 아래로 해석
        2. on(), addEventListener()는
            요소에 이벤트가 발생했을 때 동작(기능)을
            추가하는 메소드

        (중요!) 기존에 on(), addEventListener()를 이용하여
        이벤트 동작을 추가할 때는
        이미 화면에 로딩이 완료된 상태인 요소에 추가를 함

        지금 같은 경우는 기존 화면에 없던 요소(span)에 
        이벤트 동작을 추가하려 했지만 되지 않음

        정적 요소 : HTML 문서 로딩 전부터 이미 작성되어 있는 요소
           -> 기존 방법 on('click', function(){}) 사용 가능

        동적 요소 : 자바스크립트 또는 제이쿼리에 의해서
                    HTML 문서 로딩 이후 추가되는 요소
                    -> 기존 방법 불가
                    ->$(document).on('이벤트', '선택자', function(){})
    */
});

// 아이디가 focus-blur인 요소에 초점이 맞춰진 경우
// 배경색을 pink로 바꾸는 동작 추가

$('#focus-blur').on('focus', function(){
    $(this).css('backgroundColor' , 'pink');
})

// 아이디가 focus-blur인 요소에 초점이 해제된 경우
// 배경색을 원래대로 바꾸는 동작을 추가

$('#focus-blur').on('blur', function(){
    $(this).css('backgroundColor' , 'white');
});

// 아이디가 change1인 요소의 체크/해제 될 때마다
// 콘솔에 "checkbox 값이 변경되었습니다." 출력

$('#change1').on('change', function(){
    console.log('checkbox 값이 변경 되었습니다.');
})

// 아이디가 change2인 요소의 입력값이 변한 상태로 포커스가 해제될 때마다
// 콘솔에 "입력값이 변경되었습니다." 출력

$('#change2').on('change', function(){
    console.log('입력 값이 변경 되었습니다.');
})

// 아이디가 select인 요소의 입력 값에 블럭이 잡힌 경우(드래그한것)
// 콘솔에 "입력 값이 블럭 잡힙" 출력

$('#select').on('select', function(){
    console.log('입력 값이 블럭 잡힘');
});


$('#input-content').on('input', function(){
    
    let length = $('#input-content').val().length;
    $('#counter').text(length);

    // #counter의 글자색 변경
    // 글자수가 0~130이면 글자색 검은색
    // 131 ~149 까지는 주황색 글씨
    // 150 부터 빨간색으로 출력
    if(length>130 && length<150){
        $('#counter').css('color', 'orange');
    } else if(length>=150){
        $('#counter').css('color', 'red');


        // 150글자 이상 작성 불가능하게 만들기

        // 1. textarea에 작성된 값(문자열)을 변수에 저장
        const str = $(this).val();

        // 2.substring을 이용해서 글자를 150글자 까지만 잘라내기
        // 문자열.substring(시작 인덱스, 종료인덱스)
        //  -> 문자열을 시작 인덱스 이상부터
        //     종료 인덱스 미만까지 잘라내어 반환

        // str.substring(0, 150);
        // 3. 150글자만 잘라내어 textarea의 값으로 세팅하기
        $(this).val(str.substring(0,150));
        // 151번째 입력이 인식되면 150글자로 잘라냄
        // 그런데 자르기 전 글자수를 카운트해서 151로 보이는 문제 발생
        length = $('#input-content').val().length;
        $('#counter').text(length);
        // $('#input-content').attr('readonly' , true);
    }

});