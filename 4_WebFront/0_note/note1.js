

let str = 'asf31d3fsdf54sd6f84sdf23sdf1321sdf3dfs at +10000 afdsdfsdf394038  dsafklsdfkafsasf at +100002ldasd at +100003ldasd';

const RegExp1 = /at\s*\+(\d+)/g;
const RegExp2 = /\d+/g;
const btn = document.querySelector('#btn');
const resultArr= [];

// btn.addEventListener('click' , () => {

//     a = str.match(RegExp1);
//     console.log(a);
    
//     a.forEach ( (result) => {
//         let result2=result.match(RegExp2)
        
//         resultArr.push(Number(result2.toString()));
//     });

//     console.log(resultArr);
// })



let result;
btn.addEventListener('click', () => {

    while( (result=RegExp1.exec(str) )!== null){
        // console.log(result[0])
        // console.log(result[1])
        resultArr.push(result[1]);
    }
    
    console.log(RegExp1.exec(str));
    console.log(resultArr);
});

// 데이터를 찾은 다음에 깔끔하게 저장하는 방법


let user = new Object();

user.stats = 100;
user.atk=250;
user.engrave= ['aa', 'bb' ,'cc' ,'dd', 55]
console.log(user);
user.engrave.push(66);
console.log(user);
let dmg  =9;
let w_dmg  =20;

let en = {
    a :  dmg,
    b :  w_dmg
}
console.log(en.a+en.b);

console.log(Math.sqrt(en.a));
console.log(localStorage)