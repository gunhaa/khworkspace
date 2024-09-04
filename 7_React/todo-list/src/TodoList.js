// TodoList목록 출력
import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';


const TodoList = () => {

    const { todoList, setTodoList, loginMember } = useContext(TodoListContext);

    const [inputTodo, setInputTodo] = useState("");

    let keyIndex = 0;

    //할 일 추가
    const handleAddTodo = () => {

        // 입력을 안했을 경우
        if (inputTodo.trim().length === 0) {
            alert("할 일을 입력해주세요.");
            return;
        }

        fetch("/todo", {
            method: "POST",
            headers: {
                // 전달되는 데이터 타입
                'Content-Type': 'application/json',
                // 응답 데이터 타입 
                'Accept': 'application/json'
            },
            body: JSON.stringify({
                "title": inputTodo,
                "todoMemberNo": loginMember.todoMemberNo
            })
        })
            .then(resp => resp.text())
            .then(result => {
                console.log(result);
                if (result > 0) {
                    alert("todo 등록에 성공하였습니다.");
                    let input = {
                        "title": inputTodo,
                        "isDone": "X"
                    }

                    setTodoList([...todoList, input]);
                    setInputTodo("");

                } else {
                    alert("todo 등록 실패");
                }

            })
            .catch(err => {
                console.log(err);
            })

    }

    // O , X 업데이트
    const handleToggleTodo = (item, index) => {

        const updatedTodoList = [...todoList];
        const updatedItem = { ...item };

        if (updatedItem.isDone === "X") {
            updatedItem.isDone = "O";
        } else if (updatedItem.isDone === "O") {
            updatedItem.isDone = "X";
        }

        updatedTodoList[index] = updatedItem;
        setTodoList(updatedTodoList);

        fetch("/todo", {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "todoNo": updatedItem.todoNo,
                "isDone": updatedItem.isDone
            })
        })
            .then(resp => resp.text())
            .then(result => {
                console.log(result);

                if (result > 0) {

                    alert("상태 변경 완료");


                } 
            })
            .catch(err => {
                console.log(err);
            })

    }

    // 삭제
    const handleDeleteTodo = (todoNo, index) => {

        fetch("/todo", {
            method: "DELETE",
            headers: {
                // 전달되는 데이터 타입
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(todoNo)
        })
            .then(resp => resp.text())
            .then(result => {

                if (result > 0) {
                    alert("todo를 삭제하였습니다.")
                    const updatedTodoList = [...todoList];
                    updatedTodoList.splice(index, 1);

                    setTodoList(updatedTodoList);
                }

            })
            .catch(err => {
                console.log(err);
            })
    }

    return (

        <>
            <h1>{loginMember.name}의 TodoList</h1>
            <div className="todo-container">


                <h3>할 일(Todo) 입력</h3>
                <div>
                    <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)} />
                    <button onClick={handleAddTodo}>Todo 추가</button>
                </div>


                <ul>
                    {todoList.map((todo, index) => (
                        <li key={keyIndex++}>
                            <div>
                                <span className={todo.isDone === 'O' ? 'todo-complete' : ''}> {todo.title} </span>


                                <span>
                                    <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                    <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                                </span>
                            </div>
                        </li>
                    ))}
                </ul>


            </div>

        </>
    )


}
export default TodoList;