import React from 'react';
// props : 부모 컴포넌트가 자식 컴포넌트에게
//         데이터 전달 시 사용하는 객체
//  ** props 는 자식 -> 부모 데이터 전달은 불가능 **

// test() 가능
// PropsEx() 불가능

// function test(){
//     console.log("test");    
// }

const ChildComponent = (props) => {
    return (
        <>
            <ul>
                <li>이름 : {props.name}</li>
                <li>나이 : {props.age}</li>
            </ul>
        </>
    );
}

// **변수 할당하면 호이스팅 되지 않는다
// **function으로 만들어야 호이스팅됨

const PropsEx = (props) => {
    // props 매개변수 : 부모로부터 전달 받은 값이 담겨있는 객체

    
    //console.log(props);
    const menu= {'돈까쓰' : 8000 , '쫄면' : 5000, }
    
    const MenuPrint = (props) => {
        return (
            <>
                <h4>돈까쓰 : {props.돈까쓰}, 쫄면 : {props.쫄면}</h4>
            </>

        )
    }
    
    return (

        <>
            <h1>{props.name} </h1>
            <ChildComponent name={props.name} age={props.name === 'insu' ? 20 : 25}/>
            {/* <MenuPrint 돈까쓰={8000} 쫄면={5000}/> */}
            <MenuPrint {...menu} />
        </>

    );

}

export default PropsEx;