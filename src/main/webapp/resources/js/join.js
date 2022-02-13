function duplicateEmail(){
    // ajax로 받아오기 
    const userEmail = btoa($('#user_email').val());
    const url =`http://localhost:8080/bbs/api/user/userCheckEmail/${userEmail}`
    $.ajax({
        method:'get',
        url,
        success : function(data){
            if(data){
               $('#warnUserEmail').text('중복된 이메일이 있습니다.');
            }else{
                $('#warnUserEmail').text('')
            }           
        }
    })
}
function duplicateId(){
    // ajax로 받아오기 
    const userId = $('#user_id').val();
    const url =`http://localhost:8080/bbs/api/user/userCheckId/${userId}`
    $.ajax({
        method:'get',
        url,
        success : function(data){
            if(data){
               $('#warnUserId').text('중복된 아이디가 있습니다.');
            }else{
                $('#warnUserId').text('')
            }           
        }
    })
}
function checkForm(){
    const userWarnEmail = $('#warnUserEmail').text();
    const userWarnId = $('#warnUserId').text();

    const userEmail = $('#user_email').val();
    const userId = $('#user_id').val();
    const userPassword = $('#user_password').val();
    const userRePassword = $('#user_repassword').val();
    const userName = $('#user_name').val();
    console.log(userEmail, userId, userPassword, userRePassword, userName);
    if(userEmail === '' || userId === '' || userPassword === '' || userRePassword === '' || userName === ''){
        alert('비어있는 텍스트가 있는지 확인하세요');
        return false;
    }
    if(userWarnEmail != '' ){
        alert('이미 등록된 이메일이 있습니다.');
        return false;
    }
    if( userWarnId != '' ){
        alert('이미 등록된 아이디가 있습니다.');
        return false;
    }
    if(userPassword != userRePassword){
        alert('비밀번호가 일치하지 않습니다');
        return false;
    }
    return true;
}
$(document).ready(() => {
    //duplicateId();
});