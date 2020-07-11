/* server */
var http =require('http');

//web server creat
var server = http.createServer();

//port number setting -> binding 이라고함
var port = 8000;
server.listen(port, function () {
    console.log("server start: %d", port);
});

server.on('connection', function (socket) {
  var addr = socket.address();
  console.log('client connect: %s %d', addr.address, addr.port);
});

server.on('request', function (req, res) {
    console.log('client 요청이 들어왔습니다.');

    res.writeHead(200,{'Content-Type':'text/html; charset=utf-8'});/* 200 -> success, 404 etc */
    res.write("<!DOCTYPE html>");
    res.write("<html>");

    res.write("<head>");
    res.write("<title>응답페이지</title>");
    res.write("</head>");
    res.write("<body>");
    res.write("<h1>서버로 부터 응답</h1>");
    res.write("</body>");
    res.write("</html>");

    res.end();
})