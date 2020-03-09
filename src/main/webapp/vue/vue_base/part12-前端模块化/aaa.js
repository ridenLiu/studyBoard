var name = '小明';
var age = 18;
var address = '江西';
var flag = true;

function func1() {
    console.log("this is aaa.func")
}

// 1. 导出方式一
export {
    flag, func1
}

// 2. 导出方式二
export var name1 = name;

// 3. 导出函数/类
export function nml(num1, num2) {
    return num1 + num2;
}

export class Person {
    sayHi(name) {
        console.log("hello everyone my name is " + name);
    }
}

// 4. export default 导出没有名字的事物,在一个模块中只能使用一个default
const gName = '这是export default导出的结果';
export default gName;