var path = require('path')
var utils = require('./utils')
var config = require('../config')
var vueLoaderConfig = require('./vue-loader.conf')
const vuxLoader = require('vux-loader')

function resolve (dir) {
  return path.join(__dirname, '..', dir)
}

var webpackConfig = module.exports = {
  entry: {
    app: './src/main.js'
  },
  output: {
    path: config.build.assetsRoot,
    filename: '[name].js',
    publicPath: process.env.NODE_ENV === 'production'
      ? config.build.assetsPublicPath
      : config.dev.assetsPublicPath
  },
  externals: {
    'zepto': 'Zepto'
  },
  resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      'vue$': 'vue/dist/vue.esm.js',
      '@': resolve('src'),
      'zepto': 'Zepto'
    }
  },
  module: {
    rules: [
      /* {
         test: /\.(js|vue)$/,
         loader: 'eslint-loader',
         enforce: 'pre',
         include: [resolve('src'), resolve('test')],
         options: {
           formatter: require('eslint-friendly-formatter')
         }
       }, */
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: vueLoaderConfig
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        include: [resolve('src'), resolve('test')]
      },
      {
        test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
        loader: 'url-loader',
        options: {
          limit: 10000,
          name: utils.assetsPath('img/[name].[hash:7].[ext]')
        }
      },
      {
        test: /\.(mp4|webm|ogg|mp3|wav|flac|aac)(\?.*)?$/,
        loader: 'url-loader',
        options: {
          limit: 10000,
          name: utils.assetsPath('media/[name].[hash:7].[ext]')
        }
      },
      {
        test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
        loader: 'url-loader',
        options: {
          limit: 10000,
          name: utils.assetsPath('fonts/[name].[hash:7].[ext]')
        }
      }
      // {
      //   test: resolve('src/assets/scripts/lib/zepto.min.js'),
      //   loader: 'exports-loader?window.$!script-loader'
      // }
    ]
    // loaders: [{
    //   test: require.resolve('zepto'),
    //   loader: 'exports-loader?window.Zepto!script-loader'
    // }]
  }

}
module.exports = vuxLoader.merge(webpackConfig, {
  plugins: [

    {name: 'progress-bar'},
    {
      name: 'duplicate-style'
    },
    {
      name: 'less-theme',
      path: 'src/styles/theme.less'
    }
  ]
})
