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


