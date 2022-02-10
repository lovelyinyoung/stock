const webpack = require('webpack')
const path = require('path');

let config = {
  entry: path.resolve(__dirname, 'dist/xydata.js'),
  output: {
    path: path.resolve(__dirname, ''),
    filename: 'dist/static/xydata-web.js',
  },
  mode: "development",
  devtool: "source-map",
  module: {
    rules: [{ test: /\.js$/, loader: "babel-loader" }],
  }
};

module.exports = config;