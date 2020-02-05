// 该插件用于将js代码压缩
const uglifyjsWebpackPlugin = require('uglifyjs-webpack-plugin');
// 该插件用于合并配置文件
const webpackMerge = require('webpack-merge');
// 获取配置文件
const baseConfig = require('./base.config');

module.exports = webpackMerge(baseConfig, {
    plugins: [
        new uglifyjsWebpackPlugin(),
    ],
});