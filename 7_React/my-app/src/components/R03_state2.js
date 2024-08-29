import React , {useState} from 'react';

const State2 = (props) => {

    // props : 부모로부터 전달 받은 값을 저장한 "객체"
    // {init : 50}
    const [count , setCount] = useState(props.init);
    
    // useState : 컴포넌트의 상태를 관리할 때 사용하는 Hook (use가 들어가면 대부분 hook이다)
    // count [변수, 값을 변경하는 함수(setter)] = useState(초기값);


    const changeMyValue = () => {
        setCount(() => count+1);
    }

    return(
        <div>
            <h3>{count}</h3>
            <button onClick={changeMyValue}>클릭시 count 1 증가</button>
        </div>
    )
}

export default State2;