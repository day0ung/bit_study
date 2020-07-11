/* 
MySql, MongoDB -> Node.js
Oracle
*/

//server와 관련없음
var oracledb = require('oracledb'); /* npm install oracledb >>모듈이 없어서 터미널에 설치해야함 */

var config = {
    connectString: "localhost/xe",
    user: "hr",
    password: "hr"
}

oracledb.getConnection(config, (err, conn) => {
    if(err){ //err가 true면
        console.log('접속에 실패했습니다.', err);
        return;
    }

    console.log('접속 성공!');
});