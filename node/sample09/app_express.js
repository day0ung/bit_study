var http = require('http');
var fs = require('fs');
var express = require('express');

var app = express();

var server = http.createServer(app); 

//view를 설정
app.set('views', __dirname+"/views");

//css
var myCss = {
    style: fs.readFileSync( __dirname+'/css/style.cs', 'utf-8') // Sync동기화
}

app.get('/', function (req,res) {
    //app.set을 햇기 때문에 바로 불러들일수 있음
    res.render('index.ejs', //rendering 하는것임, 뿌리는것(index.ejs라는 파일을 읽어들여라)
        {
            title:'제목',
            mycss: myCss
        }
    );
});

server.listen(8000, function () {
   console.log('web server 동작중...'); 
});

/* 에러 났을때 터미널에서 npm install ejs */