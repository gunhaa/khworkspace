// 상세 조회 ,게시글 작성 - 목록으로 버튼


(function () {
    const goToListBtn = document.querySelector("#goToListBtn");


    if (goToListBtn != null) { //목록으로 버튼이 화면에 있을 때만 이벤트 추가

        goToListBtn.addEventListener("click", function () {

            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)

            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            // 단, 시작 인덱스 이후 부터 검색
            const pathname = location.pathname; // 주소상에서 요청했던 주소 반환
            // /community/board/detail

            // 이동할 주소 저장

            let url = pathname.substring(0, pathname.indexOf("/", 1));


            url += "/board/list?"; // /community/board/list?

            // location.href = "주소"; --> 해당 주소로 이동




            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리스트링만 별도의 객체로 반환
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type"); // type=1
            let cp;


            if (params.get("cp") != null) {// 쿼리스트링에 cp가 있는 경우
                cp = "cp=" + params.get("cp"); //cp=1
            } else {
                cp = "cp=1";
            }



            // 조립
            url += type + "&" + cp;
            // /community/board/list?type=1&cp=1

            // 검색 key, query가 존재하는 경우 url에 추가

            if(params.get("key")!=null && params.get("query")!=null){
                url += "&key="+params.get("key")+"&query="+params.get("query"); 
            }

            // location.href = "주소"; --> 해당 주소로 이동 
            location.href = url;

        });

    }


})();

// 즉시 실행 함수 : 성능 up, 변수명 중복 안됨

(function () {

    const thumbnail = document.getElementsByClassName("list-thumbnail");

    if (thumbnail.length > 0) { //목록에 썸네일 이미지가 있을 경우
        const modal = document.querySelector(".modal");
        const modalClose = document.getElementById("modal-close");
        const modalImage = document.getElementById("modal-image");

        // thumbnail.forEach((item)=>{
        //     item.addEventListener("click", ()=>{
        //         console.log('11');
        //         modal.classList.add("show");
        //     })
        // });

        for (let th of thumbnail) {
            th.addEventListener("click", function () {
                modalImage.setAttribute("src", th.getAttribute("src"));

                // on/off 스위치 
                // classList.toggle("클래스명") : 클래스가 없으면 추가(add)
                //                                클래스가 있으면 제거(remove)

                modal.classList.toggle("show"); // add
            })


        }

        modalClose.addEventListener("click", function () {
            modal.classList.toggle("hide"); // hide 클래스 추가

            setTimeout(function () { // 0.45초후 동작

                modal.classList.toggle("hide"); // hide 클래스 제거

                modal.classList.toggle("show"); // show 클래스 remove

            }, 450);
        });
    }
})();


// 즉시 실행 함수 : 게시글 삭제
(function () {

    const deleteBtn = document.getElementById("deleteBtn");

    if (deleteBtn != null) { //삭제 버튼이 화면에 존재할 때
        deleteBtn.addEventListener("click", () => {

            // 현재 : /community/board/detail?no=1521&cp=1&type=1

            // 목표 : /community/board/delete?no=1523&type=1

            let url = "delete"; // 상대 경로 형식으로 작성

            // 주소에 작성된 쿼리스트링에서 필요한 파라미터만 얻어와서 사용

            // 1. 쿼리스트링에 존재하는 파라미터 모두 얻어오기
            const params = new URL(location.href).searchParams;
            // 2. 원하는 파라미터만 얻어와서 변수에 저장
            const no = "no=" + params.get("no");
            const type = "type=" + params.get("type");

            // 3. url 쿼리스트링에 추가
            url += `?${no}&${type}`;

            if (confirm("정말로 삭제하시겠습니까?")) {
                location.href = url; // get방식으로 url 에 요청
            }

        });
    }


})();


// 검색창에 이전 검색 기록 반영

(function () {

    const select = document.getElementById("search-key");
    const input = document.getElementById("search-query");
    const option = document.querySelectorAll("#search-key > option");

    if (select != null) { // 검색창 화면이 존재할 때만 적용

        // 현재 주소에서 쿼리스트링(파라미터) 얻어오기
        // 얻어온 파라미터 중 key,query만 변수에 저장
        const params = new URL(location.href).searchParams;

        const key = params.get("key");
        const query = params.get("query");


        // input에 query 값 대입
        input.value = query;
        // option을 반복 접근해서 value와 key가 같으면 selected 속성 추가

        option.forEach((op) => {

            if (op.value == key) {
                op.selected = true;
            }
        })

        // for(let op of option){
        //     if(op.value==key){
        //         op.selected = true;
        //     }
        // }
    }


})();


function searchValidate(){

    const query = document.querySelector("#search-query");

    if(query.value.trim().length == 0){
        query.value="";
        query.focus();
        return false;
    }
    return true;

};