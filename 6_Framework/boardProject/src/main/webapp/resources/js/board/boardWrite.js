// 미리보기 관련 요소 모두 얻어오기

// img5개
const preview = document.getElementsByClassName("preview");
// file 5개
const inputImage = document.getElementsByClassName("inputImage");
// x버튼 5개
const deleteImage = document.getElementsByClassName("delete-image");

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

        if (file != void 0) { //파일이 선택 되었을 때
            const reader = new FileReader(); // 파일을 읽는 객체
            reader.readAsDataURL(file);

            // onload, load가 같음
            reader.addEventListener("load", () => {
                preview[i].src = reader.result
            })
            // reader.onload= () => {
            //     preview[i].src = reader.result;
            // }


        } else {
            preview[i].removeAttribute("src");
        }

        deleteImage[i].addEventListener("click", e => {
            // preview[i].src = "";
            // document.querySelector(`#img${i}`).value="";
            // 미리보기가 있을 경우
            if(preview[i].getAttribute("src") != ""){
                // 미리보기 삭제
                preview[i].removeAttribute("src");
                // input type="file" 태그의 value 삭제
                // * input type="file"의 value는 빈칸('')만 대입 가능
                inputImage[i].value="";
            }
        
        });

    })
   
}

const boardTitle = document.querySelector("#boardtitle");
const boardContent = document.querySelector("#boardContent");

document.querySelector("#boardWriteFrm").addEventListener("submit", e=>{
    
    if(boardTitle.value.trim().length==0){
        alert("제목을 입력해주세요");
        boardTitle.focus();
        boardTitle.value="";
        e.preventDefault();
        return;
    }
    if(boardContent.value.trim().length==0){
        alert("내용을 입력해주세요");
        boardContent.focus();
        boardContent.value="";
        e.preventDefault();
        return;
    }

})