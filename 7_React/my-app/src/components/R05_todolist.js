import React, { useState } from 'react';


//useState 복습
const InputName = () => {

    const [name, setName] = useState("");
    // name : 변수명
    // setName : name의 변수의 setter
    // useState('') : name 변수에 대입되는 초기값을 ''(빈칸)으로 지정
    //                 -> state의 변화가 감지되면 컴포넌트를 리렌더링

    return (

        <>
            <div>
                <p>이름을 입력하세요</p>
                <input type="text" onChange={e => setName(e.target.value)}></input>
                <h3>여기에 입력한 이름 출력 : {name}</h3>
            </div>
        </>

    )

}

const TodoList = () => {


    // 할 일을 저장할 변수
    // -> 상태가 변하면 컴포넌트(TodoList) 리렌더링
    const [todos, setTodos] = useState([
        { text: "요구사항 정의서 제출하기", completed: false },
        { text: "유스케이스 제출하기", completed: false },
        { text: "와이어 프레임 제출하기", completed: false }
    ]);
    console.log(todos);
    // 할 일 입력 컴포넌트
    const InputTodo = () => {

        const [inputText, setInputText] = useState("");

        // 추가하기 버튼 클릭 시 할 일 추가
        const addTodo = () => {
            const newTodo = { text: inputText, completed: false }
            // todos에 newTodo를 추가한 객체 배열 newTodos를 만든다.
            const newTodos = [...todos, newTodo];
            // 새로운 객체배열 newTOdos를 todos에 대입
            // 상태 변화 인식-> 리렌더링 진행
            setTodos(newTodos);

        }

        return (
            <>
                <div>
                    <h4>할 일 추가</h4>
                    <input type="text" onChange={e => setInputText(e.target.value)}></input>
                    <button onClick={addTodo}>추가하기</button>
                </div>
            </>
        )


    };

    // 체크박스 값 변경 시
    const todoChange = (index) => {
        const newTodos = [...todos]; // todos를 풀어서 새로운 배열 생성
                                     // 전개 연산자를 이용한 배열 깊은 복사
        console.log(newTodos);
        console.log(index);

        newTodos[index].completed= !newTodos[index].completed;
        setTodos(newTodos);

        // boolean 값 반대로 변경해서 대입
    }
                                    
    
    const deleteTodo= (index) => {
        const newTodos = [...todos];
        
        // 배열.splice(인덱스, 제거할 요소의 개수)
        newTodos.splice(index,1);

        setTodos(newTodos);
    }

    return (

        <>
            <InputName />
            <hr />
            <h1>Todo List</h1>

            {/* 입력 */}
            <InputTodo></InputTodo>
            {/* 할 일 목록 */}
            {/* 배열.map( (배열 요소, 인덱스)=>{ return 값;} )
                -> 기존 배열을 이용해서 새로운 배열을 만드는 함수
                -> 새로운 배열의 요소는 map에서 return되는 값으로 이루어짐
            */}
            <ul>
                {todos.map((todo, index) => {
                    return (
                        <li key={index}>
                            <input type="checkbox" checked={todo.completed} onChange={()=>{todoChange(index)}}></input>
                            <span className={ todo.completed ? "completed" : ""}>{todo.text}</span>

                            <button onClick={()=>{deleteTodo(index)}}>삭제하기</button>
                        </li>
                    )
                })}
            </ul>
        </>

    );

}

export default TodoList;