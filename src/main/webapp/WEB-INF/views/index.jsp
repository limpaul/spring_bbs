<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head><title>webSocket page</title></head>
<body>
<form>
	<input type="text" id="textMessage">
	<input type="button" onclick="sendMessage()" value="Send">
	<input type="button" onclick="disconnect()" value="Disconnect">
</form>
<textarea id="messageTextArea" rows="50" cols="50"></textarea>
<script>
	var webSocket = new WebSocket("ws://localhost:8080/servletBbs/websocket")
	// 콘솔 텍스트 에리어 오브젝트
	var messageTextArea = document.getElementById("messageTextArea");
	// WebSocket 서버와 접속이 되면 호출되는 함수
	webSocket.onopen = function(message) {
	// 콘솔 텍스트에 메시지를 출력한다.
	messageTextArea.value += "Server connect...\n";
	};
	// WebSocket 서버와 접속이 끊기면 호출되는 함수
	webSocket.onclose = function(message) {
	// 콘솔 텍스트에 메시지를 출력한다.
	messageTextArea.value += "Server Disconnect...\n";
	};
	// WebSocket 서버와 통신 중에 에러가 발생하면 요청되는 함수
	webSocket.onerror = function(message) {
	// 콘솔 텍스트에 메시지를 출력한다.
	messageTextArea.value += "error...\n";
	};
	// WebSocket 서버로 부터 메시지가 오면 호출되는 함수
	webSocket.onmessage = function(message) {
	// 콘솔 텍스트에 메시지를 출력한다.
	messageTextArea.value += "Recieve From Server => "+message.data+"\n";
	};
	// Send 버튼을 누르면 호출되는 함수
	function sendMessage() {
	// 송신 메시지를 작성하는 텍스트 박스 오브젝트를 취득한다.
	var message = document.getElementById("textMessage");
	// 콘솔 텍스트에 메시지를 출력한다.
	messageTextArea.value += "Send to Server => "+message.value+"\n";
	// WebSocket 서버에 메시지를 송신한다.
	webSocket.send(message.value);
	// 송신 메시지를 작성하는 텍스트 박스를 초기화한다.
	message.value = "";
	}
	// Disconnect 버튼을 누르면 호출되는 함수
	function disconnect() {
	// WebSocket 접속 해제
	webSocket.close();
	}

</script>
</body>
</html>
