

function login(){
	$(location).attr('href', '/bbs/login');
}
function writeReview(sessionID){ // 댓글 달기 기능 
   const pathName = $(location).attr('pathname').split('/');
   const bbsId = pathName[3]; // bbs_id

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


    
}
/*
	리뷰를 갱신화하는 메소드를 부분화한다.
 */
function refreshReviews(data){
	 //review setting
	const userId = data.userID;
    const reviews = data.reviews;
	console.log('reviews', reviews);
    const reviews_length = reviews.length;
    var html ="";
    for(var i = 0 ; i < reviews_length ; i++){
        const reviewId = reviews[i].reviewId;
		const reviewUserId = reviews[i].userId;
        const reviewContent = reviews[i].reviewContent;
        const reviewDate = reviews[i].reviewDate;
        const reviewRecommend = reviews[i].reviewRecommend;
        html += 
        `
           <p> ${reviewId} ${reviewUserId} ${reviewContent}<b> ${reviewDate} 추천수: ${reviewRecommend}</b> <button>삭제</button><button>비추천</button><button>추천</button></p>
        `
    }
    // review modeling
    $('#reviews')
    .append(html); 
}
function refreshSubReviews(data){
	 //review setting

    const reviews_length = data.length;
    var html ="";
    for(var i = 0 ; i < reviews_length ; i++){
        const reviewId = data[i].reviewId;
		const reviewUserId = data[i].userId;
        const reviewContent = data[i].reviewContent;
        const reviewDate = data[i].reviewDate;
        const reviewRecommend = data[i].reviewRecommend;
        html += 
        `
           <p> ${reviewId} ${reviewUserId} ${reviewContent}<b> ${reviewDate} 추천수: ${reviewRecommend}</b> <button>삭제</button><button>비추천</button><button>추천</button></p>
        `
    }
    // review modeling
    $('#reviews')
    .html(html); 
}


function searchBoardById(bbs_id){ // 게시판 정보를 bbsid로 조회
    const url = `http://localhost:8080/bbs/api/bbs/${bbs_id}`
    $.ajax({
        method:'get',
        url,
        success: function(data){
            console.log(data);
            model_board(data);
			refreshReviews(data);
			bbsReviewPageSet(data.reviewCount);
        }
    })
}
function requestPageData(page, count){
	const pathName = $(location).attr('pathname').split('/');
    const bbs_id = pathName[3];
	const url = `http://localhost:8080/bbs/api/review/${bbs_id}/${page}/${count}`;
	$.ajax({
		method: 'get',
		url,
		success:function(data){
			console.log(data);
			refreshSubReviews(data);
		}
	})
}
// review 데이터를 localhost:8080/bbs/api/review/bbs번호/리뷰시작페이지/가져올데이터개수 로 조회.
// localhost:8080/bbs/api/review/${i+1}
function bbsReviewPageSet(page){ 
	/** 여기서 a onclick시 부분 모델링으로 댓글 페이지 전환해줘야함. */ 
    var html ="< ";
    for(var i = 0 ; i < page ; i++){
        html += `<a onclick='requestPageData(${i+1}, 5)'>${i+1}</a>&nbsp;&nbsp;`;
    }
    html += " >"
    $('#page').html(html);
}


$(document).ready(()=>{
	const pathName = $(location).attr('pathname').split('/');
    const bbs_id = pathName[3];
    searchBoardById(bbs_id);
})