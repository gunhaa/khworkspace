import React, { useState, useContext } from 'react';
import UserContext from '../contexts/UserContext';

const User = () => {

    const { user, temp } = useContext(UserContext); // user , temp
    // useContext(Context명) : 지정된 Context를 사용
    // -> 부모 컴포넌트에서 제공한 값을 꺼내쓸 수 있다.

    // UserContext에서 user를 꺼내서 변수 user에 저장
    // UserContext에서 temp를 꺼내서 변수 temp에 저장

    console.log(user);
    console.log(temp);

    return (
        <ul>
            <li>{user.name}</li>
            <li>{user.email}</li>
        </ul>
    );
}


const Profile = () => {

    const [user, setUser] = useState({ name: '유저이', email: 'user02@kh.or.kr', hidden: false });
    const [visible, setVisible] = useState(false);

    const print = () => {

        setUser({ name: '유저이', email: 'user02@kh.or.kr', hidden: false });

    }

    const temp = "임시 변수";

    return (
        /* UserContext가 감싸고 있는 자식 컴포넌트에게
            Context API를 이용해서 user를 제공
            USER가 컴포넌트, button은 요소
        */
        <UserContext.Provider value={{ user, temp }}>
            <div>

                {/* 삼항 연산자를 이용한 컴포넌트 렌더링 제어 (조건부 렌더링) */}
                {user === null ? (
                    <>
                        {/* <button onClick={print}>개인 정보 출력</button> */}
                        <button onClick={print}>개인 정보 출력</button>
                    </>
                ) : (
                    <>
                        {visible && <User user={user} />}
                        <button onClick={() => { setVisible(!visible) }}>
                            {visible ? "개인정보 숨기기" : "개인정보 출력"}
                        </button>
                    </>
                )}
            </div>


        </UserContext.Provider>

    )

}

export default Profile;