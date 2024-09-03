import React, { useState, createContext } from 'react';
import SignupContainer from './Signup';
import Login from './Login';
import TodoList from './TodoList';


import './App.css';

export const TodoListContext = createContext(); // 전역 변수 생성



function App() {
  // 회원 가입, 로그인, 회원의 Todo List 출력/추가/제거
  const [signupView, setSignupView] = useState(false);

  // 로그인한 회원의 정보 저장
  const [loginMember, setLoginMember] = useState(null);
  
  // 로그인한 회원의 todo-list 저장
  const [todoList , setTodoList] = useState([]);


  return (
    // Context의 값 전달 (value로)
    <TodoListContext.Provider value={ {todoList, setTodoList, setLoginMember, loginMember} }>
      <button onClick={()=>{setSignupView(!signupView)}}>
        {signupView ? ("회원 가입 닫기") : ("회원 가입 열기")}
      </button>
      <div className="signup-wrapper">
        {/* signupView가 true인 경우에만 회원 가입 컴포넌트 렌더링 */}
        {/* 조건식 && (true인 경우) */}
        {signupView === true && (<SignupContainer />)}
      </div>
      <Login />
      <hr></hr>
      {/* 로그인 시 todolist 출력 */}
      {loginMember ? <TodoList></TodoList> : ""}
      

    </TodoListContext.Provider>

  );
}

export default App;
