// 定义该属性,则使用了node中的path包,则可使用__dirname常量
const path = require('path');
// 该插件用于解决vue的corresponding plugin报错
const VueLoaderPlugin = require('vue-loader/lib/plugin');
// 该插件用于打包html文件到dist文件夹下
const HtmlWebpackPlugin = require('html-webpack-plugin');

// 使用该js配置webpack,简化cmd命令
module.exports = {
    entry: './source/main.js', //入口文件
    output: {
        // __dirname是node中的一个全局变量,表示当前文件所在路径
        path: path.resolve(__dirname, '../dist'),
        filename: 'webpack_res.js',
        //publicPath: 'dist/',//使用publicPath后所有的url前都会添加该路径,html页面不在dist文件架下使用
    },
    plugins: [
        // vue-loader was used without the corresponding plugin. Make sure to include VueLoaderPlugin in your webpack config.
        // 上述错误解决方法
        new VueLoaderPlugin(),
        new HtmlWebpackPlugin({// 将html文件打包插件
            template: 'index.html'
        }),
        // 该插件用于生成一个注释
        // new webpack.BannerPlugin('最终版权归于Riden'),
    ],
    module: {// 目前由于配置loader
        rules: [
            {
                // 该test使用正则表达式来匹配css文件
                test: /\.css$/,
                // css-loader只负责将css文件进行加载
                // 使用多个loader时,是从右向左读取
                use: ['style-loader', 'css-loader'],
            },
            {
                test: /\.less$/,
                use: ['style-loader', 'css-loader', 'less-loader'], // 将 Less 编译为 CSS
            },
            {
                test: /\.(png|jpg|jpeg|gif)$/i,
                use: [
                    {
                        loader: 'url-loader',
                        options: {
                            // 当加载的图片,小于limit时,会将图片编译成base64字符串形式
                            // 如果大于limit是,需要使用file-loader
                            limit: 8192,
                            name: 'img/[name]$[hash:8].[ext]'
                        },

                    }
                ]
            },
            {// vue文件
                test: /\.vue$/,
                use: ['vue-loader']
            }
        ],
    },
    resolve: {// 使用vue默认使用的是runtime-only版本,需要需改为ems.js版本
        alias: {
            "vue$": "vue/dist/vue.esm.js"
        }
    }
};