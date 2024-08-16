
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


//-------------------------------------------------------------------------------------------

// 프로필 이미지 추가/변경/삭제

const profileImage = document.getElementById("profileImage"); // img 태그
const deleteImage = document.getElementById("deleteImage"); // x버튼
const imageInput = document.getElementById("imageInput"); // input 태그


let initCheck; // 초기 프로필 이미지 상태를 저장하는 변수
// false == 기본 이미지
// true == 이전 업로드 이미지
let deleteCheck= -1; // 프로필 이미지가 새로 업로드 되거나 삭제되었음을 나타내는 변수
// -1 == 초기값, 0 == 프로필 삭제(X버튼), 1 == 새 이미지 업로드

let originalImage; // 초기 프로필 이미지 파일 경로 저장


if(imageInput != null){ //화면에 imageInput이 있을 경우

    // 프로필 이미지가 출력되는 img의 src 속성을 저장
    //originalImage = profileImage.src;
    // 같은 코드
    originalImage = profileImage.getAttribute("src");

    // 회원 프로필 화면 진입 시
    // 현재 회원의 프로필 이미지 상태를 확인

    if(originalImage=="/resources/images/user.png"){
        // 기본 이미지인 경우
        initCheck = false;
    } else{
        initCheck = true;
    }


    // change 이벤트 : 값이 변했을 때
    // - input type="file" , "checkbox", "radio"에서 많이 사용
    // - text/number 형식 사용 가능
    // -> 이 때 input값 입력 후 포커스를 잃었을 때
    //    이전 값과 다르면 change 이벤트 발생
    imageInput.addEventListener("change", e=>{

        // 2MB로 최대 크기 제한
        const maxSize = 1 * 1024 * 1024 * 2; // 파일의 최대 크기 지정(바이트 단위)


        //console.log(e.target); //input 태그
        //console.log(e.target.value); // 업로드 된 파일 경로
        //console.log(e.target.files); // 업로드 된 파일의 정보가 담긴 배열

        const file = e.target.files[0]; // 업로드한 파일의 정보가 담긴 객체


        // 파일을 한번 선택한 후 취소했을 때
        if(file == undefined){
            console.log("파일 선택 취소");

            // 취소 == 파일 없음 == 초기 상태
            deleteCheck = -1;

            // 취소 시 기본 이미지로
//          profileImage.src = originalImage;
            originalImage = profileImage.getAttribute(originalImage);
            return;
        }

        // 선택된 파일의 크기가 최대 크기를 초과한 경우 
        if(file.size > maxSize){
            
            alert("2MB이하의 이미지를 선택해주세요.");
            imageInput.value="";
            deleteCheck = -1;
            // input type="file" 태그에 대입할 수 있는 value는 ""(빈칸) 뿐
            return;
        
        }

        // JS에서 파일을 읽는 객체
        // 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있음
        const reader = new FileReader();
        
        //매개변수에 작성된 파일을 읽어서 저장 후
        //파일을 나타내는 URL을 result 속성으로 얻어올 수 있게함
        reader.readAsDataURL(file);

        reader.onload= (e)=>{
            //console.log(e.target);
            let base64data = reader.result;
            // 두가지는 같다
            //console.log(reader.result.result);
            //console.log(base64data);
            
            profileImage.src=base64data;
            deleteCheck = 1;
            // 같은 코드
            //profileImage.setAttribute("src", base64data)
        }

    });

    // x버튼 클릭시 
    // 프로필 이미지를 기본 이미지로 변경

    deleteImage.addEventListener("click", e=>{

        //originalImage="/resources/images/user.png";
        profileImage.src="/resources/images/user.png";
        imageInput.value=""; // input type="file"의 value 삭제
        deleteCheck = 0;

    });

    // #profileFrm이 제출 되었을 때
    document.getElementById("profileFrm").addEventListener("submit", e=>{
        //let initCheck; // 초기 프로필 이미지 상태를 저장하는 변수
        // false == 기본 이미지
        // true == 이전 업로드 이미지
        //let deleteCheck= -1; // 프로필 이미지가 새로 업로드 되거나 삭제되었음을 나타내는 변수
        // -1 == 초기값, 0 == 프로필 삭제(X버튼), 1 == 새 이미지 업로드

        // 프로필 이미지가 없다 -> 있다
        let flag = true;
        if(!initCheck && deleteCheck==1){
            flag=false;
            console.log("제출되야함");
        } 

        // 프로필 이미지가 있다 -> 없다(삭제)

        if(initCheck && deleteCheck==0){
            flag=false;
        }

        // 이전 프로필 이미지가 있다 -> 새 이미지

        if(initCheck && deleteCheck==1){
            flag=false;
        }


        if(flag){ // flag == true -> 제출하면 안되는 경우
            e.preventDefault(); // form 기본 이벤트 제거
            alert("이미지 변경 후 클릭해주세요.");
        }

    });

}

