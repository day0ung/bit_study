var oracledb = require('oracledb');
var express = require('express');
var app = express.Router();

var db = require("../util");
var oracle = require("../oracle");

app.get('/bbslist', function (req, res) {
    console.log('/bbslist 접속 성공');
    console.log('session id:' + req.session.user_id);
    
    //게시판 뿌리기
    var conn = db.getConn();                                                                               //JSON으로 받기
    conn.execute("SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS ORDER BY REF DESC, STEP ASC", 
    {}, {outFormat:oracledb.OBJECT}, function (err, result) {
        if(err) console.log('조회 실패');     
        
        str = JSON.stringify(result.rows);
        //console.log(str);

        //json형태로 바꾸기
        json = JSON.parse(str);
        //console.log(json);

        //맨 처음에 있는 seq를 뽑고 싶을때 -> 배열로 접근할 수 있다.
        console.log(json[0].SEQ);

        //bbslist.ejs로 이동하기/ 그냥이동하면안됨, render사용(짐 가져가기)
        res.render('bbslist.ejs', 
            {   //짐가져가기
                user:req.session.user_id,
                datas:json
            }
        );
       /*  변수의 충돌을 막기위해서 나온것: const,let ::> 
        const 와 let 의 차이점: 
        const -> const json; 하면 에러남, 바꿀수 없는 object 처음에 값을 넣어주어야함 const json= 1; 이렇게
        let json; -> let json; let json; 허용이됨, */         
    })
})

module.exports = app;