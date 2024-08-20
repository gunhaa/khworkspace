// 미리보기 관련 요소 모두 얻어오기

// img5개
const preview = document.getElementsByClassName("preview");
// file 5개
const inputImage = document.getElementsByClassName("inputImage");
// x버튼 5개
const deleteImage = document.getElementsByClassName("delete-image");

// 게시글 수정 시 삭제된 이미지의 순서를 기록할 Set객체 생성
const deleteSet = new Set(); // 순서X, 중복X
//-> X버튼 클릭 시 순서를 한 번만 저장하는 용도 


// -> 위에서 얻어온 요소들의 개수가 같음 == 인덱스가 일치함
for (let i = 0; i < inputImage.length; i++) {

    // 파일이 선택되거나, 선택 후 취소되었을 때 
    inputImage[i].addEventListener("change", e => {
        //preview[i].src
        const file = e.target.files[0]; //선택된 파일의 데이터
        //     const reader = new FileReader();
        //     reader.readAsDataURL(file);

        //     reader.onload= () => {
        //         let base64data = reader.result;

        //         preview[i].src=base64data;
        //     }
        // });

        if (file != undefined) { //파일이 선택 되었을 때
            const reader = new FileReader(); // 파일을 읽는 객체
            reader.readAsDataURL(file);

            // onload, load가 같음
            // reader.addEventListener("load", () => {
            //     preview[i].src = reader.result;
            //     // 이미지가 성공적으로 읽어지면
            //     // deleteSet에서 삭제
            //     deleteSet.delete(i);
            // })
            reader.onload= () => {
                preview[i].src = reader.result;
                deleteSet.delete(i);
            }


        } else {
            preview[i].removeAttribute("src");
        }
        
    });

    deleteImage[i].addEventListener("click", () => {
        console.log("test");
        // preview[i].src = "";
        // document.querySelector(`#img${i}`).value="";
        // 미리보기가 있을 경우
        if (preview[i].getAttribute("src") != "") {
            // 미리보기 삭제
            preview[i].removeAttribute("src");
            // input type="file" 태그의 value 삭제
            // * input type="file"의 value는 빈칸('')만 대입 가능
            inputImage[i].value = "";

            // deleteSet에 삭제된 이미지 순서 추가
            deleteSet.add(i);
        }

    })

}

// 게시글 수정 시 제목, 내용 작성 여부 검사
const boardTitle = document.querySelector("#boardtitle");
const boardContent = document.querySelector("#boardContent");

document.querySelector("#boardUpdateFrm").addEventListener("submit", e => {

    if (boardTitle.value.trim().length == 0) {
        alert("제목을 입력해주세요");
        boardTitle.focus();
        boardTitle.value = "";
        e.preventDefault();
        return;
    }
    if (boardContent.value.trim().length == 0) {
        alert("내용을 입력해주세요");
        boardContent.focus();
        boardContent.value = "";
        e.preventDefault();
        return;
    }

    // input type="hidden" 태그에
    // deleteSet에 저장된 값을 "1,2,3" 형태로 변경해서 저장

    // Array.from(deleteSet) : Set -> Array 변경

    // JS에 배열은 string에 대입되거나 출려될 때
    // 요소, 요소, 요소 형태의 문자열을 반환한다.

    document.querySelector("[name='deleteList']").value= Array.from(deleteSet);
    //e.preventDefault();
});



