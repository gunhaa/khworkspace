
document.querySelector("#btn").addEventListener("click", change);

function change(){
    const div1 = document.querySelector("#div1");
    const a= (Math.random()*255+1);
    const b= (Math.random()*255+1);
    const c= (Math.random()*255+1);
    const d= (Math.random()*100);
    div1.style.backgroundColor=`rgb(${a}, ${b}, ${c})`;
    div1.style.borderRadius=`${d}px`;
    div1.style.border= `${d}px solid black`;
    div1.style.margin=`${d}px`
    div1.style.fontSize=`${d}px`
    div1.style.color=`rgb(${c}, ${d}, ${a})`
    console.log(window);
}