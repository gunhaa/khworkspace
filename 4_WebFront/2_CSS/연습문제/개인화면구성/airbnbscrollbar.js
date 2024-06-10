

const headerbottomnone = document.querySelector("#header-bottom");
const movebar=document.querySelector("#needmoveclass");
const hiddenbar = document.querySelector("#header-top-hidden");

window.addEventListener("scroll", changenavbar);

function changenavbar(){
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
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



// 0. 스크롤이 n px이상 되었을때
// 1. div id="header-bottom에 class="displaynonejs"추가

// 2. nav에 nav-move 클래스 추가 + nav id설정하기

// 3.<div id="header-top-hidden">에 class displaynonejs 를 넣어놓고 스크롤시 제거해야함 header의 자식으로 존재해야함 

// nav bar


