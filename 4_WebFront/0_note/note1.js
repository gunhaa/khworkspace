

let str = 'asf31d3fsdf54sd6f84sdf23sdf1321sdf3dfs at +10000 afdsdfsdf394038  dsafklsdfkafsasf at +100002ldasd';

const RegExp1 = /at\s*\+(\d+)/g;
const RegExp2 = /\d+/g;
const btn = document.querySelector('#btn')
const resultArr= [];

btn.addEventListener('click' , () => {

    a = str.match(RegExp1);
    console.log(a);
    
    a.forEach ( (result) => {
        let result2=result.match(RegExp2)
        
        resultArr.push(Number(result2.toString()));
    });

    console.log(resultArr);
})