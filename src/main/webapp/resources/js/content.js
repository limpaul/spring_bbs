

function writeReview(){ // 댓글 달기 기능 
   const bbsId = $(location).attr("search").split("=")[1]; // bbs_id
   const reviewContent = $('#review').val();
   const userId = "test";
   
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
    const bbsID = data.bbsID;
    const bbsTitle = data.bbsTitle;
    const userID = data.userID;
    const bbsDate = data.bbsDate;
    const bbsContent = data.bbsContent;
    var bbsRecommend = data.bbsRecommend;
    var bbsVisited = data.bbsVisited;
    $('div > ul > li:nth-child(1)')
    .html(`제목 ${bbsTitle}  아이디: ${userID} 추천수: ${bbsRecommend}  조회수: ${bbsVisited} ${bbsDate}`);

    $('div > ul > li:nth-child(2)')
    .html(`${bbsContent}`);
}
function model_board_review(data){
    var html ="";
    for(var i = 0 ; i < data.length; i++){
        const reviewId = data[i].reviewId;
        const bbsId = data[i].bbsId;
        const userId = data[i].userId;
        const reviewContent = data[i].reviewContent;
        const reviewDate = data[i].reviewDate;
        const reviewRecommend = data[i].reviewRecommend;
        html += 
        `
           <p> ${reviewId} ${userId} ${reviewContent}<b> ${reviewDate} 추천수: ${reviewRecommend}</b> <button>삭제</button><button>비추천</button><button>추천</button></p>
        `
    }
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
function searchReviewBybbsId(bbs_id){
    const url = `http://localhost:8080/bbs/api/review/${bbs_id}`
    $.ajax({
        method:'get',
        url,
        success: function(data){
            console.log(data);
            model_board_review(data);
        }
    })
}


$(document).ready(()=>{
    const bbs_id = $(location).attr('search').split('=')[1];
    searchBoardById(bbs_id);
    searchReviewBybbsId(bbs_id);
})