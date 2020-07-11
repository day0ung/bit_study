var http = require('http');
var fs = require('fs');
var express = require('express'); 
var oracledb = require('oracledb'); 
var ejs = require('ejs');

var app = express();

oracledb.autoCommit = true; //auto commit 설정해주는

var server = http.createServer(app);

//dbconnect하기 위한 변수
var dbconn;

//Parameter ? &seq= & <<요런거 설정하기 이거아하면 안넘어감모듈없으면: npm install body-parser
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded( {extended:true }))

//DB Connection -json 코드로
oracledb.getConnection({
    user:'hr',
    password:'hr',
    host:'localhost',
    database:'xe'
}, function (err, conn) {
    if(err) console.log('접속 실패'+err);
    
    console.log('DB 접속 성공');
    dbconn = conn;
});

app.get('/', function (req, res) {
   fs.readFile(__dirname+"/write.html", function (err,data) {
      console.log("write.html 접속 성공"); 

      //fs안에 있는 파일을 읽어들여서 data를 넘겨주겟다 
      res.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});/* 200 -> success, 404 etc */
      res.write(data);    
      res.end();   
   }); 
   
});

//html에서 post로 보냄
app.post('/regist', function (req,res) {
   console.log('regist 접속성공');

   //parameter -> data수집(write.html의 data가져오기)
   var writer = req.body.writer; // ==getParametr 
   var title = req.body.title;
   var content = req.body.content;
   // body로 받는 것은 post방식
   //req.params.writer -> params로 받는 것은 get방식
   console.log(writer+ title+ content); 

   dbconn.execute("insert into notice(writer, title, content) values('"+writer+"', '"+title+"', '"+content+"')", 
   function (err, result) {
      if(err){
          console.log('등록 중 에러 발생'+err);
      }else{
         console.log('등록 성공');
         // list 이동
         res.redirect('list'); //redirect = sendRedirect와 동일
      }
   })
})

app.get('/list', function (req, res) {
  console.log('/list 접속성공'); 

  //list로 가기 전에 db에서 꺼내서 짐싸기 {} >>oracle db의  object형식으로 바꿔라는 뜻 
  dbconn.execute("select * from notice", {}, {outFormat:oracledb.OBJECT}, function (err, result) {
      if(err){
         console.log('조회 중 에러 발생'+err);
      }else{
         console.log(result);
         console.log("result.rows"+result.rows);

         //string변경
         var json = JSON.stringify(result.rows);

         //json변경
         var arr = JSON.parse(json);
         console.log(arr);

         //이동
         fs.readFile(__dirname+"/list.ejs", "utf-8", function (err, data) {
            if(err) console.log('read fail'+ err);

            //날려주어야할것, 데이터를 같이 가져가야함
            res.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});
                              //짐을 가져가는 부분
            res.end(ejs.render(data, {arrlist:arr} )); //data는 list에 넘어갈때 데이터임,  이데이터를 통해서 같이 가져가야하는것이 arrlist 임

         })
      }
   })
});
//서버동작시키기 listen
server.listen(8000, function () {
   console.log('웹서버 실행중'); 
});
