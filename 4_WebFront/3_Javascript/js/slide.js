
let curindex = 0;
let maxindex = document.querySelectorAll("img").length;
let px = 0;
let x=0;

document.querySelector("#b4").addEventListener("click", right)

function right() {
    curindex += 1;
    px=300*curindex;
    if (curindex < maxindex) {
        document.querySelectorAll(".c3").forEach(function (pic) {
            console.log(px);
            console.log(maxindex);
            pic.style.transform = `translateX(-${px}px)`;
        })
    }
}


document.querySelector("#b5").addEventListener("click", left)
function left(){
    curindex -= 1;
    px=300*curindex;
    if (curindex < maxindex) {
        document.querySelectorAll(".c3").forEach(function (pic) {
            console.log(px);
            pic.style.transform = `translateX(${px}px)`;
        })
    }
}
