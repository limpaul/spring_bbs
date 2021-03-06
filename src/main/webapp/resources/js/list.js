function writeBoard(bbsID){
    var inputString = prompt('�대�� 寃���湲� 鍮�諛�踰��몃�� ���ν���몄��', '�대�� 寃���湲� 鍮�諛�踰��몃�� ���ν���몄��');
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
                alert("삭제되었습니다.");
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
            <td><a href='http://localhost:8080/bbs/list/${bbsID}'>${bbsTitle}</a></td>
            <td>${userID}</td>
            <td>${bbsDate}</td>
            <td>${bbsRecommend}</td>
            <td>${bbsVisited}</td>
            <td><button onclick="writeBoard(${bbsID})">remove</button></td>
            </tr>
            `;
    }
    $('table > tbody').html(html);
}
function bbsPageSet(page){ 
    var html ="< ";
    for(var i = 0 ; i < page ; i++){
        html += `<a href='localhost:8080/bbs/api/bbs_list?page=${i+1}'>${i+1}</a>`;
    }
    html += "&nbsp;&nbsp;>"
    $('#page').html(html);
}

function getBoardData(){
   $.ajax({
    type:'get',   
    url:'http://localhost:8080/bbs/api/bbs_list',
    success: function(data){
           console.log(data);
           addTable(data.bbs);
 			bbsPageSet(data.bbsPage);
    },
	})
   
}
$(document).ready(() => {
    getBoardData();
})