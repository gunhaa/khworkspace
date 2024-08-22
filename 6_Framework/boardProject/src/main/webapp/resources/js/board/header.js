const searchBtn = document.querySelector("#searchBtn");
const search = document.querySelector("#query")


if (search) {

    search.addEventListener("input", e => {


        fetch("/search", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: search.value
        })
            .then(res => res.json())
            .then(result => {

                document.querySelector("#searchBox").innerHTML="";
                document.querySelector("#searchBox").hidden = false;

                result.forEach(item => {
                    const regExp = new RegExp(`${search.value}`, 'g');

                    // if(regExp.test(item.boardTitle)){
                    //     console.log("pass"+item.boardTitle)
                    // } else {
                    //     console.log("non"+item.boardTitle)
                    // }

                    let regTitle = item.boardTitle.replaceAll(regExp, `<span style="color:red" id="item">${search.value}</span>`);
                    
                    //http://localhost/board/2/1508?cp=1
                    let astr = `http://localhost/board/${item.boardCode}/${item.boardNo}`
                    // console.log(astr)
                    document.querySelector("#searchBox").insertAdjacentHTML("beforeend", `<a href="${astr}">${regTitle}</a><br>`)
                
                });

            })
            .catch(err => {
                console.log(err);
            })

    })
}

window.document.addEventListener("click", function(e){
    document.querySelector("#searchBox").hidden = true;
})