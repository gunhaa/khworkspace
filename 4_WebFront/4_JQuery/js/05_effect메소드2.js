
$(document).ready(function () {
    $('div').on('click', function () {
        //     const contents = $('.contents');
        //     for(let i=0 ; i<contents.length; i++){
        //         if($(contents[i]).css('display')!=='none'){
        //             $(contents[i]).slideUp();
        //         }
        //     }
        //     if($(this).next().css('display')=='none'){
        //         $(this).next().slideDown();
        //     } else{
        //         $(this).next().slideUp();
        //     }
        // })

        // 다른 풀이
        if($(this).next('p').css('display') == 'none'){
            $(this).siblings('.contents').slideUp();
            $(this).next().slideDown();
        } else{
            $(this).next().slideUp();
        }


    })
});