import './App.css';
// components 폴더의 Exam1.js를 가져와서 사용
// 이 때, 이름을 Ex1으로 지정
import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';
import PropsEx from './components/R01_props'

function App() {
  // 리액트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다!
  // -> 여러 요소를 반환하고 싶은 경우 부모 요소로 묶어준다.
  
  return (
    /* fragment(<></>) : 반환되는 요소를 감쌀 때 사용, 해석 X */
    <>
      {/* jsx 주석*/}
      {/* 리액트에서는 class가 아니라 className으로 작성해야함 */}
      <h1 className="test">Hello React</h1>

      <div style={{color:'red', fontSize:'25px'}}>리액트 1일차</div>

      {/* <Ex1 /> */}
      {/* <Ex2 /> */}
      {<PropsEx name={'gunha'}/>}
      {<PropsEx name={'insu'} age={'22'}/>}

    </>
  );
}

export default App;

