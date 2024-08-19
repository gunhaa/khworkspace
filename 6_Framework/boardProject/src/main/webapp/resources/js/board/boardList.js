const insertBtn = document.getElementById("insertBtn");
if(insertBtn){
    
    insertBtn.addEventListener("click", e=>{

        // JS BOM 객체 중 location 
    
        // location.href = "주소"
        // 해당 주소 요청(GET 방식)
        location.href=`/board2/${location.pathname.split("/")[2]}/insert`;
    
    })
}
