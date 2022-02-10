function check(){
    const userID = $('#userID').val();
    const userPW = $('#userPW').val();
    if(userID == ''){
        alert('아이디를 입력해주세요.');		
        return false;
    }
    if(userPW == ''){
        alert('비밀번호를 입력해주세요.')	
        return false;
    }
    if(userID && userPW){
        return true;
    }
}
$(document).ready(()=>{

});