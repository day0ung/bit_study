<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>조장 정하기</h3>

<div id="div1">
<p id = "p">
팀 갯수 <input type="text" name="limit" id="limit">
<input type="button" name="btn" id="btn" value="버튼" onclick="teamButton();">
</p> 
<br>
<input type="button" name="trans" id="trans" value = "전송" onclick="transInfo();" style="display:none;"><br>
</div>



<script type="text/javascript">
function transInfo(){
	
	var length = document.getElementsByClassName("leader").length;
	var name = document.getElementsByClassName("leader");
	var param = "result.jsp?length="+length;
	
	for(i = 0 ; i < length ; i++){
		param += "&name="+name[i].value;
	}                                           
	location.href=param;
}

function teamButton(){
	
	var teamCount = document.getElementById("limit").value;
	
	if(teamCount<1 || teamCount>6){
		alert("1~6 사이의 숫자를 입력해주세요.");
	}
	else{
		document.getElementById("p").style.display = "none";
		document.getElementById("trans").style.display = "block";
		for(i = 0 ; i < teamCount ; i++){
			document.getElementById("div1").innerHTML += 
				(i+1) + "팀 조장  <input type='text' class='leader' name='leader' id='leader' ><br>";
		}
	}
	
}

</script>


</body>
</html>