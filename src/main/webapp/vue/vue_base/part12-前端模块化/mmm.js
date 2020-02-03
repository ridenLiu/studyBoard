import {name1,flag,func1} from "./aaa.js";
import def from './aaa.js';

// 统一全部导入
// import * as aaa from './aaa.js';
// console.log('name1:',aaa.name1);
if (flag) {
    func1();
    console.log("name1: "+name1);
    console.log("mmm is running");
    console.log("def: ", def);
}