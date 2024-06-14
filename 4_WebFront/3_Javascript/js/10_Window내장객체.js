// window.setTimeout(함수, 지연시간(ms))

document.querySelector("#btn1").addEventListener("click", function(){


    setTimeout(function(){
        alert("3초후 출력");
    }, 3000);
        // 3초
})

let interval; //setInterval을 저장하기 위한 전역변수

function clockFn(){
    const clock = document.getElementById("clock");
    clock.innerText = currentTime(); //현재 시간 화면에 출력
    
    // 지연 시간 마다 반복(첫 반복도 지연 시간 후에 시작)
    // -> 페이지 로딩 후 1초 후 부터 반복 (지연 -> 함수 -> 지연 -> 함수)
    interval = setInterval(function(){
        clock.innerText = currentTime();
    },1000);
}
clockFn(); //함수 호출

// 현재 시간 문자열로 반환하는 함수
function currentTime(){
    const now = new Date();
    let hours = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();
    if(hours<10){
        hours = `0${hours}`;
    }
    if(min<10){
        min = '0'+min;
    }
    if(sec<10){
        sec = `0${sec}`;
    }
    return `${hours} : ${min} : ${sec}`

}


// clearInterval (setInterval이 저장된 변수)
document.getElementById('stop').addEventListener("click", function(){
    clearInterval(interval);
})
