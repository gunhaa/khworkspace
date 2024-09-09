import './App.css';
import logo from './images/logo.jpg';
import { Routes, Route, Link } from 'react-router-dom';
import MainContent from './routes/MainContent';
import BoardList from './routes/BoardList';
import React, { useState } from 'react';
import { createContext , useContext} from 'react';

export const DataContext = createContext();

function App() {



  const [data, setData] = useState([
    { title: "프로젝트 조원이 안나올 때 꿀팁!", writer: '유저일', like: 0, issueDate: '2024-09-06', updateDate: '', content: '다음시간에 알아보도록 하자!' },
    { title: "리액트 마스터 하는 법", writer: '유저이', like: 0, issueDate: '2024-08-06', updateDate: '', content: '이해될 때까지 복습' },
    { title: "바디프로필 100일만에 찍는 법", writer: '유저삼', like: 0, issueDate: '2024-07-07', updateDate: '', content: '덜 먹고 더 운동하기' },
  ])


  return (
    <>
      <main>
        <header>
          <section>
            {/* Link : a 태그 역할 */}
            <Link to="/">
              <img src={logo} id="homeLogo" />
            </Link>
          </section>

          <section></section>
          <section></section>
        </header>

        <nav>
          <ul>
            <li><Link to="/0">공지사항</Link></li>
            <li><Link to="/1">자유 게시판</Link></li>
            <li><Link to="/2">질문 게시판</Link></li>
            <li><Link to="/3">FAQ</Link></li>
            <li><Link to="/4">1:1문의</Link></li>
          </ul>
        </nav>


        {/* :URL 파라미터
            path : 요청 주소 작성
            elment : 보여질 화면(컴포넌트)
        */}
        <Routes>
          <Route path="/" element={<MainContent></MainContent>}></Route>
          <Route path="/:boardCode" element={

            <DataContext.Provider value={ {data, setData} }>
              <BoardList></BoardList>
            </DataContext.Provider>

          } />
        </Routes>



      </main>
    </>
  );
}

export default App;
