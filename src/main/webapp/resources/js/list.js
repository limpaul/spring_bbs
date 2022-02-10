function writeBoard(bbsID){
    var inputString = prompt('해당 게시글 비밀번호를 입력하세요', '해당 게시글 비밀번호를 입력하세요');
    if(inputString=='' || inputString == null){
        return;
    }
    inputData = {
        bbsID: bbsID,
        bbsSecret: inputString
    }
    console.log(inputData);
    $.ajax({
        type:'POST',
        contentType : "application/json; charset=utf-8",
        url:'http://localhost:8080/bbs/api/removeContent',
        data: JSON.stringify(inputData),
        success: function(data){
            if(data == 'false'){
                alert("비밀번호가 올바르지 않습니다!.");
            }
            location.reload();
        }
    })
}
function addTable(data){
    const size = data.length;
    console.log(size);
    var html ="";
    for(var i = 0 ; i < size; i++){
        var bbsID = data[i].bbsID;
        var bbsTitle = data[i].bbsTitle;
        var userID = data[i].userID;
        var bbsDate = data[i].bbsDate;
       	var bbsRecommend = data[i].bbsRecommend;
		var bbsVisited = data[i].bbsVisited;
        html += 
        `
            <tr>
            <td>${bbsID}</td>
            <td><a href='http://localhost:8080/bbs/content.html?bbs_id=${bbsID}'>${bbsTitle}</a></td>
            <td>${userID}</td>
            <td>${bbsDate}</td>
            <td>${bbsRecommend}</td>
            <td>${bbsVisited}</td>
            <td><button onclick="writeBoard(${bbsID})">삭제</button></td>
            </tr>
            `;
    }
    $('table > tbody').html(html);
}
function getBoardData(){
   $.ajax({
    type:'get',   
    url:'http://localhost:8080/bbs/api/bbs_list',
    success: function(data){
           console.log(data);
           addTable(data);
    },
   })
   
}
$(document).ready(() => {
    getBoardData();
})