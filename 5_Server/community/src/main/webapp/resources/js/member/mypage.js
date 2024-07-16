

function formValidate() {

    const nickname = document.querySelector("input[name='memberNickname']");
    const tel = document.querySelector("input[name='memberTel']");
    const address = document.querySelectorAll("input[name='memberAddress']");
    let adr = "";

    address.forEach((item) => {
        adr += item.value;
    });

    const nickreg = /^[0-9a-zA-Z가-힣]{2,10}$/;
    const telreg = /^0(1[079]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; //전화번호 정규식


    if (nickname.value.trim().length == 0) {
        return printAlert(nickname, "닉네임을 입력하세요");
    } else if (!nickreg.test(nickname.value)) {
        return printAlert(nickname, "닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요");
    }

    if (tel.value.trim().length == 0) {
        return printAlert(tel, "전화 번호를 입력해주세요(-제외)");
    } else if (!telreg.test(tel.value)) {
        return printAlert(tel, "전화번호 형식이 올바르지 않습니다");
    }
    return true;
}

function printAlert(el, msg) { //매개변수 el은 요소
    alert(msg);
    el.focus();
    return false;
}


// 비밀번호 제출 시 유효성 검사


function pwValidate() {

    const currentPw = document.querySelector("input[name='currentPw']");
    const newPw = document.querySelector("input[name='newPw']");
    const newPwConfirm = document.querySelector("input[name='newPwConfirm']");

    const pwreg = /^[a-zA-Z0-9!@#-_]{6,30}$/;


    if (currentPw.value.trim().length == 0) {
        return printAlert(currentPw, "현재 비밀번호를 입력해주세요.");
    }

    if (newPw.value.trim().length == 0) {
        return printAlert(newPw, "새 비밀번호를 입력해주세요.");
    } else if (!pwreg.test(newPw.value)) {
        return printAlert(newPw, "영어,숫자,특수문자(!,@,#,-,_) 6-30글자 사이로 작성해주세요.");
    }

    if (newPwConfirm.value.trim().length == 0) {
        return printAlert(newPw, "비밀번호 확인을 입력해주세요.");
    } else if (newPw.value != newPwConfirm.value) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
        return false;
    }

    return true;
}



function secessionValidate() {

    const memberPw = document.querySelector("input[name='memberPw']")
    const agree = document.querySelector("input[name='agree']");
    if (memberPw.value.trim().length == 0) {
        return printAlert(memberPw, "비밀번호를 입력해 주세요");
    }
    // 약관 동의 체크 박스
    // - 체크박스 요소.checked : 체크 시 true, 해제 시 false 반환
    if (!agree.checked) {
        return printAlert(agree, "비밀번호를 입력해 주세요");
    }

    if (confirm("정말 탈퇴하시겠습니까?")) {
        return true;
    }

    return false;
}

// 회원의 프로필 이미지 변경

const inputImage = document.querySelector("#input-image");

if (inputImage != null) { //inputImage요소가 화면에 존재할 때

    // input type="file" 요소는 파일이 선택 될 때 change 이벤트가 발생함
    inputImage.addEventListener("change", function(){
        
        //this : 이벤트가 일어난 객체(input type="file")
        
        // files : input type="file"만 사용 가능한 속성으로
        
        //         선택된 파일 목록(배열)을 반환
        // console.log(this.files);
        //console.log(this.files[0]); // 파일 목록에서 첫번째 파일 객체를 선택
        if(this.files[0]!=undefined) {

            const reader = new FileReader();
            // 자바 스크립트의 filereader
            // - 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체
            console.log(reader);
            reader.readAsDataURL(this.files[0]);
            // FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함
            // - 읽어오는게 완료 되면 result 속성 data:에
            // 읽어온 파일의 위치를 나타내는 url이 포함된다.
            // -> 해당 url을 이용해서 브라우저에 이미지를 볼 수 있다.

            // reader.onload = function(){
            //   -FileReader가 파일을 다 읽어온 경우 함수를 수행
            // }

            reader.onload = function(e){
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소(객체) -> FileReader 
                // e.target.result : FileReader가 읽어온 파일의 URL
                // console.log(e.target.result);
              
                // 프로필 이미지의 src속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");
                profileImage.setAttribute("src", e.target.result);
                console.log(this.result);
                // ->setAttribute() 호출 시 중복된느 속성이 존재하면 덮어쓰기
                //event.target: 이벤트가 실제로 발생한 요소를 가리킵니다.
                //this: 이벤트 리스너가 부착된 요소를 가리킵니다.
            };
        };
    });
};

// 이미지 선택 확인
function  profileValidate(){

    const inputImage = document.getElementById("input-image");

    if(inputImage.value == ""){ //파일 선택 X
        alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.");
        return false;
    } else {
        return true;
    }

}