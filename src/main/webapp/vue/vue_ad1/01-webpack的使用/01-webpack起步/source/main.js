// 1.使用ES6的模块化的规范
import {add} from './mathUtils';
// 2. 依赖css
require('./css/normal.css');

//3. 依赖less文件
require('./css/special.less');

// 4. 引用Vue
import Vue from 'vue';
// import App from './vue/app';
import App from './vue/App.vue';

console.log("res:", add(1, 4));
document.writeln('<h2>I\'am riden,I can do it test!<h2>');

new Vue({
    el: '#app',
    template: '<app/>', // 它会替换index.html中的id为app的标签
    components: {
        App,
    }
});