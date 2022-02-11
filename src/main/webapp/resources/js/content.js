

function login(){
	$(location).attr('href', '/bbs/login');
}
function writeReview(sessionID){ // 댓글 달기 기능 
   const bbsId = $(location).attr("search").split("=")[1]; // bbs_id
   const reviewContent = $('#review').val();
   const userId = sessionID;
   
   if(sessionID == null){
		$(location).attr('href', '/bbs/login');
   }
   const sendData = {
       userId,
       reviewContent,
   }
   $.ajax({
        method: 'post',
        contentType : "application/json; charset=utf-8",
        url: `http://localhost:8080/bbs/api/review/${bbsId}`,
        data: JSON.stringify(sendData),
        success: function(data){
            console.log(data);
            location.reload();
        }
   })
   
}
function model_board(data){
    const bbsId = data.bbsID;
    const bbsTitle = data.bbsTitle;
    const userId = data.userID;
    const bbsDate = data.bbsDate;
    const bbsContent = data.bbsContent;
    var bbsRecommend = data.bbsRecommend;
    var bbsVisited = data.bbsVisited;

    // bbs setting
    $('div > ul > li:nth-child(1)')
    .html(`제목 ${bbsTitle}  아이디: ${userId} 추천수: ${bbsRecommend}  조회수: ${bbsVisited} ${bbsDate}`);

    $('div > ul > li:nth-child(2)')
    .html(`${bbsContent}`);


    //review setting
    const reviews = data.reviews;
    const reviews_length = reviews.length;
    var html ="";
    for(var i = 0 ; i < reviews_length ; i++){
        const reviewId = reviews[i].reviewId;
        const reviewContent = reviews[i].reviewContent;
        const reviewDate = reviews[i].reviewDate;
        const reviewRecommend = reviews[i].reviewRecommend;
        html += 
        `
           <p> ${reviewId} ${userId} ${reviewContent}<b> ${reviewDate} 추천수: ${reviewRecommend}</b> <button>삭제</button><button>비추천</button><button>추천</button></p>
        `
    }
    // review modeling
    $('div > ul > li:nth-child(5)')
    .append(html); 
}


function searchBoardById(bbs_id){
    const url = `http://localhost:8080/bbs/api/bbs/${bbs_id}`
    $.ajax({
        method:'get',
        url,
        success: function(data){
            console.log(data);
            model_board(data);
        }
    })
}



$(document).ready(()=>{
    const bbs_id = $(location).attr('search').split('=')[1];
    searchBoardById(bbs_id);
})