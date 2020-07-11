/*
var a = 10;
var str = '타이거즈';

console.log("%d", a);
console.log("%s", str);
console.log("Hello" + str + " node js");
*/

/*
// key = value 
var Person = {}
Person['age'] = 24;
Person['name'] = '전지현';
Person.mobile = '010-1111-2222';

console.log("나이: %d", Person.age);
console.log("이름: %s", Person.name);
console.log("전화번호: %s", Person['mobile']);
*/

/*
function multi(a, b){
    return a * b;
}

var c = multi(10, 20);
console.log('%d * %d = %d', 10, 20, c);
*/
/*
var Human = {
    age: 25,
    name:'홍길동',
    multi:function(a,b){
        return a*b;
    }
}

console.log('%d ', Human.multi(4,2));
console.log('이름: %s', Human.name);
*/

var Users = [
    {name:'홍길동', age:24},
    {name:'일지매', age:21}
]
console.log('첫번째 회원: %s %d', Users[0].name, Users[0].age);
console.log('2번째 회원: %s %d', Users[1].name, Users[1].age);

//데이터 추가push, 데이터 빼기 top
Users.push({name:'정수동', age:26})
console.log('3번째 회원: %s %d', Users[2].name, Users[2].age);
//json 길이값
console.log('Json Array length: %d', Users.length);


/*
push(Object)    추가
pop()           배열의 끝에 요소(element)를 삭제 
unshift()       배열의 앞에 요소를 추가
shift           배열의 앞에 요소를 추가
splice          다수의 요소를 추가/삭제
slice           다수의 요소를 취득하여 새로운 배열을 생성
*/

