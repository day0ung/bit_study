var oracledb = require('oracledb');
var express = require('express');
var app = express.Router();

var session = require("express-session"); // npm install express-session

var db = require("../util");
var oracle = require("../oracle");

// link == Controller(+Dao) 

// Parameter 받기 위해서 설정
var bodyParser = require('body-parser'); //npm install body-parser
app.use( bodyParser.urlencoded( {extended:true} ) );

// session 설정
app.use(
    session({
        secret: 'keyboard cat',
        resave: false,
        saveUninitialized: true
    })
);


app.get('/', function (req, res) {
    console.log('/ 접속 성공');
    res.render('index.html');

});

app.get('/login', function (req, res) {
    console.log('/login 접속 성공');
    res.render('login.html');
});

app.get('/regi', function (req, res) {
    console.log('/regi 접속 성공');
    res.render('regi.html');
});


app.post('/idcheck', function (req, res) {
    console.log('/idcheck 접속 성공');
    var id = req.body.id;
    console.log('id:' + id);

    // db에서 산출
    var conn = db.getConn();
    
    conn.execute("SELECT COUNT(*) FROM MEMBER WHERE ID='" + id + "'", function (err, result) {
        if(err) console.log('db error');

        console.log("결과:" + result.rows); // 중복되는 id = 1 출력 / 사용 가능한 id = 0
        if(result.rows == 0){
            res.send( { result:'YES' } ); //Ajax는 send()를 사용
        }else{
            res.send( { result:'NO' } );    
        }
    })
});

app.post('/regiAf', function(req, res){
    console.log('/regiAf 접속 성공');

    var id = req.body.id;
    var pwd = req.body.pwd;
    var name = req.body.name;
    var email = req.body.email;


    console.log(id + " " + pwd + " " + name + " " + email);

    var conn = db.getConn();

    conn.execute("INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) VALUES(:id, :pwd, :name, :email, 3)", [id, pwd, name, email], function (err, result){
        if(err) console.log("db insert error");

        console.log('insert success');
        res.redirect('login');

    });

});

app.post('/loginAf', function (req, res) {
    console.log('/loginAf 접속 성공');

    var id = req.body.id;   // req.body(POST방식), req.query (GET방식)
    var pwd = req.body.pwd;
   
    var conn = db.getConn();
    conn.execute("SELECT ID, NAME, EMAIL, AUTH FROM MEMBER WHERE ID=:id AND PWD=:pwd", [id, pwd], {outFormat:oracledb.OBJECT}, function (err, result) {
        if(err) console.log("db select error");

        console.log("result:" + result);

        /* 데이터 꺼내기
        str = JSON.stringify(result.rows[0]);
        var json = JSON.parse(str);
        
        console.log("str:" + str);
        console.log("json:" + json);
        // console.log("결과:" + json[0][0]);
        */

        if(result.rows != 0) { // login 성공
            json = JSON.stringify(result.rows[0]);
            console.log(json); // json 방식  ex) {"ID":"aaa","NAME":"aaa","EMAIL":"aaa","AUTH":3}
            var arr =JSON.parse(json);
            console.log("id:" + arr.ID);

            // session id 저장
            req.session.user_id = req.body.id;

            // 이동
            res.redirect('bbslist');

        }else { // login 실패
            res.redirect('login');
        }

    });
    

});


// app을 밖으로 내보내겠다
module.exports = app;
