const path = require('path');
const webpack = require('webpack');
const UglifyJSPlugin = require('uglifyjs-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const MinifyPlugin = require('babel-minify-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const CompressionPlugin = require('compression-webpack-plugin');

const productionEnv = new webpack.EnvironmentPlugin({ NODE_ENV: 'production' });

const extractSass = new ExtractTextPlugin({
  filename: '[name].[contenthash].css',
  disable: process.env.NODE_ENV === 'development',
});

const uglyjsConfig = {
  uglifyOptions: {
    ie8: false,
    ecma: 8,
    output: {
      comments: false,
      beautify: false,
    },
    compress: { drop_console: true },
    warnings: false,
  },
};

const pathsToClean = [
  'dist/*.html',
  'dist/*.js',
  'dist/*.css',
  'dist/*.map',
  'dist/*.gz',
];

const cleanOptions = {
  root: path.resolve(__dirname),
  exclude: [],
  verbose: true,
  dry: false,
};

module.exports = {
  entry: {
    vendor: ['react', 'react-dom'],
    app: './client/index.js',
  },
  output: {
    filename: '[name].[chunkhash].js',
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        include: path.resolve(__dirname, 'client'),
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
        },
      },
      {
        test: /\.scss$/,
        include: path.resolve(__dirname, 'client'),
        use: extractSass.extract({
          use: [
            {
              loader: 'css-loader',
              options: { minimize: true },
            },
            {
              loader: 'sass-loader',
            },
          ],
          fallback: 'style-loader',
        }),
      },
    ],
  },
  plugins: [
    new CleanWebpackPlugin(pathsToClean, cleanOptions),
    new webpack.DefinePlugin({ productionEnv }),
    new UglifyJSPlugin(uglyjsConfig),
    new MinifyPlugin(),
    extractSass,
    new webpack.HashedModuleIdsPlugin(),
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      minChunks: Infinity,
    }),
    new webpack.optimize.CommonsChunkPlugin({
      name: 'common',
      minChunks: Infinity,
    }),
    new CompressionPlugin({
      asset: '[path].gz[query]',
      algorithm: 'gzip',
      test: /\.js$/,
      threshold: 10240,
      minRatio: 0.8,
    }),
  ],
};
