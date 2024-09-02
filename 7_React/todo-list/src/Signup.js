import React, { useState } from 'react';

const SignupContainer = () => {

    const [id, setId] = useState("");
    const [pw, setPw] = useState("");
    const [pwCheck, setPwCheck] = useState("");
    const [name, setName] = useState("");
    const [result, setresult] = useState("");

    const signup = () => {

        // 1. 비밀번호가 일치하지 않으면
        // '비밀번호가 일치하지 않습니다' alert로 출력
        


        // 2. id ==='user01' , pw ==='pass01'
        // 이라면 result에 '회원 가입 성공' 출력
        // + 모든 입력칸(input)내용 삭제

        // 아니라면 result에 '회원 가입 실패' 출력


        if(pw !== pwCheck){
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }


        // ** 회원 가입 요청(비동기, POST) **

        fetch("/signup", {
            method : "POST", 
            headers: {
                'Content-Type': 'application/json',
              },
            body : JSON.stringify({
                "id" : id , 
                "pw" : pw , 
                "name" : name ,
            })
        })
        .then(resp => resp.text())
        .then(res => {
            console.log(res)
            if(res==="1"){
                setId("");
                setPw("");
                setPwCheck("");
                setName("");
                setresult("회원 가입 성공");
            }else{
                setresult("회원 가입 실패");
            }
        })
        .catch(err=>{
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
                ID : <input type="text" onChange={e => {setId(e.target.value)}} value={id}/>
            </label>
            
            <label>
                PW : <input type="password" onChange={e => {setPw(e.target.value)}} value={pw}/>
            </label>
            
            <label>
                PW CHECK : <input type="password" onChange={e => {setPwCheck(e.target.value)}} value={pwCheck}/>
            </label>
            
            <label>
                NAME : <input type="text" onChange={e => {setName(e.target.value)}} value={name}/>
            </label>

            <button onClick={signup}>가입하기</button>

            <hr/>

            <h3>{result}</h3>

        </div>


    );

}

export default SignupContainer;