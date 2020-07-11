var oracledb = require('oracledb');
var util = require('./util');

oracledb.autoCommit = true;

//DB Connection 
oracledb.getConnection({
    user: 'hr',
    password: 'hr',
    host: 'localhost',
    database: 'xe'
}, function (err, conn) {
    if (err) console.log('접속 실패' + err);
    console.log('DB 접속 성공!');

    dbconn = conn;

    util.setConn(conn);

});