import React, { useState } from 'react';

const SignupContainer = () => {

    const [id, setId] = useState("");
    const [pw, setPw] = useState("");
    const [pwCheck, setPwCheck] = useState("");
    const [name, setName] = useState("");
    const [result, setresult] = useState("");

    // 아이디 중복 검사

    const [idValidation, setIdValidation] = useState(false);

    // false => 사용 불가능
    // true => 사용 가능

    const idCheck = inputId => {
        // inputId : 내가 입력한 아이디
        setId(inputId); // id 변수에 입력받은 아이디 대입

        // 4글자 미만 검사X
        if (inputId.trim().length < 4) {
            setIdValidation(false);
            return;
        }

        fetch(`/idCheck?id=${inputId}`)
        .then(resp => resp.text())
        .then(result => {
            // 응답은 String 형태로 넘어온다
            // result ===0 은 틀리고, 이렇게 쓰고싶다면 "0" 혹은 Number(result)로 작성해야 한다.

            if(result>0){
                setIdValidation(false);
                // alert("중복 아이디임");
                console.log("중복 아이디임"+result);
            }else{
                setIdValidation(true);   
                // alert("사용 가능한 아이디임");
                console.log("사용 가능한 아이디임"+result);
            }
        })
        .catch(err=>{
            console.log(err)
        })

    }


    const signup = () => {
        //0. 아이디가 사용 불가인 경우 (짧거나 중복)
        if(!idValidation){
            alert("아이디를 다시 입력해주세요.");
            return;
        }


        // 1. 비밀번호가 일치하지 않으면
        // '비밀번호가 일치하지 않습니다' alert로 출력



        // 2. id ==='user01' , pw ==='pass01'
        // 이라면 result에 '회원 가입 성공' 출력
        // + 모든 입력칸(input)내용 삭제

        // 아니라면 result에 '회원 가입 실패' 출력




        if (pw !== pwCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }


        // ** 회원 가입 요청(비동기, POST) **

        fetch("/signup", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                "id": id,
                "pw": pw,
                "name": name,
            })
        })
            .then(resp => resp.text())
            .then(res => {
                console.log(res)
                if (res === "1") {



                    setId("");
                    setPw("");
                    setPwCheck("");
                    setName("");
                    setresult("회원 가입 성공");
                } else {
                    setresult("회원 가입 실패");
                }
            })
            .catch(err => {
                alert("회원 가입 에러");
            })


        // if(id==="user01" && pw ==="pass01"){
        //     setId("");
        //     setPw("");
        //     setPwCheck("");
        //     setName("");
        //     setresult("회원 가입 성공");
        //     return;
        // } else{
        //     setresult("회원 가입 실패");
        //     return;
        // }





    };




    return (

        <div className="signup-container">
            <label>
                ID : <input type="text" onChange={e => {
                    //setId(e.target.value)
                    idCheck(e.target.value);
                }} value={id} className={idValidation ? "" : "id-error"} />
            </label>

            <label>
                PW : <input type="password" onChange={e => { setPw(e.target.value) }} value={pw} />
            </label>

            <label>
                PW CHECK : <input type="password" onChange={e => { setPwCheck(e.target.value) }} value={pwCheck} />
            </label>

            <label>
                NAME : <input type="text" onChange={e => { setName(e.target.value) }} value={name} />
            </label>

            <button onClick={signup}>가입하기</button>

            <hr />

            <h3>{result}</h3>

        </div>


    );

}

export default SignupContainer;