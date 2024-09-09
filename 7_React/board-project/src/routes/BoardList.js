import React, { useState, useContext } from "react";
import { DataContext } from '../App';
import '../css/boardList-style.css';

const BoardList = () => {

    const { data , setData} = useContext(DataContext);

    // 선택한 게시글을 기억하기 위한 index
    let key = 0;

    const [index, setIndex] = useState(0);

    const [modal, setmodal] = useState(false);


    const Modal = (props) => {
        
        const data = props.data;
        const index = props.index;
        return (
            <div className="modal">
                <h4>{data[index].title}</h4>
                <p>{data[index].writer} | {data[index].issueDate}</p>
                <p>{data[index].content}</p>
            </div>
        )
    }


    return (
        <>
            {data.map(function (d, i) {
                return (
                    <div className="list" key={key++}>
                        <div className="content">
                            <h4>{d.title}<span onClick={()=>{
                                const likeCopy = [...data];
                                likeCopy[i].like += 1;
                                
                                setData(likeCopy);
                            }}>❤️</span>{d.like}</h4>
                            <p>{d.writer} | {d.issueDate}</p>
                        </div>
                        <div className="board-btn-area">
                            <button onClick={() => {
                                setmodal(i === index ? !modal : true)
                                setIndex(i)
                            }}>모달</button>
                        </div>

                    </div>
                );
            })}

            {modal === true ? <Modal data={data} index={index} /> : null}

        </>
    )

}

export default BoardList;