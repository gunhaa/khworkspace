
const all = document.getElementById('all'); //전체 선택 체크박스
const hobbyList = document.getElementsByName('hobby'); // 취미 체크박스
const result = document.getElementById('result');

// 전체 선택 클릭 시 전체 선택 체크박스로 값 변경
all.addEventListener('click', () => {
    for (let i = 0; i < hobbyList.length; i++) {
        hobbyList[i].checked = all.checked;
    }
})

// 카테고리 선택 버튼 클릭 시 
function selectCategory() {
    let str = "";
    for (let i = 0; i < hobbyList.length; i++) {
        if ((hobbyList[i]).checked) {
            str += hobbyList[i].value + " ";
        }
    }
    result.innerHTML = str;
}


// 취미 체크박스 클릭 시 전체 선택 여부 확인
this.addEventListener('click', (e) => {
    for (let i = 0; i < hobbyList.length; i++) {

        if (hobbyList[i] == e.target) { //취미 체크박스를 선택했을때

            // 1) 취미가 전부 선택 안되어 있을 시 전체 선택 체크박스 해체하기
            if (all.checked && !hobbyList[i].checked) {
                // 전체 선택이 체크되어 있으면서 현재 클릭한 체크박스가 체크 안된 경우

                all.checked = false; //전체 선택 해제

            }

            //취미가 전부 선택이 되어 있을 시 전체선택 체크박스 체크하기
            let flag = true;
            for (let j = 0; j < hobbyList.length; j++) { //전부 체크됬는지 확인하기 위한 for문
                if (!hobbyList[j].checked) { //하나라도 체크가 안되어있을때
                    flag = false;
                }
            }

            if(!all.checked && flag){
                //전체 선택 체크박스가 체크되어 있지 않으면서
                // 취미가 전부 선택이 되어있는 경우
                
                all.checked = true;
            
            }

        }

    }
})