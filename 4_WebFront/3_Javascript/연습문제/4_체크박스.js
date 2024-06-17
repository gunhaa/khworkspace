

document.querySelector('#selectAll').addEventListener('click', () => {
    const selectAll = document.getElementsByName('hobby');
    const select = document.querySelector('#selectAll');

    if (select.checked) {
        selectAll.forEach((box) => {
            box.checked = true;
        })
    } else {
        selectAll.forEach((box) => {
            box.checked = false;
        })
    }
})

babo();
function babo() {

    for (let i = 0; i < 12; i++) {

        document.getElementsByName('hobby')[i].addEventListener('click', () => {
            const selectAll = document.getElementsByName('hobby');
            const select = document.querySelector('#selectAll');
            var count = 0;
            selectAll.forEach((box) => {
                if (box.checked == true) {
                    count += 1;
                }
            })
            if (count == 12) {
                select.checked = true;
            } else {
                select.checked = false;
            }
        })

    }
}
// document.getElementsByName('hobby')[0].addEventListener('click', () => {
//     const selectAll = document.getElementsByName('hobby');
//     const select = document.querySelector('#selectAll');
//     var count = 0;
//     selectAll.forEach((box)=>{
//         if(box.checked==true){
//             count+=1;
//         }
//     })
//     if(count==12){
//         select.checked=true;
//     } else{
//         select.checked=false;       
//     }
// })

document.querySelector('#result-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const selectAll = document.getElementsByName('hobby');
    const result = document.querySelector('#result');
    const btn = document.querySelector('#btn');
    selectAll.forEach((box) => {
        if (box.checked == true) {
            result.innerHTML += `${box.value} `;
        }
    })
    result.classList.add('submit');
    btn.disabled = true;
})