import React, { useState } from "react";
const Id = ( {handler} ) => {
    // console.log(props);
    // console.log(props.handler);

    // props로 전달한 값 중 key가 handler인 요소의 value 반환
    console.log(handler);

    return (

        <>
            <div className="wrapper">
                <label htmlFor="id"> ID : </label>
                <input type="text" id="id" onChange={handler}></input>
            </div>
        </>

    )

}

const Pw = ({handler}) => {

    return (

        <>
            <div className="wrapper">
                <label htmlFor="pw"> pw : </label>
                <input type="text" id="pw" onChange={handler}></input>
            </div>
        </>

    )

}

// 상태 끌어올리기
const StateLiftingUp = () => {

    const [id, setId] = useState("");
    const [pw, setPw] = useState("");

    const idHandler = e => {
        // id값 변경 함수
        setId(e.target.value);
    }

    const pwHandler = e => {
        // id값 변경 함수
        setPw(e.target.value);
    }

    // console.log("id : " + id );
    // console.log("pw : " + pw );

    return(

        <>
            <Id handler={idHandler} />
            <Pw handler={pwHandler}/>
        
            <div className="wrapper">
                <button disabled={id.length === 0 || pw.length===0}>Login</button>
            </div>
        </>

    )
}

export default StateLiftingUp;