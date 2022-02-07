const webpack = require('webpack')
const path = require('path');

let config = {
  entry: path.resolve(__dirname, 'dist/xydata.js'),
  output: {
    path: path.resolve(__dirname, ''),
    filename: 'dist/static/xydata-web.js',
  },
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loader: 'babel-loader',
      query: {
        presets: ['env', 'react']
      }
    }]
  },
  plugins: [
    new webpack.ProvidePlugin({
      "React": "react",
    }),
    ["transform-object-rest-spread", { "useBuiltIns": true }]

  ],

};

module.exports = config;