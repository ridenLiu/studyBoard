const path = require('path');

module.exports = {
    entry: './source/main.js',
    output: {
        path: path.resolve(__dirname,'dist'),
        filename: 'one.js'
    }
};