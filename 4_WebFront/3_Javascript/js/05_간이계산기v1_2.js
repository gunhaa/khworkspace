function calculate(op) {

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
    let res = 0;
    switch(op){
        case '+':
            res= value1+value2;
            break;
        case '-':
            res= value1-value2; 
            break;
        case '*':
            res= value1*value2;  
            break;
        case '/':  
            res= value1/value2; 
            break;
        case '%':
            res= value1%value2; 
            break;                  
    }

    document.getElementById("result").innerText=res;
    

}