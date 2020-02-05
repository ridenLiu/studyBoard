// 该插件用于合并配置文件
const webpackMerge = require('webpack-merge');
// 获取配置文件
const baseConfig = require('./base.config');

module.exports = webpackMerge(baseConfig, {
    devServer: {// !!!最终部署时,需要注释掉
        contentBase: './dist',// 为哪一个文件夹提供本地服务,默认是根文件夹
        inline: true, // 是否实时更新
        port: '8081',//访问端口号,默认8080
        // historyApiFallback: '' // 路由相关
    }
});