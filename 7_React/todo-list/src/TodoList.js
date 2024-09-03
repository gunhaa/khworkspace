// TodoList목록 출력
import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';


const TodoList = () => {

    const { todoList, setTodoList, setLoginMember, loginMember } = useContext(TodoListContext);

    const [todo , setTodo] = useState("");

    const add = () => {

        fetch("/todo", {
            method : "POST",
            headers : {
                // 전달되는 데이터 타입
                'Content-Type': 'application/json',
                // 응답 데이터 타입 
                'Accept': 'application/json'
            },
            body: JSON.stringify({
                "title": todo,
                "todoMemberNo": loginMember.todoMemberNo
            })
        })
        .then(resp=>resp.text())
        .then(result => {
            console.log(result);            
            if(result > 0){
                alert("todo 등록에 성공하였습니다.");
                // let addTodo = [...todoList];
                // addTodo.push({

                // })
            }

        })
        .catch(err=>{
            console.log(err);
        })
        
    }

    const del = (index) => {
        //console.log(index);
        fetch("/todo", {
            method : "DELETE",
            headers : {
                // 전달되는 데이터 타입
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(index)
        })
        .then(resp=>resp.text())
        .then(result=>{
            console.log(result);
            alert("todo를 삭제하였습니다.")

        })
        .catch(err=>{
            console.log(err);
        })
    }

    const update = (index, isDone) => {

        if(isDone==="X"){
            isDone = "O"
        } else{
            isDone = "X"
        }

        fetch("/todo", {
            method : "PUT",
            headers : {
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify({
                "todoNo" : index , 
                "isDone" : isDone
            })
        })
        .then(resp=>resp.text())
        .then(result=>{
            console.log(result);
        })
        .catch(err=>{
            console.log(err);
        })

    }

    return(
        <>
            <h1>{loginMember.name}의 TodoList</h1>

            <h3>할 일(Todo) 입력</h3>
            <input type="text" onChange={e => {setTodo(e.target.value)} } value={todo}></input>
            <button onClick={add}>Todo추가</button>
            <ul>
                {todoList.map((item, index)=>{

                   return <li key={index}>{item.title}<button onClick={()=>update(item.todoNo, item.isDone)}>{item.isDone}</button><button onClick={()=> del(item.todoNo)}>삭제</button></li>

                })}

            </ul>
        </>
    );

}

export default TodoList;