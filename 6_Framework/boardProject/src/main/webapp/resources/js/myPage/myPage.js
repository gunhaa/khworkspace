
// 내 정보 페이지

// 내 정보 수정 페이지에서만 실행되어야 한다.

// 내 정보 수정 form태그가 존재할 때 == 내 정보 페이지





// 닉네임 유효성 검사



const checkObj = {
    isCheckedNick: false,
    isCheckedTel: false
}

const updateInfo = document.querySelector("#updateinfo");

if (updateInfo != null) {
    const memberNick = document.querySelector("#memberNickname");
    const memberTel = document.querySelector("#memberTel");
    let initNickname = memberNick.value;
    let initTel = memberTel.value;

    memberNick.addEventListener("input", e => {

        // if (memberNick.value.trim().length == 0) {

        //     memberNick.value = "";
        //     memberNick.classList.remove("confirm");
        //     memberNick.classList.remove("error");
        //     checkObj.isCheckedNick = false;
        //     return;
        // }

        // const regEx = /^[가-힣a-zA-Z0-9]{2,10}$/;
        // // 입력 받은 비밀번호와 정규표현식 일치 확인
        // if (regEx.test(memberNick.value)) {

        //     memberNick.classList.add("confirm");
        //     memberNick.classList.remove("error");
        //     checkObj.isCheckedNick = true;

        // } else {
        //     memberNick.classList.add("error");
        //     memberNick.classList.remove("confirm");
        //     checkObj.isCheckedNick = false;
        // }

        // 변경전 닉네임과 입력 값이 같을 경우
        if (initNickname == memberNick.value) {
            // memberNick.classList.remove("error");
            // memberNick.classList.remove("confirm");
            memberNick.removeAttribute("style");
            return;
        }

        const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;

        if (regExp.test(memberNick.value)) {
            memberNick.style.color = "green"
            checkObj.isCheckedNick = true;

        } else {
            memberNick.style.color = "red"
            checkObj.isCheckedNick = false;
        }

    });



    //전화번호 유효성 검사




    memberTel.addEventListener("input", e => {


        // 변경 전 전화번호와 입력값이 같을 경우
        if (initTel == memberTel.value) {
            memberTel.classList.remove("error");
            memberTel.classList.remove("confirm");
            // memberTel.removeAttribute("style");
            return;
        }
        const regEx = /^[0-9]{10,11}$/;
        // 입력 받은 비밀번호와 정규표현식 일치 확인
        if (regEx.test(memberTel.value)) {

            memberTel.classList.add("confirm");
            memberTel.classList.remove("error");
            checkObj.isCheckedTel = true;

        } else {
            memberTel.classList.add("error");
            memberTel.classList.remove("confirm");
            checkObj.isCheckedTel = false;
        }


    });


    document.querySelector(".myPage-submit").addEventListener("click", (e) => {

        // if(memberNickname.style.color=="red"){

        // } 이런 식으로도 쓸 수 있음



        for (let key in checkObj) {
            if (!checkObj[key]) {
                switch (key) {
                    case "isCheckedNick":
                        memberNick.focus();
                        alert("닉네임을 확인해주세요.");
                        break;
                    case "isCheckedTel":
                        memberTel.focus();
                        alert("번호를 확인해주세요.");
                        break;
                }

                e.preventDefault();
                return;
            }
        }
    });


}


// 비밀번호 변경 페이지

// const checkPw = {
//     isCheckedPw: false,
//     isCheckedPwConfirm: false,
// }

// if (document.querySelector("#currentPw")) {

//     const memberPw1 = document.querySelector("#currentPw");

//     memberPw1.addEventListener("input", e => {

//         if (memberPw1.value.trim().length == 0) {

//             memberPw1.value = "";
//             memberPw1.classList.remove("confirm");
//             memberPw1.classList.remove("error");
//             checkObj.isCheckedPw = false;
//             return;
//         }

//         const regEx = /^[a-zA-Z!@#-_]{6,20}$/;
//         // 입력 받은 비밀번호와 정규표현식 일치 확인
//         if (regEx.test(memberPw1.value)) { // 유효한 경우

//             checkObj.isCheckedPw = true;
//             memberPw1.classList.add("confirm");
//             memberPw1.classList.remove("error");

//         } else {

//             checkObj.isCheckedPw = false;
//             memberPw1.classList.add("error");
//             memberPw1.classList.remove("confirm");
//         }
//     });
// }


// if (document.querySelector("newPw")) {

//     const newPw = document.querySelector("#newPw");
//     const newPwConfirm = document.querySelector("#newPwConfirm");

//     newPw.addEventListener("input", e => {

//         if (newPw.value.trim().length == 0) {

//             newPw.value = "";
//             newPw.classList.remove("confirm");
//             newPw.classList.remove("error");
//             checkObj.isCheckedPwConfirm = false;
//             return;
//         }

//         const regEx = /^[a-zA-Z!@#-_]{6,20}$/;
//         // 입력 받은 비밀번호와 정규표현식 일치 확인
//         if (regEx.test(memberPw1.value)) { // 유효한 경우

//             checkObj.isCheckedPwConfirm = false;
//             newPw.classList.add("confirm");
//             newPw.classList.remove("error");

//             if (newPw.value == newPwConfirm.value) {
//                 newPwConfirm.classList.add("confirm");
//                 newPwConfirm.classList.remove("error");
//                 checkObj.isCheckedPwConfirm = true;
//             }

//         } else {

//             checkObj.isCheckedPwConfirm = false;
//             newPw.classList.add("error");
//             newPw.classList.remove("confirm");
//         }

//     });

//     newPwConfirm.addEventListener("input", e => {

//         if (newPwConfirm.value.trim().length == 0) {

//             newPwConfirm.value = "";
//             newPwConfirm.classList.remove("confirm");
//             newPwConfirm.classList.remove("error");
//             checkObj.isCheckedPwConfirm = false;
//             return;
//         }

//         const regEx = /^[a-zA-Z!@#-_]{6,20}$/;
//         // 입력 받은 비밀번호와 정규표현식 일치 확인
//         if (regEx.test(memberPw1.value)) { // 유효한 경우

//             checkObj.isCheckedPwConfirm = false;
//             newPwConfirm.classList.add("confirm");
//             newPwConfirm.classList.remove("error");

//             if (newPw.value == newPwConfirm.value) {
//                 newPwConfirm.classList.add("confirm");
//                 newPwConfirm.classList.remove("error");
//                 checkObj.isCheckedPwConfirm = true;
//             }

//         } else {

//             checkObj.isCheckedPwConfirm = false;
//             newPwConfirm.classList.add("error");
//             newPwConfirm.classList.remove("confirm");
//         }

//     });


// }

// 비밀번호 변경 제출 시
const changePwFrm = document.getElementById("changePwFrm");
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

// 비밀번호 변경 페이지인 경우
if (changePwFrm != null) {

    changePwFrm.addEventListener("submit", e => {

        // 현재 비밀번호 미작성 시
        if (currentPw.value.trim() == "") {
            alert("현재 비밀번호를 입력해 주세요.");
            e.preventDefault();
            currentPw.focus();
            currentPw.value = "";
            return;
        }

        // 비밀번호 유효성 검사
        const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;

        if (!regEx.test(newPw.value)) {
            alert("비밀번호가 유효하지 않습니다.");
            e.preventDefault();
            newPw.focus();
            return;
        }

        // 비밀번호 == 비밀번호 확인
        if (newPw.value != newPwConfirm.value) {
            alert("비밀번호가 일치하지 않습니다.");
            e.preventDefault();
            newPwConfirm.focus();
            return;
        }
    })
}


// 비밀번호 유효성 검사
// 비밀번호 == 비밀번호 확인

// 회원 탈퇴 페이지

// 체크박스 동의 여부


const secessionFrm = document.querySelector("#secessionFrm");
const memberPw = document.querySelector("#memberPw");
const agree = document.querySelector("#agree");

if (secessionFrm != null) {

    // 비밀번호 미작성

    //체크박스 동의되지 않은 경우

    //"정말로 탈퇴하시겠습니까?" 취소 클릭 시

    secessionFrm.addEventListener("submit", e => {

        // 비밀번호 미작성
        if (memberPw.value.trim().length == 0) {
            alert("비밀번호를 작성해주세요.");
            memberPw.focus();
            e.preventDefault();
            return;
        }

        // 체크박스 동의 되지 않은 경우
        if (!agree.checked) {
            alert("약관에 동의 해주세요.");
            agree.focus();
            e.preventDefault();
            return;
        }

        // "정말로 탈퇴하시겠습니까?" 취소 클릭 시
        if (!confirm("정말로 탈퇴하시겠습니까?")) {
            e.preventDefault();
            return;
        }

    });

}