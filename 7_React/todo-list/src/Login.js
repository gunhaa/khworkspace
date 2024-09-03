import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';


const LoginComponent = () => {

    // 전연 변수 Context 사용
    const { setTodoList, setLoginMember, loginMember } = useContext(TodoListContext);

    const [id, setId] = useState("");
    const [pw, setPw] = useState("");

    const login = () => {

        fetch("/login", {
            method: "POST",
            headers: {
                // 전달되는 데이터 타입
                'Content-Type': 'application/json',
                // 응답 데이터 타입 
                'Accept': 'application/json'
            },
            body: JSON.stringify({
                "id": id,
                "pw": pw
            })
        })
            .then(resp => resp.json())
            .then(result => {

                if (result.loginMember === null) {
                    alert("로그인이 실패했습니다..");
                    return;
                }
                console.log(result.todoList);
                console.log(result.loginMember);
                setLoginMember(result.loginMember);
                setTodoList(result.todoList);
                setId("");
                setPw("");


            })
            .catch(e => {
                console.log(e);
            })

    }

    const logout = () => {
        setLoginMember(null);
    }


    return (
        <div className="login-container">
            <table>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td><input type="text" onChange={e => { setId(e.target.value) }} value={id}></input></td>
                    </tr>
                    <tr>
                        <th>PW</th>
                        <td><input type="password" onChange={e => { setPw(e.target.value) }} value={pw}></input></td>
                        <td><button onClick={login}>Login</button></td>
                    </tr>
                </tbody>
            </table>


            {loginMember !== null && (<button onClick={logout}>로그아웃</button>) }
            {/* <button className={loginMember ? "" : "none"} onClick={logout}>로그아웃</button> */}


        </div>
    );

}



export default LoginComponent;