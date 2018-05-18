require('dotenv').config();
const path = require('path');
const merge = require('webpack-merge');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const devOptions = require('./webpack.dev');
const prodOptions = require('./webpack.prod');

const isInProduction = process.env.NODE_ENV === 'production';

const defaultConfig = {
  output: {
    path: path.resolve(__dirname, 'dist'),
    publicPath: '/',
  },
  module: {
    rules: [
      {
        test: /\.(gif|png|jpe?g|svg)$/i,
        include: path.resolve(__dirname, 'dist/assets'),
        use: [
          'file-loader',
          {
            loader: 'image-webpack-loader',
            options: {
              bypassOnDebug: true,
            },
          },
        ],
      },
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({
      title: 'React Start Environment',
      filename: 'index.html',
      template: 'client/views/index.html',
    }),
  ],
};

const webpackConfig = isInProduction ?
  merge(defaultConfig, prodOptions) :
  merge(defaultConfig, devOptions);

module.exports = webpackConfig;

