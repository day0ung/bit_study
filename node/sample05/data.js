//variable
var item = 'apple';
exports.item = item;  //밖으로 내보내겟다

//function
var getName = function () {
    console.log(item + "입니다");
}
exports.getName = getName;

//Object
var obj = {
    name:'banana',
    price:2500,
    store:'myMarket',
}
exports.obj = obj;

