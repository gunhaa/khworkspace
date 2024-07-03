

function formValidate(){

    const nickname=document.querySelector("input[name='memberNickname']");
    const tel=document.querySelector("input[name='memberTel']");
    const address=document.querySelectorAll("input[name='memberAddress']");
    let adr = "";

    address.forEach((item)=>{
        adr+=item.value;
    });
    
    const nickreg= /^[0-9a-zA-Z가-힣]{2,10}$/;
    const telreg=/^0(1[079]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; //전화번호 정규식


    if(nickname.value.trim().length==0){
        return printAlert( nickname, "닉네임을 입력하세요");
    } else if(!nickreg.test(nickname.value)){
        return printAlert( nickname, "닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요");
    }

    if(tel.value.trim().length==0){
        return printAlert( tel, "전화 번호를 입력해주세요(-제외)");
    } else if(!telreg.test(tel.value)){
        return printAlert( tel, "전화번호 형식이 올바르지 않습니다");
    }
    return true;
}

function printAlert(el, msg){ //매개변수 el은 요소
    alert(msg);
    el.focus();
    return false;
}


// 비밀번호 제출 시 유효성 검사


function pwValidate(){

    const currentPw=document.querySelector("input[name='currentPw']");
    const newPw=document.querySelector("input[name='newPw']");
    const newPwConfirm=document.querySelector("input[name='newPwConfirm']");

    const pwreg = /^[a-zA-Z0-9!@#-_]{6,30}$/;

    
    if(currentPw.value.trim().length==0){
        return printAlert(currentPw, "현재 비밀번호를 입력해주세요.");
    }

    if(newPw.value.trim().length==0){
        return printAlert(newPw, "새 비밀번호를 입력해주세요.");
    }else if(!pwreg.test(newPw.value)){
        return printAlert(newPw, "영어,숫자,특수문자(!,@,#,-,_) 6-30글자 사이로 작성해주세요.");
    }

    if(newPwConfirm.value.trim().length==0){
        return printAlert(newPw, "비밀번호 확인을 입력해주세요.");
    } else if(newPw.value!=newPwConfirm.value){
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
        return false;
    }

    return true;
}



function secessionValidate(){

    const pw=document.querySelector("input[name='memberPw']")
    const chk=document.querySelector("input[name='agree']");
    if(pw.value.trim().length==0){
        return printAlert(pw, "비밀번호를 입력해 주세요");
    }

    if(!chk.checked){
        alert("약관 동의 후 탈퇴 버튼을 클릭해주세요.")
        return false;
    }

    if(confirm("정말 탈퇴하시겠습니까?")){
        return true;
    }

    return false;
}
