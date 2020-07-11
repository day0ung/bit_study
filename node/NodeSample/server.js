var express = require('express');
var app = express();


var member = require('./router/member');
var bbs = require('./router/bbs');

app.use(member);
app.use(bbs);
//resource 등록 부분
var resou = require('./router/resource.js');
app.use(resou);

// view set
app.set('views',__dirname + "/views");

// res.render 메소드에서 .ejs를 생략할 수 있는 설정
app.set('view engine', 'ejs'); 
app.engine('html', require('ejs').renderFile);

var server = app.listen(8000, function () {
    console.log('웹 서버 실행 중...');
})

