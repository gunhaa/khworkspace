// 상세 조회 - 목록으로 버튼

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
            const cp = "cp=" + params.get("cp"); //cp=1

            // 조립
            url += type + "&" + cp;
            // /community/board/list?type=1&cp=1


            // location.href = "주소"; --> 해당 주소로 이동 
            location.href = url;

        });

    }


})();



// 미리보기 관련 요소 모두 얻어오기
// -> 동일한 개수의 요소가 존재함 == 인덱스가 일치함
const preview = document.getElementsByClassName("preview");
const inputImage = document.getElementsByClassName("inputImage");
const deleteImage = document.getElementsByClassName("delete-image");

// 게시글 수정 시 삭제된 이미지의 레벨(위치)를 저장할 input 요소
const deleteList = document.getElementById("deleteList");

// 게시글 수정 시 삭제된 이미지의 레벨(위치)를 기록해둘 Set 생성
const deleteSet = new Set(); // 중복 허용 안함, 순서가 없다 -> 여러번 클릭시 중복 값 저장방지


for (let i = 0; i < inputImage.length; i++) {

    // 파일이 선택 되었을 때
    inputImage[i].addEventListener("change", function () {

        if (this.files[0] != undefined) {

            const reader = new FileReader();
            // 선택된 파일을 읽을 객체 생성
            reader.readAsDataURL(this.files[0]);
            // 지정된 파일을 읽기 시작함 -> result에 저장(URL 포함)
            // -> URL을 이용해서 이미지 볼 수 있음
            reader.onload = function (e) {
                // e.target == reader
                // e.target.result == 읽어들인 이미지의 url
                // preview[i] == 파일이 선ㅌ액된 input 태그와 인전합 preview 이미지 태그
                preview[i].src = reader.result;
                // preview[i].setAttribute("src", e.target.result);

                deleteSet.delete(i);
            };

        } else { // 파일이 선택이 되지 않을 때 (취소)
            preview[i].removeAttribute("src");
        }

    });

    // 미리보기 삭제 버튼(X)이 클릭 되었을 떄
    deleteImage[i].addEventListener("click", function () {


        // 미리보기가 존재하는 경우에만(이전에 추가된 이미지가 있을때만 X버튼 동작)
        if (preview[i].getAttribute("src") != "") {

            // 미리보기 삭제
            preview[i].removeAttribute("src");
            // preview[i].src="";
            // input의 값 "" 만들기
            inputImage[i].value = "";
            // deleteSet에 삭제된 이미지 레벨(i) 추가
            deleteSet.add(i);
        }




    });
};


// 게시글 작성 유효성 검사

function writeValidate() {

    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']");

    if (boardTitle.value.trim().length == 0) {
        alert("제목을 입력해주세요.");
        boardTitle.focus();
        boardTitle.value = "";
        return false;
    }

    if (boardContent.value.trim().length == 0) {
        alert("내용을 입력해주세요.");
        boardContent.focus();
        boardContent.value = "";
        return false;
    }

    // 제목, 내용이 유효한 경우
    // deleteList(input 태그)에 deleteSet(삭제된 이미지 레벨)을 추가
    // -> JS 배열 특징 이용
    //    :JS 배열을 HTML 요소 또는 console에 출력하게 되는 경우 0,1,2,3 과 같은 문자열로 출력
    //     (배열 기호 사라짐)

    // *Set -> Array로 변경 -> deleteList.value에 대입

    // Array.from(유사배열 | 컬렉션) : ㅇ사배열 | 컬렉션을 배열로 변환해서 반환 
    deleteList.value = Array.from(deleteSet);


    return true;
}

