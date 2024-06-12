function calculate(btn) {

    
    // btn에는 this(클릭된 버튼 요소)가 전달되어짐
    console.log(btn);

    const op = btn.innerText; // 버튼의 내용(+,-,*,%,/)를 얻어옴

    console.log(btn.innerText)
    
    const num1 = document.querySelector("#num1");
    const num2 = document.querySelector("#num2");
    const result = document.querySelector("#result");
    // op에는 +, -, *, /, % 중 하나가 전달되어짐

    const value1 = Number(num1.value);
    const value2 = Number(num2.value);
    // if (op === '+') {
    //     result.innerHTML= Number(value1)+Number(value2);
    // } else if (op ==='-'){
    //     result.innerHTML= Number(value1)-Number(value2);        
    // } else if (op ==='*'){
    //     result.innerHTML= Number(value1)*Number(value2);     
    // } else if (op ==='/'){
    //     result.innerHTML= Number(value1)/Number(value2);            
    // } else if (op ==='%'){
    //     result.innerHTML= Number(value1)%Number(value2);           
    // }
    // 결과 저장용 변수


    // eval("코드 형식 문자열")
    // -> 작성된 문자열을 JS코드로 해석
    // -> 속도+ 보안 이슈가 있어서 사용 지양

    // document.getElementById("result").innerText= eval(value1 + op + value2);
    
    // 
    document.getElementById("result").innerText
            = new Function("return " + value1 + op + value2)();
    

}