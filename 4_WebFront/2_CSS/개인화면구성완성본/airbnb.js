// loginmenu 나오도록
const menu = document.querySelector("#login-menu");

const menu1= document.querySelector("#header-event-menu");

menu.addEventListener("click", menuFuction);

function menuFuction(){

    if(menu1.classList.contains("displaynonejs")){
        menu1.classList.remove("displaynonejs");
    } else{
        menu1.classList.add("displaynonejs");
    }
}
// 회원가입 버튼 클릭시 loginmodal 출력

const modalMenu = document.querySelector("#login-modal-menu-container");

const signinBtn = document.querySelector("#menu-signin-btn");

signinBtn.addEventListener("click" , createModal);

function createModal(){
    
    if(modalMenu.classList.contains("displaynonejs")===true){
        modalMenu.classList.remove("displaynonejs"); // display:none을 제거함
        menu1.classList.add("displaynonejs")
    }

};


// X버튼시 loginmenu 제거

const Xbutton = document.querySelector("#login-modal-menu-nav-x");


Xbutton.addEventListener("click", Xfunction);

function Xfunction(){

        modalMenu.classList.add("displaynonejs");
}


// nav bar
const headerbottomnone = document.querySelector("#header-bottom");
const movebar=document.querySelector("#needmoveclass");
const hiddenbar = document.querySelector("#header-top-hidden");

window.addEventListener("scroll", changenavbar);

function changenavbar(){
    if (document.body.scrollTop > 90 || document.documentElement.scrollTop > 90) {
        // 스크롤이 100픽셀 이상 내려갔을 때 실행할 코드
        headerbottomnone.classList.add("displaynonejs");
        movebar.classList.add("nav-move");
        hiddenbar.classList.remove("displaynonejs");
    } else {
        headerbottomnone.classList.remove("displaynonejs");
        movebar.classList.remove("nav-move");
        hiddenbar.classList.add("displaynonejs");
    }
}

// 회원가입 조건 검사

document.querySelector(".login-modal-menu-body-textbox").addEventListener("keyup", function(){

    const regExp = /^\w{3,12}@\w{3,10}.(com|net|kr)$/;

    
    const result = document.querySelector("#login-modal-result-box-email");
    if(regExp.exec(this.value)){
        result.innerText = "올바른 형식입니다.";   
        result.style.color = "green";
    } else {
        result.innerText = "이메일이 올바르지 않습니다.";
        result.style.color = "red";
    }
    if(this.value.length==0){
        result.innerText = "이메일을 입력해주세요.";
    }

})

document.querySelector("#login-modal-result-box-pw1").addEventListener("keyup", function(){
    const regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/;

    const result = document.querySelector("#login-modal-result-box-pw");

    if(regExp.exec(this.value)){
        result.innerText = '올바른 형식 입니다.'
        result.style.color= 'green';
    } else {
        result.innerText = '올바르지 않은 형식입니다.'
        result.style.color = "red";
    }

    if(this.value.length==0){
        result.innerText = "비밀 번호를 입력해주세요.";
    }
})