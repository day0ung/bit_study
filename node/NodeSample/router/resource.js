var express = require('express');
var app = express.Router();
var fs = require('fs');

/* arrow img 불러오기 */
app.get('/arrow', function (req,res) {  /* 현재폴더를 기준점으로 하면 router가 기준 + 한칸나가서 /../ */
    fs.readFile(__dirname+'/../image/arrow.png', function (err, data) {
        res.end(data);  /* /arrow로 등록된 이미지가 /../image/arrow.png가  됨  */
    })
});

module.exports = app; /* 이거하고 나서 server.js 에서 부러 주어야함 */