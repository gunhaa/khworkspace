


const num1 = document.querySelector("#num1");
const num2 = document.querySelector("#num2");
const result = document.querySelector("#result");

function plus() {

    const value1 = num1.value;
    const value2 = num2.value;
    num1.value = "";
    num2.value = "";
    result.innerText = Number(value1) + Number(value2);
}

function minus() {
    // const num1= document.querySelector("#num1");
    // const num2= document.querySelector("#num2");
    // const result = document.querySelector("#result");

    const value1 = num1.value;
    const value2 = num2.value;
    num1.value = "";
    num2.value = "";
    result.innerText = Number(value1) - Number(value2);
}

function multiply() {
    const num1 = document.querySelector("#num1");
    const num2 = document.querySelector("#num2");
    const result = document.querySelector("#result");

    const value1 = num1.value;
    const value2 = num2.value;
    num1.value = "";
    num2.value = "";
    result.innerText = Number(value1) * Number(value2);
}

function divide() {
    const num1 = document.querySelector("#num1");
    const num2 = document.querySelector("#num2");
    const result = document.querySelector("#result");

    const value1 = num1.value;
    const value2 = num2.value;
    num1.value = "";
    num2.value = "";
    result.innerText = Number(value1) / Number(value2);
}

function mod() {
    const num1 = document.querySelector("#num1");
    const num2 = document.querySelector("#num2");
    const result = document.querySelector("#result");

    const value1 = num1.value;
    const value2 = num2.value;
    num1.value = "";
    num2.value = "";
    result.innerText = Number(value1) % Number(value2);
}


