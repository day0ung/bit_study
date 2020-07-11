const foo  = require('./foo.js');
var cal = require('./cal');
/* 외부에 있는 변수나 함수를 불러 쓸수 있는 것: require */
console.log(foo.aa); /* <- 외부 변수 */

num1 = 3;
num2 = 4;

console.log(_cal.add(num1, num2));