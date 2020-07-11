<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
 <table class="list_table" style="width:85%">
    <colgroup>
       <col width="200px">
       <col width="500px">
    </colgroup>
    <tbody>
       <tr>
          <th>채팅명</th>
          <td style="text-align:left;">
             <input type="text" id="nickname">
             <input type="button" id="enterBtn" value="입장" onclick="connect()">
             <input type="button" id="exitBtn" value="나가기" onclick="disconnect()">
          </td>
       </tr>
       <tr>
          <th>아이디</th>
          <td style="text-align:left">
             <input type="text" id="id" value="${login.id }">
          </td>
       </tr>
       <tr>
          <td colspan="2">
             <textarea rows="10" cols="70" id="charMessageArea"></textarea>
          </td>
       </tr>
       <tr>
          <td colspan="2">
             <input type="text" id="message" size="20">
             <input type="button" id="sendBtn" value="전송" onclick="send()">
          </td>
       </tr>
    </tbody>    
 </table>

<script>
// web socket 변수
var wsocket;

// 입장 버튼 클릭시 호출되는 함수 [접속]
function connect() {
   // alert("connect");   
   
   // 이미 소켓이 생성된 경우
   if(wsocket != undefined && wsocket.readyState != WebSocket.CLOSED){      
      alert("이미 입장하셨습니다");
      return;
   }

   // Web Socket 생성//SpringSamplesTeacher0313 이건연결안됌 show view- servers 서버에서 더블클릭해서 modules edit하면됨
   wsocket = new WebSocket("ws://localhost:8090/SpringSamples/echo.do");
   alert("wsocket:" + wsocket);

   
   wsocket.onopen = onOpen; // open 됐을 때 onOpen 함수를 호출
   wsocket.onmessage = onMessage; // onmessage 됐을 때 onMessage 함수를 호출
   wsocket.close = onClose; // close 됐을 때 onClose 함수를 호출
}

// 접속 종료
function disconnect() {
   wsocket.close();
   location.href = 'chatting.do'
}

// 연결
function onOpen(evt){
   appendMessage("연결되었습니다" + "\n");
}

// 메시지
function onMessage(evt){
   var data = evt.data;
   if(data.substring(0, 4) == "msg:"){
      appendMessage(data.substring(4)); // 4번째부터 다 가져와라
   }
}

// 끊겼을 때
function onClose(evt){
   appendMessage("연결이 끊겼습니다." + "\n");
}

function send(){
   var nickname = $("#nickname").val();
   var msg = $("#message").val();

   // 실제로 전송
   wsocket.send("msg:" + nickname + ":" + msg);
   $("#message").val("ㅋㅋㅋㅋㅋ");
}

function appendMessage(msg){
   // 메시지를 추가하고 개행
   $("#charMessageArea").append(msg + "\n");

   // 스크롤을 구현하고 채팅내용을 위로 올려준다. (자동 스크롤)
   const top = $("#charMessageArea").prop('scrollHeight');
   $("#charMessageArea").scrollTop(top);
   
}

 
 </script>
 