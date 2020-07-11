var http  = require('http');
var fs = require('fs');

http.createServer(function (req,res) {
    //file read <- html   
    /* (__dirname >> 현재경로를 취득할 수 잇음  demo 파일은 sample07에 있음*/
    fs.readFile(__dirname+'/demo.html', function (err, data) { //demo.html 이 function 안의 data에 들어옴
       if (err) console.log(err); //err가 참이면 err출력
       console.log('readfile success');

       if(req.method == 'GET'){
           res.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});

           res.write(data);
           res.end();
       }
    });
}).listen(8000);