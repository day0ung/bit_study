var http = require('http');
var fs = require('fs');//file system
var express = require('express'); //express module 이 없을때 터미널가서  npm install express 입력

var app = express();

var server = http.createServer(app); 

server.listen(8000, function () {
    console.log('web server 가동중...')
});

app.get('/', function (req, res) {
   console.log('/ 접속 성공!');

   fs.readFile(__dirname + '/index.html', function (err, data) { // __dirname == 현재경로
        if(err) console.log(err);
        console.log('readFile success');

        res.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});/* 200 -> success, 404 etc */
        res.write(data);    
        res.end();    

    });
    
});



app.get('/main', function (req, res) {
    console.log('/main 접속 성공!');
 
    fs.readFile(__dirname + '/main.html', function (err, data) { // __dirname == 현재경로
         if(err) console.log(err);
         console.log('readFile success');
 
         res.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});/* 200 -> success, 404 etc */
         res.write(data);    
         res.end();    
 
     });
     
 });