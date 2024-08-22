const insertBtn = document.getElementById("insertBtn");
if(insertBtn){
    
    insertBtn.addEventListener("click", e=>{

        // JS BOM 객체 중 location 
    
        // location.href = "주소"
        // 해당 주소 요청(GET 방식)
        location.href=`/board2/${location.pathname.split("/")[2]}/insert`;
    
    })
}

// 검색창에 검색 기록 남기기

const boardSearch = document.getElementById("boardSearch");
const searchKey = document.getElementById("searchKey");
const searchQuery = document.getElementById("searchQuery");
const options = document.querySelectorAll("#searchKey > option");

(()=>{
    // 현재 URL의 querystring을 얻어온다.
    // key = t qs가 있다면, params.get("key")로 t를 얻어올 수 있다.
    const params = new URL(location.href).searchParams;

    const key = params.get("key"); // t,c,tc,w 중 하나
    const query = params.get("query"); // 검색어

    searchQuery.value=query;
    options.forEach(item=>{
        if(item.value==key){
            item.selected=true;
        }
    })
    document.querySelector("#query").value=query;
    // forEach 대신 for(let .. of.. )사용 가능

})();

// 검색어 입력 없이 제출된 경우
boardSearch.addEventListener("submit", e=>{

    // 검색어 미입력 시 
    // form 기본 이벤트 제거
    if(searchQuery.value.trim().length==0){
        e.preventDefault();
        location.href = location.pathname;// 해당 게시판 1페이지로 이동
        //location.pathname : 쿼리스트링을 제외한 실제 주소
    }

});


