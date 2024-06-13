document.querySelector("#btn1").addEventListener("click", function(){

    // 문자열.indexOf("str") : 
    // 문자열에서 "str"과 일치하는 부분이 시작되는 인덱스를 반환
    // 없으면 -1 반환
    const str1 = "Hello world";

    console.log(str1.indexOf("e")); // 1반환
    console.log(str1.indexOf("l")); // 2(가장 먼저 검색된 인덱스 반환)
    console.log(str1.indexOf('a')); // -1반환


    // 문자열.substring(시작인덱스, 종료인덱스(미포함)) : 문자열 일부 잘라내기
    // -시작 이상 종료 미만

    const str2="abcdefg";
    console.log(str2.substring(0,3)); //abc 반환
    console.log(str2.substring(2,6)); //cdef

    // 문자열.split("구분자") : 문자열을 "구분자"로 잘라서 배열로 반환

    const str3 = '짜장면, 짬뽕, 탕수육, 라면, 피자, 디저트';

    const arr = str3.split(', ');

    for(let i=0; i<arr.length; i++){
        console.log(arr[i]);
    }

})


document.querySelector("#btn2").addEventListener("click", function(){

    // Infinity 리터럴 확인

    console.log( 7 / 0 );

    if(7/0==Infinity){
        console.log("무한 입니다.");
    }

    // NaN 리터럴 확인

    console.log("aaa" * 1000);

    // "aaa"*1000 == NaN (X)

    // isNaN(값); 값이 NaN이면 true, 아니라면 false

    if(isNaN("aaa"*1000)){
        console.log("숫자가 아닙니다.")
    }


    // Math.random() : 0이상 1미만의 난수 발생 (0<= random <1)
    // this.innerText = Math.random();

    // 소수점 관련 함수
    // round(), ceil(), floor(), trunc()
    // 반올림    올림     내림     버림(절삭)

    // -> 소수점 자리 지정할 수 없다.

    console.log(Math.round(10.5)); //11
    console.log(Math.ceil(10.5)); //11
    console.log(Math.floor(-10.5)); // -11
    console.log(Math.trunc(-10.5)); // -10
    // 버튼 배경색 랜덤으로 바꾸기
    const r = Math.floor(Math.random()*256)//0~255
    const g = Math.floor(Math.random()*256)//0~255
    const b = Math.floor(Math.random()*256)//0~255


    console.log(this.style);

    this.style.backgroundColor=`rgb(${r},${g},${b})`;

    // 숫자.toFixed(자릿수) : 지정된 자릿수까지 반올림해서 표현
    console.log((1.45).toFixed(1));

})

document.querySelector("#btn3").addEventListener("click", function(){
    const num = 11;

    console.log(parseInt('1.234'));
    console.log(parseFloat('1.234'));
    console.log(Number("1.234"));
    console.log(typeof num)
})

document.querySelector("#btn4").addEventListener("click", function(){

    const a = "11";
    const b = 11;

    console.log(a==b);
    console.log(a===b);

    if("1" == true) {
        console.log("동등 합니다");
    }

    if("1"===1){
        console.log("동일 합니다.");
    }

})

