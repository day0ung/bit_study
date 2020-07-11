<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
   integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
   crossorigin="anonymous">
<title>Insert title here</title>
</head>

<body>

<style>
#wrpa {width:100%; padding-left:300px;}
.gnb {position:fixed; top:0; left:0; width:250px; height:100vh; background:#000;}
.gnb h2 {color:#fff;}
.sub_contents {width:100%;}
.sub_contents ul {}
.sub_contents ul li {padding-left: 250px; pedding-right: 100px; width:100%; height:500px;background:green;}
.sub_contents ul li:nth-child(2n) {background:#ddd;}
header{
   height: 10vh;
   color: fff;
}


</style>

<div id="wrap">
   <div class="gnb">
      <h2><</h2>
   </div>   
   <header>
      <div class="btn-group" role="group" aria-label="Basic example"
            style="float: right;">
            <button type="button" class="btn btn-info js-foward-regi">회원가입</button>
            <button type="button" class="btn btn-primary js-foward-login">로그인</button>
         </div>
   </header>
   <div class="sub_contents">
     <ul>
        <li>
           <div>
              <h2>내용을적으시오</h2>
           </div>
            <div class="input-group mb-3">
               <div class="input-group-prepend">
                  <span class="input-group-text" id="basic-addon1">ID</span>
               </div>
               <input type="text" class="form-control input-id" placeholder="ID"
                  aria-label="Username" aria-describedby="basic-addon1">
            </div>

            <div class="input-group mb-3">
               <div class="input-group-prepend">
                  <span class="input-group-text" id="basic-addon1">PASSWORD</span>
               </div>
               <input type="password" class="form-control input-pwd"
                  placeholder="PASSWORD" aria-label="Username"
                  aria-describedby="basic-addon1">
            </div>

            <div>
               <div>
                  <span class="checkbox"></span>
               </div>
            </div>

            <div class="btn-group" role="group" aria-label="Basic example">
               <button type="button" class="btn btn-info regiBtn">회원가입</button>
               <button type="button" class="btn btn-primary loginBtn">로그인</button>
            </div>
        

        </li>

     </ul>
   </div>
</div><!-- //wrap -->

</body>
</html>