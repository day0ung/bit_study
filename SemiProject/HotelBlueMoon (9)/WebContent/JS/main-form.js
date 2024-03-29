const formLoginBtn = document.querySelector(".js-foward-login");
const formRregiBtn = document.querySelector(".js-foward-regi");
const formLogoutBtn = document.querySelector(".js-foward-logout");
const formSessionId = document.querySelector(".js-session");

const formMainBtn = document.querySelector(".js-main-foward");
const formSearchBtn = document.querySelector(".js-search-foward");
const formQnabtn = document.querySelector(".js-qna-foward");
const formReview = document.querySelector(".js-review-foward");
const formMypage = document.querySelector(".js-mypage-foward");

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
};

function loginCheck() {
	if (formSessionId.value === null || formSessionId.value === "null") {
		formRregiBtn.style.visibility = 'visible';
		formLoginBtn.classList.remove("btn-warning");
		formLoginBtn.classList.add("btn-success");
		formLoginBtn.innerHTML = "로그인"
	} else if (formSessionId !== null) {
		formRregiBtn.style.visibility = 'hidden';
		formLoginBtn.classList.remove("btn-success");
		formLoginBtn.classList.add("btn-warning");
		formLoginBtn.innerHTML = "로그아웃";
	}
}

function fowardRegi() {
	location.href = getContextPath() + "/regifoward";
}

function fowardLogin() {
	if (formLoginBtn.innerHTML === "로그인") {
		location.href = getContextPath() + "/fowardlogin";
	} else if (formLoginBtn.innerHTML === "로그아웃") {
		location.href = getContextPath() + "/fowardlogout";
	}
}

function fowardMain() {
	location.href = getContextPath() + "/mainfoward";
}

function fowardSearch() {
	location.href = getContextPath() + "/main";
}

function fowardQna() {
	location.href = getContextPath() + "/qnafoward";
}

function fowardReview() {
	location.href = getContextPath() + "/reviewfoward";
}

function fowardMypage() {
	$.ajax({
		url:`${getContextPath()}`+"/mypageidcheck",
		method:"get",
		data: {
			"loginId" : `${formSessionId.value}`
		} ,
		success:function(data){
			if(data.trim() === "1" ){
				alert("로그인페이지로 이동합니다.")
				location.href= getContextPath() +"/fowardlogin";
			}else if (data === "2"){
				location.href= getContextPath() +"/mypagefoward";
			}
		},
		error:function(){
			alert("error")
		}
	});
}

function init() {
	loginCheck();
	formRregiBtn.addEventListener("click", fowardRegi);
	formLoginBtn.addEventListener("click", fowardLogin);
	formMainBtn.addEventListener("click", fowardMain);
	formSearchBtn.addEventListener("click", fowardSearch);
	formQnabtn.addEventListener("click", fowardQna);
	formReview.addEventListener("click", fowardReview);
	formMypage.addEventListener("click", fowardMypage);
}

init();